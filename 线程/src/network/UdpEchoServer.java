package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.sql.SQLOutput;

/**
 * Created with IntelliJ IDEA.
 * Description:按照UDP协议写一个简单的回显服务的服务器
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class UdpEchoServer {
    private DatagramSocket socket = null;
    //通过构造方法传入端口号
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }
    //启动服务器
    public void start() throws IOException {
        System.out.println("启动服务器");
        //UDP不需要建立连接,直接发送数据就可
        while (true){
            //1.读取客户端发来的请求,接收数据,先需要准备一个盘子来接收数据
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(requestPacket);
            //将数据解析成string的格式,我们比较好看
            String request= new String(requestPacket.getData(),0,requestPacket.getLength(),
                    "UTF-8");
            //2.根据请求来响应,由于我们写的是一个回显服务,收到的就是我们要给的


            String response = process(request);
            //3.将响应发送给客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress());//发送的时候需要知道发那个地方
            socket.send(responsePacket);
            //打印一下客户端的地址和端口号看看
            System.out.printf("[%s,%d] req:%s, resp:%s\n",
                    requestPacket.getAddress(),requestPacket.getPort(),request,response);
        }
    }

    public String process(String request) {
        return request;
    }


    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(9090);//指定服务器的端口
        udpEchoServer.start();//启动服务器
    }
}

// 站在服务器的角度:
// 1. 源 IP: 服务器程序本机的 IP
// 2. 源端口: 服务器绑定的端口 (此处手动指定了 9090)
// 3. 目的 IP: 包含在收到的数据报中. (客户端的IP)
// 4. 目的端口: 包含在收到的数据报中. (客户端的端口)
// 5. 协议类型: UDP
/*
public class UdpEchoServer {
    // 进行网络编程, 第一步就需要先准备好 socket 实例~ 这是进行网络编程的大前提.
    private DatagramSocket socket = null;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 启动服务器.
    public void start() throws IOException {
        System.out.println("启动服务器!");
        // UDP 不需要建立连接, 直接接收从客户端来的数据即可
        while (true) {
            // 1. 读取客户端发来的请求
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket); // 为了接受数据, 需要先准备好一个空的 DatagramPacket 对象, 由 receive 来进行填充数据
            // 把 DatagramPacket 解析成一个 String
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "UTF-8");
            // 2. 根据请求计算响应(由于咱们这是一个回显服务, 2 省略)
            String response = process(request);
            // 3. 把响应写回到客户端
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req: %s, resp: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    // 由于是回显服务, 响应就和请求一样了.
    // 实际上对于一个真实的服务器来说, 这个过程是最复杂的. 为了实现这个过程, 可能需要几万行, 几十万行代码....
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
*/

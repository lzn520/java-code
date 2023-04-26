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
            socket.send(requestPacket);
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

package network;

import com.sun.javafx.binding.StringFormatter;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:按照UDP协议写一个简单的回显服务的客户端
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class UdpEchoClient {
    //先要一个遥控器来操作网卡
    private DatagramSocket socket = null;
    //通过构造方法把服务器端的ip和端口传入
    private String serverIp;
    private int serverPort;
    public UdpEchoClient(String ip,int port) throws SocketException {
        socket = new DatagramSocket();//在构造方法中给一个遥控器
        serverIp = ip;
        serverPort = port;
    }
    //启动客户端
   /* public void  start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1.先从控制台读取数据
            System.out.println("-> ");
            String request = scanner.next();
            //2.将读取到的数据打包发送给服务器端
            //    构造的请求里面包括两部分信息:
            //    1> 数据的内容
            //    2> 数据要给谁,服务器的ip+端口
            DatagramPacket requestData = new DatagramPacket(request.getBytes(),request.getBytes().length
            , InetAddress.getByName(serverIp),serverPort);//客户端发送请求,需要将服务端的ip和端口都打包
            socket.send(requestData);
            //3.从服务器端读取响应的数据,并解析
            DatagramPacket responseData = new DatagramPacket(new byte[1024],1024);//准备一个盘子来装数据
            socket.receive(responseData);
            //   解析收到的数据
            String response  = new String(responseData.getData(),0,responseData.getLength(),
                    "UTF-8");
            //4.将响应结果显示到控制台
            System.out.printf("req:%s resp:%s\n",request,response);
        }
    }*/

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 1. 先从控制台读取用户输入的字符串
            System.out.print("-> ");
            String request = scanner.next();
            // 2. 把这个用户输入的内容, 构造成一个 UDP 请求, 并发送.
            //    构造的请求里包含两部分信息:
            //    1) 数据的内容. request 字符串
            //    2) 数据要发给谁~ 服务器的 IP + 端口
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIp), serverPort);
            socket.send(requestPacket);
            // 3. 从服务器读取响应数据, 并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");
            // 4. 把响应结果显示到控制台上.
            System.out.printf("req: %s, resp: %s\n", request, response);
        }
    }
    public static void main(String[] args) throws IOException {
        //由于服务器和客户端在同一个机器上,使用的ip仍然是127.0.0.1,如果不在一个机器上当然就需要更改这里的ip了
        UdpEchoClient udpEchoClient = new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}

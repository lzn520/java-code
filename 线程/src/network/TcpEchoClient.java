package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description按照TCP写一个回显服务的客户端
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class TcpEchoClient {
    private Socket socket = null;
    private String serverIP;
    private int serverPort;
    //Tcp的构造方法中,是传入服务器的ip和端口来建立连接
    //这里的传入ip和端口号不是自己绑定,而是和服务器建立连接
    //调用这个构造方法,就会和服务器建立连接,相当于拨号了
    public  TcpEchoClient(String serverIP,int serverPort) throws IOException {
      socket = new Socket(serverIP,serverPort);
    }

    public void start(){
        System.out.println("服务器连接成功!");
        try(InputStream inputStream = socket.getInputStream()){
            try(OutputStream outputStream = socket.getOutputStream()){
                while(true){
                    //要做的事情,还是四个步骤
                    //1.从控制台读取字符
                    System.out.println("-> ");
                    Scanner scanner = new Scanner(System.in);
                    String request = scanner.next();

                    //2.根据读取的字符,构造请求,发送给服务器
                    //还是直接用PrintWriter耿介方便
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);//这里的意思是把请求写入到outputStream
                    printWriter.flush();//刷新缓冲区,避免服务器不能及时看到数据
                    //3.从服务器读取响应并解析
                    Scanner respScanner = new Scanner(inputStream);
                    String response = respScanner.next();
                    //4.把结果显示到控制台上
                    System.out.printf("req:%s resp:%s\n",request,response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1",9090);
        tcpEchoClient.start();//不要忘记启动
    }
}

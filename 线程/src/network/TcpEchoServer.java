package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description按照TCP写一个回显服务的服务器端
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */

public class TcpEchoServer {
    //先来一个遥控器
     private ServerSocket serverSocket = null;

     public TcpEchoServer(int port) throws IOException {
         serverSocket = new ServerSocket(port);
     }

     //启动服务器
     public void start() throws IOException {
         System.out.println("服务器启动");
         //由于TPC是有连接的,不能一上来就读数据,而要先建立连接.(接电话)
         //accept就是在接电话,接电话的前提是有人给你打了电话,如果当前没有客户端尝试建立连接,那么此处的accept就会阻塞
         //accept发挥了一个Socket对象,称为clientSocket,后续和客户端直接沟通都是通过clientSocket来完成
         //进一步来讲,ServerSocket就干了一件事,接电话
         while(true){
             Socket clientSocket = serverSocket.accept();
             processConnection(clientSocket);
         }
     }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d]  客户端建立连接!\n",clientSocket.getInetAddress(),clientSocket.getPort());
        //后面处理请求和响应
        //这里的针对TCP socket的读写就和文件的读写是一模一样的
        try(InputStream inputStream = clientSocket.getInputStream()) {
            try(OutputStream outputStream = clientSocket.getOutputStream()){
                //可以直接通过一个scanner来读
                Scanner scanner = new Scanner(inputStream);
                //循环处理每个请求,分别返回响应
                while(true){
                    //1.读取请求
                    if(!scanner.hasNext()){
                        //客户端断开连接
                        System.out.printf("[%s:%d]  客户端断开连接!",clientSocket.getInetAddress(),clientSocket.getPort());
                        break;
                    }
                    //此处用scanner更方便,如果不用这个,用inputStream的read也是可以的
                    String request = scanner.next();
                    //2.根据请求计算响应
                    String response = process(request);
                    //3.把这个请求返回客户端
                    //为了方便起见,可以用一个printWrite把OutPutStream包裹起来
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(response);
                    //刷新缓冲区,如果没有这个刷新,客户端就不能第一时间看到结果
                    printWriter.flush();

                    System.out.printf("[%s:%d]  req:%s resp:%s",clientSocket.getInetAddress(),clientSocket.getPort(),request,response);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //此处要记得来个关闭操作
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
         return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9090);
        tcpEchoServer.start();//一定不要忘记启动
    }
}

package network;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:按照UDP协议写一个英译汉服务器,主要是要调整process方法
 * User: LZN
 * Date: 2023-04-19
 * Time: 15:27
 */
public class UdpDicServer extends UdpEchoServer{

    private HashMap<String,String> dict = new HashMap<>();

    public UdpDicServer(int port) throws SocketException {
        super(port);

        //简单构造几个词
        dict.put("cat","小猫");
        dict.put("pig","小猪");
        dict.put("dog","小狗");
    }
    //重写一下process方法
    @Override
    public String process(String request) {
        return dict.getOrDefault(request,"该词无法被翻译!!");
    }

    public static void main(String[] args) throws IOException {
        UdpDicServer server = new UdpDicServer(9090);
        server.start();
    }
}

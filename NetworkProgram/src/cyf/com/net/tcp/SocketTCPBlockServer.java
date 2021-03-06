package cyf.com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 基于TCP协议的 socket服务端 (阻塞服务器)
 *
 * @author cyfIverson
 * @create 2018-04-11
 */
public class SocketTCPBlockServer {

    /**
     * 服务器IP
     */
    public static final String SEVER_IP = "127.0.0.1";

    /**
     * 服务器端口
     */
    public static final int SEVER_PORT = 9898;

    /**
     * 请求终止字符
     */
    public static final char REQUEST_END_CHAR = '#';

    /**
     * TCP协议socket
     */
    private static ServerSocket serverSocket;

    /**
     * 服务获取请求，并处理数据后返回给客户端
     *
     * @param severIp
     * @param serverPort
     */
    public static void startServer(String severIp, int serverPort) {

        //创建服务器地址对象
        try {
            InetAddress serverAddress = InetAddress.getByName(severIp);

            //java提供ServerSocket作为服务器
            serverSocket = new ServerSocket(serverPort, 5, serverAddress);
            while (true) {
                StringBuffer receiveStrBuffer = new StringBuffer();

                //有客户端发送tcp链接时，accept()会返回一个socket
                Socket connectionSocket = serverSocket.accept();
                InputStream in = connectionSocket.getInputStream();
                for (int c = in.read(); c != REQUEST_END_CHAR ; c = in.read()) {
                    receiveStrBuffer.append((char) c);
                }
                receiveStrBuffer.append('#');
                String responseStr = receiveStrBuffer.toString();

                System.out.println(responseStr);

                //向客户端发送处理后的数据
                String sendStr = responseStr.toUpperCase();
                OutputStream out = connectionSocket.getOutputStream();
                out.write(sendStr.getBytes());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void main(String[] args) {
        SocketTCPBlockServer.startServer(SocketTCPBlockServer.SEVER_IP, SocketTCPBlockServer.SEVER_PORT);
    }
}

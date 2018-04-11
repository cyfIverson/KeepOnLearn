package cyf.com.net.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * 基于TCP协议的 socket客户端
 * @author cyfIverson
 * @create 2018-04-11
 */
public class SocketTCPClient {

    /**
     * 创建客户端TCP socket
     */
    public static Socket clientSocket;

    /**
     * 客户端向服务发送数据,并接收服务返回的数据
     * @param severIp
     * @param serverPort
     * @param str
     */
    public static void clientRemoteServer(String severIp,int serverPort,String str){
        StringBuffer receiveStrBuffer = new StringBuffer();
        try {
            //创建连接socket,并向服务端发送请求
            clientSocket = new Socket(severIp,serverPort);
            OutputStream out = clientSocket.getOutputStream();
            out.write(str.getBytes());

            //读取服务器响应
            InputStream in = clientSocket.getInputStream();
            for (int c = in.read(); c != '#'; c = in.read()) {
                receiveStrBuffer.append((char)c);
            }
            System.out.println(receiveStrBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (clientSocket!=null){
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        String sendStr = "i love java"+SocketTCPBlockServer.REQUEST_END_CHAR;
        SocketTCPClient.clientRemoteServer(SocketTCPBlockServer.SEVER_IP,SocketTCPBlockServer.SEVER_PORT,sendStr);
    }
}

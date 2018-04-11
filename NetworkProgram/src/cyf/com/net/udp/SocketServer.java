package cyf.com.net.udp;

import java.io.IOException;
import java.net.*;

/**
 *
 * 基于UDP协议 socket服务器
 * @author cyfIverson
 * @create 2018-04-10
 */

public class SocketServer {

    /** 服务器IP */
    public static final String SEVER_IP = "127.0.0.1";

    /** 服务器端口 */
    public static final int SEVER_PORT = 9898;

    /** 最大处理的字符 */
    public static final int MAX_BYTE = 1024;

    /** UDP使用DatagramSocket发送数据包*/
    private static DatagramSocket serverSocket = null;

    /**
     * 服务启动响应
     * @param serverIp 服务器Ip
     * @param serverPort 服务器端口
     */
    public static void socketServerStart(String serverIp,int serverPort){
        try {
            //创建DatagramSocket
            InetAddress inetAddress = InetAddress.getByName(serverIp);
            serverSocket = new DatagramSocket(serverPort,inetAddress);

            //创建接收数据对象
            byte[] receiveBuf = new byte[MAX_BYTE];
            DatagramPacket datagramPacket = new DatagramPacket(receiveBuf,receiveBuf.length);

            //服务一直启动
            while (true){
                //接收数据
                serverSocket.receive(datagramPacket);
                String receiveStr = new String(datagramPacket.getData(),0,datagramPacket.getLength());

                System.out.println("sever receive:"+receiveStr);

                //获取客户端的IP和端口
                InetAddress clientIP = datagramPacket.getAddress();
                int clientPort = datagramPacket.getPort();

                //对客户端回传数据
                String backData = receiveStr.toUpperCase();
                byte[] sendByte = backData.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendByte,sendByte.length,clientIP,clientPort);

                serverSocket.send(sendPacket);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer.socketServerStart(SEVER_IP,SEVER_PORT);
    }
}

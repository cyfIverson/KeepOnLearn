package cyf.com.net.udp;

import java.io.IOException;
import java.net.*;

/**
 *
 * 基于UDP协议 socket客户端
 * @author cyfIverson
 * @create 2018-04-10
 */
public class SocketClient {

    /** UDP使用DatagramSocket发送数据包*/
    private static DatagramSocket clientSocket;

    /**
     * 客户端向服务器端发送数据，并接收服务器端的响应
     * @param severIp
     * @param serverPort
     * @param str
     * @return
     */
    public static String socketClientRemote(String severIp,int serverPort,String str){
        String receiveStr = "";
        try {
            //创建UDP socket
            clientSocket = new DatagramSocket();

            //向服务器发送数据
            byte[] sendByte = str.getBytes();
            InetAddress severAddress = InetAddress.getByName(severIp);
            DatagramPacket sendPacket = new DatagramPacket(sendByte,sendByte.length,severAddress,serverPort);

            clientSocket.send(sendPacket);

            //接收服务响应
            byte[] receiveBuf = new byte[SocketServer.MAX_BYTE];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuf,receiveBuf.length);
            clientSocket.receive(receivePacket);

            receiveStr = new String(receivePacket.getData(),0,receivePacket.getLength());

            System.out.println("client get response:"+receiveStr);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return receiveStr;
    }

    public static void main(String[] args) throws IOException {
        SocketClient.socketClientRemote(SocketServer.SEVER_IP,SocketServer.SEVER_PORT,"hello Java");
    }
}

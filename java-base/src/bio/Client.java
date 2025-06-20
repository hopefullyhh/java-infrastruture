package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket()) {
            InetSocketAddress localhost = new InetSocketAddress("localhost", 8001);
            socket.connect(localhost);
            System.out.println("客户端启动");

            new Thread(() -> CommUtil.sendMsg(socket)).start();

            byte[] readBytes = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            while (inputStream.read(readBytes) != -1) {
                String s = new String(readBytes);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

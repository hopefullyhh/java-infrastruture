package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8001)) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            System.out.println("启动服务");
            // 实现多个客户端连接
            while (true) {
                // 连接阻塞                                                                             
                Socket socket = serverSocket.accept();
                System.out.println(socket);
                executorService.execute(() -> handle(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handle(Socket socket) {
        try (InputStream inputStream = socket.getInputStream()) {
            System.out.println(Thread.currentThread().getName());

            new Thread(() -> CommUtil.sendMsg(socket)).start();

            byte[] bytes = new byte[8192];
            // 读阻塞
            while (inputStream.read(bytes) != -1) {
                String s = new String(bytes);
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

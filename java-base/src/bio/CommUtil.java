package bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CommUtil {
    public static void sendMsg(Socket socket) {
        try (Scanner scanner = new Scanner(System.in)) {
            OutputStream outputStream = socket.getOutputStream();
            while (true) {
                String next = scanner.next();
                if ("exit".equals(next)) {
                    break;
                }
                outputStream.write(next.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

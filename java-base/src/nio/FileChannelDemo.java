package nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("FileChannelTest.txt")) {
            String str = "hello";
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.put(str.getBytes());
            byteBuffer.flip();
            FileChannel channel = fileOutputStream.getChannel();
            channel.write(byteBuffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

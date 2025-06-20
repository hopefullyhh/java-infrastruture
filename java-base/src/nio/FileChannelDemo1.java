package nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("FileChannelTest.txt")) {
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer);
            String s = new String(byteBuffer.array());
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

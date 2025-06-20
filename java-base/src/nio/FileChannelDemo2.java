package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo2 {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("FileChannelTest.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("FileChannelTestCopy_1.txt")) {
            FileChannel inputChannel = fileInputStream.getChannel();
            FileChannel outputChannel = fileOutputStream.getChannel();
//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//            while (inputChannel.read(byteBuffer) != -1) {
//                byteBuffer.flip();
//                outputChannel.write(byteBuffer);
//                byteBuffer.clear();
//            }
             // transferFrom完成拷贝
             outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

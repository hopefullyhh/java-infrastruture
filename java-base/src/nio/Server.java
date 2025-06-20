package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel = serverSocketChannel.bind(new InetSocketAddress(8001));
            // 创建连接，阻塞直到有连接
            SocketChannel acceptedSocketChannel = serverSocketChannel.accept();
            acceptedSocketChannel.configureBlocking(false);
            // 将acceptedSocketChannel注册给Selector
            Selector selector = Selector.open();
            acceptedSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {
                int flag = selector.select();
                if (flag > 0) {
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey selectionKey = iterator.next();
                        if (selectionKey.isAcceptable()) {
                            // 通过serverSocketChannel.accept()创建Channel，不阻塞，因为存在了连接
                            SocketChannel readableSocketChannel = serverSocketChannel.accept();
                            readableSocketChannel.configureBlocking(false);
                            readableSocketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        if (selectionKey.isReadable()) {
                            SelectableChannel selectableChannel = selectionKey.channel();
                            SocketChannel readableSocketChannel = (SocketChannel) selectableChannel;
                            // handle
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

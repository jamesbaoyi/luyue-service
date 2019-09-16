package cn.baoyi.luyue.service.domain.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/3 10:12
 * @Description:
 */
public class RpcServer {

    private static final ExecutorService executor = Executors.newCachedThreadPool();

    public void publisher(final Object service, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            executor.execute(new ProcessorHandler(socket, service));
            System.out.println("服务端正在监控。。。。");
        }
    }
}

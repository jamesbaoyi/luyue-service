package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.service.domain.Model.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/2 14:51
 * @Description:
 */
public class TcpTransport {

    private String host;

    private Integer port;

    public TcpTransport(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    private Socket newSocker() throws IOException {
        System.out.println("创建socket连接：主机："+host+"，端口："+port);
        Socket socket=new Socket(host,port);
        return socket;
    }

    public Object send(RpcRequest rpcRequest) throws IOException, ClassNotFoundException {
        Socket socket =newSocker();
        ObjectOutputStream outputStream =new ObjectOutputStream(socket.getOutputStream());
        outputStream.writeObject(rpcRequest);
        outputStream.flush();
        ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
        Object result = inputStream.readObject();
        inputStream.close();
        outputStream.close();
        return result;
    }
}

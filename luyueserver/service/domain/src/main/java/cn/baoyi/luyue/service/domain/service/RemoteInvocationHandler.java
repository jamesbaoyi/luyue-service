package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.service.domain.Model.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/2 14:28
 * @Description:
 */
public class RemoteInvocationHandler implements InvocationHandler {

    private String host;

    private Integer port;

    public RemoteInvocationHandler(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setParameters(args);
        TcpTransport tcpTransport = new TcpTransport(host, port);
        return tcpTransport.send(rpcRequest);
    }
}

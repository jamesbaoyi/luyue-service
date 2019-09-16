package cn.baoyi.luyue.service.domain.service;

import java.lang.reflect.Proxy;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/2 11:30
 * @Description:
 */
public class RpcClientProxy {

    public <T> T clientProxy(final Class<T> classLoader, final String host, final Integer port) {
        return (T) Proxy.newProxyInstance(classLoader.getClassLoader(), new Class[]{classLoader}, new RemoteInvocationHandler(host, port));
    }
}

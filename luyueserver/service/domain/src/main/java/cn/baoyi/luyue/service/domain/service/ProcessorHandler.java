package cn.baoyi.luyue.service.domain.service;

import cn.baoyi.luyue.service.domain.Model.RpcRequest;
import sun.security.util.Length;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Objects;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/3 9:56
 * @Description:
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    private Object service;

    public ProcessorHandler(Socket socket, Object service) {
        this.socket = socket;
        this.service = service;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInputStream =new ObjectInputStream(socket.getInputStream());
            RpcRequest rpcRequest =(RpcRequest) objectInputStream.readObject();
            Object result =invoke(rpcRequest);
            ObjectOutputStream objectOutputStream =new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(result);
            objectOutputStream.flush();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private Object invoke(RpcRequest rpcRequest) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("服务端开始调用");
        Object[] parameters = rpcRequest.getParameters();
        if(Objects.isNull(parameters))
            return  null;
        Class[] parameterTypes = new Class[parameters.length];
        for (int i = 0, length = parameters.length; i < length; i++) {
            parameterTypes[i] = parameters[i].getClass();
        }
        Method method = service.getClass().getMethod(rpcRequest.getMethodName(), parameterTypes);
        return method.invoke(service, parameters);
    }


}

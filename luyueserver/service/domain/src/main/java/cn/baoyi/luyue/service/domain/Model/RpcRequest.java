package cn.baoyi.luyue.service.domain.Model;

import java.io.Serializable;

/**
 * @Author: qijigui
 * @CreateDate: 2019/9/2 14:31
 * @Description:
 */
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] parameters;

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }
}

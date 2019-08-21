package cn.baoyi.luyue.service.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: qijigui
 * @CreateDate: 2019/8/15 11:03
 * @Description:
 */
@Aspect
@Component
public class DataConvertAspect {
    @Pointcut("@annotation(cn.baoyi.luyue.common.utils.DataConvert)")
    public void pointcut() {
        System.out.println("111");
    }

    @Around("pointcut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //拦截的实体类
        Object target = joinPoint.getTarget();
        //拦截的方法名称
        String methodName = joinPoint.getSignature().getName();
        //拦截的方法参数
        Object[] args = joinPoint.getArgs();
        //拦截的放参数类型
        Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        //TODO 处理业务代码

        //处理完之后放行
        return joinPoint.proceed(args);
    }
}

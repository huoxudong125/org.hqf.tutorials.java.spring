package org.hqf.tutorials.spring.interceptor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.hqf.tutorials.spring.JdbcContextHolder;

import java.lang.reflect.Method;

/**
 * @author huoquanfu
 * @date 2019/03/18
 */
public class DataSourceChoose {
    //方法执行前
    public void before(JoinPoint point){
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        Class<?>[] classz = target.getClass().getInterfaces();
        MethodSignature methodSignature = (MethodSignature)point.getSignature();
        Class<?>[] parameterTypes = methodSignature.getMethod().getParameterTypes();
        try {
            Method m = classz[0].getMethod(method, parameterTypes);
            if (m!=null && m.isAnnotationPresent(CustomDtaSource.class)) {
                CustomDtaSource data = m.getAnnotation(CustomDtaSource.class);
                JdbcContextHolder.clearJdbcType();
                JdbcContextHolder.setJdbcType(data.value().getName());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

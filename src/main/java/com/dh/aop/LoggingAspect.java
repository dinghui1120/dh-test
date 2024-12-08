package com.dh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: dh
 * @date: 2024年12月01日
 **/
@Component
@Aspect
public class LoggingAspect {

    @Pointcut("execution(public int com.dh.aop.Compute.*(int,int))")
    public void pointCut() {}

    /**
     * 前置通知
     * 在目标方法执行之前执行
     * 可以带参数 JoinPoint(spring框架提供的 且它的值 也是spring赋予的)
     * joinPoint的作用:获取方法执行过程中的相关信息(方法名、参数)
     * 注意:如果加入参数 JoinPoint应该在第一位
     * @param joinPoint
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        //方法名称
        String methodName = joinPoint.getSignature().getName();
        //方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("日志管理-前置通知(" + methodName + "," + Arrays.toString(args) + ")");
    }

    /**
     * 后置通知
     * (在目标方法执行之后执行，无论方法是否成功完成、后置通知无法读取到返回值)
     * 若需要在增强的过程中 获取方法信息 和前置通知一样 使用参数JoinPoint
     * @param joinPoint
     */
    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("日志管理-后置通知,methodName:" + methodName);
    }

    /**
     * 返回值通知
     * (在目标方法成功执行并返回结果之后执行、返回值递知可以读取到返回值还可以修改它)
     * 可以在返回值通知中携带参数:JoinPoint、描述返回值的参数(类型建议为obiect)
     * 在使用注解的returning属性时 需要保证它和obiect类型形参的名称一致
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("日志管理-返回值通知,methodName:" + methodName + "结果:" + result);
    }

    /**
     * 异常通知
     * 在目标方法抛出异常时执行
     * @param ex
     */
    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        System.out.println("日志管理-异常通知,className:" + className + "\nmethodName:"
                + methodName + "\nargs:" + Arrays.toString(args) + "\ne:" + ex);
    }

    /**
     * 环绕通知
     * 在目标方法执行之前和之后都执行，它允许你完全控制方法调用的过程
     * 1、一般不与其他通知混合使用
     * 2、使用环绕通知 也可以表示其他4种通知
     * 3、相当于JDK代理中的控制器(InvocationHandler)
     * 4、可以携带参数ProceedingJoinPoint(周定的不能修改)相当于InvocationHandler接口中invoke方法的参数 method
     * 5、必须要有返回值(obiect) 表示的意思为:目标方法的执行结果
     * 6、经常用于事务的处理(开启事务+增删改(执行目标方法)+提交(回滚)事务)
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            System.out.println("前置通知");
            result = proceedingJoinPoint.proceed();
            System.out.println("返回值通知");
        } catch (Throwable e) {
            System.out.println("异常通知");
        } finally {
            System.out.println("后置通知");
        }
        return result;
    }

}

package com.dh.jdk;

import com.dh.jdk.lambda.MethodReferenceDemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 方法引用
 * @author: dh
 * @date: 2022年11月27日
 **/
@SpringBootTest
public class MethodReferenceDemoTest {

    @Test
    public void classStaticMethod() {
        MethodReferenceDemo.classStaticMethod();
    }

    @Test
    public void classInstanceMethod() {
        MethodReferenceDemo.classInstanceMethod();
    }

    @Test
    public void objectInstanceMethod() {
        MethodReferenceDemo.objectInstanceMethod();
    }

    @Test
    public void constructorReference() {
        MethodReferenceDemo.constructorReference();
    }

    @Test
    public void arrayReference() {
        MethodReferenceDemo.arrayReference();
    }

}

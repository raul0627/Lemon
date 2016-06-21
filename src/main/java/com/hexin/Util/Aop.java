package com.hexin.Util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("serviceMethods")
public class Aop implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("++++++before advice");
		arg0.proceed();
		System.out.println("++++++after advice");
		return null;
	}
	
}

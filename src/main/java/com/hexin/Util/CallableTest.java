package com.hexin.Util;

import java.util.concurrent.Callable;

public class CallableTest implements Callable<String>{

	private Integer count;
	
	public CallableTest(Integer count) {
		super();
		this.count = count;
	}

	@Override
	public String call() throws Exception {
		System.out.println("start-------------count: " + count);
		Thread.sleep(3000);
		count++;
		System.out.println("end-------------count: " + count);
		return count.toString();
	}

}

package com.hexin.Util;

import com.hexin.Dto.User;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Ts {
	
	/*public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		try {
			testDomain();
*//*			Integer c = 6;
			CallableTest ct = new CallableTest(c);
			FutureTask<String> ft = new FutureTask<>(ct);
			executor.submit(ft);
			executor.shutdown();
			System.out.println("++++++++++++++++ count : " + c);
			String res = ft.get();
			System.out.println("++++++++++++++++ count : " + res);*//*
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public static void testDomain(){
		try {
            User user = new User();
            user.setId(0);
            user.setName("raul");
			Class<?> usr = Class.forName("com.hexin.Dto.User");
			Field[] fields = usr.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.println(field.getName());
				System.out.println(field.get(user));
			}

			for (Method method : usr.getDeclaredMethods()) {
				System.out.println(method.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		byte[] byteArrayA = {1, 2};
		byte[] byteArrayB = {3, 4};

		ByteBuf heapBuffer = Unpooled.buffer();
		System.out.println("/***********Heap ByteBuf***************/");
		System.out.println("Default Byte Order: " + heapBuffer.order());
		System.out.println("Default Heap Buffer Capacity: " + heapBuffer.capacity());
		System.out.println();
		System.out.println();

		ByteBuf wrappedBufferA = Unpooled.wrappedBuffer(byteArrayA);
		System.out.println("/***********Wrapped ByteBuf***************/");
		for(int i = 0; i < wrappedBufferA.writerIndex(); i++){
			System.out.println(wrappedBufferA.getByte(i));
		}
		System.out.println();
		System.out.println();

		ByteBuf wrappedBufferB = Unpooled.wrappedBuffer(byteArrayB);
		ByteBuf compositeByteBuf = Unpooled.compositeBuffer().addComponent(wrappedBufferA).addComponent(wrappedBufferB);
		Iterator<ByteBuf> compositeIterator = ((CompositeByteBuf)compositeByteBuf).iterator();
		System.out.println("/***********Composite ByteBuf***************/");
		while(compositeIterator.hasNext()){
			ByteBuf tempBuf = compositeIterator.next();
			for(int i = 0; i < 2;i++){
				System.out.println(tempBuf.getByte(i));
			}
		}
		System.out.println();
		System.out.println();


		System.out.println("/***********Direct ByteBuf***************/");
		ByteBuf directByteBuf =  Unpooled.directBuffer();
//		System.out.println("Has NIO Buffer? " + directByteBuf.nio);
		System.out.println();
		System.out.println();
		System.out.println("/*****************End*********************/");
	}
}

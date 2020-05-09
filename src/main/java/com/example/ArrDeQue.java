package com.example;

import java.util.ArrayDeque;

public class ArrDeQue{
	public static ArrayDeque<String> ADQ;
	public static ArrayDeque<String> createADQ() {
		
		ADQ=new ArrayDeque<>();
		return ADQ;
	}
public static void addADQ(String a) {
		
		ADQ.addLast(a);

	}


	
	
}

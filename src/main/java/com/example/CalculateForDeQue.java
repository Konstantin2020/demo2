package com.example;

import java.util.Iterator;


public class CalculateForDeQue {
	 public static String Processor="ожидание первой обработки";
	 
	public static void main() {
		Product product = null;
		Processor="старт";
		System.out.println(Processor);
	Iterator<String> iterator = ArrDeQue.ADQ.iterator();
	 SearchMap.nextLineSM=new String [ArrDeQue.ADQ.size()];
	 int z=0;
	 while (iterator.hasNext()) {
		 SearchMap.nextLineSM [z]=(String) iterator.next();
		 Processor="обработка заявки "+SearchMap.nextLineSM [z]+" и внесение ее в базу данных";
				  product = new Product(SearchMap.nextLineSM [z]);
				  ProductDB.insert(product);
				   System.out.println(Processor);
		   ArrDeQue.ADQ.pollFirst();
		   z++;
			
	 }
	 Processor="обработка завершена";
	 System.out.println(Processor);
   try {
       App.main();

		//App.J1_jsp(App.appMapSearchFile, App.appMap_J1_J2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

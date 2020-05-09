package com.example;


import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;
import java.util.logging.Logger;

import org.json.JSONObject;

public class SearchMap {
	public static String[] nextLineSM;
	public static String[] DBnextLineSM;
    private static Logger log = Logger.getLogger(SearchMap.class.getName());
    
//класс для получения искомых ключей
    public Map mainRetSearchMap() throws Exception {
    	
    	ArrayList<Product> products = ProductDB.select();

    	DBnextLineSM=new String[products.size()];
        int r=0;     
for(Product prod_1_2: products) {
	DBnextLineSM[r]=prod_1_2.getName();
	r++;
}
    	
        System.out.println(" ");
        Map<String, Integer> resultSM = new LinkedHashMap<>();
        Integer d=0;
        for(int z = 0; z<DBnextLineSM.length;z++) {
                
                
                //либо
                //int d=0;
                //тогда в JSON_2 будет выводить 0
                resultSM.put(DBnextLineSM[z], d);
            }
        
        return resultSM;
     }
}





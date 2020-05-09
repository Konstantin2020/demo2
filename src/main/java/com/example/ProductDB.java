package com.example;
 
import java.io.PrintWriter;
import java.sql.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.apache.commons.lang3.ArrayUtils;


 
public class ProductDB {
	static Connection conn;
	
public static void createDB()
            throws Exception {
	
	try {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
            getConnection("jdbc:h2:mem:test", "sa", " ");
        // add application code here
        Statement statement = conn.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS CONTROLDB (ID INT, SIGN BOOLEAN);"+"CREATE TABLE IF NOT EXISTS PRODUCTS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NAME VARCHAR(30));"
        		+ "CREATE TABLE IF NOT EXISTS SOURCEMARKS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NAMESOURCEMARK VARCHAR(30), QUANTITYSOURCEMARK INT);"
        		+"INSERT INTO CONTROLDB (ID,SIGN) values (1,TRUE);");
        //System.out.println("Connection to ProductDB succesfull!");
	}catch (Exception ex){
		App.create_DB_bool=false;
		//System.out.println("Connection failed...");
        ex.printStackTrace();
	} finally {
          }
            }
	

public static ArrayList<Product> select() {
   
        ArrayList<Product> products = new ArrayList<Product>();
        
        try{Class.forName("org.h2.Driver");
    	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {

                  
                Statement statement = conn.createStatement();
                //statement.execute("CREATE TABLE IF NOT EXISTS PRODUCTS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NAME VARCHAR(30), PRICE INT);");
                //statement.execute("INSERT INTO PRODUCTS (NAME,PRICE) values ('asd', 12321321);");
                //statement.execute("INSERT INTO PRODUCTS (NAME,PRICE) values ('ggg', 1353453);");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
           
                    Product product = new Product(id, name);
                    products.add(product);
                }
    	}
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }
    
public static Sign selectOneSign(int id) {
    
    Sign sign = null;
    try{Class.forName("org.h2.Driver");
	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {
              
            String sql = "SELECT * FROM CONTROLDB WHERE id=?";
            try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){

                    int signId = resultSet.getInt(1);
                    boolean signName = resultSet.getBoolean(2);
                    
                    sign = new Sign(signId, signName);
                }
            }
        }
    }
    catch(Exception ex){
        System.out.println(ex);
    }
    return sign;
}







public static ArrayList<SourceMark> selectForMap() {
 	   
        ArrayList<SourceMark> sourcemarks = new ArrayList<SourceMark>();
        
        try{Class.forName("org.h2.Driver");
    	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {

                  
                Statement statement = conn.createStatement();
                //statement.execute("CREATE TABLE IF NOT EXISTS PRODUCTS (ID INT PRIMARY KEY AUTO_INCREMENT NOT NULL, NAME VARCHAR(30), PRICE INT);");
                //statement.execute("INSERT INTO PRODUCTS (NAME,PRICE) values ('asd', 12321321);");
                //statement.execute("INSERT INTO PRODUCTS (NAME,PRICE) values ('ggg', 1353453);");
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SOURCEMARKS");
                while(resultSet.next()){
                      
                    int idSourceMark = resultSet.getInt(1);
                    String nameSourceMark = resultSet.getString(2);
                    int quantitySourceMark = resultSet.getInt(3);
                    SourceMark sourcemark = new SourceMark(idSourceMark, nameSourceMark, quantitySourceMark);
                    sourcemarks.add(sourcemark);
                }
    	}
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return sourcemarks;
    }
    


    
public static Map<String,Integer[]> selectForMapWithArr() {
  	   
        ArrayList<SourceMark> sourcemarks = new ArrayList<SourceMark>();
        ArrayList<String> combinedKey = new ArrayList<>();
        ArrayList<Integer> combinedValue = new ArrayList<>();
        Map<String, Integer> resultSMWA_Step1 = new LinkedHashMap<>();
		String nameSourceMark;
        int quantitySourceMark;
        Map<String, Integer[]> resultSMWA_Step2 = new HashMap<>();
        ArrayList<String> combinedKey2 = new ArrayList<>();
        ArrayList<Integer[]> combinedValue2 = new ArrayList<>();
        Map<String, Integer[]> MapCombined_J3 = new HashMap<>();
        Map<String,Integer[]> MapJ3_Step1 = new LinkedHashMap<>();
        Map<String,Integer[]> MapJ3_Step2=new HashMap<>();
        Map<String,Integer[]> MapJ3_Step3= new HashMap<>();

        
        try{Class.forName("org.h2.Driver");
    	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM SOURCEMARKS");
                while(resultSet.next()){
                	BiFunction<Integer, Integer, Integer> bFunc = (oldValue, newValue) -> oldValue + newValue;
                    int idSourceMark = resultSet.getInt(1);
                    nameSourceMark = resultSet.getString(2);
                    quantitySourceMark = resultSet.getInt(3);
                    SourceMark sourcemark = new SourceMark(idSourceMark, nameSourceMark, quantitySourceMark);
                    sourcemarks.add(sourcemark);
//для J3
//заполняем два списка отдельно для ключа(имени метки), отдельно для значения(количество) (ключ-значение)
                combinedKey.add(nameSourceMark.toUpperCase());
                combinedValue.add(quantitySourceMark);
//заполняем Map<String, Integer> resultSMWA_Step1 с суммированием значений, но нам от нее нужны только ключи
                resultSMWA_Step1.merge(nameSourceMark.toUpperCase(), quantitySourceMark, bFunc);
                }

//перебираем ключи в resultSMWA_Step1, сравниваем их с ключами из Связанного списка
                for (java.util.Map.Entry<String, Integer> entrysource2 : resultSMWA_Step1.entrySet()) {
                    String mark = entrysource2.getKey();
//создаем массив для хранения значений, которые будут встречаться для ключа
                    	Integer[] resIntWA = new Integer[0];
//если для ключа встречаются несколько значений, то они заносятся в массив
                    	for (int b = 0; b < combinedKey.size(); b++) {
                        if ((mark).equalsIgnoreCase(combinedKey.get(b))) {
                            resIntWA = Arrays.copyOf(resIntWA, resIntWA.length + 1);
                            resIntWA[resIntWA.length - 1] = Integer.valueOf(combinedValue.get(b));
                        }
//на основе resultSMWA_Step1 и двух списков (ключей и значений) значения заполняются массивами для соответствующих ключей
//заполняем Map<String, Integer[]> resultSMWA_Step2 , каждому ключу присваивается значение в виде массива с количествами, 
//размер массива зависит от того сколько значений для ключа в базе встречается
                    }resultSMWA_Step2.put(mark,resIntWA);
                }
//на основе resultSMWA_Step2 заполняем Map<String, Integer[]> MapJ3_Step2, каждому ключу присваивается массив со значениями, 
//заполняем два списка отдельно для Имени метки, отдельно для массивов со значениями (разбираем Map ключ-массив со значениями)
                   for (java.util.Map.Entry<String, Integer[]> entrysource1 : resultSMWA_Step2.entrySet()) {
                        combinedKey2.add(entrysource1.getKey());
                        combinedValue2.add(entrysource1.getValue());
                        MapJ3_Step2.put(entrysource1.getKey(), entrysource1.getValue());
                    }
//на основе MapJ3_Step2 и двух списков (ключей и значений(массивов с количествами)) значения заполняются массивами для соответствующих ключей
//заполняем Map<String, Integer[]> MapCombined_J3, каждому ключу присваивается массив со значениями, 
//размер массива зависит от того сколько значений для ключа в базе встречается                    
                        for (java.util.Map.Entry<String, Integer[]> entrysource2 : MapJ3_Step2.entrySet()) {
                        String mark = entrysource2.getKey();
//создается массив для хранения количеств
                        Integer[] both = new Integer[0];
//при совпадении ключей в Map и массиве ключей 
                        for (int b = 0; b < combinedKey2.size(); b++) {
                            if ((mark).equalsIgnoreCase(combinedKey2.get(b))) {
//в массив both вносится массив с количествами из списка 
                                both = ArrayUtils.addAll(both, combinedValue2.get(b));
//массив сортируется в обратно порядке(по убыванию)
                                Arrays.sort(both, Collections.reverseOrder());
                                }
                       }MapCombined_J3.put(mark,both);
        
                        }
                
    	}
    	        }
    	catch(Exception ex){
            System.out.println(ex);
        }//finally { System.out.println("Finally ");}
    	
        return MapCombined_J3;
    }
    
    
    
    public static int insert(Product product) {
         
        try{Class.forName("org.h2.Driver");
        	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {
                  
                String sql = "INSERT INTO PRODUCTS (name) Values (?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
 
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
public static int insertSourceMark(SourceMark sourcemark) {
        
        try{Class.forName("org.h2.Driver");
        	try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:test","sa"," ")) {
                  
                String sql = "INSERT INTO SOURCEMARKS (nameSourceMark,quantitySourceMark) Values (?,?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, sourcemark.getSourceMarkName());
                    preparedStatement.setInt(2, sourcemark.getSourceMarkQuantity());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }


}
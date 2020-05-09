package com.example;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;




//главный класс приложения
public class App {
    private static Logger log = Logger.getLogger(App.class.getName());
    public static Map<String, Integer> appMapSearchFile;
    //public static SearchMap SM = new SearchMap();
    public static Map <String,Integer> appMap_J1_J2;
    public static Map <String,String> org_json_Map_J2;
    public static Map <String,Integer[]> appMap_J3;
    public static JSONObject JSON_11;
    public static JSONObject JSON_22;
    public static JSONObject JSON_33;
    public static Boolean Calc=false;
    public static Boolean For_J2=false;
    public static String [] prod_name_from_DB;
    public static String Last_Mark;
    public static String fileSourceName;
    public static int fileSourceName_int=0;
    //public static int uploadFile_int=0;
    public static String directoryFileSourceName;
    public static boolean create_DQ_bool;
    public static boolean create_DB_bool;
    public static int create_Request_int=0;
    public static Map<String,Integer> MapFromDB=new LinkedHashMap<>();
    public static int insert_Data_To_DB_int=0;
//начальный метод приложения, создает Map с искомыми метками   
    public static void main( ) throws Exception {
/*        try {// внимание! при компиляции файл настроек логирования стирается из корневого каталога
            LogManager.getLogManager().readConfiguration(
                    App.class.getResourceAsStream("logging.properties"));
        } catch (IOException e) {
System.err.println("Could not setup logger configuration: " + e.toString());
        }
*/
    	SearchMap SM = new SearchMap();
	    App.appMapSearchFile = SM.mainRetSearchMap();
//получение MAP с искомыми ключами
        log.info("receive SearchMap");
        }

//метод для ввода в базу данных и вывода из нее Map использующихся как второй параметр в методах J№_jsp
public static void ForEnter( ) throws Exception {
//    	 if(App.insert_Data_To_DB_int==0) 
//    	    {
//распаковка архива    	    	
    	    UnzipReadWriteFiles URWF=new UnzipReadWriteFiles();
//получение списка файлов
    	    String [] appListFiles = URWF.mainRetArrUnzipFiles();
//создание класса для внесения данных в базу данных
    	    GeneralSourceMap_J1_J2_J3 GSM123=new GeneralSourceMap_J1_J2_J3(App.appMapSearchFile,appListFiles);
//вызов метода, заносящего записи в базу данных для всех файлов
    	    GSM123.mainRetGeneralSourceMap_J1_J2();
//присвоение Map результата метода получающего из базы данных (ключ-значение(суммарное количество)    	    
    	    App.appMap_J1_J2=App.getMapFromDB();
//присвоение Map результата метода получающего из базы данных (ключ-значение(массив с количествами))
    	    App.appMap_J3=ProductDB.selectForMapWithArr();
//для контроля оставляю закомментированные Map
    	    //System.out.println(appMap_J1_J2);
    	    //System.out.println(App.appMap_J3);
    	    //System.out.println(MapFromDB);
       	 	//System.out.println(appMapSearchFile);
    	    System.out.println("Данные из файлов-источников внесены в базу данных.");
    	  }
//   else {System.out.println("Данные из файлов-источников уже внесены в базу данных!!!");
//  }
//}
    
    
//JSON_1
public static void J1_jsp(Map<String, Integer> J1_A, Map<String,Integer> J1_B) throws Exception {
        log.info("start to JSON_1");
        Map<String,Integer> afterPJ1;
        PrevJ1 pj1= new PrevJ1(J1_A, J1_B);
        afterPJ1=pj1.mainRetJ1();
        JSON_11=new JSONObject(afterPJ1);
}
        
        
//JSON_2
       // @SuppressWarnings("null")
public static void J2_jsp( Map<String,Integer> J2_A, Map<String,Integer> J2_B) throws Exception {
        log.info("start to JSON_2");
      //JSON_1_������������� ��� JSON_2
              log.info("start medium JSON_1 for JSON_2");
              Map<String,Integer> afterPJ1;
              PrevJ1 pj1= new PrevJ1(J2_A, J2_B);
              afterPJ1=pj1.mainRetJ1();

      //JSON_2
              log.info("start to JSON_2");
              Map<String,Integer> afterPJ2;
              PrevJ2 pj2= new PrevJ2(J2_A, afterPJ1);
              afterPJ2=pj2.mainRetJ2();
              JSONObject JSON_221=new JSONObject();
     for(java.util.Map.Entry<String, Integer> entrysource : afterPJ2.entrySet()) {
              JSON_221.put(entrysource.getKey(), entrysource.getValue()==0? (Object) JSONObject.NULL: (Object) entrysource.getValue());
 	 }
    JSON_22=JSON_221;
}





//JSON_3
        
public static void J3_jsp(Map<String, Integer> J3_A, Map<String,Integer[]> J3_B) throws Exception {
        log.info("start to JSON_3");
        Map<String,Integer[]> afterPJ3;
        PrevJ3 pj3= new PrevJ3(J3_A, J3_B);
        afterPJ3=pj3.mainRetJ3();
        JSON_33  = new JSONObject(afterPJ3);
}

//метод для разворота значений массива (чтобы последнее значение стало первым)     
public static String[] sort(String[] massive) {
            for (int i = 0; i < massive.length / 2; i++) {
                String tmp = massive[i];
                massive[i] = massive[massive.length - i - 1];
                massive[massive.length - i - 1] = tmp;
            }
 return massive;
}

//метод для получения истории заявок из базы данных
public static String[] getArrFromDB() {
           	ArrayList<Product> products = ProductDB.select();
            prod_name_from_DB=new String[products.size()];
            int z=0;     
    for(Product prod_1_2: products) {
    	prod_name_from_DB[z]=prod_1_2.getName();
    	z++;
    	}

    return prod_name_from_DB;
}

//метод для получения создана база данных или нет
public static boolean isCreateDB() {
	boolean createDBMediumBool=false;	
	createDBMediumBool=ProductDB.selectOneSign(1).isNameSign();
  return createDBMediumBool;
}






//метод для получения Map с суммированными значениями из базы данных
public static Map<String,Integer> getMapFromDB() {
        	BiFunction<Integer, Integer, Integer> bFunc = (oldValue, newValue) -> oldValue + newValue;
           	ArrayList<SourceMark> sourcemarks = ProductDB.selectForMap();
      for(SourceMark fromDB: sourcemarks) {
			    	MapFromDB.merge(fromDB.getSourceMarkName().toUpperCase(),fromDB.getSourceMarkQuantity(),bFunc);
	  }
 return MapFromDB;
}
        
//метод проверки есть ли такая заявка в базе данных 
public static boolean isComparison_Name_DB(String a, String [] b) {
        	boolean c = false;
        	LOOP: for(int q=0; q<b.length;q++) {
    			if(a.equalsIgnoreCase(b[q])) {
    			 System.out.println("Попытка создания заявки: "+a+", которая уже есть в базе данных"); 
    			   c = true; break LOOP;}
           		}
 return c;
}	

//метод проверки есть ли такая заявка в очереди        
public static boolean isComparison_Name_Deque(String a, Deque<String> b) {
        	boolean c = false;
        	LOOP: for(String elem: b) {
        		if(a.equalsIgnoreCase(elem)) {
       			 System.out.println("Попытка создания заявки: "+a+", которая уже есть в очереди"); 
       			   c = true; break LOOP;}
              }
  return c;
}	

        
        
        }
        















package com.example;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Logger;

//класс для вывода суммы из каждого ресурсного файла с суммированием значений для совпадающих ключей
public class SingleSourceFileMap {
    private static Logger log = Logger.getLogger(SingleSourceFileMap.class.getName());
    String paramFileName=null;
//в конструктор вносится имя каждого распакованного файла
    public SingleSourceFileMap(String s) {
        paramFileName=s;
    }

    public Map mainRetSingleSourceMap() throws Exception {
        log.info("SingleSourceFileMap for J1, J2");
       
        Map<String, Integer> result = new LinkedHashMap<>();
        CSVReader reader = new CSVReader(new FileReader(paramFileName), ',', '"', 1);
        String[] nextLine;
        BiFunction<Integer, Integer, Integer> bFunc = (oldValue, newValue) -> oldValue + newValue;
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                String [] lastLine=nextLine;
                String nameSourceMark=((String) lastLine[0]).toUpperCase();
                int quantitySourceMark= Integer.parseInt(lastLine[1]);
                SourceMark sourcemark=new SourceMark(nameSourceMark,quantitySourceMark);
                ProductDB.insertSourceMark(sourcemark);
                result.merge(((String) lastLine[0]).toUpperCase(),Integer.parseInt(lastLine[1]),bFunc);
                
            }
                
                
        }

        return result;
    }
}
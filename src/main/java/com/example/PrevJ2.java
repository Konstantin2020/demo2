package com.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

//предварительный класс для вывода JSON_2
public class PrevJ2 {
    Map<String,Integer> prevSearchMap;
    Map<String,Integer> prevSourceMap;
    private static Logger log = Logger.getLogger(PrevJ2.class.getName());

    public PrevJ2( Map<String, Integer> appMapSearchFile, Map<String, Integer> afterPJ1) {
//получение MAP с искомыми ключами
        prevSearchMap=appMapSearchFile;
//получение MAP с ресурсными ключами и суммированными для каждого ключа значениями
        prevSourceMap= afterPJ1;
    }
    public Map<String,Integer> mainRetJ2() throws Exception {
        log.info("prevMap for FinJ2 formation");
        boolean loc_For_J2 = false;
        Map<String, Integer> prev_J2_Map_Step1 = new LinkedHashMap<>();
        Map<String, Integer> prev_J2_Map = prevSearchMap;
//сведение двух MAP - искомой и ресурсной,
        for (java.util.Map.Entry<String, Integer> entry : prevSearchMap.entrySet()) {
            for (java.util.Map.Entry<String, Integer> entrysource : prevSourceMap.entrySet()) {
                {
                    if ((entry.getKey()).equalsIgnoreCase(entrysource.getKey())) {
                        String key = entry.getKey();
                        Integer value = entrysource.getValue();
                        prev_J2_Map_Step1.put(key, value);
                    }
                }

            }
        }
// если в искомой есть ключи, для которых нет значений в ресурсной,
// то для таких ключей значениям присваивается null
       prev_J2_Map_Step1.forEach((k, v) -> prev_J2_Map.merge(k, v, (v1, v2) -> v2));
        for (java.util.Map.Entry<String, Integer> entry : prevSearchMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            prev_J2_Map.put(key, value);
            
        }
    
       return prev_J2_Map;
    }
}

package com.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

//предварительный класс для вывода JSON_1
public class PrevJ1 {
    private static Logger log = Logger.getLogger(PrevJ1.class.getName());
    Map<String,Integer> prevSearchMap;
    Map<String,Integer> prevSourceMap;
    public PrevJ1( Map<String, Integer> appMapSearchFile, Map<String, Integer> appMap_J1_J2) {
//получение MAP с искомыми ключами
        prevSearchMap=appMapSearchFile;
//получение MAP с ресурсными ключами и суммированными для каждого ключа значениями
        prevSourceMap= appMap_J1_J2;
    }

    public Map<String,Integer> mainRetJ1() throws Exception {
        log.info("prevMap for FinJ1 formation");
        Map<String, Integer> prev_J1_Map = new LinkedHashMap<>();
//сведение двух MAP - искомой и ресурсной,
// если в искомой есть ключи, для которых нет значений в ресурсной, то они игнорируются
          for (java.util.Map.Entry<String, Integer> entry : prevSearchMap.entrySet()) {
            for (java.util.Map.Entry<String, Integer> entrysource : prevSourceMap.entrySet()) {
                {
                    if ((entry.getKey()).equalsIgnoreCase(entrysource.getKey())) {
                        String key = entry.getKey();
                        Integer value = entrysource.getValue();
                        prev_J1_Map.put(key, value);
                    }
                }

            }
        }
        return prev_J1_Map;
    }
}

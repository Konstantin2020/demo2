package com.example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

//предварительный класс для вывода JSON_3
public class PrevJ3 {
private static Logger log = Logger.getLogger(PrevJ3.class.getName());
    Map<String,Integer> prevSearchMap_J3;
    Map<String,Integer[]> prevSourceMap_J3;


    public PrevJ3( Map<String, Integer> appMapSearchFile, Map<String, Integer[]> appMap_J3) {
//получение MAP с искомыми ключами
        prevSearchMap_J3=appMapSearchFile;
//получение MAP с ресурсными ключами и массивами значений для каждого ключа
        prevSourceMap_J3= appMap_J3;
    }

    public Map<String, Integer[]> mainRetJ3() throws Exception {
        log.info("prevMap for FinJ1 formation");
        Map<String, Integer[]> prev_J3_Map = new LinkedHashMap<>();
        for (java.util.Map.Entry<String, Integer> entry : prevSearchMap_J3.entrySet()) {
            for (java.util.Map.Entry<String, Integer[]> entrysource : prevSourceMap_J3.entrySet()) {
                {
                    if ((entry.getKey()).equalsIgnoreCase(entrysource.getKey())) {
                        String fromvaluej3 = " ";
                        String keyJ3 = entry.getKey();
                        Integer [] valueJ3 = entrysource.getValue();
                        for (int z = 0; z < valueJ3.length; z++) {
                            fromvaluej3 = fromvaluej3.concat(" " + valueJ3[z]);
                        }
                        prev_J3_Map.put(keyJ3, valueJ3);

                    }
                }
            }
        }
        return prev_J3_Map;
    }
}
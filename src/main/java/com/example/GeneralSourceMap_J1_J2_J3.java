package com.example;

import org.apache.commons.lang3.ArrayUtils;

import java.util.*;
import java.util.logging.Logger;

//класс для перебора файлов, в свою очередь для каждого файла вызывается метод вносящий записи в базу данных
public class GeneralSourceMap_J1_J2_J3 {
    private static Logger log = Logger.getLogger(GeneralSourceMap_J1_J2_J3.class.getName());
    Map<String,Integer> GSMSearchMap;
    String [] GSMArrListSourceFiles;
    public GeneralSourceMap_J1_J2_J3(Map<String, Integer> appMapSearchFile, String[] appListSourceFiles) {
        GSMSearchMap=appMapSearchFile;
        GSMArrListSourceFiles=appListSourceFiles;
    }

public void mainRetGeneralSourceMap_J1_J2() throws Exception {
        log.info("begin formation Map for J1 and J2");
        Map<String, Integer> MapCombined_J1_J2=new HashMap<>();
        ArrayList<SingleSourceFileMap> SMarr = new ArrayList<>();
        if (GSMArrListSourceFiles.length > 0) {
            for (int z = 0; z < GSMArrListSourceFiles.length; z++) {
                SingleSourceFileMap y = new SingleSourceFileMap(GSMArrListSourceFiles[z]);
                SMarr.add(y);
                SMarr.get(z).mainRetSingleSourceMap();
            }
        }
    }
}




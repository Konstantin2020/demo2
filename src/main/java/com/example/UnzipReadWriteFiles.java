package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipReadWriteFiles {
    private static Logger log = Logger.getLogger(SingleSourceFileMap.class.getName());
    ArrayList<String> alFileName = new ArrayList<>();
    String[] strLineFileName;
    String randomFileName="pts14r";
//String dateFileName=LocalDateTime.now().toString();
    public String [] mainRetArrUnzipFiles() throws Exception {
        log.info("unzip and read source files");
//чтение и распаковка архива
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(App.directoryFileSourceName+"\\"+App.fileSourceName))) {
            ZipEntry entry;
            String name;
            long size;
            System.out.println("Text message: list of packed files:");
            int k = 0;

            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName(); // название файла
                System.out.printf("%s \n", name);
//список для имен файлов
                
                alFileName.add(k, name);
                ++k;
                FileOutputStream fout = new FileOutputStream(App.directoryFileSourceName +"\\unzip_"+randomFileName+"_" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            log.log(Level.SEVERE, "Exception: ", ex);
        }
        log.fine("some minor, debug message");
        System.out.println(" ");
//составление списка распакованных файлов
        log.info("list formation for source files");
        System.out.println("Text message: list of unpacked files:");
        strLineFileName = new String[alFileName.size()];

        for (int u = 0; u < strLineFileName.length; u++) {
            strLineFileName[u] = (App.directoryFileSourceName+"\\unzip_"+randomFileName+"_"+ alFileName.get(u));
            System.out.println(strLineFileName[u]);
        }
        System.out.println(" ");

        
return strLineFileName;
}
}

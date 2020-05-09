package com.example;
 
import java.io.Serializable;
 
public class Sign implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int id;
    private boolean nameSign;

     
    public Sign(){ }
    public Sign(boolean nameSign){
         
        this.nameSign = nameSign;

    }
    public Sign(int id, boolean nameSign){
         
        this.id = id;
        this.nameSign = nameSign;
       
    }
     
    public int getId() {
        return id;
    }
     
    public boolean isNameSign() {
        return nameSign;
    }
 
    public void setNameSign(boolean nameSign) {
        this.nameSign = nameSign;
    }
 

}
package com.example;

import java.io.Serializable;
 
public class SourceMark implements Serializable {
 
    private static final long serialVersionUID = 1L;
 
    private int idSourceMark;
    private String nameSourceMark;
    private int quantitySourceMark;
     
    public SourceMark(){ }
    public SourceMark(String name, int quantity){
         
        this.nameSourceMark = name;
        this.quantitySourceMark = quantity;
    }
    public SourceMark(int id, String name, int quantity){
         
        this.idSourceMark = id;
        this.nameSourceMark = name;
        this.quantitySourceMark = quantity;
    }
     
    public int getId() {
        return idSourceMark;
    }
     
    public String getSourceMarkName() {
        return nameSourceMark;
    }
 
    public void setSourceMarkName(String name) {
        this.nameSourceMark = name;
    }
 
    public int getSourceMarkQuantity() {
        return quantitySourceMark;
    }
 
    public void setSourceMarkQuantity(int quantity) {
        this.quantitySourceMark = quantity;
    }
}
package com.example.demo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Json {
    private int id;
    @JsonFormat(pattern = "yyyy_MM_dd")
    private Date date;
    private String name;
    @JsonIgnore
    private String author;

    public Json(int id, Date date, String name, String author){
        this.id = id;
        this.date = date;
        this.name = name;
        this.author = author;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Date getDate(){
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }

}

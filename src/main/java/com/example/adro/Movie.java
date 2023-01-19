package com.example.adro;

import java.util.Date;

public class Movie {
    String name, theatre, id, language, price;
    Date time;
    int tickets_num;

    public Movie(String name, String theatre,String id, String language, Date time,int tickets_num,String price) {
        this.name = name;
        this.theatre = theatre;
        this.id = id;
        this.language = language;
        this.price = price;
        this.time = time;
        this.tickets_num=tickets_num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTickets_num(int tickets_num) {
        this.tickets_num = tickets_num;
    }

    public int getTickets_num() {
        return tickets_num;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTheatre(String theatre) {
        this.theatre = theatre;
    }

    public String getTheatre() {
        return theatre;
    }
}

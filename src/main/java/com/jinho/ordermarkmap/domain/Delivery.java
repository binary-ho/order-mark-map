package com.jinho.ordermarkmap.domain;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Delivery {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String menu;
    private String address;
    private String locationX;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    private String locationY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}

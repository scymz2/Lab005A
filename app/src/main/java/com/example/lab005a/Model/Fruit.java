package com.example.lab005a.Model;

public class Fruit {

    private String id;
    private String fName;
    private String fColor;

    public Fruit(){}

    public Fruit(String id, String fName, String fColor) {
        this.id = id;
        this.fName = fName;
        this.fColor = fColor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfColor() {
        return fColor;
    }

    public void setfColor(String fColor) {
        this.fColor = fColor;
    }
}

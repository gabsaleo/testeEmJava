package com.example.testeemjava.model.Enums;

public enum Genre {

    F("F", "Femea"),
    M("M", "Macho");

    private String id;
    private String msg;

    Genre(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static Genre toEnum(String id){
        if(id.isEmpty()) return null;
        for (Genre value : Genre.values()) {
            if(value.getMsg() == id) return value;
        }
        return null;
    }
}

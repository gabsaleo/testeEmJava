package com.example.testeemjava.model.Enums;

public enum CoatLength {

    HAIRLESS("HAIRLESS", "Sem pelo"),
    SHORT("SHORT", "Pequeno"),
    MEDIUM("MEDIUM", "Medio"),
    LONG("LONG", "Longo");

    private String id;
    private String msg;

    CoatLength(String id, String msg) {
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

    public static CoatLength toEnum(String id){
        if(id.isEmpty()) return null;
        for (CoatLength value : CoatLength.values()) {
            if(value.getMsg() == id) return value;
        }
        return null;
    }
}

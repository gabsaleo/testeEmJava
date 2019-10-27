package com.example.testeemjava.model.Enums;

public enum PetSize {
    SMALL("SMALL", "Pequeno 6kg - 15kg"),
    MEDIUM("MEDIUM", "Medio 15kg - 25kg"),
    LARGE("LARGE", "Grande 25kg - 45kg"),
    XL("XL", "Gigante 45kg - 90kg");

    private String id;
    private String msg;

    PetSize(String id, String msg) {
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

    public static PetSize toEnum(String id){
        if(id.isEmpty()) return null;
        for (PetSize value : PetSize.values()) {
            if(value.getMsg() == id) return value;
        }
        return null;
    }


}

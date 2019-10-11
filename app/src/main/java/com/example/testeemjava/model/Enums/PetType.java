package com.example.testeemjava.model.Enums;

public enum PetType {
    DOG("DOG", "Cachorro"),
    CAT("CAT", "Gato");

    private String id;
    private String msg;

    PetType(String id, String msg) {
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

    public static PetType toEnum(String id){
        if(id.isEmpty()) return null;
        for (PetType value : PetType.values()) {
            if(value.getMsg() == id) return value;
        }
        return null;
    }
}

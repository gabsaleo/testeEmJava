package com.example.testeemjava.model.Enums;

public enum PetRecommendedTo {

    KIDS("KIDS", "Criança"),
    DEFICIENT("DEFICIENT", "Deficientes Visuais"),
    OLD_MAN("OLD_MAN", "Idosos"),
    ALL("ALL", "Todos");


    private String id;
    private String msg;

    PetRecommendedTo(String id, String msg) {
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

    public static PetRecommendedTo toEnum(String id){
        if(id.isEmpty()) return null;
        for (PetRecommendedTo value : PetRecommendedTo.values()) {
            if(value.getMsg() == id) return value;
        }
        return null;
    }
}

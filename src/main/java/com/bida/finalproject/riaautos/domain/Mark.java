package com.bida.finalproject.riaautos.domain;

public enum Mark {
    AUDI("Audi", 6), MERCEDES_BENZ("Mercedes-Benz", 48),
    VOLKSWAGEN("Volkswagen", 84), RENAULT("Renault", 62),
    BMW("BMW", 9), VOLVO("Volvo", 85), TOYOTA("Toyota", 79),
    HONDA("Honda", 28), INFINITI("Infiniti", 128);
    private String name;
    private int value;

    Mark(String name, int value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static String getNameByValue(long value){
        Mark[] marks = Mark.values();
        for(int i = 0; i < marks.length; i++){
            if (marks[i].value == value){
                return marks[i].name;
            }
        }
        return "";
    }
}

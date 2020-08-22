package com.bida.finalproject.riaautos.domain;

public enum BodyStyle {
    SEDAN("Седан", 3),KROSOVER("Внедорожник / Кроссовер", 5), MINIVAN("Минивэн", 8),
    HETCHBEK("Хэтчбек", 4), UNIVERSAL("Универсал", 2), CUPE("Купе", 6),
    LKW("Легковой фургон (до 1,5 т)", 254), CABRIOLET("Кабриолет", 7), PICKUP("Пикап", 9),
    LIFTBACK("Лифтбек", 307), LIMUZIN("Лимузин", 252), OTHER("Другой", 28), RODSTER("Родстер", 315);


    private String name;
    private int value;

    private BodyStyle(String name, int value){
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
}

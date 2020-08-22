package com.bida.finalproject.riaautos.domain;

public enum GearBox {
    MANUAL("Ручная / Механика", 1), AUTO("Автомат", 2),
    TYPETRONIC("Типтроник", 3), ADAPTIV("Адаптивная", 4),
    VARIATOR("Вариатор", 5);
    private String name;
    private int value;

    GearBox(){}

    GearBox(String name, int value) {
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

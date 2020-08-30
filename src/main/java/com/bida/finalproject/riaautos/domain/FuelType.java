package com.bida.finalproject.riaautos.domain;

public enum FuelType {
    BENZIN("Бензин", 1), DIZEL("Дизель", 2), GAZ("Газ", 3),
    GAZBENZIN("Газ/бензин", 4), GIBRID("Гибрид", 5), ELECTRO("Электро", 6),
    ANOTHER("Другое", 7), GAZMETAN("Газ метан", 8), GAZPROPANBUTAN("Газ пропан-бутан", 9);

    private String name;
    private int value;

    FuelType(){}

    FuelType(String name, int value) {
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
        FuelType[] fuelTypes = FuelType.values();
        for(int i = 0; i < fuelTypes.length; i++){
            if (fuelTypes[i].value == value){
                return fuelTypes[i].name;
            }
        }
        return "";
    }
}

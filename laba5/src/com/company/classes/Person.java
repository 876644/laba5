package com.company.classes;

import com.company.Enums.*;

public class Person {
    private String name;
    private String passportID;
    private ColorY eyeColor;
    private ColorH hairColor;
    private Country nationality;

    public Person(String name, String passportID, ColorY eyeColor, ColorH hairColor,Country nationality){
        this.name = name;
        this.passportID = passportID;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
    }
}

package model;

import java.util.Arrays;

public enum Category {

    Female("Female"),

    Male("Male"),

    Unisex("Unisex"),;

    private final String name;

    Category(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static Category fromName(String name) {
        return Arrays.stream(Category.values()).filter(c -> c.equals(name)).findFirst().orElseThrow();}
}

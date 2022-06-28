package com.example.bitsandpizzas;

public class Pasta {
    private final String name;
    private final int imageResourceId;

    public static final Pasta[] pastas = {
            new Pasta("Lasagne", R.drawable.lasagne_bolonese),
            new Pasta("Spaghetti Bolognese", R.drawable.spaghetti_bolognese)
    };

    public Pasta(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

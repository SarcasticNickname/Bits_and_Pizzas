package com.example.bitsandpizzas;

public class Store {
    private final String name;
    private final int imageResourceId;

    public static final Store[] stores = {
            new Store("Cambridge", R.drawable.cambridge),
            new Store("Sebastopol", R.drawable.sebastopol)
    };

    public Store(String name, int imageResourceId) {
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

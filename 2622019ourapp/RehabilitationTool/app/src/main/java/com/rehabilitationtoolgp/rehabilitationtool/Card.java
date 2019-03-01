package com.rehabilitationtoolgp.rehabilitationtool;

public class Card {
    public int id;
    public String Name;
    public byte[] Image;

    public Card(String name, byte[] image) {
        Name = name;
        Image = image;
    }

    public Card(int id, String name, byte[] image) {
        this.id = id;
        Name = name;
        Image = image;
    }
}

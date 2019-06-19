package com.rehabilitationtoolgp.rehabilitationtool;

public class Card {
    public int Id ;
    public String Name;
    public byte[] Image;

    public Card(int id, String name, byte[] image) {

        Id = id;
        Name = name;
        Image = image;
    }

    public Card(String name, byte[] image) {
        Name = name;
        Image = image;
    }
}

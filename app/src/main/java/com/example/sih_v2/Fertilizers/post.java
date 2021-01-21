package com.example.sih_v2.Fertilizers;

public class post {
    String Category;
    String Name;
    String Number;
    String URL;

    public post() {
    }

    @Override
    public String toString() {
        return "post{" +
                "Category='" + Category + '\'' +
                ", Name='" + Name + '\'' +
                ", Number='" + Number + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}

package com.example.listview_interactive_row;

public class RowModel {
    // atributos que representan una fila
    String label;
    float rating = 2.0f;


    // ---------- constructor --------------------
    public RowModel(String label, float rating) {
        this.label = label;
        this.rating = rating;
    }

    // ------------- getter y setter ---------------

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}

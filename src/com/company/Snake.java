package com.company;

public class Snake {
    int column;
    int row;
    int value;

    public Snake(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }
    public void move(int c, int r){
        this.column = c;
        this.row = r;
    }
}

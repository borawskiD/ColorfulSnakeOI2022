package com.company;

import java.util.LinkedList;
import java.util.Scanner;

//test input from task:
//6 5 14 1 3 1 5 1 5 2 3 2 3 4 1 3 5 3 Z 1 1 Z 1 2 P P D D P Z 3 5 P Z 3 5 D Z 3 5 L Z 3 5
//output:
//0 -1 -1 3 1 2
public class Task {
    Scanner sc = new Scanner(System.in);
    int m;
    int p;
    int n;
    int[][] board;
    LinkedList<Snake> snakes = new LinkedList<>();

    public void run() {
        snakes.add(new Snake(0, 0, 0));
        m = sc.nextInt();
        p = sc.nextInt();
        n = sc.nextInt();
        board = generateBoard(m);
        int header;
        int row = 0;
        int column = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            switch (s) {
                case "P" -> column++;
                case "L" -> column--;
                case "G" -> row--;
                case "D" -> row++;
                case "Z" -> {
                    int r = sc.nextInt();
                    int c = sc.nextInt();
                    System.out.println(snakeValueAt(c - 1, r - 1));
                    continue;
                }
            }

            if (board[row][column] > 0) {
                header = board[row][column];
                snakes.add(0, new Snake(column, row, header));
            } else {
                snakes = moveSnake(snakes);
                snakes.get(0).move(column, row);
            }
        }
    }

    public LinkedList<Snake> moveSnake(LinkedList<Snake> snakes) {
        int row = snakes.get(0).row;
        int column = snakes.get(0).column;
        for (int i = 1; i < snakes.size(); i++) {
            Snake snake = snakes.get(i);
            int oldR = snake.row;
            int oldC = snake.column;
            snake.column = column;
            snake.row = row;
            snakes.set(i, snake);
            row = oldR;
            column = oldC;
        }
        return snakes;
    }

    public int snakeValueAt(int c, int r) {
        for (Snake snake : snakes) {
            if (snake.column == c && snake.row == r) return snake.value;
        }
        return -1;
    }

    public int[][] generateBoard(int m) {
        board = new int[m][m];
        board = startingValues(board);
        for (int i = 0; i < p; i++) {
            int w = sc.nextInt();
            int k = sc.nextInt();
            int c = sc.nextInt();
            board[w - 1][k - 1] = c;
        }
        return board;
    }

    public int[][] startingValues(int[][] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = 0;
            }
        }
        return board;
    }
}
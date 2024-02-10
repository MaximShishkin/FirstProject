package ru.shishkin.maxim.versus;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        new ThreadWithMusic();

        JFrame okno = new JFrame("Stark Vs Tanos");
        okno.setBounds(10, 10, 1200, 700);
        okno.setResizable(false);
        okno.add(new Panel());
        okno.setVisible(true);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

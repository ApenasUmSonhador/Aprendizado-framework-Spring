package br.com.ApenasUmSonhador.ScreenMatch.utils;

import java.util.Scanner;

public class Scan {
    private Scanner scanner = new Scanner(System.in);

    public String nextLine() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public int nextInt() {
        return scanner.nextInt();
    }

    public String urlString() {
        return nextLine().replace(" ", "+");
    }
}

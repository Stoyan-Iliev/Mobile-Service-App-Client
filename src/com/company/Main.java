package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        Scanner scanner = new Scanner(System.in);
        Scanner serverScanner = new Scanner(socket.getInputStream());
        PrintStream printout = new PrintStream(socket.getOutputStream());

        while (true) {
            try {
                String output = serverScanner.nextLine();
                while (!output.equals("#")) {
                    System.out.println(output);
                    output = serverScanner.nextLine();
                }
            } catch (NoSuchElementException e) {
                break;
            }

            printout.println(scanner.nextLine());
        }
    }
}

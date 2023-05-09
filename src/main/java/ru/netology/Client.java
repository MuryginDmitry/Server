package ru.netology;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Write your name");
            out.println(scanner.nextLine());
            String resp = in.readLine();
            System.out.println(resp);
            out.println(scanner.nextLine());
            String resp2 = in.readLine();
            System.out.println(resp2);
            if (resp2.contains("?")) {
                out.println(scanner.nextLine());
                String resp3 = in.readLine();
                System.out.println(resp3);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
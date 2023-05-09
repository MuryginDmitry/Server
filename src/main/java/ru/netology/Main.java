package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ) {
                    System.out.println("New connection accepted");
                    final String name = in.readLine();
                    out.println(String.format("Hi %s, Are you child? (yes/no)", name));
                    final String child = in.readLine();
                    if (child.equals("yes")) {
                        out.println(String.format("Welcome to the kids area, %s! Let's play! What game you want to play?", name));
                    } else {
                        out.println(String.format
                                ("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                    }
                    final String game = in.readLine();
                    out.println(String.format("%s is loading...", game));

                }
            }
        }
    }
}
package com.cieep.padre;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", "Ejercicio01_Separacion.jar");
        Process process = processBuilder.start();
        processBuilder.redirectErrorStream(true);


        InputStreamReader isr = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);

        OutputStream osw = process.getOutputStream();
        PrintStream ps = new PrintStream(osw);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Dime una frase");
        String frase = scanner.nextLine();

        // Le paso la frase al hijo
        ps.println(frase);
        ps.flush();


        // Me pongo a leer su respuesta
        String palabra;

        while (!(palabra = br.readLine()).equalsIgnoreCase("fin"))
        {
            System.out.println(palabra);
        }


    }
}
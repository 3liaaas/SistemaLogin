package br.com.sistemalogin.eliasrodrigues;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ArmazenarContagemTentativas {
    public static int lerContador() throws IOException{
        FileReader fr = new FileReader("Contador.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        System.out.println(linha);
        int linhaConverter = Integer.parseInt(linha);
        return linhaConverter;
    }

    public static void salvarContador(int valor) throws IOException {

        FileWriter fw = new FileWriter("Contador.txt");
        fw.write(String.valueOf(valor));
        fw.close();
    }
}



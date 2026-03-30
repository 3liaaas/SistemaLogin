package br.com.sistemalogin.eliasrodrigues;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.io.IOException;
import java.util.Scanner;

public class SistemaLogin {
    private static final String USUARIO_CORRETO = "admin";
    private static final String SENHA_CORRETA = "$2a$12$GTBUhX3AgPlOEs8jauard.WUac6Kv5vdfpUCTTAHBhGS.vzdwRg3K   ";
    private static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tentativas = ArmazenarContagemTentativas.lerContador();
        boolean acesso_concedido = false;

        while (tentativas < MAX_TENTATIVAS) {
            System.out.println("Usuário: ");
            String usuario = sc.nextLine();
            System.out.println("Senha; ");
            String senha = sc.nextLine();

            boolean ok = BCrypt.verifyer().verify(senha.toCharArray(), SENHA_CORRETA).verified;

            if (usuario.equals(USUARIO_CORRETO) && ok) {
                acesso_concedido = true;
                ArmazenarContagemTentativas.salvarContador(0);
                break;
            } else {
                tentativas++;
                ArmazenarContagemTentativas.salvarContador(tentativas);
                int restantes = MAX_TENTATIVAS - tentativas;
                System.out.println("Credenciais inválidas. Tentativas restantes: " + restantes);

            }
        }

        if (acesso_concedido) {
            System.out.println("Acesso concedido. Bem-vindo, " + USUARIO_CORRETO);
        } else {
            System.out.println("CONTA BLOQUEADA. Número máximo de tentativas atingido");
        }
        sc.close();
    }
}
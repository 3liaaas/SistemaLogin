package br.com.sistemalogin.eliasrodrigues;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.util.Scanner;

public class SistemaLogin {
    private static final String USUARIO_CORRETO = "admin";
    private static final String SENHA_CORRETA = "Senha2026!";
    private static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tentativas = 0;
        boolean acesso_concedido = false;

        while (tentativas < MAX_TENTATIVAS) {
            System.out.println("Usuário: ");
            String usuario = sc.nextLine();
            System.out.println("Senha; ");
            String senha = sc.nextLine();

            String hash = BCrypt.withDefaults().hashToString(12, senha.toCharArray());

            if (usuario.equals(USUARIO_CORRETO) && senha.equals(SENHA_CORRETA)) {
                acesso_concedido = true;
                break;
            } else {
                tentativas++;
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
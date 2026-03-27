package br.com.sistemalogin.eliasrodrigues;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class TesteSenha {
    public static void main(String[] args) {
        String senha = "minhasenha123";

        // Gera o hash
        String hash = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        System.out.println("Hash gerado: " + hash);

        // Verifica se a senha bate com o hash
        boolean ok = BCrypt.verifyer().verify(senha.toCharArray(), hash).verified;
        System.out.println("Senha correta? " + ok);
    }
}

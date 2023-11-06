package CriptografasSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Desafio1CriptografarSenhaModalGR {

    private static final String CHAVE_SECRETA = "#modalGR#GPTW#top#maiorEmpresaTecnologia#baixadaSantista";

    public static String criptografarSenha(String senha, String metodoCriptografia) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(metodoCriptografia);
        digest.update(senha.getBytes());
        byte[] hash = digest.digest();
        return Arrays.toString(hash);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String senha1 = "senha1";
        String senha2 = "senha2";
        String senha3 = "senha3";

        //  SHA-256
        String senha1Criptografada = Desafio1CriptografarSenhaModalGR.criptografarSenha(senha1, "SHA-256");
        System.out.println("Senha 1 criptografada com SHA-256: " + senha1Criptografada);

        //  MD5
        String senha2Criptografada = Desafio1CriptografarSenhaModalGR.criptografarSenha(senha2, "MD5");
        System.out.println("Senha 2 criptografada com MD5: " + senha2Criptografada);

        //  BCrypt
        try {
            String senha3Criptografada = Desafio1CriptografarSenhaModalGR.criptografarSenha(senha3, "BCrypt");
            System.out.println("Senha 3 criptografada com BCrypt: " + senha3Criptografada);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro: Algoritmo BCrypt não disponível.");
        }
    }
}

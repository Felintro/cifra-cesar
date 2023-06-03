package br.edu.feitep;

import br.edu.feitep.cifrador.Cifrador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo!");
        System.out.println("Selecione a opção desejada:");
        System.out.println("1 - Criptografar");
        System.out.println("2 - Descriptografar");
        System.out.println("3 - Força bruta");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nInsira o número da chave desejada:");
        System.out.println("OBS: Apenas números inteiros positivos são aceitos!");

        int chave = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nInsira a mensagem que deseja codificar/decodificar:");
        System.out.println("OBS: Apenas letras e espaços são aceitos!");

        String texto = scanner.nextLine();

        Cifrador cifrador = new Cifrador(chave, texto);

        String textoPosCesar;

        switch (opcao){
            case 1:
                textoPosCesar = cifrador.encriptar();
                System.out.println("\nTexto cifrado: " + textoPosCesar);
                break;

            case 2:
                textoPosCesar = cifrador.desencriptar();
                System.out.println("\nTexto decifrado: " + textoPosCesar);
                break;

            case 3:
                List<String> listaCombinacoes = cifrador.desencriptarForcaBruta();
                System.out.println("\nPossíveis combinações: \n");
                for(String str : listaCombinacoes) {
                    System.out.println(str);
                }
                break;

        }

        System.out.println("Pressione ENTER para encerrar!");
        scanner.nextLine();
        scanner.close();

    }

}
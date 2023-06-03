package br.edu.feitep.cifrador;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Cifrador {
    private int chave;
    private String texto;
    private static char[] ALFABETO_MINUSCULO = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] ALFABETO_MAIUSCULO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    public String encriptar() {

        StringBuilder mensagemCriptografada = new StringBuilder();
        char aux;

        for(int i=0; i<texto.length(); i++) {

            if(texto.charAt(i) == 32){ /* Tratamento para espaços */
                mensagemCriptografada.append(" ");
            }

            else if(new String(ALFABETO_MAIUSCULO).contains(""+ texto.charAt(i))) {/* Tratamento para maiúsculas */
                aux = calculaCharCriptografado(65, texto.charAt(i), ALFABETO_MAIUSCULO);
                mensagemCriptografada.append(aux);
            }

            else {/* Tratamento para minúsculas */
                aux = calculaCharCriptografado(97, texto.charAt(i), ALFABETO_MINUSCULO);
                mensagemCriptografada.append(aux);
            }

        }

        return mensagemCriptografada.toString();

    }

    public String desencriptar () {

        StringBuilder mensagemDescriptografada = new StringBuilder();
        char aux;

        for(int i=0; i<texto.length(); i++) {

            if (texto.charAt(i) == 32) { /* Tratamento para espaços */
                mensagemDescriptografada.append(" ");
            }

            else if(new String(ALFABETO_MAIUSCULO).contains("" + texto.charAt(i))) {/* Tratamento para maiúsculas */
                aux = calculaCharDescriptografado(65, texto.charAt(i), ALFABETO_MAIUSCULO);
                mensagemDescriptografada.append(aux);
            }

            else {/* Tratamento para minúsculas */
                aux = calculaCharDescriptografado(97, texto.charAt(i), ALFABETO_MINUSCULO);
                mensagemDescriptografada.append(aux);
            }

        }

        return mensagemDescriptografada.toString();

    }

    public List<String> desencriptarForcaBruta() {
        List<String> possiveisCombinacoes = new ArrayList<>();
        String str;

        for(int i=1; i<=26; i++){
            chave = i;
            str = "Chave " + chave + ": " + desencriptar();
            possiveisCombinacoes.add(str);
        }

        return possiveisCombinacoes;

    }

    private char calculaCharCriptografado(int valorASC2, char caracter, char[] alfabeto) {
        int k = caracter - valorASC2 + chave;

        if(k > 25)
            k -= 26;

        return alfabeto[k];
    }

    private char calculaCharDescriptografado(int valorASC2, char caracter, char[] alfabeto) {
        int k = caracter - valorASC2 - chave;

        if(k < 0)
            k += 26;

        return alfabeto[k];
    }

}
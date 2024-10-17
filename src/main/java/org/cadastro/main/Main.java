package org.cadastro.main;

import org.cadastro.model.Jogador;
import org.cadastro.negocio.JogadorImpl;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        JogadorImpl jogImpl = new JogadorImpl();
        String enderecoDir = "C:\\java_util\\estudos\\streams";
        String nomeArquivo = "jogadores.txt";
        List<Jogador> listaDeJogadores = jogImpl.getListaDeJogadores(Paths.get(enderecoDir + "\\" + nomeArquivo));

        if (!jogImpl.verificarArquivoExiste(Paths.get(enderecoDir))){
            System.out.println("Arquivo não encontrado");
        }else {
            System.out.println("Arquivo encontrado");
            //jogImpl.imprimirJogadores(listaDeJogadores);
            //jogImpl.imprimirJogadoresPorTime(listaDeJogadores, "Corinthians");
            //jogImpl.imprimirJogadoresTimeGol(listaDeJogadores, "Corinthians");
            //jogImpl.agruparJogadoresPorTime(listaDeJogadores);
            //System.out.println(jogImpl.calcularMediaIdade(listaDeJogadores));
            //jogImpl.imprimirJogadorMaisVelho(listaDeJogadores);
            //jogImpl.imprimirJogadorMaisNovo(listaDeJogadores);
            //jogImpl.imprimirArtilheiro(listaDeJogadores);
            //jogImpl.imprimirSomatorioDeGols(listaDeJogadores);
            //jogImpl.agruparJogadoresPorTime(listaDeJogadores);
            jogImpl.ordenarJogadoresGol(listaDeJogadores);
        }
    }


}

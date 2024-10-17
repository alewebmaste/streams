package org.cadastro.negocio;

import org.cadastro.model.Jogador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JogadorImpl {

    public boolean verificarArquivoExiste(Path caminho){

        boolean ret = false;

        try {
            Stream<Path> stream = Files.list(caminho);
            Optional<Path> arq = stream.filter(p -> p.toString().endsWith("jogadores.txt")).findAny();
            ret = arq.isPresent();

        }catch (IOException ex){
            ex.printStackTrace();
        }

        return ret;
    }

    public List<Jogador> getListaDeJogadores(Path caminho) throws IOException {

        Stream<String> linhas = Files.lines(caminho, StandardCharsets.UTF_8);
        List<String> listaDeLinhas = linhas.collect(Collectors.toList());
        List<Jogador> listaDeJogadores = new ArrayList<>();
        Jogador jogador;
        Iterator it = listaDeLinhas.listIterator();
        String str = null;
        while (it.hasNext()){
            str = (String) it.next();
            String info[] = str.split(",");
            jogador = new Jogador();
            jogador.setNome(info[0]);
            jogador.setPosicao(info[1]);
            jogador.setIdade(Integer.parseInt(info[2]));
            jogador.setTimeAtual(info[3]);
            jogador.setGolsMarcados(Integer.parseInt(info[4]));
            listaDeJogadores.add(jogador);
        }

        return listaDeJogadores;

    }

    public void imprimirJogadores(List<Jogador> jogadores){
        jogadores.forEach(System.out::println);
    }

    public void imprimirJogadoresPorTime(List<Jogador>jogadores, String time){
        jogadores.stream().filter(j -> j.getTimeAtual().equals(time)).forEach(System.out::println);
    }

    public void imprimirJogadoresTimeGol(List<Jogador> jogadores, String time){
        jogadores.stream()
                .filter(j -> j.getTimeAtual().equals(time) && j.getGolsMarcados() > 10)
                .forEach(System.out::println);
    }

    public void agruparJogadoresPorTime(List<Jogador> jogadores){
        jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getTimeAtual))
                .forEach(System.out::println);

    }

    public double calcularMediaIdade(List<Jogador> jogadores){
        return jogadores.stream().mapToInt(Jogador::getIdade).average().getAsDouble();
    }

    public void imprimirJogadorMaisVelho(List<Jogador> jogadores){
        Jogador jogador = jogadores.stream().max(Comparator.comparingInt(Jogador::getIdade)).get();
        System.out.println(jogador);
    }

    public void imprimirJogadorMaisNovo(List<Jogador> jogadores){
        Jogador jogador = jogadores.stream().min(Comparator.comparing(Jogador::getIdade)).get();
        System.out.println(jogador);
    }

    public void imprimirArtilheiro(List<Jogador> jogadores){

        Jogador jogador = jogadores.stream().max(Comparator.comparing(Jogador::getGolsMarcados)).get();
        System.out.println("Artilheiro: " + jogador.getNome());

    }

    public void imprimirSomatorioDeGols(List<Jogador> jogadores){
        int totalDeGols = jogadores.stream().mapToInt(j -> j.getGolsMarcados()).sum();
        System.out.println("Total de gols: " + totalDeGols);
    }

    public void agruparJogadoresPeloTime(List<Jogador> jogadores){
        Map<String, List<Jogador>> groupingByTime = jogadores.stream().collect(Collectors.groupingBy(Jogador::getTimeAtual));
        System.out.println(groupingByTime);
    }

    public void ordenarJogadoresGol(List<Jogador> jogadores){
        jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getGolsMarcados)
                        .reversed())
                .forEach(System.out::println);
    }
}
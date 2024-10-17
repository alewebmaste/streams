package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**Estudo de streams baseado no artigo oracle
 <a href="https://www.oracle.com/br/technical-resources/articles/java-stream-api.html">...</a>**/
public class Main {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new Pessoa().populaPessoas();

        //OPERAÇÕES INTERMEDIARIAS

        //Map
        List<Integer> idadesFiltradasPorNacionalidade = pessoas.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .map(Pessoa::getIdade)
                .toList();

        //Sorted
        List<Integer> filtradoEOrdenadoPorIdade = pessoas.stream()
                .map(Pessoa::getIdade)
                .filter(idade -> idade >= 18)
                .sorted(Integer::compareTo)
                .toList();

        List<Pessoa> filtradoPorNacionalidadeEOrdenadoPorNome = pessoas.stream()
                .filter(p -> p.getNacionalidade().equals("Brasil"))
                .sorted(Comparator.comparing(Pessoa::getNome))
                .toList();

        //Distinct
        List<Pessoa> naoRetetirObjetosIguais = pessoas.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .distinct()
                .toList();

        //Limit
        List<Pessoa> limitandoListaAPartirDeStream = pessoas.stream().limit(2).toList();

        //OPERAÇÕES TERMINAIS

        //Foreach
        pessoas.stream()
                .distinct()
                .forEach(p -> System.out.println(p.getNome()));

        //Average
        double mediaIdadeBrasileiros = pessoas.stream().
                filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .mapToInt(Pessoa::getIdade)
                .average()
                .getAsDouble();

        System.out.println(mediaIdadeBrasileiros);

        //Collect
        List<Pessoa> pessoasComM = pessoas.stream()
                .filter(pessoa -> pessoa.getNome().startsWith("M"))
                .distinct()
                .collect(Collectors.toList());


        //Count
        long totalDePessoasComN = pessoas.stream()
                .filter(pessoa -> pessoa.getNome().startsWith("N"))
                .count();



        //AllMatch
        boolean verificaSeTodosNasceramNoBrasil = pessoas.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("Brasil"));

        System.out.println(verificaSeTodosNasceramNoBrasil);
    }
}
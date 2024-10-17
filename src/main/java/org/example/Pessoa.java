package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    String id;
    String nome;
    String nacionalidade;
    int idade;  //gets e sets omitidos

    public Pessoa() {
    }

    public Pessoa(String id, String nome, String nacionalidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Pessoa> populaPessoas() {
        Pessoa pessoa1 = new Pessoa("p1", "Matheus Henrique", "Brasil", 24);
        Pessoa pessoa2 = new Pessoa("p2", "Hernandez Roja", "Mexico", 21);
        Pessoa pessoa3 = new Pessoa("p3", "Mario Fernandes", "Canada", 22);
        Pessoa pessoa4 = new Pessoa("p4", "Neymar Junior", "Brasil", 28);
        Pessoa pessoa5 = new Pessoa("p5", "João Couve", "Brasil", 16);
        Pessoa pessoa6 = new Pessoa("p6", "Maria Silva", "Brasil", 15);
        Pessoa pessoa7 = new Pessoa("p6", "Maria Silva", "Brasil", 15);

        List<Pessoa> list = new ArrayList<Pessoa>();
        list.add(pessoa1);
        list.add(pessoa2);
        list.add(pessoa3);
        list.add(pessoa4);
        list.add(pessoa5);
        list.add(pessoa6);
        list.add(pessoa7);
        return list;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

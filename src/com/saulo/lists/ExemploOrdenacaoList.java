package com.saulo.lists;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 12, cor: preto
Gato 2 = nome: Simba, idade: 14, cor: tigrado
Gato 3 = nome: Jon, idade: 18, cor: amarelo
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> listaGatos = new ArrayList<>();

        listaGatos.add(new Gato("Jon", 12, "Preto"));
        listaGatos.add(new Gato("Simba", 14, "Tigrado"));
        listaGatos.add(new Gato("Jon", 18, "Amarelo"));
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem de Inserção\t---");
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem Aleatória\t---");
        Collections.shuffle(listaGatos);
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem pelo nome\t---");
        Collections.sort(listaGatos);
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem pela idade\t---");
        //Collections.sort(listaGatos, new ComparatorIdade());
        listaGatos.sort(new ComparatorIdade());
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem pela cor\t---");
        Collections.sort(listaGatos, new ComparatorCor());
        //listaGatos.sort(new ComparatorCor());
        System.out.println(listaGatos);

        System.out.println("\n--\tOrdem por Nome/cor/idade\t---");
        //Collections.sort(listaGatos, new ComparatorNomeCorIdade());
        listaGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(listaGatos);

    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "\n{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {

        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}
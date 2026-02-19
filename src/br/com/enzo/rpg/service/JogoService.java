package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.util.Console;

import java.util.Scanner;

public class JogoService {
    private Scanner leitor = new Scanner(System.in);

    public void iniciar() {
        System.out.println("============================");
        System.out.println("  \uD83D\uDDE1\uFE0F RPG JAVA \uD83D\uDDE1\uFE0F");
        System.out.println("============================");


        System.out.print("Digite o nome do seu personagem: ");
        String nome = Console.lerString();
        ClassePersonagem classeEscolhida = escolherClasse();

        Jogador jogador = new Jogador(nome, classeEscolhida);
        System.out.println("Bem vindo " + jogador.getNome() + "!");
        int op = 0;

        do {

            System.out.println("==========================");
            System.out.println("Personagem: " + jogador.getNome());
            System.out.println("Classe: " + jogador.getClasse().name());
            System.out.println("Ataques: " + jogador.getAtaque().getNome());
            System.out.println("XP: ");
            System.out.println("==========================");
            System.out.println("MENU");
            System.out.println("1)Batalhar");
            System.out.println("2)Treinar");
            System.out.println("3)Sair");
            op = Console.lerInt();

        } while (op != 3);

    }

    public ClassePersonagem escolherClasse() {
        System.out.println("\nEscolha sua classe:");
        ClassePersonagem[] classes = ClassePersonagem.values();

        for (int i = 0; i < classes.length; i++) {
            System.out.println((i + 1) + " - " + classes[i]);
        }
        int escolha = Console.lerInt();
        if (escolha < 1 || escolha > classes.length) {
            System.out.println("Opção inválida!");
            return escolherClasse();
        }
        return classes[escolha - 1];

    }


}

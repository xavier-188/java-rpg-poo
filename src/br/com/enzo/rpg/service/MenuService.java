package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.Console;

public class MenuService {

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


    public int menuPrincipal(Jogador jogador) {

            System.out.println("\n==========================");
            System.out.println("Personagem: " + jogador.getNome());
            System.out.println("Classe: " + jogador.getClasse().name());
            System.out.println("Ataques: " + jogador.getAtaque().getNome());
            System.out.println("XP: " + jogador.getXp());
            System.out.println("==========================\n");
            System.out.println("MENU");
            System.out.println("1)Batalhar");
            System.out.println("2)Treinar");
            System.out.println("3)Sair");
            return Console.lerInt();
    }

    public TipoInimigo escolherInimigo(Jogador jogador) {

        System.out.println("\nEscolha um inimigo");

        TipoInimigo[] inimigos = TipoInimigo.values();

        for (int i = 0; i < inimigos.length; i++) {

            TipoInimigo inimigo = inimigos[i];

            if (jogador.getXp() >= inimigo.getXpNecessario()) {
                System.out.println((i + 1) + " - " + inimigo.getNome());
            } else {
                System.out.println((i + 1) + " - " + inimigo.getNome() + " Bloqueado - XP Necessário: " + inimigo.getXpNecessario());
            }

        }
        int escolha = Console.lerInt();
        TipoInimigo escolhido = inimigos[escolha - 1];
        if (jogador.getXp() < escolhido.getXpNecessario()) {
            System.out.println("Você não tem XP suficiente");
            return null;
        }
        return escolhido;

    }




}

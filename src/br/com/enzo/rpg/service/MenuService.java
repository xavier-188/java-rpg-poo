package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.Console;
import br.com.enzo.rpg.util.InimigoFactory;

import java.util.Random;

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
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("XP: " + jogador.getXp());
        System.out.println("==========================\n");
        System.out.println("MENU");
        System.out.println("1)Explorar");
        System.out.println("2)Treinar");
        System.out.println("3)Descansar");
        System.out.println("4)Sair");
        return Console.lerInt();
    }

//    public TipoInimigo escolherInimigo(Jogador jogador) {
//
//        System.out.println("\nEscolha um inimigo");
//        TipoInimigo[] inimigos = TipoInimigo.values();
//
//        for (int i = 0; i < inimigos.length; i++) {
//
//            TipoInimigo inimigo = inimigos[i];
//
//            if (jogador.getNivel() >= inimigo.getNivelNecessario()) {
//                System.out.println((i + 1) + " - " + inimigo.getNome());
//            } else {
//                System.out.println((i + 1) + " - " + inimigo.getNome() + " Bloqueado - XP Necessário: " + inimigo.getNivelNecessario());
//            }
//
//        }
//        int escolha = Console.lerInt();
//        TipoInimigo escolhido = inimigos[escolha - 1];
//        if (jogador.getXp() < escolhido.getNivelNecessario()) {
//            System.out.println("Nível insuficiente");
//            return null;
//        }
//        return escolhido;
//
//    }


    public void treinar(Jogador jogador) {
        System.out.print(jogador.getNome() + " está treinando");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jogador.ganharXp(10);
        System.out.println("\nTreinou! + 10xp");
    }


}

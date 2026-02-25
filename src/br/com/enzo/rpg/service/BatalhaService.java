package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.Console;

import java.awt.*;

public class BatalhaService {

    private MenuService menuService = new MenuService();


    public void batalhar(Jogador jogador, Inimigo inimigo) {

        System.out.println("\nVocê está enfrentando: " + inimigo.getNome());

        while (inimigo.estaVivo() && jogador.getVida() > 0) {

            System.out.println("\n1) Atacar - " + jogador.getAtaque().getNome());
            System.out.println("2) Fugir");
            int op = Console.lerInt();

            switch (op) {

                case 1:
                    inimigo.receberDano(jogador.getAtaque().getDano());
                    System.out.println(jogador.getNome() + " atacou " + inimigo.getNome() + " com " + jogador.getAtaque().getNome());
                    if (inimigo.estaVivo()) {
                        jogador.receberDano(inimigo.getDano());
                        System.out.println(inimigo.getNome() + " contra-atacou!\n");
                        System.out.println(jogador.getNome() + ": " + jogador.getVida() + "----🗡️----" + inimigo.getNome() + ": " + inimigo.getVida());
                    }
                    break;

                case 2:
                    System.out.println("Você fugiu!");
                    return;
            }
        }
        if (jogador.getVida() <= 0) {
            System.out.println("Você foi derrotado!");
            return;
        }

        System.out.println("Você derrotou " + inimigo.getNome());
        jogador.ganharXp(inimigo.getXpConcedido());
        System.out.println("XP Concedido: " + inimigo.getXpConcedido());
    }


}




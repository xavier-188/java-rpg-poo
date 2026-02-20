package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.Console;

import java.awt.*;

public class BatalhaService {

    private MenuService menuService = new MenuService();


    public void batalhar(Jogador jogador) {

        TipoInimigo inimigoEscolhido = menuService.escolherInimigo(jogador);

        if (inimigoEscolhido == null) {
            return;
        }

        Inimigo inimigo = new Inimigo(
                inimigoEscolhido.getNome(),
                inimigoEscolhido.getVida(),
                inimigoEscolhido.getDano()
        );

        while (inimigo.estaVivo()) {

            System.out.println("\n1) Atacar - " + jogador.getAtaque().getNome());
            System.out.println("2) Fugir");
            int op = Console.lerInt();

            switch (op) {

                case 1:
                    System.out.println(jogador.getNome() + " atacou "
                            + inimigo.getNome() + " com "
                            + jogador.getAtaque().getNome());

                    inimigo.receberDano(jogador.getAtaque().getDano());
                    break;

                case 2:
                    System.out.println("Você fugiu!");
                    return;
            }
        }

        System.out.println("Você derrotou " + inimigo.getNome());
        jogador.ganharXp(inimigoEscolhido.getXpConcedido());
        System.out.println("XP Concedido: " + inimigoEscolhido.getXpConcedido());
    }

}




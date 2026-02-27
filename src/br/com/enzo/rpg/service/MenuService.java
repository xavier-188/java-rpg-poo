package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.Console;
import br.com.enzo.rpg.util.InimigoFactory;

import java.util.Random;

public class MenuService {


    public int menuPrincipal(Jogador jogador) {

        System.out.println("\n===========VOCÊ===========");
        System.out.println("Personagem: " + jogador.getNome());
        System.out.println("Classe: " + jogador.getClasse().name());
        System.out.println("Stats: " + "VidaMax: " + jogador.getVidaMaxima() + " | Ataque/Dano: " + jogador.getAtaque().getDano());
        System.out.println("Nível: " + jogador.getNivel());
        System.out.println("XP: " + jogador.getXp());
        System.out.println("==========================\n");
        System.out.println("===========MENU===========");
        System.out.println("1 - Explorar");
        System.out.println("2 - Treinar");
        System.out.println("3 - Descansar");
        System.out.println("4 - Inventário");
        System.out.println("5 - Salvar");
        System.out.println("6 - Sair(Salve antes)");
        System.out.println("==========================");
        return Console.lerInt();
    }
}

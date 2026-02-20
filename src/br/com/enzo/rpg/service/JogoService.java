package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.BarraUtil;
import br.com.enzo.rpg.util.Console;

import java.util.Scanner;

public class JogoService {
    private Scanner leitor = new Scanner(System.in);
    private MenuService menuService = new MenuService();
    private BatalhaService batalhaService = new BatalhaService();

    public void iniciar() {
        System.out.println("============================");
        System.out.println("  \uD83D\uDDE1\uFE0F RPG JAVA \uD83D\uDDE1\uFE0F");
        System.out.println("============================");


        System.out.print("Digite o nome do seu personagem: ");
        String nome = Console.lerString();
        ClassePersonagem classeEscolhida = menuService.escolherClasse();
        Jogador jogador = new Jogador(nome, classeEscolhida);
        System.out.println("Bem vindo " + jogador.getNome() + "!");

        int op = 0;

        do {
            op = menuService.menuPrincipal(jogador);
            switch (op){

                case 1:
                    batalhaService.batalhar(jogador);
                    break;
            }

        }while (op != 3);



    }
}

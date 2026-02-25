package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.util.BarraUtil;
import br.com.enzo.rpg.util.Console;
import br.com.enzo.rpg.util.InimigoFactory;

import java.util.Random;
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
            switch (op) {

                case 1:
                    explorar(jogador);
                    break;

                case 2:
                    menuService.treinar(jogador);
                    break;

                case 3:
                    jogador.descansar();
                    break;

            }

        } while (op != 4);


    }

    public void explorar(Jogador jogador) {
        System.out.println("\nVocê saiu para explorar...");
        Random random = new Random();
        int evento = random.nextInt(100);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (evento <= 50) {
            Inimigo inimigo = InimigoFactory.gerarInimigo(jogador.getNivel());
            System.out.println("Você encontrou um " + inimigo.getNome());
            batalhaService.batalhar(jogador, inimigo);

        }
    }
}

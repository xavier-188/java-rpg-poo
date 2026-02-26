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
                    jogador.listaItens();
                    break;

                case 4:
                    jogador.descansar();
                    break;

            }

        } while (op != 5);


    }

    public void explorar(Jogador jogador) {
        System.out.print("\nVocê saiu para explorar");
        Random random = new Random();
        int evento = random.nextInt(100);

        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(550);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (evento <= 70) {
            Inimigo inimigo = InimigoFactory.gerarInimigo(jogador.getNivel());
            if (inimigo.getNome().equalsIgnoreCase("Dragão(Boss Final)")){
                System.out.println("\nPrepare-se para a batalha final...!");
            }
            System.out.println("\nVocê encontrou um " + inimigo.getNome() + "!");
            batalhaService.batalhar(jogador, inimigo);
        } else {
            System.out.println("\nVocê não encontrou nada nessa viagem!");
        }
    }
}

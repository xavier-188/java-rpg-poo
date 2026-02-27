package br.com.enzo.rpg.service;

import br.com.enzo.rpg.model.ClassePersonagem;
import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.persistence.SaveGame;
import br.com.enzo.rpg.util.Console;
import br.com.enzo.rpg.util.InimigoFactory;

import java.util.Random;
import java.util.Scanner;

public class JogoService {
    private final Scanner leitor = new Scanner(System.in);
    private final MenuService menuService = new MenuService();
    private final BatalhaService batalhaService = new BatalhaService();

    public void iniciar() {
        System.out.println("============================");
        System.out.println("  \uD83D\uDDE1\uFE0F RPG JAVA \uD83D\uDDE1\uFE0F");
        System.out.println("============================\n");
        System.out.println("1 - Novo Jogo");
        System.out.println("2 - Carregar Jogo");
        int opcao = Console.lerInt();
        Jogador jogador;
        if (opcao == 2) {
            jogador = SaveGame.carregar();
            if (jogador == null) {
                System.out.println("Nenhum save encontrado...Criando Novo Jogo!");
                jogador = criarNovoJogador();
            }
        } else {
            jogador = criarNovoJogador();
        }

        int op;

        do {
            op = menuService.menuPrincipal(jogador);

            switch (op) {

                case 1:
                    explorar(jogador);
                    break;

                case 2:
                    treinar(jogador);
                    break;

                case 3:
                    jogador.descansar();
                    break;

                case 4:
                    jogador.listaItens();
                    break;

                case 5:
                    SaveGame.salvar(jogador);

            }

        } while (op != 6);
    }

    public Jogador criarNovoJogador() {
        System.out.print("Digite o nome do seu personagem: ");
        String nome = Console.lerString();
        ClassePersonagem classeEscolhida = escolherClasse();
        Jogador jogador = new Jogador(nome, classeEscolhida);
        System.out.println("Bem vindo " + jogador.getNome() + "!");
        return jogador;
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
            if (inimigo.getNome().equalsIgnoreCase("Dragão(Boss Final)")) {
                System.out.println("\nPrepare-se para a batalha final...!");
            }
            System.out.println("\nVocê encontrou um " + inimigo.getNome() + "!");
            batalhaService.batalhar(jogador, inimigo);
        } else {
            System.out.println("\nVocê não encontrou nada nessa viagem!");
        }
    }

    public void treinar(Jogador jogador) {
        System.out.print(jogador.getNome() + " está treinando");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(550);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jogador.ganharXp(30);
        jogador.getAtaque().setDano(jogador.getAtaque().getDano() + 2);
        System.out.println("\nTreinou! + 30xp | + 2 Ataque/Dano");
    }

   /* Para Futuro Modo Arena;)

    public TipoInimigo escolherInimigo(Jogador jogador) {

        System.out.println("\nEscolha um inimigo");
        TipoInimigo[] inimigos = TipoInimigo.values();

        for (int i = 0; i < inimigos.length; i++) {

            TipoInimigo inimigo = inimigos[i];

            if (jogador.getNivel() >= inimigo.getNivelNecessario()) {
                System.out.println((i + 1) + " - " + inimigo.getNome());
            } else {
                System.out.println((i + 1) + " - " + inimigo.getNome() + " Bloqueado - XP Necessário: " + inimigo.getNivelNecessario());
            }

        }
        int escolha = Console.lerInt();
        TipoInimigo escolhido = inimigos[escolha - 1];
        if (jogador.getXp() < escolhido.getNivelNecessario()) {
            System.out.println("Nível insuficiente");
            return null;
        }
        return escolhido;*/
}
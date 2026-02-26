package br.com.enzo.rpg.model;


import br.com.enzo.rpg.util.Console;

import java.util.ArrayList;
import java.util.List;

public class Jogador extends Personagem {
    private ClassePersonagem classe;
    private int xp;
    private int nivel;
    private int xpParaProximoNivel;
    private List<TipoItem> inventario = new ArrayList<>();

    public Jogador(String nome, ClassePersonagem classe) {
        super(nome, classe);
        this.nivel = 1;
        this.xpParaProximoNivel = 50;

    }

    public int getXp() {
        return xp;
    }

    public int getNivel() {
        return nivel;
    }

    public List<TipoItem> getInventario() {
        return inventario;
    }

    public void ganharXp(int xpGanho) {
        this.xp += xpGanho;
        while (xp >= xpParaProximoNivel) {
            subirNivel();
        }
    }

    private void subirNivel() {
        xp -= xpParaProximoNivel;
        nivel++;
        xpParaProximoNivel += 50;
        aumentarVidaMaxima(30);
        getAtaque().setDano(getAtaque().getDano() + 5);

        System.out.println("\nLEVEL UP!");
        System.out.println("Nível atual: " + nivel);
        System.out.println("Vida UP!: " + getVida() + " | Dano UP!: " + getAtaque().getDano());
    }

    public void descansar() {
        System.out.print("Descansando!");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        curarTotal();
        System.out.println("Você descansou e recuperou a vida toda!");

    }

    public void adicionarItem(TipoItem item) {
        inventario.add(item);
    }

    public void listaItens() {

        while (true) {
            System.out.println("\n========Inventário========");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + " - " + inventario.get(i).getNome());
            }
            System.out.println("0 - Voltar");
            System.out.println("============================");
            int escolha = Console.lerInt();
            if (escolha == 0) {
                return;
            }
            if (escolha < 1 || escolha > inventario.size()) {
                System.out.println("Opção Inválida!");
                continue;
            }
            TipoItem item = getInventario().get(escolha - 1);
            usarItem(item);
            getInventario().remove(escolha - 1);

        }
    }

    public void usarItem(TipoItem item) {

        if (item == TipoItem.POCAO_CURA) {
            if (getVida() == getVidaMaxima()) {
                System.out.println("Sua vida já está cheia!");
                return;
            }
            receberCuraPocao(item.getCura());
            System.out.println("Você usou poção de cura! | Vida atual: " + getVida());

        } else if (item == TipoItem.POCAO_XP) {
            ganharXp(item.getXp());
            System.out.println("Você usou poção de XP | XP recebido: " + item.getXp());
        }
    }
}






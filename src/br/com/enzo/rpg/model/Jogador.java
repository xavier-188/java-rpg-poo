package br.com.enzo.rpg.model;

import br.com.enzo.rpg.util.Console;

public class Jogador extends Personagem {
    private ClassePersonagem classe;
    private int xp;
    private int nivel;
    private int xpParaProximoNivel;

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
        System.out.println("\nLEVEL UP!");
        System.out.println("Nível atual: " + nivel);
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

}

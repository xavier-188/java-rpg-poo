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
        this.xpParaProximoNivel = 100;
        this.vidaMaxima = 100;
        this.vidaAtual = vidaMaxima;

    }

    public int getXp() {
        return xp;
    }
    public int getNivel(){
        return nivel;
    }

    public void ganharXp(int xpGanho){
        this.xp += xpGanho;
        while (xp >= xpParaProximoNivel){
            subirNivel();
        }

    }

    private void subirNivel(){
        xp -= xpParaProximoNivel;
        nivel++;
        vidaMaxima += 20;
        vidaAtual = vidaMaxima;
        xpParaProximoNivel += 50;

        System.out.println("\nLEVEL UP!");
        System.out.println("Nível atual: " + nivel);
    }

    public void descansar(){
        System.out.print("Descansando!");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        vidaAtual = vidaMaxima;
        System.out.println("Você descansou e recuperou a vida toda!");

    }

}

package br.com.enzo.rpg.model;

public class Jogador extends Personagem {
    private ClassePersonagem classe;
    private int xp;

    public Jogador(String nome, ClassePersonagem classe) {
        super(nome, classe);
    }

    public int getXp() {
        return xp;
    }

    public void ganharXp(int xpGanho){
        this.xp += xpGanho;

    }
}

package br.com.enzo.rpg.model;

public class Ataque {
    private String nomeAtaque;
    private int dano;

    public Ataque(String nomeAtaque, int dano) {
        this.nomeAtaque = nomeAtaque;
        this.dano = dano;
    }

    public String getNome() {
        return nomeAtaque;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }
}

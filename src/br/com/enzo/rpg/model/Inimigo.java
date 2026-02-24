package br.com.enzo.rpg.model;

public class Inimigo {

    private String nome;
    private int vida;
    private int dano;

    public Inimigo(String nome, int vida, int dano) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public String getNome() {
        return nome;
    }


}

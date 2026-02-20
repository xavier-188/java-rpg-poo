package br.com.enzo.rpg.model;

import br.com.enzo.rpg.util.Console;

public enum TipoInimigo {
    GOBLIN("Goblin", 30, 5, 0, 5),
    GUERREIRO("Guerreiro Sombrio", 60, 15, 20, 10),
    BRUXO("O Bruxo", 80, 30, 50, 25),
    DRAGAO("Dragão(Boss Final)", 120, 100, 100, 50);

    private String nome;
    private int vida;
    private int dano;
    private int xpNecessario;
    private int xpConcedido;

    TipoInimigo(String nome, int dano, int vida, int xpNecessario, int xpConcedido) {
        this.nome = nome;
        this.dano = dano;
        this.vida = vida;
        this.xpNecessario = xpNecessario;
        this.xpConcedido = xpConcedido;
    }

    public String getNome() {
        return nome;
    }

    public int getXpNecessario() {
        return xpNecessario;
    }

    public int getDano() {
        return dano;
    }

    public int getVida() {
        return vida;
    }



    public int getXpConcedido() {
        return xpConcedido;
    }


}

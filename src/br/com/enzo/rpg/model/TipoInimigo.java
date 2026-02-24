package br.com.enzo.rpg.model;

import br.com.enzo.rpg.util.Console;

public enum TipoInimigo {
    GOBLIN("Goblin", 25, 15, 0, 5),
    GUERREIRO("Guerreiro Sombrio", 40, 25, 20, 10),
    BRUXO("O Bruxo", 55, 30, 50, 25),
    DRAGAO("Dragão(Boss Final)", 100, 100, 100, 50);

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

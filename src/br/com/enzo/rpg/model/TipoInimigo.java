package br.com.enzo.rpg.model;

import br.com.enzo.rpg.util.Console;

public enum TipoInimigo {
    GOBLIN("Goblin", 25, 15, 0, 5),
    ESQUELETO("Esqueleto",30, 10, 0, 5 ),
    ORC("Orc", 35, 45, 3, 10),
    GUERREIRO("Guerreiro Sombrio", 40, 25, 2, 10),
    BRUXO("O Bruxo", 55, 30, 4, 25),
    DRAGAO("Dragão(Boss Final)", 100, 100, 5, 50);

    private String nome;
    private int vida;
    private int dano;
    private int nivelNecessario;
    private int xpConcedido;

    TipoInimigo(String nome, int dano, int vida, int nivelNecessario, int xpConcedido) {
        this.nome = nome;
        this.dano = dano;
        this.vida = vida;
        this.nivelNecessario = nivelNecessario;
        this.xpConcedido = xpConcedido;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelNecessario() {
        return nivelNecessario;
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

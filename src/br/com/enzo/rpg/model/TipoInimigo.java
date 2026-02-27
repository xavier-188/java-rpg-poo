package br.com.enzo.rpg.model;

import br.com.enzo.rpg.util.Console;

public enum TipoInimigo {
    GOBLIN("Goblin", 25, 15, 1, 10),
    ESQUELETO("Esqueleto",30, 10, 1, 10 ),
    ESPIRITO("Espírito",35, 20, 2, 15 ),
    GUERREIRO("Guerreiro Sombrio", 40, 25, 2, 15),
    ORC("Orc", 35, 45, 3, 20),
    BRUXO("Bruxo", 55, 60, 4, 30),
    DRAGAO("Dragão(Boss Final)", 250, 100, 5, 150);

    private String nome;
    private int vida;
    private int dano;
    private int nivelNecessario;
    private int xpConcedido;

    TipoInimigo(String nome, int vida, int dano, int nivelNecessario, int xpConcedido) {
        this.nome = nome;
        this.vida = vida;
        this.dano = dano;
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

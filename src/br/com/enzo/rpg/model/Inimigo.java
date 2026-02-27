package br.com.enzo.rpg.model;

public class Inimigo {

    private TipoInimigo tipo;
    private int vidaAtual;

    public Inimigo(TipoInimigo tipo) {
        this.tipo = tipo;
        this.vidaAtual = tipo.getVida();
    }

    public String getNome() {
        return tipo.getNome();
    }

    public int getXpConcedido() {
        return tipo.getXpConcedido();
    }

    public int getDano() {
        return tipo.getDano();
    }

    public int getVida() {
        return vidaAtual;
    }

    public TipoInimigo getTipo() {
        return tipo;
    }

    public void receberDano(int dano) {
        vidaAtual = Math.max(0, vidaAtual - dano);
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

}

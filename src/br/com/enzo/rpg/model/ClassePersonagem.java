package br.com.enzo.rpg.model;

public enum ClassePersonagem {
    GUERREIRO(new Ataque("Espadada Bruta", 12), 100),
    MAGO(new Ataque("Bola de Fogo", 25), 80),
    ARQUEIRO(new Ataque("Flechada", 15), 60),
    ORC(new Ataque("Soco Potente", 20), 150);

    private Ataque ataqueBase;
    private int vidaBase;

    ClassePersonagem(Ataque ataqueBase, int vidaBase) {
        this.ataqueBase = ataqueBase;
        this.vidaBase = vidaBase;
    }

    public Ataque getAtaqueBase() {
        return ataqueBase;
    }

    public void setAtaqueBase(Ataque ataqueBase) {
        this.ataqueBase = ataqueBase;
    }

    public int getVidaBase() {
        return vidaBase;
    }

    public void setVidaBase(int vidaBase) {
        this.vidaBase = vidaBase;
    }

    @Override
    public String toString() {
        return name() + " (Vida: " + vidaBase +
                ", Ataque: " + ataqueBase.getNome() +
                " - Dano: " + ataqueBase.getDano() + ")";
    }
}

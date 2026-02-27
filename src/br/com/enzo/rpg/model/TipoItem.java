package br.com.enzo.rpg.model;

public enum TipoItem {
    POCAO_CURA("Poção de Cura", 35, 0),
    POCAO_XP("Poção de XP", 0, 50);

    private String nome;
    private int cura;
    private int xp;

    TipoItem(String nome, int cura, int xp) {
        this.nome = nome;
        this.cura = cura;
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public int getXp() {
        return xp;
    }

    public int getCura() {
        return cura;
    }

}

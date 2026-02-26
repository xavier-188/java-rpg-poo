package br.com.enzo.rpg.model;

public enum TipoItem {

    POCAO_CURA("Poção de Cura", 35, 0),
    POCAO_XP("Poção de XP" , 0, 100);

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }
}

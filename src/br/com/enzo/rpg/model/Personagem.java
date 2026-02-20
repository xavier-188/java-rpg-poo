package br.com.enzo.rpg.model;

public class Personagem {
    private String nome;
    private int vida;
    private ClassePersonagem classe;
    private Ataque ataque;

    public Personagem(String nome, ClassePersonagem classe) {
        this.nome = nome;
        this.ataque = classe.getAtaqueBase();
        this.classe = classe;
        this.vida = classe.getVidaBase();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClassePersonagem getClasse() {
        return classe;
    }

    public void setClasse(ClassePersonagem classe) {
        this.classe = classe;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public void atacar(Personagem alvo) {
        alvo.vida -= ataque.getDano();
        System.out.println(nome + " usou " + ataque.getNome() + " causando " + ataque.getDano() + " de dano em " + alvo.getNome());
    }



}

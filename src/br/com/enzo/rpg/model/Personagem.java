package br.com.enzo.rpg.model;

public class Personagem {
    private String nome;
    private int vidaAtual;
    private int vidaMaxima;
    private ClassePersonagem classe;
    private Ataque ataque;

    public Personagem(String nome, ClassePersonagem classe) {
        this.nome = nome;
        this.ataque = classe.getAtaqueBase();
        this.classe = classe;
        this.vidaMaxima = classe.getVidaBase();
        this.vidaAtual = vidaMaxima;

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
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVida(int vida) {
        this.vidaAtual = vida;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
    }

    protected void aumentarVidaMaxima(int valor) {
        vidaMaxima += valor;
        vidaAtual = vidaMaxima;
    }


    public void curarTotal() {
        vidaAtual = vidaMaxima;
    }

    public void receberCuraPocao(int valor){
        vidaAtual = Math.min(vidaMaxima, vidaAtual + valor);
    }


}

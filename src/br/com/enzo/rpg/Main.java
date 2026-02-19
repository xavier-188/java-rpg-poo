package br.com.enzo.rpg;

import br.com.enzo.rpg.service.JogoService;

public class Main {
    static void main(String[] args) {
        JogoService jg = new JogoService();
        jg.iniciar();
    }
}

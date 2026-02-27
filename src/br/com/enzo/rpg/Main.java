package br.com.enzo.rpg;

import br.com.enzo.rpg.service.JogoService;

import java.io.IOException;

public class Main {
    static void main(String[] args) throws IOException {
        JogoService jg = new JogoService();
        jg.iniciar();
    }
}

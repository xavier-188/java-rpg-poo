package br.com.enzo.rpg.util;

import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.TipoInimigo;

import java.util.Random;

public class InimigoFactory {

    public static Inimigo gerarInimigo(int nivelJogador){
        Random random = new Random();
        int tipo = random.nextInt(3);

        if (tipo == 0){
            return new Inimigo(TipoInimigo.GOBLIN);
        } else if (tipo == 1) {
            return new Inimigo(TipoInimigo.ESQUELETO);
        }else {
            return new Inimigo(TipoInimigo.ORC);
        }
    }
}

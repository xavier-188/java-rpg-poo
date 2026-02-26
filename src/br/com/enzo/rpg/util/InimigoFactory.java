package br.com.enzo.rpg.util;

import br.com.enzo.rpg.model.Inimigo;
import br.com.enzo.rpg.model.Jogador;
import br.com.enzo.rpg.model.TipoInimigo;
import br.com.enzo.rpg.model.TipoItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InimigoFactory {

    public static Inimigo gerarInimigo(int nivelJogador) {


        List<TipoInimigo> disponiveis = new ArrayList<>();

        for (TipoInimigo tipo : TipoInimigo.values()) {
            if (tipo.getNivelNecessario() <= nivelJogador) {
                disponiveis.add(tipo);
            }
        }

        if (disponiveis.isEmpty()) {
            return null;
        }

        Random random = new Random();
        TipoInimigo escolhido = disponiveis.get(random.nextInt(disponiveis.size()));
        return new Inimigo(escolhido);

    }

    public static TipoItem gerarDrop(){
        Random random = new Random();
        int chance = random.nextInt(100);

        if (chance<40){
            return TipoItem.POCAO_CURA;
        } else if (chance< 60) {
            return TipoItem.POCAO_XP;
        }
        return null;

    }

}

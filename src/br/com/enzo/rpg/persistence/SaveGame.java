package br.com.enzo.rpg.persistence;

import br.com.enzo.rpg.model.Jogador;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveGame {
    private static final String CAMINHO = "save.json";

    public static void salvar(Jogador jogador) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(CAMINHO)) {
            gson.toJson(jogador, writer);
            System.out.println("Jogo Salvo com Sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar jogo... " + e.getMessage());
        }
    }

    public static Jogador carregar() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(CAMINHO)) {
            Jogador jogador = gson.fromJson(reader, Jogador.class);
            System.out.println("Jogo Carregado!");
            return jogador;
        } catch (IOException e) {
            return null;
        }
    }
}

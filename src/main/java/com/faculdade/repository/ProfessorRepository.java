package com.faculdade.repository;

import com.faculdade.model.Professor;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {

    private static final String ARQUIVO = "professores.csv";

    public List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(ARQUIVO))) {
            String[] linha;
            reader.readNext(); // Pular cabeçalho
            while ((linha = reader.readNext()) != null) {
                if (linha.length == 4) {
                    professores.add(new Professor(
                            linha[0], linha[1], linha[2], Integer.parseInt(linha[3])
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return professores;
    }

    public void salvarTodos(List<Professor> professores) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ARQUIVO))) {
            writer.writeNext(new String[]{"cpf", "nome", "area", "pontos"});
            for (Professor p : professores) {
                writer.writeNext(new String[]{
                        p.getCpf(),
                        p.getNome(),
                        p.getArea(),
                        String.valueOf(p.getPontos())
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

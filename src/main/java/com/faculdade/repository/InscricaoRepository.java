package com.faculdade.repository;

import com.faculdade.model.Inscricao;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoRepository {

    private static final String ARQUIVO = "inscricoes.csv";

    public List<Inscricao> listarTodos() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(ARQUIVO))) {
            String[] linha;
            reader.readNext(); // Pular cabeçalho
            while ((linha = reader.readNext()) != null) {
                if (linha.length == 3) {
                    inscricoes.add(new Inscricao(
                            linha[0], linha[1], linha[2]
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inscricoes;
    }

    public void salvarTodos(List<Inscricao> inscricoes) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ARQUIVO))) {
            writer.writeNext(new String[]{"cpf_professor", "codigo_disciplina", "codigo_processo"});
            for (Inscricao i : inscricoes) {
                writer.writeNext(new String[]{
                        i.getCpfProfessor(),
                        i.getCodigoDisciplina(),
                        i.getCodigoProcesso()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

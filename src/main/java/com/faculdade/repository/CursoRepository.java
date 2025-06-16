package com.faculdade.repository;

import com.faculdade.model.Curso;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {

    private static final String ARQUIVO = "cursos.csv";

    public List<Curso> listarTodos() {
        List<Curso> cursos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(ARQUIVO))) {
            String[] linha;
            reader.readNext(); // Pular cabeçalho
            while ((linha = reader.readNext()) != null) {
                if (linha.length == 3) {
                    cursos.add(new Curso(linha[0], linha[1], linha[2]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public void salvarTodos(List<Curso> cursos) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ARQUIVO))) {
            writer.writeNext(new String[]{"codigo", "nome", "area"});
            for (Curso curso : cursos) {
                writer.writeNext(new String[]{
                        curso.getCodigo(),
                        curso.getNome(),
                        curso.getArea()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

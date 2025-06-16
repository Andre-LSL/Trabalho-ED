package com.faculdade.repository;

import com.faculdade.model.Disciplina;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaRepository {

    private static final String ARQUIVO = "disciplinas.csv";

    public List<Disciplina> listarTodos() {
        List<Disciplina> disciplinas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(ARQUIVO))) {
            String[] linha;
            reader.readNext(); // Pular cabeçalho
            while ((linha = reader.readNext()) != null) {
                if (linha.length == 6) {
                    disciplinas.add(new Disciplina(
                            linha[0], linha[1], linha[2], linha[3],
                            Integer.parseInt(linha[4]), linha[5]
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return disciplinas;
    }

    public void salvarTodos(List<Disciplina> disciplinas) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(ARQUIVO))) {
            writer.writeNext(new String[]{
                    "codigo", "nome", "dia_semana", "horario_inicio", "horas_diarias", "codigo_curso"
            });
            for (Disciplina d : disciplinas) {
                writer.writeNext(new String[]{
                        d.getCodigo(),
                        d.getNome(),
                        d.getDiaSemana(),
                        d.getHorarioInicio(),
                        String.valueOf(d.getHorasDiarias()),
                        d.getCodigoCurso()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

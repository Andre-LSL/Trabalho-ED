package com.faculdade.ui;

import com.faculdade.model.Inscricao;
import com.faculdade.model.Professor;
import com.faculdade.repository.InscricaoRepository;
import com.faculdade.repository.ProfessorRepository;
import com.faculdade.structures.OrderedList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaInscritos {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Consulta Inscritos (por Disciplina, ordenado por Pontuação)");

        TextField disciplinaField = new TextField();
        disciplinaField.setPromptText("Código da Disciplina");

        TextArea ta = new TextArea();
        ta.setEditable(false);

        Button btnConsultar = new Button("Consultar Inscritos");
        btnConsultar.setOnAction(e -> {
            String codigoDisciplina = disciplinaField.getText();
            List<Inscricao> inscricoes = new InscricaoRepository().listarTodos()
                    .stream()
                    .filter(i -> i.getCodigoDisciplina().equals(codigoDisciplina))
                    .collect(Collectors.toList());

            OrderedList <Professor> lista = new OrderedList<>();
            ProfessorRepository profRepo = new ProfessorRepository();
            for (Inscricao i : inscricoes) {
                Professor p = profRepo.listarTodos().stream()
                        .filter(prof -> prof.getCpf().equals(i.getCpfProfessor()))
                        .findFirst().orElse(null);
                if (p != null) lista.add(p);
            }
            lista.sort(Comparator.comparingInt(Professor::getPontos).reversed());

            StringBuilder sb = new StringBuilder();
            for (Professor p : lista.toList()) {
                sb.append(p).append("\n");
            }
            ta.setText(sb.toString());
        });

        VBox root = new VBox(10, disciplinaField, btnConsultar, ta);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}

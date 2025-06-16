package com.faculdade.ui;

import com.faculdade.model.Disciplina;
import com.faculdade.service.DisciplinaService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DisciplinaCRUD {
    private final DisciplinaService service = new DisciplinaService();

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Gerenciar Disciplinas");

        ListView<String> listView = new ListView<>();
        atualizarLista(listView);

        TextField codigoField = new TextField();
        codigoField.setPromptText("Código");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField diaSemanaField = new TextField();
        diaSemanaField.setPromptText("Dia da Semana");

        TextField horarioField = new TextField();
        horarioField.setPromptText("Horário Início");

        TextField horasField = new TextField();
        horasField.setPromptText("Horas Diárias");

        TextField codigoCursoField = new TextField();
        codigoCursoField.setPromptText("Código do Curso");

        Button btnAdd = new Button("Adicionar");
        btnAdd.setOnAction(e -> {
            try {
                Disciplina d = new Disciplina(
                        codigoField.getText(),
                        nomeField.getText(),
                        diaSemanaField.getText(),
                        horarioField.getText(),
                        Integer.parseInt(horasField.getText()),
                        codigoCursoField.getText()
                );
                service.adicionarDisciplina(d);
                atualizarLista(listView);
            } catch (Exception ex) {
                // Handle exception (entrada inválida)
            }
        });

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(e -> {
            String codigo = codigoField.getText();
            service.removerDisciplina(codigo);
            atualizarLista(listView);
        });

        VBox root = new VBox(8, listView, codigoField, nomeField, diaSemanaField, horarioField, horasField, codigoCursoField, btnAdd, btnRemover);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 400, 500));
        stage.show();
    }

    private void atualizarLista(ListView<String> listView) {
        listView.getItems().clear();
        for (Disciplina d : service.getDisciplinas()) {
            listView.getItems().add(d.toString());
        }
    }
}

package com.faculdade.ui;

import com.faculdade.model.Curso;
import com.faculdade.service.CursoService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CursoCRUD {
    private final CursoService service = new CursoService();

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Gerenciar Cursos");

        ListView<String> listView = new ListView<>();
        atualizarLista(listView);

        TextField codigoField = new TextField();
        codigoField.setPromptText("Código");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField areaField = new TextField();
        areaField.setPromptText("Área");

        Button btnAdd = new Button("Adicionar");
        btnAdd.setOnAction(e -> {
            Curso c = new Curso(codigoField.getText(), nomeField.getText(), areaField.getText());
            service.adicionarCurso(c);
            atualizarLista(listView);
        });

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(e -> {
            String codigo = codigoField.getText();
            service.removerCurso(codigo);
            atualizarLista(listView);
        });

        VBox root = new VBox(8, listView, codigoField, nomeField, areaField, btnAdd, btnRemover);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 350, 400));
        stage.show();
    }

    private void atualizarLista(ListView<String> listView) {
        listView.getItems().clear();
        for (Curso c : service.getCursos()) {
            listView.getItems().add(c.toString());
        }
    }
}

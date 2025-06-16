package com.faculdade.ui;

import com.faculdade.model.Professor;
import com.faculdade.service.ProfessorService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfessorCRUD {
    private final ProfessorService service = new ProfessorService();

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Gerenciador Professores");

        ListView<String> listView = new ListView<>();
        atualizarLista(listView);

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF");

        TextField nomeField = new TextField();
        nomeField.setPromptText("Nome");

        TextField areaField = new TextField();
        areaField.setPromptText("Área");

        TextField pontosField = new TextField();
        pontosField.setPromptText("Pontos");

        Button btnAdd = new Button("Adicionar");
        btnAdd.setOnAction(e -> {
            try {
                Professor p = new Professor(
                        cpfField.getText(),
                        nomeField.getText(),
                        areaField.getText(),
                        Integer.parseInt(pontosField.getText())
                );
                service.adicionarProfessor(p);
                atualizarLista(listView);
            } catch (Exception ex) {
                // Handle exception
            }
        });

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(e -> {
            String cpf = cpfField.getText();
            service.removerProfessor(cpf);
            atualizarLista(listView);
        });

        VBox root = new VBox(8, listView, cpfField, nomeField, areaField, pontosField, btnAdd, btnRemover);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 400, 450));
        stage.show();
    }

    private void atualizarLista(ListView<String> listView) {
        listView.getItems().clear();
        for (Professor p : service.getProfessores()) {
            listView.getItems().add(p.toString());
        }
    }
}

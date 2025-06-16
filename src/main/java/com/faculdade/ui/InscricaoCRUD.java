package com.faculdade.ui;

import com.faculdade.model.Inscricao;
import com.faculdade.service.InscricaoService;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InscricaoCRUD {
    private final InscricaoService service = new InscricaoService();

    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Gerenciar Inscrições");

        ListView<String> listView = new ListView<>();
        atualizarLista(listView);

        TextField cpfField = new TextField();
        cpfField.setPromptText("CPF Professor");

        TextField codigoDisciplinaField = new TextField();
        codigoDisciplinaField.setPromptText("Código Disciplina");

        TextField codigoProcessoField = new TextField();
        codigoProcessoField.setPromptText("Código Processo");

        Button btnAdd = new Button("Adicionar");
        btnAdd.setOnAction(e -> {
            Inscricao i = new Inscricao(
                    cpfField.getText(),
                    codigoDisciplinaField.getText(),
                    codigoProcessoField.getText()
            );
            service.adicionarInscricao(i);
            atualizarLista(listView);
        });

        Button btnRemover = new Button("Remover");
        btnRemover.setOnAction(e -> {
            service.removerInscricao(
                    cpfField.getText(),
                    codigoDisciplinaField.getText(),
                    codigoProcessoField.getText()
            );
            atualizarLista(listView);
        });

        VBox root = new VBox(8, listView, cpfField, codigoDisciplinaField, codigoProcessoField, btnAdd, btnRemover);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }

    private void atualizarLista(ListView<String> listView) {
        listView.getItems().clear();
        for (Inscricao i : service.getInscricoes()) {
            listView.getItems().add(i.toString());
        }
    }
}

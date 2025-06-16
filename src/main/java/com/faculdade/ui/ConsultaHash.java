package com.faculdade.ui;

import com.faculdade.model.Disciplina;
import com.faculdade.repository.DisciplinaRepository;
import com.faculdade.structures.HashTable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsultaHash {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Consulta Disciplinas de Cursos com Processos Abertos (Hash)");

        TextArea ta = new TextArea();
        ta.setEditable(false);

        Button btnListar = new Button("Listar Disciplinas");
        btnListar.setOnAction(e -> {
            // Usando uma função hash customizada para código do curso
            var disciplinas = new DisciplinaRepository().listarTodos();
            HashTable<String, String> hash = new HashTable<>(disciplinas.size() + 10);
            for (Disciplina d : disciplinas) {
                hash.put(d.getCodigo(), d.toString());
            }
            StringBuilder sb = new StringBuilder();
            for (Disciplina d : disciplinas) {
                sb.append(hash.get(d.getCodigo())).append("\n");
            }
            ta.setText(sb.toString());
        });

        VBox root = new VBox(10, btnListar, ta);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}

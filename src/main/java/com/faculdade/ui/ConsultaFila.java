package com.faculdade.ui;

import com.faculdade.model.Curso;
import com.faculdade.model.Disciplina;
import com.faculdade.model.Professor;
import com.faculdade.repository.CursoRepository;
import com.faculdade.repository.DisciplinaRepository;
import com.faculdade.repository.ProfessorRepository;
import com.faculdade.structures.Queue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConsultaFila {
    public void show() {
        Stage stage = new Stage();
        stage.setTitle("Consulta Fila - Disciplinas / Cursos / Professores");

        TextArea ta = new TextArea();
        ta.setEditable(false);

        Button btnDisciplinas = new Button("Listar Disciplinas");
        btnDisciplinas.setOnAction(e -> {
            Queue<Disciplina> fila = new Queue<>();
            for (Disciplina d : new DisciplinaRepository().listarTodos()) fila.enqueue(d);
            StringBuilder sb = new StringBuilder();
            for (Disciplina d : fila.toList()) sb.append(d).append("\n");
            ta.setText(sb.toString());
        });

        Button btnCursos = new Button("Listar Cursos");
        btnCursos.setOnAction(e -> {
            Queue<Curso> fila = new Queue<>();
            for (Curso c : new CursoRepository().listarTodos()) fila.enqueue(c);
            StringBuilder sb = new StringBuilder();
            for (Curso c : fila.toList()) sb.append(c).append("\n");
            ta.setText(sb.toString());
        });

        Button btnProfessores = new Button("Listar Professores");
        btnProfessores.setOnAction(e -> {
            Queue<Professor> fila = new Queue<>();
            for (Professor p : new ProfessorRepository().listarTodos()) fila.enqueue(p);
            StringBuilder sb = new StringBuilder();
            for (Professor p : fila.toList()) sb.append(p).append("\n");
            ta.setText(sb.toString());
        });

        VBox root = new VBox(10, btnDisciplinas, btnCursos, btnProfessores, ta);
        root.setStyle("-fx-padding: 10; -fx-alignment: center;");

        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }
}

package com.faculdade.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Trabalho - Sistema de Chamada Pública FATEC ZL");

        Button btnCursos = new Button("Gerenciar Cursos");
        btnCursos.setOnAction(e -> new CursoCRUD().show());

        Button btnDisciplinas = new Button("Gerenciar Disciplinas");
        btnDisciplinas.setOnAction(e -> new DisciplinaCRUD().show());

        Button btnProfessores = new Button("Gerenciar Professores");
        btnProfessores.setOnAction(e -> new ProfessorCRUD().show());

        Button btnInscricoes = new Button("Gerenciar Inscrições");
        btnInscricoes.setOnAction(e -> new InscricaoCRUD().show());

        Button btnConsultaFila = new Button("Consulta por Fila (Disciplinas, Cursos, Professores)");
        btnConsultaFila.setOnAction(e -> new ConsultaFila().show());

        Button btnConsultaInscritos = new Button("Consulta de Inscritos (ordenada por pontuação)");
        btnConsultaInscritos.setOnAction(e -> new ConsultaInscritos().show());

        Button btnConsultaHash = new Button("Consulta de Disciplinas/Processos (Hash)");
        btnConsultaHash.setOnAction(e -> new ConsultaHash().show());

        VBox root = new VBox(10, btnCursos, btnDisciplinas, btnProfessores, btnInscricoes,
                             btnConsultaFila, btnConsultaInscritos, btnConsultaHash);
        root.setStyle("-fx-padding: 20; -fx-alignment: center;");

        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.show();
    }
}

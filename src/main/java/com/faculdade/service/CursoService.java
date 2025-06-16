package com.faculdade.service;

import com.faculdade.model.Curso;
import com.faculdade.repository.CursoRepository;
import com.faculdade.structures.LinkedList;

import java.util.List;

public class CursoService {
    private final CursoRepository repository = new CursoRepository();
    private final LinkedList<Curso> cursos = new LinkedList<>();

    public CursoService() {
        carregarCursos();
    }

    public void carregarCursos() {
        cursos.clear();
        List<Curso> lista = repository.listarTodos();
        for (Curso c : lista) cursos.add(c);
    }

    public LinkedList<Curso> getCursos() {
        return cursos;
    }

    public void adicionarCurso(Curso curso) {
        cursos.add(curso);
        salvarCursos();
    }

    public void removerCurso(String codigo) {
        cursos.removeIf(c -> c.getCodigo().equals(codigo));
        salvarCursos();
    }

    public void atualizarCurso(Curso novo) {
        cursos.removeIf(c -> c.getCodigo().equals(novo.getCodigo()));
        cursos.add(novo);
        salvarCursos();
    }

    private void salvarCursos() {
        // Converter lista encadeada em lista comum para salvar
        java.util.List<Curso> lista = new java.util.ArrayList<>();
        for (Curso c : cursos) lista.add(c);
        repository.salvarTodos(lista);
    }
}

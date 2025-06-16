package com.faculdade.service;

import com.faculdade.model.Disciplina;
import com.faculdade.repository.DisciplinaRepository;
import com.faculdade.structures.LinkedList;

import java.util.List;

public class DisciplinaService {
    private final DisciplinaRepository repository = new DisciplinaRepository();
    private final LinkedList<Disciplina> disciplinas = new LinkedList<>();

    public DisciplinaService() {
        carregarDisciplinas();
    }

    public void carregarDisciplinas() {
        disciplinas.clear();
        List<Disciplina> lista = repository.listarTodos();
        for (Disciplina d : lista) disciplinas.add(d);
    }

    public LinkedList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina d) {
        disciplinas.add(d);
        salvarDisciplinas();
    }

    public void removerDisciplina(String codigo) {
        disciplinas.removeIf(d -> d.getCodigo().equals(codigo));
        salvarDisciplinas();
    }

    public void atualizarDisciplina(Disciplina nova) {
        disciplinas.removeIf(d -> d.getCodigo().equals(nova.getCodigo()));
        disciplinas.add(nova);
        salvarDisciplinas();
    }

    private void salvarDisciplinas() {
        java.util.List<Disciplina> lista = new java.util.ArrayList<>();
        for (Disciplina d : disciplinas) lista.add(d);
        repository.salvarTodos(lista);
    }
}

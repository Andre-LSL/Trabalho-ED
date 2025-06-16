package com.faculdade.service;

import com.faculdade.model.Professor;
import com.faculdade.repository.ProfessorRepository;
import com.faculdade.structures.LinkedList;

import java.util.List;

public class ProfessorService {
    private final ProfessorRepository repository = new ProfessorRepository();
    private final LinkedList<Professor> professores = new LinkedList<>();

    public ProfessorService() {
        carregarProfessores();
    }

    public void carregarProfessores() {
        professores.clear();
        List<Professor> lista = repository.listarTodos();
        for (Professor p : lista) professores.add(p);
    }

    public LinkedList<Professor> getProfessores() {
        return professores;
    }

    public void adicionarProfessor(Professor p) {
        professores.add(p);
        salvarProfessores();
    }

    public void removerProfessor(String cpf) {
        professores.removeIf(p -> p.getCpf().equals(cpf));
        salvarProfessores();
    }

    public void atualizarProfessor(Professor novo) {
        professores.removeIf(p -> p.getCpf().equals(novo.getCpf()));
        professores.add(novo);
        salvarProfessores();
    }

    private void salvarProfessores() {
        java.util.List<Professor> lista = new java.util.ArrayList<>();
        for (Professor p : professores) lista.add(p);
        repository.salvarTodos(lista);
    }
}

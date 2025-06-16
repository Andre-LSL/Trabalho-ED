package com.faculdade.service;

import com.faculdade.model.Inscricao;
import com.faculdade.repository.InscricaoRepository;
import com.faculdade.structures.LinkedList;

import java.util.List;

public class InscricaoService {
    private final InscricaoRepository repository = new InscricaoRepository();
    private final LinkedList<Inscricao> inscricoes = new LinkedList<>();

    public InscricaoService() {
        carregarInscricoes();
    }

    public void carregarInscricoes() {
        inscricoes.clear();
        List<Inscricao> lista = repository.listarTodos();
        for (Inscricao i : lista) inscricoes.add(i);
    }

    public LinkedList<Inscricao> getInscricoes() {
        return inscricoes;
    }

    public void adicionarInscricao(Inscricao i) {
        inscricoes.add(i);
        salvarInscricoes();
    }

    public void removerInscricao(String cpfProfessor, String codigoDisciplina, String codigoProcesso) {
        inscricoes.removeIf(i ->
            i.getCpfProfessor().equals(cpfProfessor)
            && i.getCodigoDisciplina().equals(codigoDisciplina)
            && i.getCodigoProcesso().equals(codigoProcesso)
        );
        salvarInscricoes();
    }

    public void removerInscricoesPorDisciplina(String codigoDisciplina) {
        inscricoes.removeIf(i -> i.getCodigoDisciplina().equals(codigoDisciplina));
        salvarInscricoes();
    }

    public void atualizarInscricao(Inscricao nova) {
        inscricoes.removeIf(i ->
            i.getCpfProfessor().equals(nova.getCpfProfessor())
            && i.getCodigoDisciplina().equals(nova.getCodigoDisciplina())
            && i.getCodigoProcesso().equals(nova.getCodigoProcesso())
        );
        inscricoes.add(nova);
        salvarInscricoes();
    }

    private void salvarInscricoes() {
        java.util.List<Inscricao> lista = new java.util.ArrayList<>();
        for (Inscricao i : inscricoes) lista.add(i);
        repository.salvarTodos(lista);
    }
}

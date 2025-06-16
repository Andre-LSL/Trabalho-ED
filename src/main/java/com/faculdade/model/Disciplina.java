package com.faculdade.model;

public class Disciplina {
    private String codigo;
    private String nome;
    private String diaSemana;
    private String horarioInicio;
    private int horasDiarias;
    private String codigoCurso;

    public Disciplina(String codigo, String nome, String diaSemana, String horarioInicio, int horasDiarias, String codigoCurso) {
        this.codigo = codigo;
        this.nome = nome;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horasDiarias = horasDiarias;
        this.codigoCurso = codigoCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getHorasDiarias() {
        return horasDiarias;
    }

    public void setHorasDiarias(int horasDiarias) {
        this.horasDiarias = horasDiarias;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " | " + diaSemana + " " + horarioInicio + " (" + horasDiarias + "h) - Curso: " + codigoCurso;
    }
}

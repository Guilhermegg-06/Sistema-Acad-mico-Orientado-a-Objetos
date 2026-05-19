package br.edu.instituicao.model;

import br.edu.instituicao.interfaces.Avaliavel;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa implements Avaliavel {
    public String mat;
    public List notas = new ArrayList();

    public Aluno(String nome, String cpf, String email, String mat) {
        super(nome, cpf, email);
        this.mat = mat;
    }

    public String getMatricula() {
        return mat;
    }

    public void setMatricula(String mat) {
        this.mat = mat;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }

    public List getNotas() {
        return notas;
    }

    @Override
    public double getMediaFinal() {
        if (notas.size() == 0) {
            return 0.0;
        }
        double soma = 0.0;
        for (int i = 0; i < notas.size(); i++) {
            Double valor = (Double) notas.get(i);
            soma = soma + valor.doubleValue();
        }
        return soma / notas.size();
    }

    @Override
    public String toString() {
        return "Aluno - Mat: " + mat + ", Nome: " + nome + ", Email: " + email + ", Media: " + getMediaFinal();
    }
}

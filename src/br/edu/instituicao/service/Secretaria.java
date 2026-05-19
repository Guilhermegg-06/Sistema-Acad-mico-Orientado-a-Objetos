package br.edu.instituicao.service;

import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;
import java.util.ArrayList;
import java.util.List;

/**
 * [PADRAO] Singleton: garante que exista apenas uma instância de Secretaria.
 * Isso evita múltiplos estados desconectados na aplicação acadêmica.
 */
public class Secretaria {
    private static Secretaria instancia;
    public List pessoas = new ArrayList();

    private Secretaria() {
    }

    public static Secretaria getInstance() {
        if (instancia == null) {
            instancia = new Secretaria();
        }
        return instancia;
    }

    public void cadastrarAluno(Aluno aluno) {
        if (aluno != null) {
            pessoas.add(aluno);
            System.out.println("Aluno cadastrado ok");
        }
    }

    public void cadastrarProfessor(Professor professor) {
        if (professor != null) {
            pessoas.add(professor);
            System.out.println("Professor/Coordenador cadastrado ok");
        }
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        if (pessoa instanceof Aluno) {
            cadastrarAluno((Aluno) pessoa);
        } else if (pessoa instanceof Professor) {
            cadastrarProfessor((Professor) pessoa);
        }
    }

    public void listarMembros() {
        if (pessoas.size() == 0) {
            System.out.println("nada cadastrado");
            return;
        }
        System.out.println("--- lista ---");
        for (int i = 0; i < pessoas.size(); i++) {
            System.out.println(pessoas.get(i));
        }
    }

    public Aluno localizarAlunoPorMatricula(String matricula) {
        for (int i = 0; i < pessoas.size(); i++) {
            Object obj = pessoas.get(i);
            if (obj instanceof Aluno) {
                Aluno aluno = (Aluno) obj;
                if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                    return aluno;
                }
            }
        }
        return null;
    }

    public Aluno localizarAlunoPorNome(String nome) {
        for (int i = 0; i < pessoas.size(); i++) {
            Object obj = pessoas.get(i);
            if (obj instanceof Aluno) {
                Aluno aluno = (Aluno) obj;
                if (aluno.getNome().equalsIgnoreCase(nome)) {
                    return aluno;
                }
            }
        }
        return null;
    }

    public List getPessoas() {
        return pessoas;
    }
}

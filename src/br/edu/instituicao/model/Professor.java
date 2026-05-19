package br.edu.instituicao.model;

import br.edu.instituicao.interfaces.Autenticavel;

public class Professor extends Pessoa implements Autenticavel {
    public String siape;
    public String senha;

    public Professor(String nome, String cpf, String email, String siape, String senha) {
        super(nome, cpf, email);
        this.siape = siape;
        this.senha = senha;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean login(String senha) {
        return senha.equals(this.senha);
    }

    @Override
    public String toString() {
        return "Professor - SIAPE: " + siape + ", Nome: " + nome + ", Email: " + email;
    }
}

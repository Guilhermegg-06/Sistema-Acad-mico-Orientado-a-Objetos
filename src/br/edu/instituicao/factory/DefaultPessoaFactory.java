package br.edu.instituicao.factory;

import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Coordenador;
import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;

/**
 * [PADRAO] Factory Method: classe concreta que cria objetos Pessoa com base no tipo.
 * O método retorna a abstração (Pessoa) para promover inversão de dependência.
 */
public class DefaultPessoaFactory implements PessoaFactory {

    @Override
    public Pessoa criarPessoa(String tipo, String nome, String cpf, String email, String siape, String senha, String matricula) {
        if ("coord".equalsIgnoreCase(tipo) || "coordenador".equalsIgnoreCase(tipo)) {
            return new Coordenador(nome, cpf, email, siape, senha);
        }
        if ("prof".equalsIgnoreCase(tipo) || "professor".equalsIgnoreCase(tipo)) {
            return new Professor(nome, cpf, email, siape, senha);
        }
        return new Aluno(nome, cpf, email, matricula);
    }
}

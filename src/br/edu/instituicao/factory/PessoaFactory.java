package br.edu.instituicao.factory;

import br.edu.instituicao.model.Pessoa;

/**
 * [PADRAO] Factory Method: define a interface para criação de objetos Pessoa.
 * Isso desacopla o cliente (Main) das classes concretas Aluno, Professor e Coordenador.
 */
public interface PessoaFactory {
    Pessoa criarPessoa(String tipo, String nome, String cpf, String email, String siape, String senha, String matricula);
}

package br.edu.instituicao.main;

import br.edu.instituicao.factory.DefaultPessoaFactory;
import br.edu.instituicao.factory.PessoaFactory;
import br.edu.instituicao.interfaces.Avaliavel;
import br.edu.instituicao.model.Aluno;
import br.edu.instituicao.model.Coordenador;
import br.edu.instituicao.model.Pessoa;
import br.edu.instituicao.model.Professor;
import br.edu.instituicao.service.RelatorioAcademico;
import br.edu.instituicao.service.Secretaria;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Secretaria secretaria = Secretaria.getInstance();
        PessoaFactory factory = new DefaultPessoaFactory();
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.println("--- sistema academico ---");
            System.out.println("1 cadastrar aluno");
            System.out.println("2 cadastrar prof / coord");
            System.out.println("3 nota aluno");
            System.out.println("4 listar");
            System.out.println("5 media geral");
            System.out.println("6 login adm");
            System.out.println("7 sair");
            System.out.print("opcao: ");
            String op = teclado.nextLine();

            if (op.equals("1")) {
                System.out.print("nome: ");
                String nome = teclado.nextLine();
                System.out.print("cpf: ");
                String cpf = teclado.nextLine();
                System.out.print("email: ");
                String email = teclado.nextLine();
                System.out.print("matricula: ");
                String mat = teclado.nextLine();
                Pessoa p = factory.criarPessoa("aluno", nome, cpf, email, null, null, mat);
                secretaria.cadastrarPessoa(p);
            } else if (op.equals("2")) {
                System.out.print("1 prof 2 coord: ");
                String tipo = teclado.nextLine();
                System.out.print("nome: ");
                String nome = teclado.nextLine();
                System.out.print("cpf: ");
                String cpf = teclado.nextLine();
                System.out.print("email: ");
                String email = teclado.nextLine();
                System.out.print("siape: ");
                String siape = teclado.nextLine();
                System.out.print("senha: ");
                String senha = teclado.nextLine();
                String tipoPessoa = tipo.equals("2") ? "coordenador" : "professor";
                Pessoa p = factory.criarPessoa(tipoPessoa, nome, cpf, email, siape, senha, null);
                secretaria.cadastrarPessoa(p);
            } else if (op.equals("3")) {
                System.out.print("1 por mat 2 por nome: ");
                String tipo = teclado.nextLine();
                Aluno aluno = null;
                if (tipo.equals("1")) {
                    System.out.print("matricula: ");
                    String mat = teclado.nextLine();
                    aluno = secretaria.localizarAlunoPorMatricula(mat);
                } else {
                    System.out.print("nome: ");
                    String nome = teclado.nextLine();
                    aluno = secretaria.localizarAlunoPorNome(nome);
                }
                if (aluno == null) {
                    System.out.println("nao achei aluno");
                } else {
                    System.out.print("nota: ");
                    String notaStr = teclado.nextLine();
                    try {
                        double nota = Double.parseDouble(notaStr.replace(',', '.'));
                        aluno.adicionarNota(nota);
                        System.out.println("nota registrada");
                    } catch (Exception e) {
                        System.out.println("nota errada");
                    }
                }
            } else if (op.equals("4")) {
                secretaria.listarMembros();
            } else if (op.equals("5")) {
                RelatorioAcademico rel = new RelatorioAcademico();
                List lista = secretaria.getPessoas();
                for (int i = 0; i < lista.size(); i++) {
                    Object obj = lista.get(i);
                    if (obj instanceof Avaliavel) {
                        rel.adicionarDados((Avaliavel) obj);
                    }
                }
                rel.exibirMediaGeral();
            } else if (op.equals("6")) {
                System.out.print("siape: ");
                String siape = teclado.nextLine();
                System.out.print("senha: ");
                String senha = teclado.nextLine();
                List lista = secretaria.getPessoas();
                boolean ok = false;
                for (int i = 0; i < lista.size(); i++) {
                    Object obj = lista.get(i);
                    if (obj instanceof Professor) {
                        Professor p = (Professor) obj;
                        if (p.siape.equalsIgnoreCase(siape) && p.login(senha)) {
                            System.out.println("entrando...");
                            ok = true;
                            break;
                        }
                    }
                }
                if (!ok) {
                    System.out.println("erro no login");
                }
            } else if (op.equals("7")) {
                System.out.println("tchau");
                teclado.close();
                break;
            } else {
                System.out.println("nao entendi");
            }
        }
    }
}

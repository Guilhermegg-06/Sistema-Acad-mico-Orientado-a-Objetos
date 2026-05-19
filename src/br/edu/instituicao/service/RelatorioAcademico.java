package br.edu.instituicao.service;

import br.edu.instituicao.interfaces.Avaliavel;
import java.util.ArrayList;
import java.util.List;

public class RelatorioAcademico {
    public List dados = new ArrayList();

    public void adicionarDados(Avaliavel objeto) {
        dados.add(objeto);
    }

    public double calcularMediaGeral() {
        if (dados.size() == 0) {
            return 0.0;
        }
        double soma = 0.0;
        for (int i = 0; i < dados.size(); i++) {
            Avaliavel a = (Avaliavel) dados.get(i);
            soma = soma + a.getMediaFinal();
        }
        return soma / dados.size();
    }

    public void exibirMediaGeral() {
        System.out.println("--- media geral ---");
        System.out.println("Media geral: " + calcularMediaGeral());
    }
}

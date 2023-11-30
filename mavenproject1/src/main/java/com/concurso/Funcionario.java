package com.concurso;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Usuario {
    private static List<Funcionario> listaFunc = new ArrayList<>();

    public Funcionario(String CPF, String senha, String nome, String endereco,
                       String dataDeNascimento, String telefone) {
        super(1, CPF, senha, nome, endereco, dataDeNascimento, telefone);
    }

    static {
        adicionarFunc("123", "123", "ADM", "Rua", "01/01/2000", "123456789");
    }

    public static void adicionarFunc(String CPF, String senha, String nome, String endereco,
                                  String dataDeNascimento, String telefone) {
        Funcionario novoFunc = new Funcionario(CPF, senha, nome, endereco, dataDeNascimento, telefone);
        listaFunc.add(novoFunc);
        GerenciarCadastro.adicionarFuncionario(novoFunc);
    }


    public static List<Funcionario> getListaFunc() {
        return listaFunc;
    }
}

package com.concurso;

public class Funcionario extends Usuario {

    public Funcionario(int perfil,String CPF, String senha, String nome, String endereco, String dataDeNascimento, String telefone, String cargo) {
        super(1,CPF, senha, nome, endereco, dataDeNascimento, telefone);
    }

    
}

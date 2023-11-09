package com.concurso;

public class Usuario {
    private static int proximoId = 1;
    private final int id;
    private int perfil;
    private String CPF;
    private String senha;
    private String nome;
    private String endereco;
    private String dataDeNascimento;
    private String telefone;

    public Usuario(int perfil,String CPF, String senha, String nome, String endereco, String dataDeNascimento, String telefone) {
        this.id = proximoId++;
        this.perfil = perfil;
        this.CPF = CPF;
        this.senha = senha;
        this.nome = nome;
        this.endereco = endereco;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
    }

    // Getters e Setters
    public int getId() {
    return id;
    }
    
     public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }
    
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

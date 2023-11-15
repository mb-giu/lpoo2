package com.concurso;

public class Participante extends Usuario {
    private String cargo;
    private Municipio municipio;

    public Participante(int perfil, String CPF, String senha, String nome, String endereco, String dataDeNascimento, String telefone, String cargo, Municipio municipio) {
        super(2, CPF, senha, nome, endereco, dataDeNascimento, telefone);
        this.cargo = cargo;
        this.municipio = municipio;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}

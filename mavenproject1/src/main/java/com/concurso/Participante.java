package com.concurso;

public class Participante extends Usuario {
    private Cargo cargo;
    private Municipio municipio;

    public Participante(int perfil, String CPF, String senha, String nome, String endereco, String dataDeNascimento, String telefone, Cargo cargo, Municipio municipio) {
        super(2, CPF, senha, nome, endereco, dataDeNascimento, telefone);
        this.cargo = cargo;
        this.municipio = municipio;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}

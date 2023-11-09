package com.concurso;

import java.util.*;

public class Participante extends Usuario {
    public Participante(int perfil,String CPF, String senha, String nome, String endereco, String dataDeNascimento, String telefone, String cargo) {
        super(2,CPF, senha, nome, endereco, dataDeNascimento, telefone);
    }

//public class Participante extends Municipio {
//    public Participante(String nomeMunicipio) {
//        super(nomeMunicipio);
//    }

//Private Cargo cargo;

}
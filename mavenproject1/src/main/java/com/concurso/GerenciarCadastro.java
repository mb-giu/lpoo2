package com.concurso;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class GerenciarCadastro {
    private static Map<String, Usuario> usuariosPorCPF = new HashMap<>();
    private static Map<Integer, Cargo> cargos = new HashMap<>();
    private static Map<Integer, InscricaoVaga> inscricoes = new HashMap<>();
    private static Map<Integer, Participante> participantes = new HashMap<>();

    public static Usuario getUsuarioByCPF(String cpf) {
        return usuariosPorCPF.get(cpf);
    }

    public static void cadastrarUsuario(Usuario usuario) {
        usuariosPorCPF.put(usuario.getCPF(), usuario);
    }

    public static void cadastrarCargo(String nome, double salario, int numeroDeVagas) {
        Cargo cargo = new Cargo(nome, salario, numeroDeVagas);
        cargos.put(cargo.getId(), cargo);
    }

    public static void cadastrarInscricaoVaga(Cargo cargo, int numeroDeInscritos) {
        InscricaoVaga inscricaoVaga = new InscricaoVaga(cargo, numeroDeInscritos);
        inscricoes.put(inscricaoVaga.getCargo().getId(), inscricaoVaga);
    }

    public static List<String> obterCargos() {
        List<String> listaCargos = new ArrayList<>();
        for (Cargo cargo : cargos.values()) {
            listaCargos.add(cargo.getNome());
        }
        return listaCargos;
    }

    public static Participante cadastrarParticipante(String CPF, String senha, String nome, String endereco,
                                                     String dataDeNascimento, String telefone, Cargo cargo, Municipio municipio) {
        Participante participante = new Participante(2, CPF, senha, nome, endereco, dataDeNascimento, telefone, cargo, municipio);
        participantes.put(participante.getId(), participante);
        usuariosPorCPF.put(CPF, participante);
        return participante;
    }
}

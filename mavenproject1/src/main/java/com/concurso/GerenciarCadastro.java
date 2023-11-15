package com.concurso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciarCadastro {
    private static Map<Integer, Participante> participantes = new HashMap<>();
    private static Map<Integer, Funcionario> funcionarios = new HashMap<>();
    private static Map<Integer, Cargo> cargos = new HashMap<>();
    private static Map<Integer, InscricaoVaga> inscricoes = new HashMap<>();

    public static void cadastrarParticipante(int perfil, String CPF, String senha, String nome, String endereco,
                                            String dataDeNascimento, String telefone, String cargo,String municipio) {
        Participante participante = new Participante(perfil, CPF, senha, nome, endereco, dataDeNascimento, telefone, cargo,municipio);
        participantes.put(participante.getId(), participante);
    }

    public static void cadastrarFuncionario(int perfil, String CPF, String senha, String nome, String endereco,
                                            String dataDeNascimento, String telefone, String cargo) {
        Funcionario funcionario = new Funcionario(perfil, CPF, senha, nome, endereco, dataDeNascimento, telefone, cargo);
        funcionarios.put(funcionario.getId(), funcionario);
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

    public static List<String> obterParticipantes() {
        List<String> listaParticipantes = new ArrayList<>();
        for (Participante participante : participantes.values()) {
            listaParticipantes.add(participante.getNome());
        }
        return listaParticipantes;
    }

    // Adicione métodos semelhantes para obter funcionários, vagas e inscrições

    // Adicione métodos para atualizar, excluir e buscar dados conforme necessário
}

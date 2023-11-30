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
    private static List<Funcionario> listaFunc = new ArrayList<>();

    public static Usuario getUsuarioByCPF(String cpf) {
        return usuariosPorCPF.get(cpf);
    }

    public static void cadastrarUsuario(Usuario usuario) {
        usuariosPorCPF.put(usuario.getCPF(), usuario);
    }
    
    public static Funcionario getFuncionarioByCPF(String cpf) {
    // Verificar na lista estática
        for (Funcionario func : Funcionario.getListaFunc()) {
            if (func.getCPF().equals(cpf)) {
                return func;
            }
        }
        // Verificar na lista de funcionários cadastrados
        //for (Funcionario funcionario : funcionarios.values()) {
            // if (funcionario.getCPF().equals(cpf)) {
             //    return funcionario;
           // }
        // }
        // Se não encontrar em nenhuma das listas, retornar null
        return null;
    }

     public static Participante getParticipanteByCPF(String cpf) {
        // Verificar na lista de participantes
        for (Participante participante : participantes.values()) {
            if (participante.getCPF().equals(cpf)) {
                return participante;
            }
        }
        // Se não encontrar na lista de participantes, retornar null
        return null;
    }
    
  ///////////
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
        Participante participante = new Participante (2, CPF, senha, nome, endereco, dataDeNascimento, telefone, cargo, municipio);
        participantes.put(participante.getId(), participante);
        usuariosPorCPF.put(CPF, participante);
        return participante;
    }
    
    public static Funcionario cadastrarFuncionario(String CPF, String senha, String nome, String endereco,
                                               String dataDeNascimento, String telefone) {
        Funcionario funcionario = new Funcionario(CPF, senha, nome, endereco, dataDeNascimento, telefone);
        listaFunc.add(funcionario);
        usuariosPorCPF.put(CPF, funcionario);
        return funcionario;
    }
    
    public static void adicionarFuncionario(Funcionario funcionario) {
        usuariosPorCPF.put(funcionario.getCPF(), funcionario);
    }
    
    //////
    
    public static List<Participante> getParticipantesPorVaga(Municipio municipio, Cargo cargo) {
        List<Participante> participantesPorVaga = new ArrayList<>();

        for (Participante participante : participantes.values()) {
            // Check if the participant's municipality and cargo match the specified ones
            if (participante.getMunicipio().equals(municipio) && participante.getCargo().equals(cargo)) {
                participantesPorVaga.add(participante);
            }
        }

        return participantesPorVaga;
    }

}

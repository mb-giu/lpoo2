package com.concurso;
import java.util.*;

public class Cargo {
    private static int proximoId = 1;
    private final int id; 
    private String nome;
    private double salario;
    private Vaga vaga;
    private Municipio municipio;

    public Cargo(String nome, double salario, int numeroDeVagas) {
        this.id = proximoId++;
        this.nome = nome;
        this.salario = salario;
        this.vaga = new Vaga(this, numeroDeVagas);
    }


//Métodos    
   
    private static List<Cargo> listaCargos = new ArrayList<>();
    static {
        adicionarCargoAutomatico("Analista de Desenvolvimento", 5000.0, 32);
        adicionarCargoAutomatico("Gerente de Projetos", 8000.0, 45);
        adicionarCargoAutomatico("Gerente de Vendas", 7000.0,16);
        adicionarCargoAutomatico("Analista de Rh", 5500.0,17);
        adicionarCargoAutomatico("Marketing", 6000.0,18);
        adicionarCargoAutomatico("Designer", 5500.0,45);
        adicionarCargoAutomatico("Desenvolvedor Web", 6000.0,36);
        adicionarCargoAutomatico("Desenvolvedor Java", 6500.0,2);
        adicionarCargoAutomatico("Gerente de Produção", 7500.0,2);
        adicionarCargoAutomatico("Secretaria(o)", 4500.0,12);
    }

    private static void adicionarCargoAutomatico(String nome, double salario, int numeroDeVagas) {
        Cargo novoCargo = new Cargo(nome, salario,numeroDeVagas);
        listaCargos.add(novoCargo);
    }

    public static void registrarCargo(Cargo novoCargo) {
        listaCargos.add(novoCargo);
        System.out.println("Cargo registrado com sucesso!");
    }


    public static List<String> getCargos() {
        List<String> cargos = new ArrayList<>();
        for (Cargo cargo : listaCargos) {
            cargos.add(cargo.getNome());
        }
        return cargos;
    }
   
    
        // Getters e Setters
    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
     public Vaga getVaga() {
        return vaga;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
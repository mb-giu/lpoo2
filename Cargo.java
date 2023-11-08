package com.concurso;

public class Cargo {
    private int id; 
    private String nome;
    private double salario;

    public Cargo(String nome, double salario) {
        this.id = proximoId++;
        this.nome = nome;
        this.salario = salario;
    }

    // Getters e Setters
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

//Métodos    
   
    private static List<Cargo> listaCargos = new ArrayList<>();
    static {
        adicionarCargoAutomatico("Analista de Desenvolvimento", 5000.0);
        adicionarCargoAutomatico("Gerente de Projetos", 8000.0);
        adicionarCargoAutomatico("Gerente de Vendas", 7000.0);
        adicionarCargoAutomatico("Analista de Rh", 5500.0);
        adicionarCargoAutomatico("Marketing", 6000.0);
        adicionarCargoAutomatico("Designer", 5500.0);
        adicionarCargoAutomatico("Desenvolvedor Web", 6000.0);
        adicionarCargoAutomatico("Desenvolvedor Java", 6500.0);
        adicionarCargoAutomatico("Gerente de Produção", 7500.0);
        adicionarCargoAutomatico("Secretaria(o)", 4500.0);
    }

    //adicionar cargos 
    private static void adicionarCargoAutomatico(String nome, double salario) {
        Cargo novoCargo = new Cargo(nome, salario);
        listaCargos.add(novoCargo);
    }

    // registra um cargo
    public static void registrarCargo(Cargo novoCargo) {
        listaCargos.add(novoCargo);
        System.out.println("Cargo registrado com sucesso!");
    }

    // lista os cargos
    public static void listarCargos() {
        if (listaCargos.isEmpty()) {
            System.out.println("Não há cargos registrados.");
        } else {
            System.out.println("Lista de Cargos:");
            for (Cargo cargo : listaCargos) {
                System.out.println("ID: " + cargo.getId() + ", Nome: " + cargo.getNome() + ", Salário: " + cargo.getSalario());
            }
        }
    }

}

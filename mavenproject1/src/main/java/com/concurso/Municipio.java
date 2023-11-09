package com.concurso;

import java.util.*;

public class Municipio {
    private static int proximoId = 1;
    private final int id;
    private String nomeMunicipio;
    private String estado;

    private static Map<String, List<Municipio>> municipiosPorEstado = new HashMap<>();
    static {
        adicionarMunicipioAutomatico("São Paulo", "SP");
        adicionarMunicipioAutomatico("Rio de Janeiro", "RJ");
        adicionarMunicipioAutomatico("Belo Horizonte", "MG");
        adicionarMunicipioAutomatico("Porto Alegre", "RS");
        adicionarMunicipioAutomatico("Curitiba", "PR");
        adicionarMunicipioAutomatico("Maringá", "PR");
    }

    public Municipio(String nomeMunicipio, String estado) {
        this.id = proximoId++;
        this.nomeMunicipio = nomeMunicipio;
        this.estado = estado;
    }

//Métodos

    // adicionar municípios na lista
    private static void adicionarMunicipioAutomatico(String nomeMunicipio, String estado) {
        Municipio novoMunicipio = new Municipio(nomeMunicipio, estado);

        // verifica se o estado já está na lista
        if (municipiosPorEstado.containsKey(estado)) {
            municipiosPorEstado.get(estado).add(novoMunicipio);
        } else {
            List<Municipio> listaMunicipios = new ArrayList<>();
            listaMunicipios.add(novoMunicipio);
            municipiosPorEstado.put(estado, listaMunicipios);
        }
    }

    public static void registrarMunicipio(Municipio novoMunicipio) {
        // Verifica se o estado já está na lista
        if (municipiosPorEstado.containsKey(novoMunicipio.getEstado())) {
            municipiosPorEstado.get(novoMunicipio.getEstado()).add(novoMunicipio);
        } else {
            List<Municipio> listaMunicipios = new ArrayList<>();
            listaMunicipios.add(novoMunicipio);
            municipiosPorEstado.put(novoMunicipio.getEstado(), listaMunicipios);
        }

        System.out.println("Município registrado com sucesso!");
    }

    public static void listarMunicipiosPorEstado(String estado) {
        if (municipiosPorEstado.containsKey(estado)) {
            System.out.println("Lista de Municípios em " + estado + ":");
            for (Municipio municipio : municipiosPorEstado.get(estado)) {
                System.out.println("ID: " + municipio.getId() + ", Nome: " + municipio.getNome() + ", Estado: " + municipio.getEstado());
            }
        } else {
            System.out.println("Não há municípios registrados para o estado de " + estado + ".");
        }
    }
    
    public static List<String> getMunicipios() {
        List<String> municipios = new ArrayList<>();
        for (List<Municipio> lista : municipiosPorEstado.values()) {
            for (Municipio municipio : lista) {
                municipios.add(municipio.getNome());
            }
        }
        return municipios;
    }


    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nomeMunicipio;
    }

    public void setNome(String nome) {
        this.nomeMunicipio = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
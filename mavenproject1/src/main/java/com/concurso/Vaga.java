package com.concurso;

public class Vaga {
    private int numeroDeVagas;
    private Cargo cargo;

    public Vaga(Cargo cargo, int numeroVagas) {
        this.numeroDeVagas = numeroVagas;
    }

    // Getters e Setters
    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }
    
    public Cargo getCargo() {
        return cargo;
    }
}

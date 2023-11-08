package com.concurso;

public class Vaga {
    private int numeroDeVagas;

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
}

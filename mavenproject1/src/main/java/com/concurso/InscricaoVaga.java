package com.concurso;

public class InscricaoVaga {
    private Cargo cargo;
    private int numeroDeInscritos;

    public InscricaoVaga(Cargo cargo, int numeroDeInscritos) {
        this.cargo = cargo;
        this.numeroDeInscritos = numeroDeInscritos;
    }

    public Cargo getCargo() {
        return cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getNumeroDeInscritos() {
        return numeroDeInscritos;
    }

    public void setNumeroDeInscritos(int numeroDeInscritos) {
        this.numeroDeInscritos = numeroDeInscritos;
    }

    public void incrementarInscritos() {
        this.numeroDeInscritos++;
    }

    public void decrementarInscritos() {
        if (numeroDeInscritos > 0) {
            this.numeroDeInscritos--;
        }
    }
}

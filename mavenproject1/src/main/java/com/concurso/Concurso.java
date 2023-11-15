package com.concurso;
import java.util.*;

public class Concurso {

    public static void main(String[] args) {
        List<String> listaMunicipios = Municipio.getMunicipios();
        List<String> listaCargos = Cargo.getCargos();

        // Criar uma instância da classe CadastroParticipanteGUI
        CadastroParticipante cadastroParticipante = new CadastroParticipante(listaMunicipios, listaCargos);

        // Tornar a tela visível
        cadastroParticipante.setVisible(true);
    }
}

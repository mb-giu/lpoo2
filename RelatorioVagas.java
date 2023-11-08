package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelatorioVagas extends JFrame {
    private JTextArea textAreaRelatorio;

    public RelatorioVagas() {
        initComponents();
        criarRelatorio();
    }

    private void initComponents() {
        setTitle("Relatório de Vagas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textAreaRelatorio = new JTextArea();
        textAreaRelatorio.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textAreaRelatorio);

        getContentPane().add(scrollPane);

        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void criarRelatorio() {

        List<Cargo> cargos = Cargo.getCargos();
        Map<String, Integer> participantesPorVaga = obterParticipantesPorVaga();

        textAreaRelatorio.setText("Relatório de Vagas:\n\n");

        for (Cargo cargo : cargos) {
            String nomeCargo = cargo.getNome();
            int participantesInscritos = participantesPorVaga.getOrDefault(nomeCargo, 0);
            int vagasTotais = obterVagasTotaisPorCargo(nomeCargo);

            textAreaRelatorio.append("Cargo: " + nomeCargo + "\n");
            textAreaRelatorio.append("Participantes Inscritos: " + participantesInscritos + "\n");
            textAreaRelatorio.append("Vagas Totais: " + vagasTotais + "\n");
            textAreaRelatorio.append("\n");
        }
    }

    private Map<String, Integer> obterParticipantesPorVaga() {
        // Dado ficticio por enquanto pq n tem login ainda
        Map<String, Integer> participantesPorVaga = new HashMap<>();
        participantesPorVaga.put("Desenvolvedor Java", 3);
        participantesPorVaga.put("Analista de Rh", 1);
        participantesPorVaga.put("Marketing", 2);
        

        return participantesPorVaga;
    }

    private int obterVagasTotaisPorCargo(String cargo) {
        // Dado ficticio por enquanto pq n tem login ainda
        Map<String, Integer> vagasTotaisPorCargo = new HashMap<>();
        vagasTotaisPorCargo.put("Desenvolvedor Java", 5);
        vagasTotaisPorCargo.put("Analista de Rh", 2);
        vagasTotaisPorCargo.put("Marketing", 3);
        

        return vagasTotaisPorCargo.getOrDefault(cargo, 0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RelatorioVagas relatorio = new RelatorioVagas();
            relatorio.setVisible(true);
        });
    }
}

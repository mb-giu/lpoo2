package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginaParticipantesPorVaga extends JFrame {
    private JComboBox<Municipio> comboBoxMunicipio;
    private JLabel labelMunicipio;
    private JButton buttonVoltar;

    public PaginaParticipantesPorVaga(List<String> listaMunicipios, List<String> listaCargos) {
        initComponents(listaMunicipios, listaCargos);
    }

    private void initComponents(List<String> municipios, List<String> cargos) {
        setTitle("Participantes por Vaga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout()); // Layout de fluxo para colocar os componentes lado a lado

        labelMunicipio = new JLabel("Selecione o Município:");
        comboBoxMunicipio = new JComboBox<>(municipios.stream().map(nome -> new Municipio(nome, "Estado Padrão")).toArray(Municipio[]::new));
        inputPanel.add(labelMunicipio);
        inputPanel.add(comboBoxMunicipio);

        // Criação do texto para os cargos
        JPanel panelCargos = new JPanel();
        panelCargos.setLayout(new GridLayout(cargos.size() + 1, 3, 0, 5)); // +1 para incluir a linha de títulos

        // Adiciona títulos acima das colunas
        JLabel labelCargos = new JLabel("Cargos");
        JLabel labelVagas = new JLabel("Vagas");
        JLabel labelInscritos = new JLabel("Inscritos");
        labelCargos.setHorizontalAlignment(JLabel.LEFT); // Alinha à esquerda
        labelVagas.setHorizontalAlignment(JLabel.LEFT); // Alinha à esquerda
        labelInscritos.setHorizontalAlignment(JLabel.LEFT); // Alinha à esquerda

        panelCargos.add(labelCargos);
        panelCargos.add(labelVagas);
        panelCargos.add(labelInscritos);

        // Estrutura de dados para representar o número de vagas e inscritos para cada cargo
        Map<String, Integer> vagasPorCargo = new HashMap<>();
        Map<String, Integer> inscritosPorCargo = new HashMap<>();

        // Suponha que inicialmente todas as vagas e inscritos são 10 (altere conforme necessário)
        for (String cargo : cargos) {
            vagasPorCargo.put(cargo, 20);
            inscritosPorCargo.put(cargo, 80);
        }

        // Adiciona cargos, vagas e inscritos
        for (String cargo : cargos) {
            JLabel labelCargo = new JLabel(cargo);
            JLabel labelVagasCargo = new JLabel(String.format("%02d", vagasPorCargo.get(cargo)));
            JLabel labelInscritosCargo = new JLabel(String.format("%02d", inscritosPorCargo.get(cargo)));

            panelCargos.add(labelCargo);
            panelCargos.add(labelVagasCargo);
            panelCargos.add(labelInscritosCargo);
        }

        buttonVoltar = new JButton("Voltar");
        setButtonStyle(buttonVoltar);
        buttonVoltar.addActionListener(e -> voltarParaPaginaPrincipal());

        // Adiciona os componentes ao painel principal
        panel.add(inputPanel, BorderLayout.NORTH); // Adiciona na parte superior
        panel.add(panelCargos, BorderLayout.CENTER); // Ocupa toda a largura disponível
        panel.add(buttonVoltar, BorderLayout.SOUTH); // Adiciona na parte inferior

        getContentPane().add(panel);
        pack(); // Ajusta o tamanho automaticamente
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(800, 400); // Ajuste a largura conforme necessário
    }

    private void setButtonStyle(JButton button) {
        button.setPreferredSize(new Dimension(100, 30)); // Ajusta a largura do botão
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private void voltarParaPaginaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            new PaginaPrincipalParticipante().setVisible(true);
            PaginaParticipantesPorVaga.this.dispose();
        });
    }
}

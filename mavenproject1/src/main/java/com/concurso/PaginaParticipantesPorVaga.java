package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaginaParticipantesPorVaga extends JFrame {
    private JComboBox<String> comboBoxMunicipio;
    private JLabel labelMunicipio;
    private JButton buttonVoltar;
    private JPanel panelCargos;

    public PaginaParticipantesPorVaga(List<String> listaMunicipios, List<String> listaCargos) {
        initComponents(listaMunicipios, listaCargos);
    }

    private void initComponents(List<String> municipios, List<String> cargos) {
        setTitle("Participantes por Vaga");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        labelMunicipio = new JLabel("Selecione o Município:");
        comboBoxMunicipio = new JComboBox<>(municipios.toArray(new String[0]));
        inputPanel.add(labelMunicipio);
        inputPanel.add(comboBoxMunicipio);

        panelCargos = new JPanel();
        panelCargos.setLayout(new GridLayout(cargos.size() + 1, 3, 0, 5));

        JLabel labelCargos = new JLabel("Cargos");
        JLabel labelVagas = new JLabel("Vagas");
        JLabel labelInscritos = new JLabel("Inscritos");
        labelCargos.setHorizontalAlignment(JLabel.LEFT);
        labelVagas.setHorizontalAlignment(JLabel.LEFT);
        labelInscritos.setHorizontalAlignment(JLabel.LEFT);

        panelCargos.add(labelCargos);
        panelCargos.add(labelVagas);
        panelCargos.add(labelInscritos);

        // Adiciona cargos, vagas e inscritos
        for (String cargo : cargos) {
            JLabel labelCargo = new JLabel(cargo);
            JLabel labelVagasCargo = new JLabel(String.format("%02d", obterVagasPorCargo(cargo)));
            JLabel labelInscritosCargo = new JLabel(String.format("%02d", obterInscritosPorCargo(cargo)));

            panelCargos.add(labelCargo);
            panelCargos.add(labelVagasCargo);
            panelCargos.add(labelInscritosCargo);
        }

        buttonVoltar = new JButton("Voltar");
        setButtonStyle(buttonVoltar);
        buttonVoltar.addActionListener(e -> exibirPaginaPrincipal());

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(panelCargos, BorderLayout.CENTER);
        panel.add(buttonVoltar, BorderLayout.SOUTH);

        getContentPane().add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(800, 400);
    }

    private void setButtonStyle(JButton button) {
        button.setPreferredSize(new Dimension(100, 30));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private void exibirPaginaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
            if (usuarioLogado != null) {
                int perfil = obterPerfilUsuario(usuarioLogado);
                if (perfil == 1) {
                    new PaginaPrincipalFuncionario(buttonText -> {
                        System.out.println("Botão clicado (Funcionário): " + buttonText);
                    }).setVisible(true);
                } else {
                    System.out.println("Abrindo Página Principal do Participante");
                    new PaginaPrincipalParticipante().setVisible(true);
                }
                dispose();
            }
        });
    }

    private int obterPerfilUsuario(Usuario usuario) {
        return usuario.getPerfil();
    }

    private int obterVagasPorCargo(String cargo) {
    	return 35;
    }

    private int obterInscritosPorCargo(String cargo) {
        return 80;
    }
}

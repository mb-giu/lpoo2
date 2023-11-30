package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PerfilParticipante extends JFrame {
    private JLabel labelNome;
    private JLabel labelCPF;
    private JLabel labelEndereco;
    private JLabel labelDataNascimento;
    private JLabel labelTelefone;
    private JLabel labelMunicipio;
    private JLabel labelCargo;

    public PerfilParticipante(Participante participante) {
        initComponents(participante);
    }

    private void initComponents(Participante participante) {
        setTitle("Perfil do Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelNome = new JLabel("Nome: " + participante.getNome());
        labelCPF = new JLabel("CPF: " + participante.getCPF());
        labelEndereco = new JLabel("Endereço: " + participante.getEndereco());
        labelDataNascimento = new JLabel("Data de Nascimento: " + participante.getDataDeNascimento());
        labelTelefone = new JLabel("Telefone: " + participante.getTelefone());
        labelMunicipio = new JLabel("Município: " + participante.getMunicipio());
        labelCargo = new JLabel("Cargo: " + participante.getCargo());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(labelNome);
        panel.add(labelCPF);
        panel.add(labelEndereco);
        panel.add(labelDataNascimento);
        panel.add(labelTelefone);
        panel.add(labelMunicipio);
        panel.add(labelCargo);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton buttonVoltar = new JButton("Voltar");
        JButton buttonEditarPerfil = new JButton("Editar Perfil");

        buttonVoltar.addActionListener(this::voltarParaPaginaPrincipal);
        buttonEditarPerfil.addActionListener(this::exibirEditarPerfil);

        buttonPanel.add(buttonVoltar);
        buttonPanel.add(buttonEditarPerfil);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void voltarParaPaginaPrincipal(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            new PaginaPrincipalParticipante().setVisible(true);
            PerfilParticipante.this.dispose();
        });
    }

    private void exibirEditarPerfil(ActionEvent e) {
        SwingUtilities.invokeLater(() -> {
            new EditarPerfilParticipante(SessaoUsuario.getParticipanteLogado()).setVisible(true);
            PerfilParticipante.this.dispose();
        });
    }
}

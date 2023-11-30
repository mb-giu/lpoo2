package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PaginaPrincipalParticipante extends JFrame {
    public PaginaPrincipalParticipante() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Página Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton buttonPerfil = new JButton("Perfil");
        JButton buttonParticipantes = new JButton("Participantes por Vaga");
        JButton buttonSair = new JButton("Sair");

        buttonPerfil.addActionListener(this::exibirPaginaPerfil);
        buttonParticipantes.addActionListener(this::exibirPaginaParticipantesPorVaga);
        buttonSair.addActionListener(this::encerrarSessao);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(buttonPerfil);
        panel.add(buttonParticipantes);
        panel.add(buttonSair);

        getContentPane().add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void exibirPaginaPerfil(ActionEvent e) {
        Usuario usuario = SessaoUsuario.getUsuarioLogado();
        if (usuario != null && usuario instanceof Participante) {
            new PerfilParticipante((Participante) usuario).setVisible(true);
            PaginaPrincipalParticipante.this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não logado ou não é um participante.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirPaginaParticipantesPorVaga(ActionEvent e) {
        java.util.List<String> listaMunicipios = Municipio.getMunicipios();
        java.util.List<String> listaCargos = Cargo.getCargos();

        // Usando uma referência final para a instância atual de PaginaPrincipalParticipante
        final PaginaPrincipalParticipante paginaPrincipal = this;

        SwingUtilities.invokeLater(() -> {
            new PaginaParticipantesPorVaga(listaMunicipios, listaCargos).setVisible(true);
            paginaPrincipal.dispose();
        });
    }

    private void encerrarSessao(ActionEvent e) {
        SessaoUsuario.encerrarSessao();
        exibirPaginaLogin();
        PaginaPrincipalParticipante.this.dispose();
    }

    private void exibirPaginaLogin() {
        SwingUtilities.invokeLater(() -> {
            new PaginaLogin().setVisible(true);
            PaginaPrincipalParticipante.this.dispose();
        });
    }
}

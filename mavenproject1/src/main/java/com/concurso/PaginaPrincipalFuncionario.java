package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PaginaPrincipalFuncionario extends JFrame {
    private JButton buttonCadastrarFuncionario;
    private JButton buttonCadastrarMunicipio;
    private JButton buttonCadastrarCargo;
    private JButton buttonCadastrarVagas;
    private JButton buttonParticipantesPorVaga;
    private JButton buttonSair;

    public PaginaPrincipalFuncionario(Consumer<String> buttonClickHandler) {
        initComponents(buttonClickHandler);
    }

    private void initComponents(Consumer<String> buttonClickHandler) {
        setTitle("Página Principal - Funcionário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 10, 10));

        buttonCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        setButtonStyle(buttonCadastrarFuncionario);
        buttonCadastrarFuncionario.addActionListener(e -> {
            buttonClickHandler.accept("Cadastrar Funcionário");
            dispose();
        });

        buttonCadastrarMunicipio = new JButton("Cadastrar Município");
        setButtonStyle(buttonCadastrarMunicipio);
        buttonCadastrarMunicipio.addActionListener(e -> {
            buttonClickHandler.accept("Cadastrar Município");
            dispose();
        });

        buttonCadastrarCargo = new JButton("Cadastrar Cargo");
        setButtonStyle(buttonCadastrarCargo);
        buttonCadastrarCargo.addActionListener(e -> {
            buttonClickHandler.accept("Cadastrar Cargo");
            dispose();
        });

        buttonCadastrarVagas = new JButton("Cadastrar Vagas");
        setButtonStyle(buttonCadastrarVagas);
        buttonCadastrarVagas.addActionListener(e -> {
            buttonClickHandler.accept("Cadastrar Vagas");
            dispose();
        });

        buttonParticipantesPorVaga = new JButton("Participantes por Vaga");
        setButtonStyle(buttonParticipantesPorVaga);
        buttonParticipantesPorVaga.addActionListener(e -> {
            buttonClickHandler.accept("Participantes por Vaga");
            dispose();
        });

        buttonSair = new JButton("Sair");
        setButtonStyle(buttonSair);
        buttonSair.addActionListener(e -> {
            SessaoUsuario.encerrarSessao();
            dispose();
            exibirPaginaLogin();
        });

        panel.add(buttonCadastrarFuncionario);
        panel.add(buttonCadastrarMunicipio);
        panel.add(buttonCadastrarCargo);
        panel.add(buttonCadastrarVagas);
        panel.add(buttonParticipantesPorVaga);
        panel.add(buttonSair);

        getContentPane().add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(400, 300);
    }

    private void setButtonStyle(JButton button) {
        button.setPreferredSize(new Dimension(200, 30));
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private void exibirPaginaLogin() {
        SwingUtilities.invokeLater(() -> {
            new PaginaLogin().setVisible(true);
        });
    }
}

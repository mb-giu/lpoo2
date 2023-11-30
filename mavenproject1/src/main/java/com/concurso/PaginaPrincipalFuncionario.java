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
    private JButton buttonVoltar;

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
        buttonCadastrarFuncionario.addActionListener(e -> buttonClickHandler.accept("Cadastrar Funcionário"));

        buttonCadastrarMunicipio = new JButton("Cadastrar Município");
        setButtonStyle(buttonCadastrarMunicipio);
        buttonCadastrarMunicipio.addActionListener(e -> buttonClickHandler.accept("Cadastrar Município"));

        buttonCadastrarCargo = new JButton("Cadastrar Cargo");
        setButtonStyle(buttonCadastrarCargo);
        buttonCadastrarCargo.addActionListener(e -> buttonClickHandler.accept("Cadastrar Cargo"));

        buttonCadastrarVagas = new JButton("Cadastrar Vagas");
        setButtonStyle(buttonCadastrarVagas);
        buttonCadastrarVagas.addActionListener(e -> buttonClickHandler.accept("Cadastrar Vagas"));

        buttonParticipantesPorVaga = new JButton("Participantes por Vaga");
        setButtonStyle(buttonParticipantesPorVaga);
        buttonParticipantesPorVaga.addActionListener(e -> buttonClickHandler.accept("Participantes por Vaga"));

        buttonVoltar = new JButton("Voltar");
        setButtonStyle(buttonVoltar);
        buttonVoltar.addActionListener(e -> buttonClickHandler.accept("Voltar"));

        panel.add(buttonCadastrarFuncionario);
        panel.add(buttonCadastrarMunicipio);
        panel.add(buttonCadastrarCargo);
        panel.add(buttonCadastrarVagas);
        panel.add(buttonParticipantesPorVaga);
        panel.add(buttonVoltar);

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
}

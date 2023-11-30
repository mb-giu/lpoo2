package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;
import java.util.*;

public class PaginaPrincipalFuncionario extends JFrame {
    private JButton buttonCadastrarFuncionario;
    private JButton buttonCadastrarMunicipio;
    private JButton buttonCadastrarCargo;
    private JButton buttonParticipantesPorVaga;
    private JButton buttonSair;

    public PaginaPrincipalFuncionario(Consumer<String> buttonClickHandler) {
        initComponents(buttonClickHandler);
    }

    private void initComponents(Consumer<String> buttonClickHandler) {
        setTitle("Página Principal - Funcionário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        buttonCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        setButtonStyle(buttonCadastrarFuncionario);
        buttonCadastrarFuncionario.addActionListener(e -> {
            exibirCadastroFuncionario();
            dispose();
        });

        buttonCadastrarMunicipio = new JButton("Cadastrar Município");
        setButtonStyle(buttonCadastrarMunicipio);
        buttonCadastrarMunicipio.addActionListener(e -> {
            exibirCadastroMunicipio();
            dispose();
        });

        buttonCadastrarCargo = new JButton("Cadastrar Cargo");
        setButtonStyle(buttonCadastrarCargo);
        buttonCadastrarCargo.addActionListener(e -> {
            exibirCadastroCargo();
            dispose();
        });

        buttonParticipantesPorVaga = new JButton("Participantes por Vaga");
        setButtonStyle(buttonParticipantesPorVaga);
        buttonParticipantesPorVaga.addActionListener(e -> {
            exibirPaginaParticipantesPorVaga();
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

    private void exibirCadastroFuncionario() {
        SwingUtilities.invokeLater(() -> {
            new CadastroFuncionario().setVisible(true);
            PaginaPrincipalFuncionario.this.dispose();
        });
    }

    private void exibirCadastroMunicipio() {
        SwingUtilities.invokeLater(() -> {
            new CadastroMunicipio().setVisible(true);
            PaginaPrincipalFuncionario.this.dispose();
        });
    }

    private void exibirCadastroCargo() {
        SwingUtilities.invokeLater(() -> {
            new CadastroCargo().setVisible(true);
            PaginaPrincipalFuncionario.this.dispose();
        });
    }

    private void exibirPaginaParticipantesPorVaga() {
    	java.util.List<String> listaMunicipios = Municipio.getMunicipios();
        java.util.List<String> listaCargos = Cargo.getCargos();

        SwingUtilities.invokeLater(() -> {
            PaginaParticipantesPorVaga pagina = new PaginaParticipantesPorVaga(listaMunicipios, listaCargos);
            pagina.setVisible(true);
            PaginaPrincipalFuncionario.this.dispose();
        });
    }
}

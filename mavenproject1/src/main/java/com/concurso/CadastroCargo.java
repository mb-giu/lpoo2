package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

public class CadastroCargo extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldSalario;
    private JTextField fieldNumeroVagas;
    private JButton buttonCadastrar;
    private JButton buttonVoltar;

    public CadastroCargo() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Cargo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelSalario = new JLabel("Salário:");
        JLabel labelNumeroVagas = new JLabel("Número de Vagas:");

        fieldNome = new JTextField(10);
        fieldSalario = new JTextField(10);
        fieldNumeroVagas = new JTextField(10);

        buttonCadastrar = new JButton("Cadastrar");
        buttonVoltar = new JButton("Voltar");

        buttonCadastrar.addActionListener(e -> {
            cadastrarCargoAsync();
        });

        buttonVoltar.addActionListener(e -> exibirPaginaPrincipalFuncionario());

        // componentes do painel
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(labelSalario);
        panel.add(fieldSalario);
        panel.add(labelNumeroVagas);
        panel.add(fieldNumeroVagas);
        panel.add(new JLabel()); // Espaçamento
        panel.add(new JLabel()); // Espaçamento
        panel.add(buttonVoltar);
        panel.add(buttonCadastrar);

        getContentPane().add(panel);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void exibirPaginaPrincipalFuncionario() {
        SwingUtilities.invokeLater(() -> {
            new PaginaPrincipalFuncionario(buttonText -> {
                System.out.println("Botão clicado: " + buttonText);
            }).setVisible(true);
            CadastroCargo.this.dispose();
        });
    }

    private void cadastrarCargoAsync() {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                cadastrarCargo();
                return null;
            }

            @Override
            protected void done() {
                exibirPaginaPrincipalFuncionario();
            }
        };

        worker.execute();
    }

    private void cadastrarCargo() {
        String nome = fieldNome.getText();
        double salario = Double.parseDouble(fieldSalario.getText());
        int numeroVagas = Integer.parseInt(fieldNumeroVagas.getText());

        Cargo novoCargo = new Cargo(nome, salario, numeroVagas);
        Cargo.registrarCargo(novoCargo);

        System.out.println("Cargo cadastrado: " + nome);
    }
}

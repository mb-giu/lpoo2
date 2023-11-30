package com.concurso;

import javax.swing.*;
import java.awt.*;

public class CadastroMunicipio extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldEstado;
    private JButton buttonCadastrar;
    private JButton buttonVoltar;

    public CadastroMunicipio() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Município");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelEstado = new JLabel("Estado:");

        fieldNome = new JTextField(10);
        fieldEstado = new JTextField(10);

        buttonCadastrar = new JButton("Cadastrar");
        buttonVoltar = new JButton("Voltar");

        buttonCadastrar.addActionListener(e -> {
            cadastrarMunicipio();
            exibirPaginaPrincipalFuncionario();
        });

        buttonVoltar.addActionListener(e -> exibirPaginaPrincipalFuncionario());

        // componentes do painel
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(labelEstado);
        panel.add(fieldEstado);
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
            CadastroMunicipio.this.dispose();
        });
    }

    private void cadastrarMunicipio() {
        String nome = fieldNome.getText();
        String estado = fieldEstado.getText();

        Municipio novoMunicipio = new Municipio(nome, estado);
        Municipio.registrarMunicipio(novoMunicipio);

        System.out.println("Município cadastrado: " + nome);
    }

}

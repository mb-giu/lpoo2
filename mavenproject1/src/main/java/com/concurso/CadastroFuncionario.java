package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroFuncionario extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldCPF;
    private JPasswordField fieldSenha;
    private JTextField fieldEndereco;
    private JTextField fieldDataNascimento;
    private JTextField fieldTelefone;
    private JButton buttonCadastrar;
    private JButton buttonVoltar;

    public CadastroFuncionario() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Funcionário");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelCPF = new JLabel("CPF:");
        JLabel labelSenha = new JLabel("Senha:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        JLabel labelTelefone = new JLabel("Telefone:");

        fieldNome = new JTextField(10);
        fieldCPF = new JTextField(10);
        fieldSenha = new JPasswordField(10);
        fieldEndereco = new JTextField(10);
        fieldDataNascimento = new JTextField(10);
        fieldTelefone = new JTextField(10);

        buttonCadastrar = new JButton("Cadastrar");
        buttonVoltar = new JButton("Voltar");

        buttonCadastrar.addActionListener(e -> {
            cadastrarFuncionario();
            exibirPaginaPrincipalFuncionario();
        });

        buttonVoltar.addActionListener(e -> exibirPaginaPrincipalFuncionario());

        // componentes do painel
        panel.add(labelNome);
        panel.add(fieldNome);
        panel.add(labelCPF);
        panel.add(fieldCPF);
        panel.add(labelSenha);
        panel.add(fieldSenha);
        panel.add(labelEndereco);
        panel.add(fieldEndereco);
        panel.add(labelDataNascimento);
        panel.add(fieldDataNascimento);
        panel.add(labelTelefone);
        panel.add(fieldTelefone);
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
                // Lógica para lidar com cliques de botões na PaginaPrincipalFuncionario
                System.out.println("Botão clicado: " + buttonText);
            }).setVisible(true);
            CadastroFuncionario.this.dispose();
        });
    }

    private void cadastrarFuncionario() {
        String nome = fieldNome.getText();
        String CPF = fieldCPF.getText();
        String senha = new String(fieldSenha.getPassword());
        String endereco = fieldEndereco.getText();
        String dataNascimento = fieldDataNascimento.getText();
        String telefone = fieldTelefone.getText();

        GerenciarCadastro.cadastrarFuncionario(CPF, senha, nome, endereco, dataNascimento, telefone);
        System.out.println("Funcionário cadastrado: " + nome);
    }
}

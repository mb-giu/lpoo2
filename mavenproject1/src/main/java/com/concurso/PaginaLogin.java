package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PaginaLogin extends JFrame {
    private JTextField fieldCPF;
    private JPasswordField fieldSenha;

    public PaginaLogin() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Página de Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelCPF = new JLabel("CPF:");
        JLabel labelSenha = new JLabel("Senha:");

        fieldCPF = new JTextField(10);
        fieldSenha = new JPasswordField(10);

        JButton buttonLogin = new JButton("Login");
        JButton buttonCadastro = new JButton("Cadastrar-se");

        buttonLogin.addActionListener(e -> realizarLogin());
        buttonCadastro.addActionListener(e -> exibirPaginaCadastro());

        panel.add(labelCPF);
        panel.add(fieldCPF);
        panel.add(labelSenha);
        panel.add(fieldSenha);
        panel.add(buttonCadastro);
        panel.add(buttonLogin);
        panel.add(new JLabel()); // Espaçamento
        panel.add(new JLabel()); // Espaçamento

        getContentPane().add(panel);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    private void realizarLogin() {
        // Lógica de autenticação aqui
        String cpfDigitado = fieldCPF.getText();
        String senhaDigitada = new String(fieldSenha.getPassword());

        if (autenticarUsuario(cpfDigitado, senhaDigitada)) {
            exibirPaginaPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Login inválido. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean autenticarUsuario(String cpf, String senha) {
        // Lógica real de autenticação aqui
        // Substitua pelo seu mecanismo de autenticação
        return "cpfExemplo".equals(cpf) && "senhaExemplo".equals(senha);
    }

    private void exibirPaginaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            new PaginaPrincipalParticipante().setVisible(true);
            dispose();
        });
    }

    private void exibirPaginaCadastro() {
        SwingUtilities.invokeLater(() -> {
            new CadastroParticipante(Cargo.getCargos(), Municipio.getMunicipios()).setVisible(true);
            dispose();
        });
    }
}
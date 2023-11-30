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

        buttonLogin.addActionListener(this::realizarLogin);
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

    private void realizarLogin(ActionEvent e) {
        String cpfDigitado = fieldCPF.getText();
        String senhaDigitada = new String(fieldSenha.getPassword());

        if (autenticarUsuario(cpfDigitado, senhaDigitada)) {
            SessaoUsuario.setParticipanteLogado(GerenciarCadastro.getParticipanteByCPF(cpfDigitado));
            exibirPaginaPrincipal();
        } else {
            JOptionPane.showMessageDialog(null, "Login inválido. Tente novamente.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean autenticarUsuario(String cpf, String senha) {
        // Verifica se é um funcionário
        Usuario usuario = GerenciarCadastro.getUsuarioByCPF(cpf);
        System.out.println("Usuário encontrado: " + usuario);
        return usuario != null && usuario.getSenha().equals(senha);
    }

    private void exibirPaginaPrincipal() {
        SwingUtilities.invokeLater(() -> {
            new PaginaPrincipalParticipante().setVisible(true);
            dispose();
        });
    }

    private void exibirPaginaCadastro() {
        SwingUtilities.invokeLater(() -> {
            new CadastroParticipante(Municipio.getMunicipios(), Cargo.getCargos()).setVisible(true);
            dispose();
        });
    }
}

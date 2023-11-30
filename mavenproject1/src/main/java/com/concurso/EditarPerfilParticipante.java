package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class EditarPerfilParticipante extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldCPF;
    private JPasswordField fieldSenha;
    private JTextField fieldEndereco;
    private JTextField fieldDataNascimento;
    private JTextField fieldTelefone;

    public EditarPerfilParticipante(Participante participante) {
        initComponents(participante);
    }

    private void initComponents(Participante participante) {
        setTitle("Editar Perfil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2, 5, 5)); // Removendo espaçamento abaixo dos componentes

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelCPF = new JLabel("CPF:");
        JLabel labelSenha = new JLabel("Senha:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        JLabel labelTelefone = new JLabel("Telefone:");

        fieldNome = new JTextField(participante.getNome());
        fieldCPF = new JTextField(participante.getCPF());
        fieldSenha = new JPasswordField(participante.getSenha());
        fieldEndereco = new JTextField(participante.getEndereco());
        fieldDataNascimento = new JTextField(participante.getDataDeNascimento());
        fieldTelefone = new JTextField(participante.getTelefone());

        JButton buttonConfirmar = new JButton("Confirmar");
        JButton buttonVoltar = new JButton("Voltar");

        setButtonStyle(buttonConfirmar);
        setButtonStyle(buttonVoltar);

        buttonConfirmar.addActionListener(e -> confirmarAlteracoes(participante));
        buttonVoltar.addActionListener(e -> voltarParaPerfil(participante));

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
        panel.add(buttonVoltar);
        panel.add(buttonConfirmar);

        getContentPane().add(panel);
        setSize(500, 400); // Ajustando a altura da janela
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void setButtonStyle(JButton button) {
        button.setPreferredSize(new Dimension(120, 30)); // Ajustando a largura e mantendo a altura dos botões
        button.setFont(new Font("Arial", Font.PLAIN, 14));
    }

    private void confirmarAlteracoes(Participante participante) {
        // Obter os dados inseridos nos campos
        String nome = fieldNome.getText();
        String CPF = fieldCPF.getText();
        String senha = new String(fieldSenha.getPassword());
        String endereco = fieldEndereco.getText();
        String dataNascimento = fieldDataNascimento.getText();
        String telefone = fieldTelefone.getText();

        // Atualizar o perfil do participante
        participante.setNome(nome);
        participante.setCPF(CPF);
        participante.setSenha(senha);
        participante.setEndereco(endereco);
        participante.setDataDeNascimento(dataNascimento);
        participante.setTelefone(telefone);
        exibirPerfilAtualizado(participante);
    }

    private void exibirPerfilAtualizado(Participante participante) {
        SwingUtilities.invokeLater(() -> {
            new PerfilParticipante(participante).setVisible(true);
            EditarPerfilParticipante.this.dispose();
        });
    }

    private void voltarParaPerfil(Participante participante) {
        SwingUtilities.invokeLater(() -> {
            new PerfilParticipante(participante).setVisible(true);
            EditarPerfilParticipante.this.dispose();
        });
    }
}

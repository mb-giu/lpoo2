package com.concurso;

import javax.swing.*;
import java.awt.*;

public class InicialParticipante extends JFrame {
    private JLabel labelNome;
    private JLabel labelCPF;
    private JLabel labelEndereco;
    private JLabel labelDataNascimento;
    private JLabel labelTelefone;
    private JLabel labelMunicipio;
    private JLabel labelCargo;

    public InicialParticipante(Participante participante) {
        initComponents(participante);
    }

    private void initComponents(Participante participante) {
        setTitle("Perfil do Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelNome = new JLabel("Nome: " + participante.getNome());
        labelCPF = new JLabel("CPF: " + participante.getCPF());
        labelEndereco = new JLabel("Endereço: " + participante.getEndereco());
        labelDataNascimento = new JLabel("Data de Nascimento: " + participante.getDataDeNascimento());
        labelTelefone = new JLabel("Telefone: " + participante.getTelefone());
        labelMunicipio = new JLabel("Município: " + participante.getMunicipio());
        labelCargo = new JLabel("Cargo: " + participante.getCargo());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 1));
        panel.add(labelNome);
        panel.add(labelCPF);
        panel.add(labelEndereco);
        panel.add(labelDataNascimento);
        panel.add(labelTelefone);
        panel.add(labelMunicipio);
        panel.add(labelCargo);

        getContentPane().add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

}

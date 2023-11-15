package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CadastroParticipante extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldCPF;
    private JPasswordField fieldSenha;
    private JTextField fieldEndereco;
    private JTextField fieldDataNascimento;
    private JTextField fieldTelefone;
    private JComboBox<String> comboBoxMunicipio;
    private JComboBox<String> comboBoxCargo;
    private JButton buttonCadastrar;

    public CadastroParticipante(List<String> listaMunicipios, List<String> listaCargos) {
        initComponents(listaMunicipios, listaCargos);
    }

    private void initComponents(List<String> municipios, List<String> cargos) {
        setTitle("Cadastro de Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelCPF = new JLabel("CPF:");
        JLabel labelSenha = new JLabel("Senha:");
        JLabel labelEndereco = new JLabel("Endereço:");
        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        JLabel labelTelefone = new JLabel("Telefone:");
        JLabel labelMunicipio = new JLabel("Município:");
        JLabel labelCargo = new JLabel("Cargo:");

        fieldNome = new JTextField(10);
        fieldCPF = new JTextField(10);
        fieldSenha = new JPasswordField(10);
        fieldEndereco = new JTextField(10);
        fieldDataNascimento = new JTextField(10);
        fieldTelefone = new JTextField(10);

        comboBoxMunicipio = new JComboBox<>(municipios.toArray(new String[0]));
        comboBoxCargo = new JComboBox<>(cargos.toArray(new String[0]));
        JScrollPane scrollPaneMunicipio = new JScrollPane(comboBoxMunicipio);
        JScrollPane scrollPaneCargo = new JScrollPane(comboBoxCargo);


        buttonCadastrar = new JButton("Cadastrar");

        buttonCadastrar.addActionListener(e -> {
            Participante participante = cadastrarParticipante();
            exibirInicialParticipante(participante);
        });

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
        panel.add(labelMunicipio);
        panel.add(comboBoxMunicipio);
        panel.add(labelCargo);
        panel.add(comboBoxCargo);
        panel.add(new JLabel()); // Espaçamento
        panel.add(buttonCadastrar);

        getContentPane().add(panel);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private void exibirInicialParticipante(Participante participante) {
        InicialParticipante inicialParticipante = new InicialParticipante(participante);
        inicialParticipante.setVisible(true);
        CadastroParticipante.this.dispose();
    }

    private Participante cadastrarParticipante() {
        String nome = fieldNome.getText();
        String CPF = fieldCPF.getText();
        String senha = new String(fieldSenha.getPassword());
        String endereco = fieldEndereco.getText();
        String dataNascimento = fieldDataNascimento.getText();
        String telefone = fieldTelefone.getText();
        String cargoSelecionado = (String) comboBoxCargo.getSelectedItem();
        String municipioSelecionado = (String) comboBoxMunicipio.getSelectedItem();

        // Agora, chame o método da classe GerenciadorCadastro
        return GerenciarCadastro.cadastrarParticipante(2, CPF, senha, nome, endereco, dataNascimento, telefone, cargoSelecionado, municipioSelecionado);
    }
}

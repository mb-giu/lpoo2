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
    private JComboBox<Municipio> comboBoxMunicipio;
    private JComboBox<Cargo> comboBoxCargo;
    private JButton buttonCadastrar;
    private JButton buttonLogin;

    public CadastroParticipante(List<String> listaMunicipios, List<String> listaCargos) {
        initComponents(listaMunicipios, listaCargos);
    }

    private void initComponents(List<String> municipios, List<String> cargos) {
        setTitle("Cadastro de Participante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(12, 2));

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

        comboBoxMunicipio = new JComboBox<>(municipios.stream().map(nome -> new Municipio(nome, "Estado Padrão")).toArray(Municipio[]::new));
        comboBoxCargo = new JComboBox<>(cargos.stream().map(nome -> new Cargo(nome, 0.0, 0)).toArray(Cargo[]::new));

        buttonCadastrar = new JButton("Cadastrar");
        buttonLogin = new JButton("Ir para Login");

        buttonCadastrar.addActionListener(e -> {
            Participante participante = cadastrarParticipante();
            exibirPaginaLogin();
        });
        
        buttonLogin.addActionListener(e -> {
            exibirPaginaLogin();
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
        panel.add(new JLabel()); // Espaçamento
        panel.add(buttonLogin);
        panel.add(buttonCadastrar);
        

        getContentPane().add(panel);
        setSize(500, 400);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    private void exibirPaginaLogin() {
        PaginaLogin paginaLogin = new PaginaLogin();
        paginaLogin.setVisible(true);
        CadastroParticipante.this.dispose();
       }

    private Participante cadastrarParticipante() {
        String nome = fieldNome.getText();
        String CPF = fieldCPF.getText();
        String senha = new String(fieldSenha.getPassword());
        String endereco = fieldEndereco.getText();
        String dataNascimento = fieldDataNascimento.getText();
        String telefone = fieldTelefone.getText();

        // Obtenha o objeto Municipio selecionado
        Municipio municipioSelecionado = (Municipio) comboBoxMunicipio.getSelectedItem();

        // Obtenha o objeto Cargo selecionado
        Cargo cargoSelecionado = (Cargo) comboBoxCargo.getSelectedItem();

        System.out.println("Cadastrando participante: " + nome);
        System.out.println("Município selecionado: " + municipioSelecionado);
        System.out.println("Cargo selecionado: " + cargoSelecionado);

        // Retorne o participante criado
        return GerenciarCadastro.cadastrarParticipante(CPF, senha, nome, endereco, dataNascimento, telefone, cargoSelecionado, municipioSelecionado);
    }


}

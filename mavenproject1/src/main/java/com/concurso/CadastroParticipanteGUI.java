package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CadastroParticipanteGUI extends JFrame {
    private JTextField fieldNome;
    private JTextField fieldCPF;
    private JPasswordField fieldSenha;
    private JTextField fieldEndereco;
    private JTextField fieldDataNascimento;
    private JTextField fieldTelefone;
    private JComboBox<String> comboBoxMunicipio;
    private JComboBox<String> comboBoxCargo;
    private JButton buttonCadastrar;

    public CadastroParticipanteGUI(List<String> listaMunicipios, List<String> listaCargos) {
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

        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarParticipante();
            }
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
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void cadastrarParticipante() {
        // Obter dados do formulário
        String nome = fieldNome.getText();
        String CPF = fieldCPF.getText();
        String senha = new String(fieldSenha.getPassword());
        String endereco = fieldEndereco.getText();
        String dataNascimento = fieldDataNascimento.getText();
        String telefone = fieldTelefone.getText();
        String municipioSelecionado = (String) comboBoxMunicipio.getSelectedItem();
        String cargoSelecionado = (String) comboBoxCargo.getSelectedItem();

        // Realizar a lógica de cadastro do participante
        // Exemplo: imprimir os dados cadastrados
        /*System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Senha: " + senha);
        System.out.println("Endereço: " + endereco);
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Telefone: " + telefone);
        System.out.println("Município: " + municipioSelecionado);
        System.out.println("Cargo: " + cargoSelecionado);
        */
        // Lógica adicional para salvar os dados no sistema
    }

}

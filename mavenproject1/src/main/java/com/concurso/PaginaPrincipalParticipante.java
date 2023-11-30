package com.concurso;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaginaPrincipalParticipante extends JFrame {
    public PaginaPrincipalParticipante() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Página Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton buttonPerfil = new JButton("Perfil");
        JButton buttonParticipantes = new JButton("Participantes por Vaga");
        JButton buttonSair = new JButton("Sair");

        buttonPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPaginaPerfil();
            }
        });

        buttonParticipantes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exibirPaginaParticipantesPorVaga();
            }
        });
        
        buttonSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encerrarSessao();
                exibirPaginaLogin();
            }
        });

        // Adicione mais lógica para o botão "Participantes por Vaga" se necessário

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(buttonPerfil);
        panel.add(buttonParticipantes);
        panel.add(buttonSair);

        getContentPane().add(panel);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    private void exibirPaginaPerfil() {
        Participante participante = SessaoUsuario.getParticipanteLogado();
        if (participante != null) {
            PerfilParticipante perfilParticipante = new PerfilParticipante(participante);
            perfilParticipante.setVisible(true);
            PaginaPrincipalParticipante.this.dispose();
        } else {
            // Trate o caso em que o participante não está logado
            JOptionPane.showMessageDialog(null, "Usuário não logado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exibirPaginaParticipantesPorVaga(){
        java.util.List<String> listaMunicipios = Municipio.getMunicipios();
        java.util.List<String> listaCargos = Cargo.getCargos();
        
        PaginaParticipantesPorVaga pagina = new PaginaParticipantesPorVaga(listaMunicipios, listaCargos);
        pagina.setVisible(true);
        PaginaPrincipalParticipante.this.dispose();
    }
    
    private void exibirPaginaLogin() {
        PaginaLogin paginaLogin = new PaginaLogin();
        paginaLogin.setVisible(true);
        PaginaPrincipalParticipante.this.dispose();
    }

    private void encerrarSessao() {
        SessaoUsuario.encerrarSessao();
    }
}

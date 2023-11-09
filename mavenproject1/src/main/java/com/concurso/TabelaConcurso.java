package com.concurso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TabelaConcurso extends JFrame {
    private JTable tabela;

    public TabelaConcurso(List<InscricaoVaga> inscricoes) {
        initComponents(inscricoes);
    }

    private void initComponents(List<InscricaoVaga> inscricoes) {
        setTitle("Tabela de Concurso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Município");
        model.addColumn("Cargo");
        model.addColumn("Quantidade de Vagas");
        model.addColumn("Quantidade de Inscritos");

        for (InscricaoVaga inscricao : inscricoes) {
            Object[] row = {
                inscricao.getCargo().getMunicipio().getNome(),
                inscricao.getCargo().getNome(),
                inscricao.getCargo().getVaga().getNumeroDeVagas(),
                inscricao.getNumeroDeInscritos()
            };
            model.addRow(row);
        }

        tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);

        getContentPane().add(scrollPane);

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

}

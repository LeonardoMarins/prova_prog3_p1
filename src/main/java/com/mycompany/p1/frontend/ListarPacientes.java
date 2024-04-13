/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.p1.frontend;

import com.mycompany.p1.backend.MenuBack;
import com.mycompany.p1.backend.Paciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marin
 */
public class ListarPacientes extends javax.swing.JFrame {

    /**
     * Creates new form ListarPacientes
     */
    private ArrayList<Paciente> listaPacientes;
    private MenuBack menuB;
    
    public ListarPacientes(MenuBack menu, ArrayList<Paciente> lista) {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.listaPacientes = lista;
        this.menuB = menu;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int linha = 0; // Inicializa a linha
     
        for (Paciente paciente : listaPacientes) {
        model.addRow(new Object[]{ // Adiciona uma nova linha na tabela
            paciente.getIdPaciente(),
            paciente.getNomePessoal(),
            paciente.getContato().getTelefone(),
            paciente.getContatoResponsavel().getNomeResponsavel(),
            paciente.getDataCadastro(),
            paciente.getDataNascimento(),
            paciente.getEndereco().getRua(),
            paciente.getGenero().M,
            paciente.getIdade(),
            paciente.getObsGeral(),
            "Edit", 
            "Delete" 
            
        });
        linha++; // Incrementa a linha

    }
        jTable1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int column = jTable1.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / jTable1.getRowHeight();
        if (row < jTable1.getRowCount() && row >= 0 && column < jTable1.getColumnCount() && column >= 0) {
            Object idValue = jTable1.getValueAt(row, 0);
            int id = Integer.parseInt(String.valueOf(idValue));
            System.out.println("ID do paciente na linha " + row + ": " + id);

            Object value = jTable1.getValueAt(row, column);
            if (value instanceof String && ((String) value).equals("Edit")) {
                new EditPaciente(menuB, id).setVisible(true);
                setVisible(false);
            } else if (value instanceof String && ((String) value).equals("Delete")) {
                menuB.excluirConsulta(row);
                setVisible(false);
            }
        }
    }
});
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String campo = campoPesquisar.getText();
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                for(int i = 0; i < menuB.listaDePaciente.size(); i++) {
                    if(menuB.listaDePaciente.get(i).getNomePessoal().toLowerCase().contains(campo)) {
                       model.addRow(new Object[]{ // Adiciona uma nova linha na tabela
                        menuB.listaDePaciente.get(i).getIdPaciente(),
                        menuB.listaDePaciente.get(i).getNomePessoal(),
                        menuB.listaDePaciente.get(i).getContato().getTelefone(),
                        menuB.listaDePaciente.get(i).getContatoResponsavel().getNomeResponsavel(),
                        menuB.listaDePaciente.get(i).getDataCadastro(),
                        menuB.listaDePaciente.get(i).getDataNascimento(),
                        menuB.listaDePaciente.get(i).getEndereco().getRua(),
                        menuB.listaDePaciente.get(i).getGenero().M,
                        menuB.listaDePaciente.get(i).getIdade(),
                        menuB.listaDePaciente.get(i).getObsGeral(),
                       "Edit", 
                       "Delete"
                    });  
                    }else if(campo.isEmpty()) {
                        model.addRow(new Object[]{ 
                        menuB.listaDePaciente.get(i).getNomePessoal(),
                        menuB.listaDePaciente.get(i).getContato().getTelefone(),
                        menuB.listaDePaciente.get(i).getContatoResponsavel().getNomeResponsavel(),
                        menuB.listaDePaciente.get(i).getDataCadastro(),
                        menuB.listaDePaciente.get(i).getDataNascimento(),
                        menuB.listaDePaciente.get(i).getEndereco().getRua(),
                        menuB.listaDePaciente.get(i).getGenero().M,
                        menuB.listaDePaciente.get(i).getIdade(),
                        menuB.listaDePaciente.get(i).getObsGeral(),
                        "Edit", 
                        "Delete" 
                        });  
                    }
                }
            }
            
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        campoPesquisar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CONTATO", "CONTATO RESPONSAVEL", "DATA CADASTRO", "DATA NASCIMENTO", "ENDEREÇO", "GENERO", "IDADE", "OBS GERAL", "EDIT", "DELETE"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("PESQUISAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(campoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarPacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        ArrayList<Paciente> lista = new ArrayList();
        MenuBack menu = new MenuBack();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarPacientes(menu, lista).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPesquisar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

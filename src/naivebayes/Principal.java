/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naivebayes;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Joao Marcos
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Princiapal
     */
    NaiveBayes nb = new NaiveBayes();
    ArrayList<String> attSelecionados = new ArrayList<>();
    HashMap<String, Double> probabilidades = new HashMap<>();
    
    public Principal() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtArquivo = new javax.swing.JTextField();
        painelAtributos = new javax.swing.JPanel();
        btnTeste = new javax.swing.JButton();
        painelClasses = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Classificador NaiveBayes");

        jButton1.setText("Selecionar Arquivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtArquivo.setEditable(false);

        painelAtributos.setBorder(javax.swing.BorderFactory.createTitledBorder("Atributos"));

        javax.swing.GroupLayout painelAtributosLayout = new javax.swing.GroupLayout(painelAtributos);
        painelAtributos.setLayout(painelAtributosLayout);
        painelAtributosLayout.setHorizontalGroup(
            painelAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        painelAtributosLayout.setVerticalGroup(
            painelAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        btnTeste.setText("Testar");
        btnTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTesteActionPerformed(evt);
            }
        });

        painelClasses.setBorder(javax.swing.BorderFactory.createTitledBorder("Classes"));

        javax.swing.GroupLayout painelClassesLayout = new javax.swing.GroupLayout(painelClasses);
        painelClasses.setLayout(painelClassesLayout);
        painelClassesLayout.setHorizontalGroup(
            painelClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        painelClassesLayout.setVerticalGroup(
            painelClassesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArquivo)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(painelAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(painelClasses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTeste)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(txtArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painelClasses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(btnTeste)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = 0;
        int j;
        int auxiliar = 0;
        int auxRB = 0;
        int x = 10;
        int y = 25;
        String temp = "";
        ArrayList<String> aux = new ArrayList<>();
        nb = new NaiveBayes();
        painelClasses.removeAll();
        painelAtributos.removeAll();
        //Pesquisa o Arquivo CSV
        JFileChooser arquivo = new JFileChooser();
        FileNameExtensionFilter filtroPDF = new FileNameExtensionFilter("Arquivos CSV", "csv");
        arquivo.addChoosableFileFilter(filtroPDF);
        arquivo.setAcceptAllFileFilterUsed(false);
        if (arquivo.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            txtArquivo.setText(arquivo.getSelectedFile().getAbsolutePath());
            String[][] dataset = nb.preencherMatriz(txtArquivo.getText());
            probabilidades = nb.treinamento(dataset);
            for (i = 0; i < nb.getnColunas(); i++) {
                JLabel lbl = new JLabel(dataset[0][i]);
                lbl.setBounds(10, i * 70, 100, 50);
                painelAtributos.add(lbl);
                this.repaint();
            }
             while (auxiliar < nb.getnColunas()-1) {
                    aux.clear();
                    for (j = 1; j < nb.getnLinhas()-1; j++) {
                        temp = dataset[j][auxiliar];
                        if (aux.isEmpty()) {
                            aux.add(temp);
                        }
                        for (i = 0; i < aux.size(); i++) {
                            if (aux.contains(temp)) {
                                continue;
                            } else {
                                aux.add(temp);
                            }
                        }
                    }
                    JComboBox cb = new JComboBox();
                    cb.setBounds(x, y, 170, 30);
                    cb.addItem("Selecione uma classe");
                    cb.setSelectedItem(cb.getItemAt(0));
                    cb.addItemListener(new ItemListener(){
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                if(ie.getStateChange() == ItemEvent.SELECTED){
                                    Object item = ie.getItem();
                                    attSelecionados.add((String)item);
                                }
                            }
                        });
                    for (String att : aux) {
                        cb.addItem(att);   
                    }
                    painelClasses.add(cb);
                    auxiliar++;
                    y += 75;
                    this.repaint();
                    
                }
             
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTesteActionPerformed
        int i = 0;
        double probP = 1;
        double probN = 1;
        for(i = 0; i<attSelecionados.size()-1;i++){
            probP *= probabilidades.get(attSelecionados.get(i)+" "+nb.getClassePositiva());
        }
        for(i = 0; i<attSelecionados.size()-1;i++){
            probN *= probabilidades.get(attSelecionados.get(i)+" "+nb.getClasseNegativa());
        }
        probP *= nb.getProbabPositiva();
        probN *= nb.getProbabNegativa();
        JOptionPane.showMessageDialog(this,"Probabilidade Positiva de evento: " +new DecimalFormat("#0.####").format(probP)+"\n"+
                                        "Probabilidade Negativa de evento: " +new DecimalFormat("#0.####").format(probN));
        attSelecionados.clear();
    }//GEN-LAST:event_btnTesteActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTeste;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelAtributos;
    private javax.swing.JPanel painelClasses;
    private javax.swing.JTextField txtArquivo;
    // End of variables declaration//GEN-END:variables
}

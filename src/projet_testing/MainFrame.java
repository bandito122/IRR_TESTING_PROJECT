/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_testing;

import Dialog.AddProjectDial;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import projet.projet;

/**
 *
 * @author vincent
 */
public class MainFrame extends javax.swing.JFrame {
    
    DefaultListModel listModel;
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        listModel = new DefaultListModel<projet>();
        ProjectList.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        AddProjectButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        DeleteProjectButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ModifyProjectButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CalculateNPVButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        CalculateIRRButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        SelectProjectButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProjectList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setLayout(new java.awt.GridLayout(11, 1));

        AddProjectButton.setText("Ajouter un projet");
        AddProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddProjectButtonActionPerformed(evt);
            }
        });
        jPanel2.add(AddProjectButton);
        jPanel2.add(jLabel1);

        DeleteProjectButton.setText("Supprimer un projet");
        DeleteProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteProjectButtonActionPerformed(evt);
            }
        });
        jPanel2.add(DeleteProjectButton);
        jPanel2.add(jLabel2);

        ModifyProjectButton.setText("Modifier un projet");
        ModifyProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyProjectButtonActionPerformed(evt);
            }
        });
        jPanel2.add(ModifyProjectButton);
        jPanel2.add(jLabel3);

        CalculateNPVButton.setText("Calcul NPV");
        CalculateNPVButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateNPVButtonActionPerformed(evt);
            }
        });
        jPanel2.add(CalculateNPVButton);
        jPanel2.add(jLabel4);

        CalculateIRRButton.setText("Calcul IRR");
        CalculateIRRButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateIRRButtonActionPerformed(evt);
            }
        });
        jPanel2.add(CalculateIRRButton);
        jPanel2.add(jLabel5);

        SelectProjectButton.setText("Sélection de projet");
        jPanel2.add(SelectProjectButton);

        getContentPane().add(jPanel2);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setViewportView(ProjectList);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddProjectButtonActionPerformed
        AddProjectDial apd = new AddProjectDial(this,true);
        apd.setVisible(true);
    }//GEN-LAST:event_AddProjectButtonActionPerformed

    private void DeleteProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteProjectButtonActionPerformed
        int index = ProjectList.getSelectedIndex();
        if(index != -1)
        {
            listModel.remove(index);
        }
        else
            JOptionPane.showMessageDialog(this, "Vous devez d'abord sélectionner un projet", "Erreur de suppresion de projet", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_DeleteProjectButtonActionPerformed

    private void ModifyProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyProjectButtonActionPerformed
        int index = ProjectList.getSelectedIndex();
        if(index != -1)
        {
            projet project = (projet)listModel.get(index);
            AddProjectDial apd = new AddProjectDial(this,true,project);
            apd.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this, "Vous devez d'abord sélectionner un projet", "Erreur de modification de projet", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_ModifyProjectButtonActionPerformed

    private void CalculateNPVButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateNPVButtonActionPerformed
        int index = ProjectList.getSelectedIndex();
        if(index != -1)
        {
            projet project = (projet)listModel.get(index);
            project.CalculateNPV();
            JOptionPane.showMessageDialog(this, "Le NPV du projet est : "+project.getNPV(), "Affichage du NPV", JOptionPane.INFORMATION_MESSAGE, null);
        }
        else
            JOptionPane.showMessageDialog(this, "Vous devez d'abord sélectionner un projet", "Erreur de calcul du NPV", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_CalculateNPVButtonActionPerformed

    private void CalculateIRRButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculateIRRButtonActionPerformed
        int index = ProjectList.getSelectedIndex();
        if(index != -1)
        {
            try
            {
                double taux = Double.parseDouble(JOptionPane.showInputDialog(this, "Veuillez entrer le taux d'actualisation estimé (entre 0 et 1)", 0.1));
                
                 projet project = (projet)listModel.get(index);
                 project.CalculateIRR(taux);
                 JOptionPane.showMessageDialog(this, "l'IRR du projet est  : "+project.getIRR(), "Affichage de l'IRR", JOptionPane.INFORMATION_MESSAGE);
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(this, "Erreur de saisie du taux d'actualisation", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vous devez d'abord sélectionner un projet", "Erreur de calcul du IRR", JOptionPane.ERROR_MESSAGE, null);
    }//GEN-LAST:event_CalculateIRRButtonActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void addProject(projet pr)
    {
        listModel.addElement(pr);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddProjectButton;
    private javax.swing.JButton CalculateIRRButton;
    private javax.swing.JButton CalculateNPVButton;
    private javax.swing.JButton DeleteProjectButton;
    private javax.swing.JButton ModifyProjectButton;
    private javax.swing.JList<String> ProjectList;
    private javax.swing.JButton SelectProjectButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

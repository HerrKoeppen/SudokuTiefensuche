/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JDialog;


/**
 *
 * @author zochrab.blume
 */
public class SudokuImportment4x4 extends javax.swing.JPanel {

    /**
     * Creates new form SudokuImportment_4x4
     */
    public SudokuImportment4x4() {
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

        ZurückImp = new javax.swing.JButton();
        ImportImp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        L1x1 = new javax.swing.JTextPane();
        L1x2 = new javax.swing.JTextPane();
        L1x3 = new javax.swing.JTextPane();
        L1x4 = new javax.swing.JTextPane();
        L2x1 = new javax.swing.JTextPane();
        L2x2 = new javax.swing.JTextPane();
        L2x3 = new javax.swing.JTextPane();
        L2x4 = new javax.swing.JTextPane();
        L3x2 = new javax.swing.JTextPane();
        L3x4 = new javax.swing.JTextPane();
        L3x3 = new javax.swing.JTextPane();
        L3x1 = new javax.swing.JTextPane();
        L4x4 = new javax.swing.JTextPane();
        L4x2 = new javax.swing.JTextPane();
        L4x1 = new javax.swing.JTextPane();
        L4x3 = new javax.swing.JTextPane();
        LösenImp = new javax.swing.JButton();

        ZurückImp.setText("Zurück");
        ZurückImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZurückImpActionPerformed(evt);
            }
        });

        ImportImp.setText("Import");

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 20)); // NOI18N
        jLabel1.setText("4x4");

        L1x1.setMinimumSize(new java.awt.Dimension(24, 24));

        L1x2.setMinimumSize(new java.awt.Dimension(24, 24));

        L1x3.setMinimumSize(new java.awt.Dimension(24, 24));

        L1x4.setMinimumSize(new java.awt.Dimension(24, 24));

        L2x1.setMinimumSize(new java.awt.Dimension(24, 24));

        L2x2.setMinimumSize(new java.awt.Dimension(24, 24));

        L2x3.setMinimumSize(new java.awt.Dimension(24, 24));

        L2x4.setMinimumSize(new java.awt.Dimension(24, 24));

        L3x2.setMinimumSize(new java.awt.Dimension(24, 24));

        L3x4.setMinimumSize(new java.awt.Dimension(24, 24));

        L3x3.setMinimumSize(new java.awt.Dimension(24, 24));

        L3x1.setMinimumSize(new java.awt.Dimension(24, 24));

        L4x4.setMinimumSize(new java.awt.Dimension(24, 24));

        L4x2.setMinimumSize(new java.awt.Dimension(24, 24));

        L4x1.setMinimumSize(new java.awt.Dimension(24, 24));

        L4x3.setMinimumSize(new java.awt.Dimension(24, 24));

        LösenImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Lösen Knopf text klein.png"))); // NOI18N
        LösenImp.setBorder(null);
        LösenImp.setBorderPainted(false);
        LösenImp.setContentAreaFilled(false);
        LösenImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LösenImpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ZurückImp)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(ImportImp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L1x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L1x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(L1x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L1x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L2x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L2x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(L2x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L2x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L3x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L3x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(L3x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L3x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L4x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(L4x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(L4x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(L4x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LösenImp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImportImp)
                    .addComponent(jLabel1)
                    .addComponent(ZurückImp))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L1x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L1x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L2x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L2x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L3x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L3x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L4x1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4x2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4x3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L4x4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(LösenImp, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ZurückImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZurückImpActionPerformed
        control.main.window.remove(this);
        control.main.window.setSize(450,300);
        control.main.szeCh = new view.SizeChoosement();
        control.main.window.add(control.main.szeCh);        
        control.main.window.setVisible(true);
    }//GEN-LAST:event_ZurückImpActionPerformed

    private void LösenImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LösenImpActionPerformed
        control.main.window.remove(this);
        control.main.sdkExp4 = new view.SudokuExportment4x4();
        control.main.window.add(control.main.sdkExp4);

        control.main.sudokuInitialisieren((short)4);
        
        control.main.zelleVeraendern((short)0, (short)0, L1x1.getText());
        control.main.zelleVeraendern((short)0, (short)1, L1x2.getText());
        control.main.zelleVeraendern((short)0, (short)2, L1x3.getText());
        control.main.zelleVeraendern((short)0, (short)3, L1x4.getText());
        
        control.main.zelleVeraendern((short)1, (short)0, L2x1.getText());
        control.main.zelleVeraendern((short)1, (short)1, L2x2.getText());
        control.main.zelleVeraendern((short)1, (short)2, L2x3.getText());
        control.main.zelleVeraendern((short)1, (short)3, L2x4.getText());
        
        control.main.zelleVeraendern((short)2, (short)0, L3x1.getText());
        control.main.zelleVeraendern((short)2, (short)1, L3x2.getText());
        control.main.zelleVeraendern((short)2, (short)2, L3x3.getText());
        control.main.zelleVeraendern((short)2, (short)3, L3x4.getText());
        
        control.main.zelleVeraendern((short)3, (short)0, L4x1.getText());
        control.main.zelleVeraendern((short)3, (short)1, L4x2.getText());
        control.main.zelleVeraendern((short)3, (short)2, L4x3.getText());
        control.main.zelleVeraendern((short)3, (short)3, L4x4.getText());
        
        control.main.sudokuErstellen();
        control.main.sudokuLoesen();
    }//GEN-LAST:event_LösenImpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ImportImp;
    private javax.swing.JTextPane L1x1;
    private javax.swing.JTextPane L1x2;
    private javax.swing.JTextPane L1x3;
    private javax.swing.JTextPane L1x4;
    private javax.swing.JTextPane L2x1;
    private javax.swing.JTextPane L2x2;
    private javax.swing.JTextPane L2x3;
    private javax.swing.JTextPane L2x4;
    private javax.swing.JTextPane L3x1;
    private javax.swing.JTextPane L3x2;
    private javax.swing.JTextPane L3x3;
    private javax.swing.JTextPane L3x4;
    private javax.swing.JTextPane L4x1;
    private javax.swing.JTextPane L4x2;
    private javax.swing.JTextPane L4x3;
    private javax.swing.JTextPane L4x4;
    private javax.swing.JButton LösenImp;
    private javax.swing.JButton ZurückImp;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

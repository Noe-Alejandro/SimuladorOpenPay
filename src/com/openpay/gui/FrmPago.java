package com.openpay.gui;

import com.itextpdf.text.DocumentException;
import com.opencsv.exceptions.CsvValidationException;
import com.openpay.api.API;
import com.openpay.model.Recibo;
import com.openpay.validation.TarjetaValidar;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmPago extends javax.swing.JFrame {

    public FrmPago() {
        initComponents();
        AgregarHorarios();
        setLocationRelativeTo(null);
        this.PanelDatosTarjeta.setVisible(false);
        this.setLocationRelativeTo(null);
    }

    Recibo pdf = new Recibo();

    public void AgregarHorarios() {
        FechaTxt.setText(pdf.fecha());
        HusoTxt.setText("México");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        ConceptoPagoTxt = new javax.swing.JTextField();
        TipoBienTxt = new javax.swing.JTextField();
        IDEventoTxt = new javax.swing.JTextField();
        ImporteServTxt = new javax.swing.JTextField();
        FechaTxt = new javax.swing.JTextField();
        HoraTxt = new javax.swing.JTextField();
        HusoTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PagoTarjetaBtn = new javax.swing.JButton();
        PanelDatosTarjeta = new javax.swing.JPanel();
        titularTxt = new javax.swing.JTextField();
        cardNumberTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        anioTxt = new javax.swing.JTextField();
        mesTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CVCTxt = new javax.swing.JTextField();
        telefonoTxt = new javax.swing.JTextField();
        PagarBtn = new javax.swing.JButton();

        jTextField9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número telefónico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jTextField10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número telefónico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel1KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Nova", 0, 24)); // NOI18N
        jLabel1.setText("Pagar ahora");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSeparator1.setOpaque(true);

        ConceptoPagoTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Concepto de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        ConceptoPagoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConceptoPagoTxtActionPerformed(evt);
            }
        });
        ConceptoPagoTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ConceptoPagoTxtKeyTyped(evt);
            }
        });

        TipoBienTxt.setEditable(false);
        TipoBienTxt.setBackground(new java.awt.Color(255, 255, 255));
        TipoBienTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipo de bien", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N

        IDEventoTxt.setBackground(new java.awt.Color(255, 255, 255));
        IDEventoTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ID del evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        IDEventoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDEventoTxtActionPerformed(evt);
            }
        });

        ImporteServTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Importe del servicio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        ImporteServTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImporteServTxtActionPerformed(evt);
            }
        });
        ImporteServTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ImporteServTxtKeyTyped(evt);
            }
        });

        FechaTxt.setEditable(false);
        FechaTxt.setBackground(new java.awt.Color(255, 255, 255));
        FechaTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha de adjudicación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        FechaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FechaTxtActionPerformed(evt);
            }
        });

        HoraTxt.setEditable(false);
        HoraTxt.setBackground(new java.awt.Color(255, 255, 255));
        HoraTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hora de adjudicación", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        HoraTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoraTxtActionPerformed(evt);
            }
        });

        HusoTxt.setEditable(false);
        HusoTxt.setBackground(new java.awt.Color(255, 255, 255));
        HusoTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huso horario deseado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13), new java.awt.Color(0, 51, 102))); // NOI18N
        HusoTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HusoTxtActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Seleccione un método de pago:");

        PagoTarjetaBtn.setBackground(new java.awt.Color(255, 255, 255));
        PagoTarjetaBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/openpay/gui/tarjeta.png"))); // NOI18N
        PagoTarjetaBtn.setAutoscrolls(true);
        PagoTarjetaBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        PagoTarjetaBtn.setContentAreaFilled(false);
        PagoTarjetaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagoTarjetaBtnActionPerformed(evt);
            }
        });

        PanelDatosTarjeta.setBackground(new java.awt.Color(255, 255, 255));

        titularTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre de tarjetahabiente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        cardNumberTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número de tarjeta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        cardNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNumberTxtActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Fecha de expiración (MM/AA)");

        anioTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        mesTxt.setToolTipText("");
        mesTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        jLabel6.setText("/");

        CVCTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CVC", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        telefonoTxt.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número telefónico", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        javax.swing.GroupLayout PanelDatosTarjetaLayout = new javax.swing.GroupLayout(PanelDatosTarjeta);
        PanelDatosTarjeta.setLayout(PanelDatosTarjetaLayout);
        PanelDatosTarjetaLayout.setHorizontalGroup(
            PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                        .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5))
                            .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                                .addComponent(mesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(anioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149)
                        .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CVCTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(titularTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(380, Short.MAX_VALUE)))
        );
        PanelDatosTarjetaLayout.setVerticalGroup(
            PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(cardNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(2, 2, 2)
                        .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mesTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(anioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefonoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                        .addComponent(CVCTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelDatosTarjetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PanelDatosTarjetaLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(titularTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(143, Short.MAX_VALUE)))
        );

        PagarBtn.setBackground(new java.awt.Color(92, 184, 92));
        PagarBtn.setText("Pagar");
        PagarBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        PagarBtn.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        PagarBtn.setDefaultCapable(false);
        PagarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PagarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelDatosTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ConceptoPagoTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                        .addComponent(TipoBienTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(IDEventoTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ImporteServTxt, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(61, 61, 61)
                                        .addComponent(PagoTarjetaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(FechaTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                    .addComponent(HoraTxt)
                                    .addComponent(HusoTxt))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(PagarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HoraTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HusoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(FechaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConceptoPagoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoBienTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(IDEventoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImporteServTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PagoTarjetaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatosTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PagarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyTyped

    }//GEN-LAST:event_jPanel1KeyTyped

    private void cardNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNumberTxtActionPerformed

    private void PagarBtnActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_PagarBtnActionPerformed

        String token = JOptionPane.showInputDialog("TOKEN");
        API api = new API();
        TarjetaValidar validar = new TarjetaValidar(this.cardNumberTxt.getText(),"Santander",this.titularTxt.getText(),
        (this.mesTxt.getText()+"/"+this.anioTxt.getText()),this.CVCTxt.getText(),token);
        
        try {
            api.pagar(this.cardNumberTxt.getText(),validar.validar(), this.IDEventoTxt.getText());
        } catch (IOException ex) {
            Logger.getLogger(FrmPago.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CsvValidationException ex) {
            Logger.getLogger(FrmPago.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_PagarBtnActionPerformed

    private void PagoTarjetaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PagoTarjetaBtnActionPerformed
        // TODO add your handling code here:
        selectedPago();
    }//GEN-LAST:event_PagoTarjetaBtnActionPerformed

    private void HusoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HusoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HusoTxtActionPerformed

    private void HoraTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoraTxtActionPerformed

    }//GEN-LAST:event_HoraTxtActionPerformed

    private void FechaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FechaTxtActionPerformed

    }//GEN-LAST:event_FechaTxtActionPerformed

    private void ImporteServTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ImporteServTxtKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
        }
    }//GEN-LAST:event_ImporteServTxtKeyTyped

    private void ImporteServTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImporteServTxtActionPerformed

    }//GEN-LAST:event_ImporteServTxtActionPerformed

    private void IDEventoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDEventoTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDEventoTxtActionPerformed

    private void ConceptoPagoTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ConceptoPagoTxtKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(rootPane, " Ingresar solo palabras");
        }
    }//GEN-LAST:event_ConceptoPagoTxtKeyTyped

    private void ConceptoPagoTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConceptoPagoTxtActionPerformed

    }//GEN-LAST:event_ConceptoPagoTxtActionPerformed

    private void selectedPago() {
        if (!PagoTarjetaBtn.isSelected()) {
            PanelDatosTarjeta.setVisible(true);
            PagoTarjetaBtn.setSelected(true);
            PagoTarjetaBtn.setBackground(Color.LIGHT_GRAY);

        } else {
            PanelDatosTarjeta.setVisible(false);
            PagoTarjetaBtn.setSelected(false);
            PagoTarjetaBtn.setBackground(Color.WHITE);

        }
    }

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
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPago().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CVCTxt;
    private javax.swing.JTextField ConceptoPagoTxt;
    private javax.swing.JTextField FechaTxt;
    private javax.swing.JTextField HoraTxt;
    private javax.swing.JTextField HusoTxt;
    private javax.swing.JTextField IDEventoTxt;
    private javax.swing.JTextField ImporteServTxt;
    private javax.swing.JButton PagarBtn;
    private javax.swing.JButton PagoTarjetaBtn;
    private javax.swing.JPanel PanelDatosTarjeta;
    private javax.swing.JTextField TipoBienTxt;
    private javax.swing.JTextField anioTxt;
    private javax.swing.JTextField cardNumberTxt;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField mesTxt;
    private javax.swing.JTextField telefonoTxt;
    private javax.swing.JTextField titularTxt;
    // End of variables declaration//GEN-END:variables

}

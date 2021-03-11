/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.GrupoJogador;
import br.com.ufjf.estudante.main.Item;
import br.com.ufjf.estudante.main.ItemArma;
import br.com.ufjf.estudante.main.ItemArmadura;
import br.com.ufjf.estudante.main.Jogador;
import java.util.List;

/**
 *
 * @author Luiz
 */
public class Janela_Mochila extends javax.swing.JFrame {

    
    Janela_Batalha janela;
    public Janela_Mochila(Janela_Batalha janela) {
//        GrupoJogador.iniciaGrupo(jogador);
        this.janela = janela;
        initComponents();
    }
    //FUNCOES PARA ATUALIZACAO DAS COMBOBOX
    //cbox personagem:
    private void limpaComboBox_Personagem(){
        for(int i = cbox_personagemMochila.getItemCount()-1; i >= 0 ; i--){//Removendo lixo inicial da cboxItens
            cbox_personagemMochila.removeItemAt(i);
        }
    }
    
    private void iniciaComboBox_Personagem(){
        limpaComboBox_Personagem();
        for (int i = 0; i < GrupoJogador.getSize(); i++) {
            cbox_personagemMochila.addItem(GrupoJogador.getJogador(i).getNomePersonagem());
        }
        iniciaComboBox_Armas(0);
        iniciaComboBox_Armaduras(0);
    }
    
    //cbox armas:
    private void limpaComboBox_Armas(){
        for(int i = cbox_armasMochila.getItemCount()-1; i >= 0 ; i--){//Removendo lixo inicial da cboxItens
            cbox_armasMochila.removeItemAt(i);
        }
    }
    
    private void iniciaComboBox_Armas(int id){
        limpaComboBox_Armas();
        ItemArma item;
        int tamanho = GrupoJogador.getJogador(id).getMochilaArma();
        for (int i = 0; i < tamanho; i++) {
            item = GrupoJogador.getJogador(id).getMochilaItemArma(i);
            if(item.getModelo()==1){
                cbox_armasMochila.addItem(item.getNome());
            }
        }
        label_mostraDano.setText("" + GrupoJogador.getJogador(id).getMochilaItemArma(0).getDanoArma());
    }
    private void alteraLabelDano(int id){
    if(GrupoJogador.getSize() > cbox_personagemMochila.getSelectedIndex() && id > 0 && id < GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaArma())
            label_mostraDano.setText("" + GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaItemArma(id).getDanoArma());
    }
    //cbox armaduras:
    private void limpaComboBox_Armaduras(){
        for(int i = cbox_armadurasMochila.getItemCount()-1; i >= 0 ; i--){//Removendo lixo inicial da cboxItens
            cbox_armadurasMochila.removeItemAt(i);
        }
    }
    
    private void iniciaComboBox_Armaduras(int id){
        limpaComboBox_Armaduras();
        ItemArmadura item;
        int tamanho = GrupoJogador.getJogador(id).getMochilaArmadura();
        for (int i = 0; i < tamanho; i++) {
            item = GrupoJogador.getJogador(id).getMochilaItemArmadura(i);
            if(item.getModelo()==2){
                cbox_armadurasMochila.addItem(item.getNome());
            }
        }
        label_mostraDefesa.setText("" + GrupoJogador.getJogador(id).getMochilaItemArmadura(0).getBonusDefesa());
    }
    private void alteraLabelDefesa(int id){
        if(GrupoJogador.getSize() > cbox_personagemMochila.getSelectedIndex() && id > 0 && id < GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaArmadura())
            label_mostraDefesa.setText("" + GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaItemArmadura(id).getBonusDefesa());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_arma = new javax.swing.JLabel();
        botao_ok = new javax.swing.JButton();
        label_jogador = new javax.swing.JLabel();
        cbox_armasMochila = new javax.swing.JComboBox<>();
        cbox_armadurasMochila = new javax.swing.JComboBox<>();
        botao_equiparArma = new javax.swing.JButton();
        botao_excluirArma = new javax.swing.JToggleButton();
        botao_equiparArmadura = new javax.swing.JToggleButton();
        botao_excluirArmadura = new javax.swing.JButton();
        label_danoAtual = new javax.swing.JLabel();
        label_defesaAtual = new javax.swing.JLabel();
        label_mostraDano = new javax.swing.JLabel();
        label_mostraDefesa = new javax.swing.JLabel();
        label_personagem = new javax.swing.JLabel();
        cbox_personagemMochila = new javax.swing.JComboBox<>();
        label_informacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mochila");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        label_arma.setText("Arma do Personagem:");

        botao_ok.setText("OK");
        botao_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_okActionPerformed(evt);
            }
        });

        label_jogador.setText("Armadura do Personagem:");

        cbox_armasMochila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_armasMochilaActionPerformed(evt);
            }
        });

        cbox_armadurasMochila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_armadurasMochilaActionPerformed(evt);
            }
        });

        botao_equiparArma.setText("Equipar");
        botao_equiparArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_equiparArmaActionPerformed(evt);
            }
        });

        botao_excluirArma.setText("Excluir");
        botao_excluirArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirArmaActionPerformed(evt);
            }
        });

        botao_equiparArmadura.setText("Equipar");
        botao_equiparArmadura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_equiparArmaduraActionPerformed(evt);
            }
        });

        botao_excluirArmadura.setText("Excluir");
        botao_excluirArmadura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_excluirArmaduraActionPerformed(evt);
            }
        });

        label_danoAtual.setText("Dano Atual da arma do jogador:");

        label_defesaAtual.setText("Bonus de defesa da armadura:");

        label_mostraDano.setText("000");

        label_mostraDefesa.setText("000");

        label_personagem.setText("Personagem:");

        cbox_personagemMochila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_personagemMochilaActionPerformed(evt);
            }
        });

        label_informacao.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(botao_ok))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_jogador)
                                    .addComponent(label_arma))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_informacao, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(cbox_armadurasMochila, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(16, 16, 16))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(cbox_armasMochila, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botao_equiparArma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botao_equiparArmadura))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(botao_excluirArma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botao_excluirArmadura)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_personagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbox_personagemMochila, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_danoAtual)
                            .addComponent(label_defesaAtual))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_mostraDefesa)
                            .addComponent(label_mostraDano))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbox_personagemMochila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(label_informacao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botao_equiparArma)
                            .addComponent(botao_excluirArma))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botao_equiparArmadura)
                            .addComponent(botao_excluirArmadura)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_armasMochila, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_arma, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_jogador)
                            .addComponent(cbox_armadurasMochila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_danoAtual)
                    .addComponent(label_mostraDano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_defesaAtual)
                    .addComponent(label_mostraDefesa))
                .addGap(50, 50, 50)
                .addComponent(botao_ok)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botao_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_okActionPerformed
        // QUANDO APERRTAR OK
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_botao_okActionPerformed

    private void botao_equiparArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_equiparArmaActionPerformed
        // TODO add your handling code here:
        GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).setArma(GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaItemArma(cbox_armasMochila.getSelectedIndex()));
    }//GEN-LAST:event_botao_equiparArmaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //QUANDO A JANELA ABRIR
        iniciaComboBox_Personagem();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.setVisible(false);
        janela.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void cbox_personagemMochilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_personagemMochilaActionPerformed
        //Adiciona evento quanda a caixa de selecao de personagem for ativada
        
        if(GrupoJogador.getSize()>0){
            iniciaComboBox_Armaduras(cbox_personagemMochila.getSelectedIndex());
            iniciaComboBox_Armas(cbox_personagemMochila.getSelectedIndex());
        }
        
    }//GEN-LAST:event_cbox_personagemMochilaActionPerformed

    private void cbox_armasMochilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_armasMochilaActionPerformed
        // TODO add your handling code here:
        alteraLabelDano(cbox_armasMochila.getSelectedIndex());
    }//GEN-LAST:event_cbox_armasMochilaActionPerformed

    private void cbox_armadurasMochilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_armadurasMochilaActionPerformed
        // TODO add your handling code here:
        alteraLabelDefesa(cbox_armadurasMochila.getSelectedIndex());
    }//GEN-LAST:event_cbox_armadurasMochilaActionPerformed

    private void botao_equiparArmaduraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_equiparArmaduraActionPerformed
        // TODO add your handling code here:
        GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).setArmadura(GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).getMochilaItemArmadura(cbox_armadurasMochila.getSelectedIndex()));
    }//GEN-LAST:event_botao_equiparArmaduraActionPerformed

    private void botao_excluirArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirArmaActionPerformed
        // TODO add your handling code here:
        GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).removeItemArma(cbox_armasMochila.getSelectedIndex());
        iniciaComboBox_Armas(cbox_personagemMochila.getSelectedIndex());
    }//GEN-LAST:event_botao_excluirArmaActionPerformed

    private void botao_excluirArmaduraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_excluirArmaduraActionPerformed
        // TODO add your handling code here:
        GrupoJogador.getJogador(cbox_personagemMochila.getSelectedIndex()).removeItemArmaduras(cbox_armadurasMochila.getSelectedIndex());
        iniciaComboBox_Armaduras(cbox_personagemMochila.getSelectedIndex());
    }//GEN-LAST:event_botao_excluirArmaduraActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Janela_Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Janela_Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Janela_Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Janela_Mochila.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Janela_Mochila().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_equiparArma;
    private javax.swing.JToggleButton botao_equiparArmadura;
    private javax.swing.JToggleButton botao_excluirArma;
    private javax.swing.JButton botao_excluirArmadura;
    private javax.swing.JButton botao_ok;
    private javax.swing.JComboBox<String> cbox_armadurasMochila;
    private javax.swing.JComboBox<String> cbox_armasMochila;
    private javax.swing.JComboBox<String> cbox_personagemMochila;
    private javax.swing.JLabel label_arma;
    private javax.swing.JLabel label_danoAtual;
    private javax.swing.JLabel label_defesaAtual;
    private javax.swing.JLabel label_informacao;
    private javax.swing.JLabel label_jogador;
    private javax.swing.JLabel label_mostraDano;
    private javax.swing.JLabel label_mostraDefesa;
    private javax.swing.JLabel label_personagem;
    // End of variables declaration//GEN-END:variables
}

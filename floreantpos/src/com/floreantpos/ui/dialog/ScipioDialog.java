//-AE-

package com.floreantpos.ui.dialog;

import java.text.ParseException;
import javax.swing.text.MaskFormatter;

import com.floreantpos.PosException;
import com.floreantpos.config.ui.DatabaseConfigurationDialog;
import com.floreantpos.main.Application;
import com.floreantpos.model.ScipioInfo;
import com.floreantpos.model.Ticket;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Aaron Evans <aarone@one-shore.com>
 */
public class ScipioDialog extends POSDialog {

    private Ticket ticket;
    private ScipioInfo scipioInfo;
			
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.floreantpos.swing.PosButton btnCancel;
    private com.floreantpos.swing.PosButton btnOk;
    private com.floreantpos.swing.PosButton button0;
    private com.floreantpos.swing.PosButton button1;
    private com.floreantpos.swing.PosButton button2;
    private com.floreantpos.swing.PosButton button3;
    private com.floreantpos.swing.PosButton button4;
    private com.floreantpos.swing.PosButton button5;
    private com.floreantpos.swing.PosButton button6;
    private com.floreantpos.swing.PosButton button7;
    private com.floreantpos.swing.PosButton button8;
    private com.floreantpos.swing.PosButton button9;
    private com.floreantpos.swing.PosButton buttonClear;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel lblPIN;
    private javax.swing.JLabel lblTEI;
    private com.floreantpos.ui.TitlePanel titlePanel1;
    private javax.swing.JFormattedTextField txtPIN;
    private javax.swing.JFormattedTextField txtTEI;
    // End of variables declaration//GEN-END:variables

	/**
	 * Creates new form ScipioDialog
	 */
	public ScipioDialog() {
		super(Application.getPosWindow(), true, false);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        
		initComponents();
		setResizable(false);
		pack();
	}

	private MaskFormatter createFormatter(int length) {
		String mask = StringUtils.repeat("#", length);
		MaskFormatter formatter = null;
		
		try {
			formatter = new MaskFormatter(mask);
		} catch (ParseException e) {
			e.printStackTrace();
			formatter = new MaskFormatter();
		}
		
		return formatter;
	}
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        titlePanel1 = new com.floreantpos.ui.TitlePanel();
        btnCancel = new com.floreantpos.swing.PosButton();
        btnOk = new com.floreantpos.swing.PosButton();
        lblTEI = new javax.swing.JLabel();
        lblPIN = new javax.swing.JLabel();
        txtTEI = new javax.swing.JFormattedTextField(createFormatter(ScipioInfo.TEI_LENGTH));
        txtPIN = new javax.swing.JFormattedTextField(createFormatter(ScipioInfo.PIN_LENGTH));
        buttonPanel = new javax.swing.JPanel();
        button7 = new com.floreantpos.swing.PosButton();
        button8 = new com.floreantpos.swing.PosButton();
        button9 = new com.floreantpos.swing.PosButton();
        button4 = new com.floreantpos.swing.PosButton();
        button5 = new com.floreantpos.swing.PosButton();
        button6 = new com.floreantpos.swing.PosButton();
        button1 = new com.floreantpos.swing.PosButton();
        button2 = new com.floreantpos.swing.PosButton();
        button3 = new com.floreantpos.swing.PosButton();
        button0 = new com.floreantpos.swing.PosButton();
        buttonClear = new com.floreantpos.swing.PosButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SCIPIO INFORMATION");

        titlePanel1.setTitle("SCIPIO INFORMATION");

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png"))); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanceldoCancel(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finish_32.png"))); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkdoOk(evt);
            }
        });

        lblTEI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTEI.setText("TEI:");
        lblTEI.setMaximumSize(new java.awt.Dimension(32, 16));
        lblTEI.setMinimumSize(new java.awt.Dimension(16, 16));
        lblTEI.setPreferredSize(new java.awt.Dimension(32, 16));

        lblPIN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPIN.setText("PIN:");
        lblPIN.setMaximumSize(new java.awt.Dimension(32, 16));
        lblPIN.setMinimumSize(new java.awt.Dimension(16, 16));
        lblPIN.setPreferredSize(new java.awt.Dimension(32, 16));

        txtTEI.setMaximumSize(new java.awt.Dimension(250, 30));
        txtTEI.setMinimumSize(new java.awt.Dimension(24, 20));

        txtPIN.setMaximumSize(new java.awt.Dimension(250, 30));
        txtPIN.setMinimumSize(new java.awt.Dimension(24, 20));
        txtPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPINActionPerformed(evt);
            }
        });

        buttonPanel.setOpaque(false);
        buttonPanel.setPreferredSize(new java.awt.Dimension(280, 180));
        buttonPanel.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        button7.setAction(goAction);
        button7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7_32.png"))); // NOI18N
        button7.setActionCommand("7");
        button7.setFocusable(false);
        buttonPanel.add(button7);

        button8.setAction(goAction);
        button8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8_32.png"))); // NOI18N
        button8.setActionCommand("8");
        button8.setFocusable(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });
        buttonPanel.add(button8);

        button9.setAction(goAction);
        button9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9_32.png"))); // NOI18N
        button9.setActionCommand("9");
        button9.setFocusable(false);
        buttonPanel.add(button9);

        button4.setAction(goAction);
        button4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4_32.png"))); // NOI18N
        button4.setActionCommand("4");
        button4.setFocusable(false);
        buttonPanel.add(button4);

        button5.setAction(goAction);
        button5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5_32.png"))); // NOI18N
        button5.setActionCommand("5");
        button5.setFocusable(false);
        buttonPanel.add(button5);

        button6.setAction(goAction);
        button6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6_32.png"))); // NOI18N
        button6.setActionCommand("6");
        button6.setFocusable(false);
        buttonPanel.add(button6);

        button1.setAction(goAction);
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1_32.png"))); // NOI18N
        button1.setActionCommand("1");
        button1.setFocusable(false);
        buttonPanel.add(button1);

        button2.setAction(goAction);
        button2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2_32.png"))); // NOI18N
        button2.setActionCommand("2");
        button2.setFocusable(false);
        buttonPanel.add(button2);

        button3.setAction(goAction);
        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3_32.png"))); // NOI18N
        button3.setActionCommand("3");
        button3.setFocusable(false);
        buttonPanel.add(button3);

        button0.setAction(goAction);
        button0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0_32.png"))); // NOI18N
        button0.setActionCommand("0");
        button0.setFocusable(false);
        buttonPanel.add(button0);

        buttonClear.setAction(goAction);
        buttonClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear_32.png"))); // NOI18N
        buttonClear.setText("CLEAR");
        buttonClear.setFocusable(false);
        buttonClear.setPreferredSize(new java.awt.Dimension(90, 50));
        buttonPanel.add(buttonClear);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnOk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTEI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblPIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(112, 112, 112)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTEI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTEI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void initData() throws Exception {
		scipioInfo = ticket.getScipioInfo();
		
		if (scipioInfo != null) { 
			txtPIN.setText(String.valueOf(scipioInfo.getPIN()));
			txtTEI.setText(String.valueOf(scipioInfo.getTEI()));
		}
	}

	// added to workaround Netbeans dialog code generation
	// TODO: edit to just use doOk
	private void btnOkdoOk(java.awt.event.ActionEvent evt) {
		doOk(evt);
	}
	private void doOk(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkdoOk
		try {
			if (scipioInfo == null) {
				scipioInfo = new ScipioInfo();
			}
			
			try {
				scipioInfo.setTEI(txtTEI.getText());
				scipioInfo.setPIN(txtPIN.getText());
				scipioInfo.setTicket(ticket);
			}
			catch (Exception e) {
				throw new PosException("Scipio info is not valid.\n" + e.getMessage());	
			}
				
			setCanceled(false);
			dispose();
		} catch (PosException e) {
			POSMessageDialog.showError(this, e.getMessage());
		}
	}//GEN-LAST:event_btnOkdoOk

	// temporarily added to workaround Netbeans dialog code generation
	// TODO: edit to just use doCancel
	private void btnCanceldoCancel(java.awt.event.ActionEvent evt) {
		doCancel(evt);
	}
	private void doCancel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanceldoCancel
		setCanceled(true);
		dispose();
	}//GEN-LAST:event_btnCanceldoCancel

	private void txtPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPINActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_txtPINActionPerformed

	private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_button8ActionPerformed

	
	
	Action goAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (com.floreantpos.POSConstants.CLEAR.equals(command)) {
				if (txtTEI.hasFocus()) {
					txtTEI.setText("");
				} else if (txtPIN.hasFocus()) {
					txtPIN.setText("");
				}
			} else {
				if (txtTEI.hasFocus()) {
					txtTEI.setText(txtTEI.getText() + command);
				} else if (txtPIN.hasFocus()) {
					txtPIN.setText(txtPIN.getText() + command);
				}
			}
		}
	};

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	public ScipioInfo getScipioInfo() {
		return scipioInfo;
	}
}

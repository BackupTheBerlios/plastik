/*
 * ButtonPanel.java
 *
 * Created on 21. November 2005, 20:01
 */

package de.hampelratte.test;

import javax.swing.JButton;

import de.hampelratte.plastik.PlastikLookAndFeel;

/**
 *
 * @author  TBN
 */
public class ButtonPanel extends javax.swing.JPanel {
	
	/** Creates new form ButtonPanel */
	public ButtonPanel() {
		initComponents();
	}
	
	public JButton getDefaultButton() {
		return defaultButton;
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        normalButton = new javax.swing.JButton();
        normalDisabledButton = new javax.swing.JButton();
        notFilledButton = new javax.swing.JButton();
        notFilledDisabledButton = new javax.swing.JButton();
        noBorderButton = new javax.swing.JButton();
        htmlButton = new javax.swing.JButton();
        coloredButton = new javax.swing.JButton();
        coloredNotFilledButton = new javax.swing.JButton();
        coloredDisabledButton = new javax.swing.JButton();
        marginButton = new javax.swing.JButton();
        defaultButton = new javax.swing.JButton();
        iconOnlyButton = new javax.swing.JButton();
        iconButton = new javax.swing.JButton();
        iconOnlyButton1 = new javax.swing.JButton();
        iconButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        setName("JButton");
        normalButton.setText("normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalButton, gridBagConstraints);

        normalDisabledButton.setText("normal (disabled)");
        normalDisabledButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalDisabledButton, gridBagConstraints);

        notFilledButton.setText("not filled");
        notFilledButton.setContentAreaFilled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(notFilledButton, gridBagConstraints);

        notFilledDisabledButton.setText("not filled (disabled)");
        notFilledDisabledButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(notFilledDisabledButton, gridBagConstraints);

        noBorderButton.setText("no border");
        noBorderButton.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(noBorderButton, gridBagConstraints);

        htmlButton.setText("<html><b>HTML</b><br><i>styled label</i></html>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(htmlButton, gridBagConstraints);

        coloredButton.setBackground(new java.awt.Color(255, 204, 51));
        coloredButton.setForeground(new java.awt.Color(255, 0, 0));
        coloredButton.setText("colored");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(coloredButton, gridBagConstraints);

        coloredNotFilledButton.setBackground(new java.awt.Color(255, 204, 51));
        coloredNotFilledButton.setForeground(new java.awt.Color(255, 0, 0));
        coloredNotFilledButton.setText("colored not filled");
        coloredNotFilledButton.setContentAreaFilled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(coloredNotFilledButton, gridBagConstraints);

        coloredDisabledButton.setBackground(new java.awt.Color(255, 204, 51));
        coloredDisabledButton.setForeground(new java.awt.Color(255, 0, 0));
        coloredDisabledButton.setText("colored (disabled)");
        coloredDisabledButton.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(coloredDisabledButton, gridBagConstraints);

        marginButton.setText("margin");
        marginButton.setMargin(new java.awt.Insets(20, 2, 20, 2));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(marginButton, gridBagConstraints);

        defaultButton.setText("default");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(defaultButton, gridBagConstraints);

        //iconOnlyButton.setIcon(new ImageIcon(new PlastikLookAndFeel().getClass().getResource("themes/iconthemes/CrystalSVG/icons/display.png")));
        iconOnlyButton.setIcon(PlastikLookAndFeel.getTheme().getIconTheme().getComputerIcon());
        iconOnlyButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(iconOnlyButton, gridBagConstraints);

        iconButton.setIcon(PlastikLookAndFeel.getTheme().getIconTheme().getQuestionIcon());
        iconButton.setText("with icon");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(iconButton, gridBagConstraints);

        iconOnlyButton1.setIcon(PlastikLookAndFeel.getTheme().getIconTheme().getQuestionIcon());
        iconOnlyButton1.setEnabled(false);
        iconOnlyButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(iconOnlyButton1, gridBagConstraints);

        iconButton1.setIcon(PlastikLookAndFeel.getTheme().getIconTheme().getComputerIcon());
        iconButton1.setText("with icon");
        iconButton1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(iconButton1, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
	
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton coloredButton;
    private javax.swing.JButton coloredDisabledButton;
    private javax.swing.JButton coloredNotFilledButton;
    private javax.swing.JButton defaultButton;
    private javax.swing.JButton htmlButton;
    private javax.swing.JButton iconButton;
    private javax.swing.JButton iconButton1;
    private javax.swing.JButton iconOnlyButton;
    private javax.swing.JButton iconOnlyButton1;
    private javax.swing.JButton marginButton;
    private javax.swing.JButton noBorderButton;
    private javax.swing.JButton normalButton;
    private javax.swing.JButton normalDisabledButton;
    private javax.swing.JButton notFilledButton;
    private javax.swing.JButton notFilledDisabledButton;
    // End of variables declaration//GEN-END:variables
	
}

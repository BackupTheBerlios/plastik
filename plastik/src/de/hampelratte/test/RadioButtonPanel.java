/*
 * RadioButtonPanel.java
 *
 * Created on 21. November 2005, 21:15
 */

package de.hampelratte.test;

/**
 *
 * @author  TBN
 */
public class RadioButtonPanel extends javax.swing.JPanel {
	
	/** Creates new form RadioButtonPanel */
	public RadioButtonPanel() {
		initComponents();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        normal = new javax.swing.JRadioButton();
        selected = new javax.swing.JRadioButton();
        normalDisabled = new javax.swing.JRadioButton();
        selectedDisabled = new javax.swing.JRadioButton();
        normalColored = new javax.swing.JRadioButton();
        selectedColored = new javax.swing.JRadioButton();
        normalColoredDisabled = new javax.swing.JRadioButton();
        selectedColoredDisabled = new javax.swing.JRadioButton();
        normalNotFilled = new javax.swing.JRadioButton();
        selectedNotFilled = new javax.swing.JRadioButton();
        normalBorderPainted = new javax.swing.JRadioButton();
        selectedBorderPainted = new javax.swing.JRadioButton();
        normalBorderPaintedDisabled = new javax.swing.JRadioButton();
        selectedBorderPaintedDisabled = new javax.swing.JRadioButton();

        setLayout(new java.awt.GridBagLayout());

        setName("JRadioButton");
        this.setSize(new java.awt.Dimension(487,265));
        normal.setText("normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normal, gridBagConstraints);

        selected.setSelected(true);
        selected.setText("selected");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selected, gridBagConstraints);

        normalDisabled.setText("disabled");
        normalDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalDisabled, gridBagConstraints);

        selectedDisabled.setSelected(true);
        selectedDisabled.setText("selected & disabled");
        selectedDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedDisabled, gridBagConstraints);

        normalColored.setBackground(new java.awt.Color(255, 204, 0));
        normalColored.setForeground(new java.awt.Color(255, 0, 0));
        normalColored.setText("colored");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalColored, gridBagConstraints);

        selectedColored.setBackground(new java.awt.Color(255, 204, 0));
        selectedColored.setForeground(new java.awt.Color(255, 0, 0));
        selectedColored.setSelected(true);
        selectedColored.setText("selected & colored");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedColored, gridBagConstraints);

        normalColoredDisabled.setBackground(new java.awt.Color(255, 204, 0));
        normalColoredDisabled.setForeground(new java.awt.Color(255, 0, 0));
        normalColoredDisabled.setText("colored & disabled");
        normalColoredDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalColoredDisabled, gridBagConstraints);

        selectedColoredDisabled.setBackground(new java.awt.Color(255, 204, 0));
        selectedColoredDisabled.setForeground(new java.awt.Color(255, 0, 0));
        selectedColoredDisabled.setSelected(true);
        selectedColoredDisabled.setText("selected & colored & disabled");
        selectedColoredDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedColoredDisabled, gridBagConstraints);

        normalNotFilled.setText("not filled");
        normalNotFilled.setContentAreaFilled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalNotFilled, gridBagConstraints);

        selectedNotFilled.setSelected(true);
        selectedNotFilled.setText("selected & not filled");
        selectedNotFilled.setContentAreaFilled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedNotFilled, gridBagConstraints);

        normalBorderPainted.setText("border painted");
        normalBorderPainted.setBorderPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalBorderPainted, gridBagConstraints);

        selectedBorderPainted.setSelected(true);
        selectedBorderPainted.setText("selected & border painted");
        selectedBorderPainted.setBorderPainted(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedBorderPainted, gridBagConstraints);

        normalBorderPaintedDisabled.setText("border painted");
        normalBorderPaintedDisabled.setBorderPainted(true);
        normalBorderPaintedDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(normalBorderPaintedDisabled, gridBagConstraints);

        selectedBorderPaintedDisabled.setSelected(true);
        selectedBorderPaintedDisabled.setText("selected & border painted");
        selectedBorderPaintedDisabled.setBorderPainted(true);
        selectedBorderPaintedDisabled.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        add(selectedBorderPaintedDisabled, gridBagConstraints);

    }
    // </editor-fold>//GEN-END:initComponents
	
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton normal;
    private javax.swing.JRadioButton normalBorderPainted;
    private javax.swing.JRadioButton normalBorderPaintedDisabled;
    private javax.swing.JRadioButton normalColored;
    private javax.swing.JRadioButton normalColoredDisabled;
    private javax.swing.JRadioButton normalDisabled;
    private javax.swing.JRadioButton normalNotFilled;
    private javax.swing.JRadioButton selected;
    private javax.swing.JRadioButton selectedBorderPainted;
    private javax.swing.JRadioButton selectedBorderPaintedDisabled;
    private javax.swing.JRadioButton selectedColored;
    private javax.swing.JRadioButton selectedColoredDisabled;
    private javax.swing.JRadioButton selectedDisabled;
    private javax.swing.JRadioButton selectedNotFilled;
    // End of variables declaration//GEN-END:variables
	
}  //  @jve:decl-index=0:visual-constraint="10,10"

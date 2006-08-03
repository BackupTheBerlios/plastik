package de.hampelratte.test;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTextField;



public class TextFieldPanel extends javax.swing.JPanel {
	
	private JTextField field1;
	private JTextField field2;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JTextField jTextField5 = null;
	private JTextField jTextField6 = null;
	public TextFieldPanel() {
		initComponents();
	}
	
    private void initComponents() {
    	GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
    	gridBagConstraints7.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints7.gridy = 2;
    	gridBagConstraints7.weightx = 1.0;
    	gridBagConstraints7.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints7.gridx = 2;
    	GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
    	gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints6.gridy = 4;
    	gridBagConstraints6.weightx = 1.0;
    	gridBagConstraints6.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints6.gridx = 0;
    	GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
    	gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints5.gridy = 3;
    	gridBagConstraints5.weightx = 1.0;
    	gridBagConstraints5.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints5.gridx = 2;
    	GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
    	gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints4.gridy = 3;
    	gridBagConstraints4.weightx = 1.0;
    	gridBagConstraints4.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints4.gridx = 0;
    	GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
    	gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints3.gridy = 2;
    	gridBagConstraints3.weightx = 1.0;
    	gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints3.gridx = 0;
    	GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
    	gridBagConstraints21.fill = java.awt.GridBagConstraints.HORIZONTAL;
    	gridBagConstraints21.gridy = 1;
    	gridBagConstraints21.weightx = 1.0;
    	gridBagConstraints21.insets = new java.awt.Insets(5,5,5,5);
    	gridBagConstraints21.gridx = 0;
    	setName("JTextField");
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints2.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints2.gridx = 2;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridx = 2;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
        this.setLayout(new GridBagLayout());
        this.setSize(new java.awt.Dimension(449,327));
        field1 = new JTextField();
        field1.setText("normal");
        
        field2 = new JTextField();
        field2.setEnabled(false);
        field2.setText("disabled");
        this.add(field1, gridBagConstraints);
        this.add(field2, gridBagConstraints1);
        this.add(getJTextField(), gridBagConstraints2);
        this.add(getJTextField1(), gridBagConstraints21);
        this.add(getJTextField2(), gridBagConstraints3);
        this.add(getJTextField3(), gridBagConstraints4);
        this.add(getJTextField4(), gridBagConstraints5);
        this.add(getJTextField5(), gridBagConstraints6);
        this.add(getJTextField6(), gridBagConstraints7);
        
    }

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setText("not editable");
			jTextField.setEditable(false);
		}
		return jTextField;
	}

	/**
	 * This method initializes jTextField1	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setText("right to left");
			jTextField1.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
		return jTextField1;
	}

	/**
	 * This method initializes jTextField2	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setText("opaque false");
			jTextField2.setOpaque(false);
		}
		return jTextField2;
	}

	/**
	 * This method initializes jTextField3	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBackground(java.awt.Color.orange);
			jTextField3.setForeground(java.awt.Color.red);
			jTextField3.setText("colored");
		}
		return jTextField3;
	}

	/**
	 * This method initializes jTextField4	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setText("colord disabled");
			jTextField4.setEnabled(false);
			jTextField4.setForeground(java.awt.Color.red);
			jTextField4.setBackground(java.awt.Color.orange);
		}
		return jTextField4;
	}

	/**
	 * This method initializes jTextField5	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setText("colored not editable");
			jTextField5.setEditable(false);
			jTextField5.setForeground(java.awt.Color.red);
			jTextField5.setBackground(java.awt.Color.orange);
		}
		return jTextField5;
	}

	/**
	 * This method initializes jTextField6	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField6() {
		if (jTextField6 == null) {
			jTextField6 = new JTextField();
			jTextField6.setText("no border");
			jTextField6.setBorder(null);
		}
		return jTextField6;
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"

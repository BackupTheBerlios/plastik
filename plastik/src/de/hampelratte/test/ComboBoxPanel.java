package de.hampelratte.test;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;

public class ComboBoxPanel extends JPanel {

	private JComboBox jComboBox = null;
	private JComboBox jComboBox1 = null;
	private JComboBox jComboBox2 = null;
	private JComboBox jComboBox3 = null;
	private DefaultComboBoxModel model = null;
	private JComboBox jComboBox4 = null;
	private JComboBox jComboBox5 = null;
	private JComboBox jComboBox6 = null;
	private JComboBox jComboBox7 = null;
	private JComboBox jComboBox8 = null;
	private JComboBox jComboBox9 = null;

	/**
	 * This method initializes 
	 * 
	 */
	public ComboBoxPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints6.gridy = 4;
		gridBagConstraints6.weightx = 1.0;
		gridBagConstraints6.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints6.gridx = 1;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints5.gridy = 4;
		gridBagConstraints5.weightx = 1.0;
		gridBagConstraints5.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints5.gridx = 0;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints4.gridy = 3;
		gridBagConstraints4.weightx = 1.0;
		gridBagConstraints4.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints4.gridx = 1;
		GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
		gridBagConstraints31.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints31.gridy = 3;
		gridBagConstraints31.weightx = 1.0;
		gridBagConstraints31.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints31.gridx = 0;
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints21.gridy = 2;
		gridBagConstraints21.weightx = 1.0;
		gridBagConstraints21.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints21.gridx = 1;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = java.awt.GridBagConstraints.HORIZONTAL;
		gridBagConstraints11.gridy = 2;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints11.gridx = 0;
		setName("JComboBox");
		
		model = new DefaultComboBoxModel();
		model.addElement("hallo");
		model.addElement("welt");
		
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints3.gridx = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints2.gridx = 0;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints1.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints.gridx = 0;
        this.setLayout(new GridBagLayout());
        this.setSize(new java.awt.Dimension(504,341));
        this.add(getJComboBox(), gridBagConstraints);
        this.add(getJComboBox1(), gridBagConstraints1);
        this.add(getJComboBox2(), gridBagConstraints2);
        this.add(getJComboBox3(), gridBagConstraints3);
        this.add(getJComboBox4(), gridBagConstraints11);
        this.add(getJComboBox5(), gridBagConstraints21);
        this.add(getJComboBox6(), gridBagConstraints31);
        this.add(getJComboBox7(), gridBagConstraints4);
        this.add(getJComboBox8(), gridBagConstraints5);
        this.add(getJComboBox9(), gridBagConstraints6);
			
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setModel(model);
			jComboBox.setPreferredSize(new Dimension(100, 50));
		}
		return jComboBox;
	}

	/**
	 * This method initializes jComboBox1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox1() {
		if (jComboBox1 == null) {
			jComboBox1 = new JComboBox();
			jComboBox1.setModel(model);
			jComboBox1.setEditable(true);
		}
		return jComboBox1;
	}

	/**
	 * This method initializes jComboBox2	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox2() {
		if (jComboBox2 == null) {
			jComboBox2 = new JComboBox();
			jComboBox2.setModel(model);
			jComboBox2.setEnabled(false);
		}
		return jComboBox2;
	}

	/**
	 * This method initializes jComboBox3	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox3() {
		if (jComboBox3 == null) {
			jComboBox3 = new JComboBox();
			jComboBox3.setModel(model);
			jComboBox3.setEditable(true);
			jComboBox3.setEnabled(false);
		}
		return jComboBox3;
	}

	/**
	 * This method initializes jComboBox4	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox4() {
		if (jComboBox4 == null) {
			jComboBox4 = new JComboBox();
			jComboBox4.setModel(model);
			jComboBox4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			jComboBox4.setEditable(true);
		}
		return jComboBox4;
	}

	/**
	 * This method initializes jComboBox5	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox5() {
		if (jComboBox5 == null) {
			jComboBox5 = new JComboBox();
			jComboBox5.setModel(model);
			jComboBox5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}
		return jComboBox5;
	}

	/**
	 * This method initializes jComboBox6	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox6() {
		if (jComboBox6 == null) {
			jComboBox6 = new JComboBox();
			jComboBox6.setModel(model);
			jComboBox6.setForeground(java.awt.Color.red);
			jComboBox6.setBackground(java.awt.Color.orange);
		}
		return jComboBox6;
	}

	/**
	 * This method initializes jComboBox7	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox7() {
		if (jComboBox7 == null) {
			jComboBox7 = new JComboBox();
			jComboBox7.setModel(model);
			jComboBox7.setBackground(java.awt.Color.orange);
			jComboBox7.setEditable(true);
			jComboBox7.setForeground(java.awt.Color.red);
		}
		return jComboBox7;
	}

	/**
	 * This method initializes jComboBox8	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox8() {
		if (jComboBox8 == null) {
			jComboBox8 = new JComboBox();
			jComboBox8.setModel(model);
			jComboBox8.setForeground(java.awt.Color.red);
			jComboBox8.setBackground(java.awt.Color.orange);
			jComboBox8.setEnabled(false);
		}
		return jComboBox8;
	}

	/**
	 * This method initializes jComboBox9	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox9() {
		if (jComboBox9 == null) {
			jComboBox9 = new JComboBox();
			jComboBox9.setModel(model);
			jComboBox9.setBackground(java.awt.Color.orange);
			jComboBox9.setEnabled(false);
			jComboBox9.setForeground(java.awt.Color.red);
			jComboBox9.setEditable(true);
		}
		return jComboBox9;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

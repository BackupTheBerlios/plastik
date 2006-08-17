package de.hampelratte.test;

import javax.swing.JPanel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import java.awt.GridBagConstraints;

public class SpinnerPanel extends JPanel {

	private JSpinner jSpinner = null;
	private JSpinner jSpinner1 = null;
	private JSpinner jSpinner2 = null;
	private JSpinner jSpinner3 = null;
	private JSpinner jSpinner5 = null;
	
	private SpinnerModel numberModel = new SpinnerNumberModel(50,0,100,1);
	private SpinnerModel dateModel = new SpinnerDateModel();
	
	/**
	 * This method initializes 
	 * 
	 */
	public SpinnerPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.gridx = 0;
		gridBagConstraints21.insets = new java.awt.Insets(5,5,5,5);
		gridBagConstraints21.gridy = 2;
		setName("JSpinner");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.gridx = 1;
        gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints3.gridy = 1;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.gridx = 0;
        gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints2.gridy = 1;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.gridx = 1;
        gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints1.gridy = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints.gridy = 0;
        this.setLayout(new GridBagLayout());
        this.setSize(new java.awt.Dimension(465,340));
        this.add(getJSpinner(), gridBagConstraints);
        this.add(getJSpinner1(), gridBagConstraints1);
        this.add(getJSpinner2(), gridBagConstraints2);
        this.add(getJSpinner3(), gridBagConstraints3);
        this.add(getJSpinner5(), gridBagConstraints21);
			
	}

	/**
	 * This method initializes jSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner() {
		if (jSpinner == null) {
			jSpinner = new JSpinner();
			jSpinner.setModel(numberModel);
		}
		return jSpinner;
	}

	/**
	 * This method initializes jSpinner1	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner1() {
		if (jSpinner1 == null) {
			jSpinner1 = new JSpinner();
			jSpinner1.setModel(numberModel);
			jSpinner1.setEnabled(false);
		}
		return jSpinner1;
	}

	/**
	 * This method initializes jSpinner2	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner2() {
		if (jSpinner2 == null) {
			jSpinner2 = new JSpinner();
			jSpinner2.setModel(dateModel);
			jSpinner2.setBackground(java.awt.Color.orange);
			jSpinner2.setForeground(java.awt.Color.red);
		}
		return jSpinner2;
	}

	/**
	 * This method initializes jSpinner3	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner3() {
		if (jSpinner3 == null) {
			jSpinner3 = new JSpinner();
			jSpinner3.setModel(numberModel);
			jSpinner3.setEnabled(false);
			jSpinner3.setBackground(java.awt.Color.orange);
			jSpinner3.setForeground(java.awt.Color.red);
		}
		return jSpinner3;
	}

	/**
	 * This method initializes jSpinner5	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner5() {
		if (jSpinner5 == null) {
			jSpinner5 = new JSpinner();
			jSpinner5.setModel(dateModel);
			jSpinner5.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
		}
		return jSpinner5;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

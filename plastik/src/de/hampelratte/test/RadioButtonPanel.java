package de.hampelratte.test;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

public class RadioButtonPanel extends JPanel {

	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JRadioButton jRadioButton2 = null;
	private JRadioButton jRadioButton3 = null;
	private JRadioButton jRadioButton4 = null;
	private JRadioButton jRadioButton5 = null;
	private JRadioButton jRadioButton6 = null;
	private JRadioButton jRadioButton7 = null;

	/**
	 * This is the default constructor
	 */
	public RadioButtonPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setLayout(new FlowLayout());
		this.setSize(413, 296);
		this.add(getJRadioButton(), null);
		this.add(getJRadioButton1(), null);
		this.add(getJRadioButton2(), null);
		this.add(getJRadioButton3(), null);
		this.add(getJRadioButton4(), null);
		this.add(getJRadioButton5(), null);
		this.add(getJRadioButton6(), null);
		this.add(getJRadioButton7(), null);
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("normal");
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("disabled");
			jRadioButton1.setEnabled(false);
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes jRadioButton2	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton2() {
		if (jRadioButton2 == null) {
			jRadioButton2 = new JRadioButton();
			jRadioButton2.setText("selected");
			jRadioButton2.setSelected(true);
		}
		return jRadioButton2;
	}

	/**
	 * This method initializes jRadioButton3	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton3() {
		if (jRadioButton3 == null) {
			jRadioButton3 = new JRadioButton();
			jRadioButton3.setText("selected / disabled");
			jRadioButton3.setEnabled(false);
			jRadioButton3.setSelected(true);
		}
		return jRadioButton3;
	}

	/**
	 * This method initializes jRadioButton4	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton4() {
		if (jRadioButton4 == null) {
			jRadioButton4 = new JRadioButton();
			jRadioButton4.setText("colored");
			jRadioButton4.setForeground(new java.awt.Color(255,204,51));
			jRadioButton4.setBackground(new java.awt.Color(255,153,153));
		}
		return jRadioButton4;
	}

	/**
	 * This method initializes jRadioButton5	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton5() {
		if (jRadioButton5 == null) {
			jRadioButton5 = new JRadioButton();
			jRadioButton5.setText("colored disabled");
			jRadioButton5.setBackground(new java.awt.Color(255,153,153));
			jRadioButton5.setForeground(new java.awt.Color(51,255,51));
			jRadioButton5.setEnabled(false);
		}
		return jRadioButton5;
	}

	/**
	 * This method initializes jRadioButton6	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton6() {
		if (jRadioButton6 == null) {
			jRadioButton6 = new JRadioButton();
			jRadioButton6.setText("not filled");
			jRadioButton6.setContentAreaFilled(false);
		}
		return jRadioButton6;
	}

	/**
	 * This method initializes jRadioButton7	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton7() {
		if (jRadioButton7 == null) {
			jRadioButton7 = new JRadioButton();
			jRadioButton7.setText("colored not filled");
			jRadioButton7.setForeground(java.awt.Color.BLUE);
			jRadioButton7.setBackground(new java.awt.Color(255,102,102));
			jRadioButton7.setContentAreaFilled(false);
		}
		return jRadioButton7;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"

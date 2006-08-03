package de.hampelratte.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextAreaPanel extends JPanel {

	private JTextArea jTextArea = null;
	private JScrollPane jScrollPane1 = null;
	private JScrollPane jScrollPane2 = null;
	private JScrollPane jScrollPane3 = null;
	private JTextArea jTextArea1 = null;
	private JTextArea jTextArea2 = null;
	private JTextArea jTextArea3 = null;

	/**
	 * This method initializes 
	 * 
	 */
	public TextAreaPanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
		setName("JTextArea");
        GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
        gridBagConstraints3.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints3.gridy = 1;
        gridBagConstraints3.weightx = 1.0;
        gridBagConstraints3.weighty = 1.0;
        gridBagConstraints3.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints3.gridx = 0;
        GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
        gridBagConstraints2.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints2.gridy = 1;
        gridBagConstraints2.weightx = 1.0;
        gridBagConstraints2.weighty = 1.0;
        gridBagConstraints2.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints2.gridx = 1;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints.gridx = 0;
        GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
        gridBagConstraints1.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints1.gridy = 0;
        gridBagConstraints1.weightx = 1.0;
        gridBagConstraints1.weighty = 1.0;
        gridBagConstraints1.insets = new java.awt.Insets(5,5,5,5);
        gridBagConstraints1.gridx = 1;
        this.setLayout(new GridBagLayout());
        this.setSize(new java.awt.Dimension(485,373));
        this.add(getJTextArea(), gridBagConstraints1);
        this.add(getJScrollPane1(), gridBagConstraints);
        this.add(getJScrollPane2(), gridBagConstraints2);
        this.add(getJScrollPane3(), gridBagConstraints3);
			
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setText("without scrollpane\nand colored dude!");
			jTextArea.setBackground(Color.ORANGE);
			jTextArea.setForeground(Color.RED);
			jTextArea.setPreferredSize(new Dimension(200,200));
		}
		return jTextArea;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTextArea1());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jScrollPane2	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJTextArea3());
			jScrollPane2.setBackground(Color.CYAN);
			jScrollPane2.setOpaque(false);
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jScrollPane3	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getJTextArea2());
			//jScrollPane3.setBorder(new PlastikBorder());
		}
		return jScrollPane3;
	}

	/**
	 * This method initializes jTextArea1	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setText("disabled\n");
			jTextArea1.append(text);
			jTextArea1.setEnabled(false);
		}
		return jTextArea1;
	}

	/**
	 * This method initializes jTextArea2	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
			jTextArea2.setText("editable false\n");
			jTextArea2.append(text);
			jTextArea2.setEditable(false);
		}
		return jTextArea2;
	}

	/**
	 * This method initializes jTextArea3	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea3() {
		if (jTextArea3 == null) {
			jTextArea3 = new JTextArea();
			jTextArea3.setText("normal not opaque\nscrollpane colored "+text);
			jTextArea3.setOpaque(false);
		}
		return jTextArea3;
	}

	
	private String text = "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n";
		
}  //  @jve:decl-index=0:visual-constraint="10,10"

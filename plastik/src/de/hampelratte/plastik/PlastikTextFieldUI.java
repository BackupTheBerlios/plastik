package de.hampelratte.plastik;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;

public class PlastikTextFieldUI extends BasicTextFieldUI {

	private static PlastikTextFieldUI textFieldUI;
	
	public static ComponentUI createUI(JComponent c) {
		JTextField tf = (JTextField)c;
		textFieldUI = new PlastikTextFieldUI();
		tf.addFocusListener(textFieldUI.new PlastikTextFieldFocusAdapter(tf));
		return textFieldUI;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
	}
	
	private class PlastikTextFieldFocusAdapter extends FocusAdapter {
		private JTextField tf;
		PlastikTextFieldFocusAdapter(JTextField tf) {
			this.tf = tf;
		}
		
		public void focusGained(FocusEvent e) {
			tf.repaint();
		}

		public void focusLost(FocusEvent e) {
			tf.repaint();
		}
	}
}
package de.hampelratte.plastik;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextAreaUI;

public class PlastikTextAreaUI extends BasicTextAreaUI {

	private static PlastikTextAreaUI textAreaUI;
	private static JTextArea ta;
	
	public static ComponentUI createUI(JComponent c) {
		ta = (JTextArea)c;
		textAreaUI = new PlastikTextAreaUI();
		ta.addFocusListener(textAreaUI.new PlastikTextAreaFocusAdapter(ta));
		return textAreaUI;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
	}

	private class PlastikTextAreaFocusAdapter extends FocusAdapter {
		private JTextArea ta;
		PlastikTextAreaFocusAdapter(JTextArea ta) {
			this.ta = ta;
		}
		
		public void focusGained(FocusEvent e) {
			ta.repaint();
		}

		public void focusLost(FocusEvent e) {
			ta.repaint();
		}
	}
}
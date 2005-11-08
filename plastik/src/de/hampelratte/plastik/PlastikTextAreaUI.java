package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.UIManager;
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
	
	public void update(Graphics g, JComponent c) {
		if(PlastikLookAndFeel.isTextAntialiasing()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paint(g,c);
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
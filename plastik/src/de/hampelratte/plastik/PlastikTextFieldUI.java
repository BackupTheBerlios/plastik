package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;
import javax.swing.text.JTextComponent;

public class PlastikTextFieldUI extends BasicTextFieldUI {

	private static PlastikTextFieldUI textFieldUI;
	private JTextComponent editor;
	
	public static ComponentUI createUI(JComponent c) {
		JTextField tf = (JTextField)c;
		textFieldUI = new PlastikTextFieldUI();
		tf.addFocusListener(textFieldUI.new PlastikTextFieldFocusAdapter(tf));
		return textFieldUI;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		super.propertyChange(evt);
	}
	
	public void installUI(JComponent c) {
        if (c instanceof JTextComponent) {
            editor = (JTextComponent) c;
        }
        super.installUI(c);
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
	
	public void update(Graphics g, JComponent c) {
		c.setOpaque(false);

		Color background = c.isEnabled() ? c.getBackground() : UIManager.getColor("Common.background");
		// draw background
		g.setColor(background);
		Insets i = c.getInsets();
		int width = c.getWidth() - i.left - i.right;
		int height = c.getHeight() - i.top - i.bottom;
		g.fillRect(i.left,i.top, width, height);
		
		if(PlastikLookAndFeel.isTextAntialiasing()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paint(g,c);
	}
	
	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		d.height = 26;
		d.width += 2;
		return d;
	}
}
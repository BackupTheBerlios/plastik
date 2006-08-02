package de.hampelratte.plastik;

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
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicTextFieldUI;


// FIXME antialiasing funktioniert nicht bei, wenn man in einem
// right to left orientierten feld geschrieben hat
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
	
	
	private JTextField tf;
	public void installUI(JComponent c) {
		tf = (JTextField)c;
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
		// storing original anitalising flag
		Graphics2D g2d = (Graphics2D) g;
		Object state = null;
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			state = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			if (state != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
		}
		
		super.paint(g,c);
		
		// restoring antialising flag
		if (state != null) {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, state);
		}
	}
	
	protected void paintBackground(Graphics g) {
		if(tf.isOpaque()) {
			g.setColor(tf.getBackground());
			Insets i = tf.getInsets();
			int width = tf.getWidth() - i.left - i.right;
			int height = tf.getHeight() - i.top - i.bottom;
			g.fillRect(i.left,i.top, width, height);
		}
	}
	
	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		d.height = 26;
		d.width += 2;
		return d;
	}
}
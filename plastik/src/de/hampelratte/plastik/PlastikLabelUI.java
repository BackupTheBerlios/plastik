package de.hampelratte.plastik;

import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.metal.MetalLabelUI;

public class PlastikLabelUI extends MetalLabelUI {
	
	protected static PlastikLabelUI LABEL_UI = new PlastikLabelUI();
	
	public static ComponentUI createUI(JComponent c) {
		return LABEL_UI;
	}
	
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		
		Object antialiasing = null;
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			antialiasing = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			if (antialiasing != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
		}
		
		super.paint(g,c);
		
		if (antialiasing != null) {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antialiasing);
		}
	}
	
	private static final int FOREGROUND
			= PlastikColorTheme.LABEL
			| PlastikColorTheme.FOREGROUND_COMPONENT;
	
	private static final int FOREGROUND_INACTIVE
			= PlastikColorTheme.LABEL
			| PlastikColorTheme.FOREGROUND_COMPONENT
			| PlastikColorTheme.INACTIVE;
	
	protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		int mnemonicIndex = l.getDisplayedMnemonicIndex();
		Color foreground = l.getForeground();
		PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
		
		g.setColor(theme.getColor(foreground, FOREGROUND));
		BasicGraphicsUtils.drawStringUnderlineCharAt(g, s, mnemonicIndex, textX, textY);		
	}

	protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		int mnemonicIndex = l.getDisplayedMnemonicIndex();
		Color foreground = l.getForeground();
		PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
		
		g.setColor(theme.getColor(foreground, FOREGROUND_INACTIVE | PlastikColorTheme.BRIGHTER));
		BasicGraphicsUtils.drawStringUnderlineCharAt(g, s, mnemonicIndex, textX + 1, textY + 1);
		g.setColor(theme.getColor(foreground, FOREGROUND_INACTIVE | PlastikColorTheme.DARKER));
		BasicGraphicsUtils.drawStringUnderlineCharAt(g, s, mnemonicIndex, textX, textY);
    }
}
/*
public class AvioLabelUI extends BasicLabelUI {
	
    protected static AvioLabelUI labelUI = new AvioLabelUI();

    public static ComponentUI createUI(JComponent c) {
		return labelUI;
    }

	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		Object antialising = null;
		if (AvioLookAndFeel.useTextAntialising(c)) {
			antialising = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			if (antialising != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
		}
		
		super.paint(g, c);
		
		if (antialising != null) {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, antialising);
		}
	}
	
    protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
		int mnemIndex = l.getDisplayedMnemonicIndex();
		g.setColor(UIManager.getColor("Label.disabledForeground"));
		BasicGraphicsUtils.drawStringUnderlineCharAt(g, s, mnemIndex, textX, textY);
    }
}*/
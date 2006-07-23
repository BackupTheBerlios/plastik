package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class PlastikCheckBoxMenuItemUI extends PlastikMenuItemUI {
	
	public static ComponentUI createUI(JComponent b) {
        return new PlastikCheckBoxMenuItemUI();
    }
	
	public void paintMenuItem(Graphics g, JComponent c, Icon checkIcon, Icon arrowIcon, Color background, Color foreground, int defaultTextIconGap) {
		checkIcon = PlastikIconFactory.getCheckboxIcon();
		super.paintMenuItem(g, c, checkIcon, arrowIcon, background, foreground, defaultTextIconGap);
	}
}

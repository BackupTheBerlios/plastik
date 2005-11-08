package de.hampelratte.plastik.borders;

import java.awt.Component;
import java.awt.Insets;


public class PlastikScrollPaneBorder extends PlastikBorder {

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top = insets.left = insets.right = insets.bottom = 2;
		return insets;
	}
}

package de.hampelratte.plastik;

import java.awt.Color;

import javax.swing.plaf.UIResource;

public class PlastikColorUIResource extends Color implements PlastikUIResource {

	public PlastikColorUIResource(int r, int g, int b) {
		super(r, g, b);
	}

	public PlastikColorUIResource(int rgb) {
		super(rgb);
	}

	public PlastikColorUIResource(float r, float g, float b) {
		super(r, g, b);
	}

	public PlastikColorUIResource(Color c) {
		super(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
}

package de.hampelratte.plastik;

import java.awt.Color;

import javax.swing.plaf.UIResource;

public class PlastikColorUIResource extends Color implements PlastikUIResource {

	public PlastikColorUIResource(int r, int g, int b) {
		super(r, g, b);
	}
	
	public PlastikColorUIResource(int r, int g, int b, int a) {
		super(r, g, b, a);
	}

	public PlastikColorUIResource(int rgba) {
		super(rgba, true);
	}

	public PlastikColorUIResource(float r, float g, float b) {
		super(r, g, b);
	}
	
	public PlastikColorUIResource(float r, float g, float b, float a) {
		super(r, g, b, a);
	}

	public PlastikColorUIResource(Color c) {
		super(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
	}
	
	public String toString() {
		return "PlastikColorUIResource[r="+getRed()+",g="+getGreen()+",b="+getBlue()+"]";
	}
}

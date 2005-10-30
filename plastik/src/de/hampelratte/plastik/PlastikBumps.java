package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.UIManager;

public class PlastikBumps implements Icon {
	
	private Rectangle area;
	public static int MAX_LENGTH = 18;
	private Color innerContour = UIManager.getColor("Common.contourDisabled");
	private Color innerContourSmoother = UIManager.getColor("Common.background");
	
	PlastikBumps(Rectangle area) {
		this.area = area;
	}
	
	public int getIconHeight() {
		return area.height;
	}

	public int getIconWidth() {
		return area.width;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.translate(x,y);
		int w = area.width;
		int h = area.height;
		
		for(int i = 0; i<w; i+=4) {
			for(int j = 0; j<h; j+=4) {
				g.setColor(innerContour);
				g.drawLine(i,j,i,j);
				g.drawLine(i+1,j,i+1,j);
				g.drawLine(i,j+1,i,j+1);
				g.setColor(innerContourSmoother);
				g.drawLine(i+1,j+1,i+1,j+1);
			}
		}
		
		g.translate(-x,-y);
	}

}

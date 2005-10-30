package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Gradients {
	
	public static void drawRoundBoxGradient(Graphics g, Rectangle rect, Color c1, Color c2) {
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0,0,c1,0,rect.height,c2);
		g2.setPaint(gp);
		g2.fillRoundRect((int)rect.getX(), (int)rect.getY(), 
				(int)rect.getWidth()-1, (int)rect.getHeight()-1, 4, 4);
	}
	
	
	public static void drawBoxGradient(Graphics g, Rectangle rect, Color c1, Color c2) {
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0,0,c1,0,rect.height,c2);
		g2.setPaint(gp);
		g2.fillRect((int)rect.getX(), (int)rect.getY(), 
				(int)rect.getWidth()-1, (int)rect.getHeight()-1);
	}
	
	
	public static void drawRoundGradient(Graphics g, Rectangle rect, Color c1, Color c2) {
		Graphics2D g2 = (Graphics2D)g;
		GradientPaint gp = new GradientPaint(0,0,c1,0,rect.height,c2);
		g2.setPaint(gp);
		g2.fillOval((int)rect.getX(), (int)rect.getY(), 
				(int)rect.getWidth()-1, (int)rect.getHeight()-1);
	}
}

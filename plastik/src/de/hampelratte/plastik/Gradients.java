package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;

public class Gradients {
	
	public static void drawRoundBoxGradient(Graphics g, Rectangle rect, int arcWidth, int arcHeight, Color top, Color bottom) {
		drawRoundBoxGradient(g, rect.x, rect.y, rect.width, rect.height, arcWidth, arcHeight, top, bottom);
	}
	
	
	public static void drawRoundBoxGradient(Graphics g, int x, int y, int w, int h, int arcWidth, int arcHeight, Color top, Color bottom) {
		Graphics2D g2 = (Graphics2D)g;
		Paint oldPaint = g2.getPaint();
		
		GradientPaint gp = new GradientPaint(0, y, top, 0, y+h-1, bottom);
		g2.setPaint(gp);
		g2.fillRoundRect(x, y, w, h, arcWidth, arcHeight);
		
		g2.setPaint(oldPaint);
	}
	
	
	public static void drawBoxGradient(Graphics g, Rectangle rect, Color top, Color bottom) {
		drawBoxGradient(g, rect.x, rect.y, rect.width, rect.height, top, bottom);
	}
	
	
	public static void drawBoxGradient(Graphics g, int x, int y, int w, int h, Color top, Color bottom) {
		Graphics2D g2 = (Graphics2D)g;
		Paint oldPaint = g2.getPaint();
		
		GradientPaint gp = new GradientPaint(0, y, top, 0, y+h-1, bottom);
		g2.setPaint(gp);
		g2.fillRect(x, y, w, h);
		
		g2.setPaint(oldPaint);
	}
	
	
	public static void drawRoundGradient(Graphics g, Rectangle rect, Color top, Color bottom) {
		drawRoundGradient(g, rect.x, rect.y, rect.width, rect.height, top, bottom);
	}
	
	
	public static void drawRoundGradient(Graphics g, int x, int y, int w, int h, Color top, Color bottom) {
		Graphics2D g2 = (Graphics2D)g;
		Paint oldPaint = g2.getPaint();
		
		GradientPaint gp = new GradientPaint(0, y, top, 0, y+h-1, bottom);
		g2.setPaint(gp);
		g2.fillOval(x, y, w, h);
		
		g2.setPaint(oldPaint);
	}
}

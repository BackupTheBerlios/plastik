package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

// TODO zweiten button unten einbauen
public class PlastikScrollBarUI extends BasicScrollBarUI {

	private Color contour = UIManager.getColor("Common.contour");

	private Color contourSmoother = UIManager
			.getColor("Common.contourSmoother");

	private boolean mousePressed = false;
	
	private int scrollBarWidth;

	private Point pressedAt;
	
	public static ComponentUI createUI(JComponent c) {
		PlastikScrollBarUI ui = new PlastikScrollBarUI();
		c.addMouseMotionListener(ui.new ThumbMouseListener());
		c.addMouseListener(ui.new ThumbMouseListener());
		return ui;
	}

	protected void installDefaults() {
		super.installDefaults();
		scrollBarWidth = UIManager.getInt("ScrollBar.width");
        if (scrollBarWidth <= 0) {
            scrollBarWidth = 16;
        }
	}
	
	protected JButton createDecreaseButton(int orientation) {
		return new PlastikScrollButton(orientation, scrollBarWidth);
	}

	protected JButton createIncreaseButton(int orientation) {
		return new PlastikScrollButton(orientation, scrollBarWidth);
	}

	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		// TODO farbe ins laf einbauen
		g.setColor(new Color(245, 245, 245));
		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width,
				trackBounds.height);
	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		if (!c.isEnabled()) {
			return;
		}

		int x = thumbBounds.x;
		int y = thumbBounds.y;
		int w = thumbBounds.width - 1;
		int h = thumbBounds.height - 1;
		g.translate(x, y);

		// draw contour
		g.setColor(contour);
		g.drawLine(0, 1, 0, h - 1);
		g.drawLine(w, 1, w, h - 1);
		g.drawLine(1, 0, w - 1, 0);
		g.drawLine(1, h, w - 1, h);

		// draw contour smoother
		g.setColor(contourSmoother);
		g.drawLine(0, 0, 0, 0);
		g.drawLine(w, 0, w, 0);
		g.drawLine(0, h, 0, h);
		g.drawLine(w, h, w, h);

		// draw gradient
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint gp;
		Color lightGray;
		Color darkGray;
		if (mousePressed && thumbBounds.contains(pressedAt)) {
			lightGray = new Color(239, 241, 246);
			darkGray = new Color(216, 217, 223);
		} else {
			lightGray = new Color(229, 231, 236);
			darkGray = new Color(206, 207, 213);
		}
		if (scrollbar.getOrientation() == SwingConstants.HORIZONTAL) {
			gp = new GradientPaint(0, 0, lightGray, 0, h, darkGray);
		} else {
			gp = new GradientPaint(0, 0, lightGray, w, 0, darkGray);
		}
		g2.setPaint(gp);
		g2.fillRect(2, 2, w - 2, h - 2);

		// draw bumps
		Rectangle bumpBounds = calculateBumpBounds(thumbBounds);
		PlastikBumps bumps = new PlastikBumps(bumpBounds);
		bumps.paintIcon(c, g, bumpBounds.x, bumpBounds.y);

		g.translate(-x, -y);
	}

	private Rectangle calculateBumpBounds(Rectangle thumbBounds) {
		Rectangle rect = new Rectangle();

		if (scrollbar.getOrientation() == SwingConstants.HORIZONTAL) {
			// calculate dimensions
			rect.height = thumbBounds.height - 6;
			rect.width = thumbBounds.width > (PlastikBumps.MAX_LENGTH + 10) ? PlastikBumps.MAX_LENGTH
					: thumbBounds.width - 10;
			// calculate positions
			rect.x = (thumbBounds.width - rect.width) / 2;
			rect.y = (thumbBounds.height - rect.height) / 2 + 1;
		} else {
			rect.width = thumbBounds.width - 6;
			rect.height = thumbBounds.height > (PlastikBumps.MAX_LENGTH + 10) ? PlastikBumps.MAX_LENGTH
					: thumbBounds.height - 10;
			// calculate positions
			rect.y = (thumbBounds.height - rect.height) / 2;
			rect.x = (thumbBounds.width - rect.width) / 2 + 1;
		}
		return rect;
	}

	// TODO noch nicht perfekt
	private class ThumbMouseListener implements MouseListener,
			MouseMotionListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent arg0) {
		}

		public void mouseExited(MouseEvent arg0) {
		}

		public void mousePressed(MouseEvent e) {
			mousePressed = true;
			pressedAt = e.getPoint();
			((JComponent) e.getSource()).repaint();
		}

		public void mouseReleased(MouseEvent e) {
			mousePressed = false;
			((JComponent) e.getSource()).repaint();
		}

		public void mouseDragged(MouseEvent e) {
			mousePressed = true;
			pressedAt = e.getPoint();
			((JComponent) e.getSource()).repaint();
		}

		public void mouseMoved(MouseEvent arg0) {
		}
	}

	public Dimension getPreferredSize(JComponent c) {
		if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(scrollBarWidth, scrollBarWidth * 3 + 10);
		} else { // Horizontal
			return new Dimension(scrollBarWidth * 3 + 10, scrollBarWidth);
		}
	}
}

package de.hampelratte.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class TransparencyTestPanel extends JPanel {
	
	public TransparencyTestPanel() {
		setFont(new Font("Dialog", 0, 14));
	}
		
	public void paintComponent(Graphics g) {
		int a = 20;
		int w = getWidth();
		int h = getHeight();

		// Achtung
		Rectangle rect = g.getClipBounds();
		int startX, startY, endX, endY;
		if (rect != null) {
			startX = rect.x / a;
			startY = rect.y / a;
			endX   = (rect.x+rect.width) / a + 1;
			endY   = (rect.y+rect.height) / a + 1;
		} else {
			startX = startY = 0;
			endX = getWidth() / a + 1;
			endY = getHeight() / a + 1;
		}

		Graphics gg = g.create();

		gg.translate(startX*a, startY*a);

		for (int y=startY; y<endY; y++) {
			for (int x=startX; x<endX; x++) {
				gg.setColor(new Color((x<<18+x<<4)+(y<<12)));
				gg.fillRect(0, 0, a, a);
				gg.setFont(getFont());
				gg.setColor(Color.WHITE);
				gg.drawString(""+(y+x), 2, 12);
				gg.translate(a, 0);
			}
			gg.translate(-(endX-startX)*a, a);
		}
	}
}

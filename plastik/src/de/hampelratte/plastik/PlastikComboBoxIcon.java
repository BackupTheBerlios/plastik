package de.hampelratte.plastik;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.UIManager;

public class PlastikComboBoxIcon implements Icon, Serializable {

	public int getIconHeight() {
		return 4;
	}

	public int getIconWidth() {
		return 7;
	}

	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.translate(x,y);
		g.setColor(c.isEnabled() ? UIManager.getColor("Common.innerContour") : UIManager.getColor("Common.contourDisabled"));
		//g.setColor(UIManager.getColor("Common.innerContour"));
		g.drawLine(0,0,getIconWidth()-1, 0);
		g.drawLine(1,1,getIconWidth()-2, 1);
		g.drawLine(2,2,getIconWidth()-3, 2);
		g.drawLine(3,3,getIconWidth()-4, 3);
		g.translate(-x,-y);
	}

}

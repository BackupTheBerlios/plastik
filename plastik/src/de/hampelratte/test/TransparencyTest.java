/*
 * TransparencyTest.java
 *
 * Created on 7. November 2005, 21:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package de.hampelratte.test;

import de.hampelratte.plastik.PlastikLookAndFeel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author TBN
 */
public class TransparencyTest {
	
	/** Creates a new instance of TransparencyTest */
	JFrame frame;
	JPanel panel;
	JButton button;
	JButton button2;
	
	Point point = null;
	
	public TransparencyTest() {
		frame = new JFrame();
		frame.setBounds(20, 20, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new TransparencyTestPanel();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 8));
		
		button = new JButton("TestButton");
		button.setBounds(113, 56, 250, 100);
		panel.add(button);
		
		button2 = new JButton("Button 2");
		button2.setBounds(80, 120, 100, 40);
		panel.add(button2);
		
		button.addMouseMotionListener(new MouseMotionAdapter() {
			
			public void mouseDragged(MouseEvent e) {
				if (point != null) {
					int x = e.getX();
					int y = e.getY();
					int dx = x - point.x;
					int dy = y - point.y;
					Point p = button.getLocation();
					p.translate(dx, dy);
					button.setLocation(p);
				}
			}
			
		});
		
		button.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				point = e.getPoint();
			}
			
			public void mouseReleased(MouseEvent e) {
				point = null;
			}
		});
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	private boolean changeLookTo(String lfName) {
		try {
			PlastikLookAndFeel.setDefaultOpacity(false);
			UIManager.setLookAndFeel(lfName);
			if (frame != null)
				SwingUtilities.updateComponentTreeUI(frame);
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(null, ex.getMessage());
			return false;
		}
		return true;
	}
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		TransparencyTest tt = new TransparencyTest();
		tt.changeLookTo("de.hampelratte.plastik.PlastikLookAndFeel");
	}
	
	
	private static JFrame s_frame;
	private static JLabel s_label;
	public static void displayImage(BufferedImage img) {
		if (s_frame == null) {
			s_frame = new JFrame("ImageFrame");
			s_label = new JLabel(new ImageIcon(img));
			s_frame.add(s_label, BorderLayout.CENTER);
			s_frame.setSize(400, 400);
		} else {
			s_label.setIcon(new ImageIcon(img));
		}
		s_frame.setVisible(true);
	}
	
}

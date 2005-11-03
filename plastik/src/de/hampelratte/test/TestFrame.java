package de.hampelratte.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Dieser Test soll das Verhalten beim Umschalten der UI aufzeigen.
 */
public class TestFrame extends JFrame {
	
	private JDesktopPane desktopPane;
		private JInternalFrame uiChoosingFrame;
			private JButton metalButton;
			private JButton plastikButton;
			private JButton motifButton;
		private JInternalFrame exampleFrame;
	
	
	public TestFrame() {
		initComponents();
	}
	
	private void initComponents() {
		desktopPane = new JDesktopPane();
		
		// uiChoosingFrame
		uiChoosingFrame = new JInternalFrame("UI-Chooser", true, false, false, false);
		uiChoosingFrame.setBounds(10, 10, 180, 430);
		
		Container uiChoosingContentPane = uiChoosingFrame.getContentPane();
		GridBagLayout uiChoosingLayout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5,5,5,5), 0, 0);
		uiChoosingContentPane.setLayout(uiChoosingLayout);
		
		metalButton = new JButton(getChooseMetalAction());
		plastikButton = new JButton(getChoosePlastikAction());
		motifButton = new JButton(getChooseMotifAction());
		
		// examplesFrame
		exampleFrame = new JInternalFrame("Examples", true, false, true, true);
		exampleFrame.setBounds(200, 10, 420, 430);
		
		Container contentPane = getContentPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.add(uiChoosingFrame);
		
		uiChoosingLayout.setConstraints(metalButton, constraints);
		uiChoosingContentPane.add(metalButton);
		
		constraints.gridy = 1;
		constraints.insets.top = 0;
		uiChoosingLayout.setConstraints(plastikButton, constraints);
		uiChoosingContentPane.add(plastikButton);
		
		constraints.gridy = 2;
		uiChoosingLayout.setConstraints(motifButton, constraints);
		uiChoosingContentPane.add(motifButton);
		
		
		// Metal ist voll buggy und wir schleppen das jetzt rum
		uiChoosingFrame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		uiChoosingFrame.putClientProperty("JInternalFrame.frameType", "palette");
		uiChoosingFrame.setVisible(true);
		
		desktopPane.add(exampleFrame);
		exampleFrame.setVisible(true);

	}
	
	public static void main(String[] args) {
		TestFrame f = new TestFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(640, 480);
		f.setVisible(true);
	}
	
	private Action chooseMetalAction = null;
	private Action getChooseMetalAction() {
		if (chooseMetalAction == null) {
			chooseMetalAction = new AbstractAction("Metal Look and Feel") {
				public void actionPerformed(ActionEvent e) {
					changeLookTo("javax.swing.plaf.metal.MetalLookAndFeel");
				}
			};
		}
		return chooseMetalAction;
	}
	
	private Action choosePlastikAction = null;
	private Action getChoosePlastikAction() {
		if (choosePlastikAction == null) {
			choosePlastikAction = new AbstractAction("Plastik Look and Feel") {
				public void actionPerformed(ActionEvent e) {
					changeLookTo("de.hampelratte.plastik.PlastikLookAndFeel");
				}
			};
		}
		return choosePlastikAction;
	}
	
	private Action chooseMotifAction = null;
	private Action getChooseMotifAction() {
		if (chooseMotifAction == null) {
			chooseMotifAction = new AbstractAction("Motif Look and Feel") {
				public void actionPerformed(ActionEvent e) {
					changeLookTo("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				}
			};
		}
		return chooseMotifAction;
	}
	
	private boolean changeLookTo(String lfName) {
		try {
			UIManager.setLookAndFeel(lfName);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(this, ex.getMessage());
			return false;
		}
		return true;
	}
	
}

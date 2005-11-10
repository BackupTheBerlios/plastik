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
import javax.swing.JToggleButton;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.DefaultPlastikTheme;

/**
 * Dieser Test soll das Verhalten beim Umschalten der UI aufzeigen.
 */
public class TestFrame extends JFrame {
	
	private JFrame thisFrame = this;
	private JDesktopPane desktopPane;
		private JInternalFrame uiChoosingFrame;
			private JButton metalButton;
			private JButton plastikButton;
			private JButton motifButton;
			private JButton windowsButton;
			private JToggleButton antialisingButton;
		private JInternalFrame exampleFrame;
			private AllComponentsPanel allPanel;
	
	
	public TestFrame() {
		initComponents();
	}
	
	private void initComponents() {
		desktopPane = new JDesktopPane();
		
		// uiChoosingFrame
		uiChoosingFrame = new JInternalFrame("UI-Chooser", true, false, false, false);
		uiChoosingFrame.setBounds(5, 5, 130, 250);
		
		Container uiChoosingContentPane = uiChoosingFrame.getContentPane();
		GridBagLayout uiChoosingLayout = new GridBagLayout();
		GridBagConstraints constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(5,5,5,5), 0, 0);
		uiChoosingContentPane.setLayout(uiChoosingLayout);
		
		metalButton = new JButton(getChooseMetalAction());
		plastikButton = new JButton(getChoosePlastikAction());
		motifButton = new JButton(getChooseMotifAction());
		windowsButton = new JButton(getChooseWindowsAction());
		
		//JToggleButton tog = new JToggleButton(getChangeAntialiasingAction());
		antialisingButton = new JToggleButton(getChangeAntialiasingAction());
		
		// examplesFrame
		exampleFrame = new JInternalFrame("Examples", true, false, true, true);
		exampleFrame.setBounds(140, 5, 640, 550);
		
		Container allContentPane = exampleFrame.getContentPane();
		
		allPanel = new AllComponentsPanel();
		
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
		
		constraints.gridy = 3;
		uiChoosingLayout.setConstraints(windowsButton, constraints);
		uiChoosingContentPane.add(windowsButton);

		constraints.gridy = 4;
		constraints.insets.top = 10;
		uiChoosingLayout.setConstraints(antialisingButton, constraints);
		uiChoosingContentPane.add(antialisingButton);
		
		
		
		
		// Metal ist voll buggy und wir schleppen das jetzt rum
		uiChoosingFrame.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE); 
		uiChoosingFrame.putClientProperty("JInternalFrame.frameType", "palette");
		uiChoosingFrame.setVisible(true);
		
		desktopPane.add(exampleFrame);
		exampleFrame.setVisible(true);
		allContentPane.add(allPanel, BorderLayout.CENTER);
		

	}
	
	public static void main(String[] args) {
		TestFrame f = new TestFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(800, 600);
		f.setVisible(true);
	}
	
	private Action chooseMetalAction = null;
	private Action getChooseMetalAction() {
		if (chooseMetalAction == null) {
			chooseMetalAction = new AbstractAction("Metal LnF") {
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
			choosePlastikAction = new AbstractAction("Plastik LnF") {
				public void actionPerformed(ActionEvent e) {
					PlastikLookAndFeel.setTextAntialiasing(false);
					PlastikLookAndFeel.setDefaultOpacity(false);
					PlastikLookAndFeel.setRolloverEnabled(true);
					PlastikLookAndFeel laf = new PlastikLookAndFeel();
					laf.setTheme(new DefaultPlastikTheme());
					changeLookTo(laf);
				}
			};
		}
		return choosePlastikAction;
	}
	
	private Action chooseMotifAction = null;
	private Action getChooseMotifAction() {
		if (chooseMotifAction == null) {
			chooseMotifAction = new AbstractAction("Motif LnF") {
				public void actionPerformed(ActionEvent e) {
					changeLookTo("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				}
			};
		}
		return chooseMotifAction;
	}
	
	private Action chooseWindowsAction = null;
	private Action getChooseWindowsAction() {
		if (chooseWindowsAction == null) {
			chooseWindowsAction = new AbstractAction("Windows LnF") {
				public void actionPerformed(ActionEvent e) {
					changeLookTo("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				}
			};
		}
		return chooseWindowsAction;
	}

	
	private Action changeAntialiasingAction = null;
	private Action getChangeAntialiasingAction() {
		if (changeAntialiasingAction == null) {
			changeAntialiasingAction = new AbstractAction("antialising") {
				
				private boolean antialisingEnabled = false;
				
				public void actionPerformed(ActionEvent e) {
					antialisingEnabled = !antialisingEnabled;
					PlastikLookAndFeel.setTextAntialiasing(antialisingEnabled);
					thisFrame.getContentPane().repaint();
				}
			};
		}
		return changeAntialiasingAction;
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
	
	private boolean changeLookTo(LookAndFeel laf) {
		try {
			UIManager.setLookAndFeel(laf);
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception ex) {
			JOptionPane.showConfirmDialog(this, ex.getMessage());
			return false;
		}
		return true;
	}
	
}

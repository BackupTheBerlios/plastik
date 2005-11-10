package de.hampelratte.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.DefaultPlastikTheme;

public class Main {

	private static JCheckBox checkbox;

	private static JRadioButton radiobutton;

	private static JSlider slider;

	private static JTextField textfield;
	
	private static JScrollPane scrollpane;
	
	private static JTextArea textarea;
	
	private static JScrollBar scrollb;
	
	private static JComboBox combo;
	
	private static JTabbedPane tabbedPane;
	
	private static JSpinner spinner;
	
	private static JLabel label;
	
	private static JButton button;
	
	private static JButton button2;
	
	public static void main(String[] args) {
		try {
			PlastikLookAndFeel.setTextAntialiasing(true);
			PlastikLookAndFeel.setDefaultOpacity(false);
			PlastikLookAndFeel.setRolloverEnabled(true);
			PlastikLookAndFeel laf = new PlastikLookAndFeel();
			laf.setTheme(new DefaultPlastikTheme());
			UIManager.setLookAndFeel(laf);
			
//			UIDefaults defaults = UIManager.getDefaults();
//			Enumeration enumeration = defaults.keys();
//			while (enumeration.hasMoreElements()) {
//				Object elem = enumeration.nextElement();
//				System.out.println(elem + " = " + defaults.get(elem));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);

		//JOptionPane.showMessageDialog(frame, "huhu", "plain", JOptionPane.PLAIN_MESSAGE);
		//JOptionPane.showMessageDialog(frame, "huhu", "question", JOptionPane.QUESTION_MESSAGE);
		//JOptionPane.showMessageDialog(frame, "huhu", "info", JOptionPane.INFORMATION_MESSAGE);
		//JOptionPane.showMessageDialog(frame, "huhu", "error", JOptionPane.ERROR_MESSAGE);
		//JOptionPane.showMessageDialog(frame, "huhu", "warn", JOptionPane.WARNING_MESSAGE);
		
		button = new JButton("Hallo Welt!");
		button.setToolTipText("was geht ab?");
		panel.add(button);
		
		button2 = new JButton("Hallo Welt!");
		button2.setToolTipText("was geht ab?");
		panel.add(button2);
		
		//JFileChooser fc = new JFileChooser();
		//fc.showOpenDialog(frame);
		
		label = new JLabel("Was geht denn hier ab?");
		panel.add(label);

		radiobutton = new JRadioButton("radiobutton");
		radiobutton.setToolTipText("hallo kinder");
		panel.add(radiobutton);

		checkbox = new JCheckBox("checkbox");
		panel.add(checkbox);
		
		scrollb = new JScrollBar(SwingConstants.VERTICAL);
		panel.add(scrollb);

		slider = new JSlider(0, 100);
		slider.setValue(50);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(50);
		slider.setPaintTrack(true);
		panel.add(slider);
		
		String[] items = {"hollaradiohiäoiuaasdasdasdasd","was","geht","ab","a1b","2ab","a3b","a4b","a5b","ab6","a7b","a8b","9ab","a0b"};
		combo = new JComboBox(items);
		//combo.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		combo.setEditable(true);
		panel.add(combo);

		textfield = new JTextField("zackbumm");
		panel.add(textfield);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(50,0,100,1));
		//spinner.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(spinner);
		
		textarea = new JTextArea(text);
		scrollpane = new JScrollPane(textarea);
		scrollpane.setPreferredSize(new Dimension(200,200));
		scrollpane.setOpaque(false);
		panel.add(scrollpane);
		//panel.add(textarea);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(400,200));
		tabbedPane.addTab("wasgehtab",new JPanel());
		tabbedPane.addTab("wasgehtab",new JPanel());
		tabbedPane.addTab("wasgehtab",new JPanel());
		panel.add(tabbedPane);
		
		panel.setLayout(new FlowLayout());
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkbox.setEnabled(!checkbox.isEnabled());
				radiobutton.setEnabled(!radiobutton.isEnabled());
				textfield.setEnabled(!textfield.isEnabled());
				textarea.setEnabled(!textarea.isEnabled());
				scrollb.setEnabled(!scrollb.isEnabled());
				//combo.setEnabled(!combo.isEnabled());
				combo.setEditable(!combo.isEditable());
				spinner.setEnabled(!spinner.isEnabled());
				label.setEnabled(!label.isEnabled());
				button2.setEnabled(!button2.isEnabled());
			}
		});
	}
	
	
	private static String text = "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n"
		+ "bla bla bla bla bla bla bla bla bla bla bla\n";
}

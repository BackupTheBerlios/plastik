package de.hampelratte.plastik;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Loads the icons used by swing.
 * Should be able to load icon sets from jars.
 */
public abstract class PlastikIconTheme {
	
	// TODO es fehlen noch icons
	
	abstract public ImageIcon getInfoIcon();
	abstract public ImageIcon getWarningIcon();
	abstract public ImageIcon getQuestionIcon();
	abstract public ImageIcon getErrorIcon();
	abstract public ImageIcon getDetailsViewIcon();
	abstract public ImageIcon getListViewIcon();
	abstract public ImageIcon getHomeFolderIcon();
	abstract public ImageIcon getUpFolderIcon();
	abstract public ImageIcon getNewFolderIcon();
	abstract public ImageIcon getFloppyIcon();
	abstract public ImageIcon getComputerIcon();
	abstract public ImageIcon getDirectoryIcon();
	abstract public ImageIcon getFileIcon();
	abstract public ImageIcon getHardDriveIcon();
	
	public ImageIcon loadImage(Class cl, String name) {
        URL url = cl.getResource(name);
        return new ImageIcon(url);
    }
	
}

package de.hampelratte.plastik.theme;

import java.net.URL;

import javax.swing.ImageIcon;


public abstract class AbstractIconTheme implements PlastikIconTheme {
	
	public ImageIcon loadImage(Class cl, String name) {
      URL url = cl.getResource(name);
      return new ImageIcon(url);
	}

	public abstract ImageIcon getInfoIcon();
	public abstract ImageIcon getWarningIcon();
	public abstract ImageIcon getQuestionIcon();
	public abstract ImageIcon getErrorIcon();
	public abstract ImageIcon getDetailsViewIcon();
	public abstract ImageIcon getListViewIcon();
	public abstract ImageIcon getHomeFolderIcon();
	public abstract ImageIcon getUpFolderIcon();
	public abstract ImageIcon getNewFolderIcon();
	public abstract ImageIcon getFloppyIcon();
	public abstract ImageIcon getComputerIcon();
	public abstract ImageIcon getDirectoryIcon();
	public abstract ImageIcon getFileIcon();
	public abstract ImageIcon getHardDriveIcon();
}

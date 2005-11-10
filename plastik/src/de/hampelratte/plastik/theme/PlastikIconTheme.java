package de.hampelratte.plastik.theme;

import javax.swing.ImageIcon;

/**
 * Loads the icons used by swing.
 * Should be able to load icon sets from jars.
 */
public interface PlastikIconTheme {
	
	// TODO es fehlen noch icons
	
	public ImageIcon getInfoIcon();
	public ImageIcon getWarningIcon();
	public ImageIcon getQuestionIcon();
	public ImageIcon getErrorIcon();
	public ImageIcon getDetailsViewIcon();
	public ImageIcon getListViewIcon();
	public ImageIcon getHomeFolderIcon();
	public ImageIcon getUpFolderIcon();
	public ImageIcon getNewFolderIcon();
	public ImageIcon getFloppyIcon();
	public ImageIcon getComputerIcon();
	public ImageIcon getDirectoryIcon();
	public ImageIcon getFileIcon();
	public ImageIcon getHardDriveIcon();
}

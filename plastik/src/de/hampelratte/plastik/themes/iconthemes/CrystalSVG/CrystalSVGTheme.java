package de.hampelratte.plastik.themes.iconthemes.CrystalSVG;

import javax.swing.ImageIcon;
import de.hampelratte.plastik.theme.AbstractIconTheme;


// TODO Class should be renamed to DefaultPlastikIconTheme 
// and moved to de.hampelratte.plastik.theme
// it should also be inherited from AbstractPlastikIconTheme

// Diskussion: finde ich nicht, warum nicht einfach CrystalSVGTheme
// im DefaultPlastikTheme als default setzen
// ich meine warum sollte das CrystalSVGTheme nicht so hei�en?
// nur weil es das default ist?

public class CrystalSVGTheme extends AbstractIconTheme {

	public ImageIcon getInfoIcon() {
		return loadImage(this.getClass(), "icons/info.png");
	}

	public ImageIcon getWarningIcon() {
		return loadImage(this.getClass(), "icons/warning.png");
	}

	public ImageIcon getQuestionIcon() {
		return loadImage(this.getClass(), "icons/question.png");
	}

	public ImageIcon getErrorIcon() {
		return loadImage(this.getClass(), "icons/error.png");
	}

	public ImageIcon getDetailsViewIcon() {
		return loadImage(this.getClass(), "icons/view_detailed.png");
	}

	public ImageIcon getListViewIcon() {
		return loadImage(this.getClass(), "icons/view_multicolumn.png");
	}

	public ImageIcon getHomeFolderIcon() {
		return loadImage(this.getClass(), "icons/gohome.png");
	}

	public ImageIcon getUpFolderIcon() {
		return loadImage(this.getClass(), "icons/up.png");
	}

	public ImageIcon getNewFolderIcon() {
		return loadImage(this.getClass(), "icons/folder_new.png");
	}

	public ImageIcon getFloppyIcon() {
		return loadImage(this.getClass(), "icons/floppy.png");
	}

	public ImageIcon getComputerIcon() {
		return loadImage(this.getClass(), "icons/display.png");
	}

	public ImageIcon getDirectoryIcon() {
		return loadImage(this.getClass(), "icons/folder.png");
	}

	public ImageIcon getFileIcon() {
		return loadImage(this.getClass(), "icons/file.png");
	}

	public ImageIcon getHardDriveIcon() {
		return loadImage(this.getClass(), "icons/hdd.png");
	}
}

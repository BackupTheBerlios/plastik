package de.hampelratte.plastik;

import java.awt.GraphicsConfiguration;
import java.awt.image.BufferedImage;
import java.lang.ref.WeakReference;

public class PlastikImageCache {
	
	private static BufferedImage image;
	
	private PlastikImageCache() {
	}
	
	public static BufferedImage getCachedImage(GraphicsConfiguration gc, int width, int height) {
		if (image != null && image.getWidth() >= width && image.getHeight() >= height) {
			return image;
		}
		image = gc.createCompatibleImage(width, height);
		return image;
	}
}

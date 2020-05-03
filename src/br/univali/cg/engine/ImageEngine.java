package br.univali.cg.engine;

import java.awt.image.BufferedImage;
import java.util.List;

public class ImageEngine {
	
	public BufferedImage sagital(List<BufferedImage> images) {
		BufferedImage sagital = new BufferedImage(512, images.size(), BufferedImage.TYPE_INT_RGB);
		int line = 0;
		for (BufferedImage image : images) {
			for(int y = 0; y < image.getHeight(); y++) {
				sagital.setRGB(y, line,image.getRGB(250, y));
			}
			line++;
		}
		return sagital;
	}
	
	public BufferedImage coronal(List<BufferedImage> images) {
		BufferedImage sagital = new BufferedImage(512, images.size(), BufferedImage.TYPE_INT_RGB);
		int line = 0;
		for (BufferedImage image : images) {
			for(int x = 0; x < image.getWidth(); x++) {
				sagital.setRGB(x, line,image.getRGB(x, 250));
			}
			line++;
		}
		return sagital;
	}
	
}

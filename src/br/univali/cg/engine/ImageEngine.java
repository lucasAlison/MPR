package br.univali.cg.engine;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.List;

public class ImageEngine {
	
	public BufferedImage sagital(List<BufferedImage> images, int x) {
		BufferedImage sagital = new BufferedImage(512, images.size(), BufferedImage.TYPE_INT_RGB);
		int line = 0;
		for (BufferedImage image : images) {
			for(int y = 0; y < image.getHeight(); y++) {
				sagital.setRGB(y, line,image.getRGB(x, y));
			}
			line++;
		}
		return sagital;
	}
	
	public BufferedImage coronal(List<BufferedImage> images, int y) {
		BufferedImage sagital = new BufferedImage(512, images.size(), BufferedImage.TYPE_INT_RGB);
		int line = 0;
		for (BufferedImage image : images) {
			for(int x = 0; x < image.getWidth(); x++) {
				sagital.setRGB(x, line,image.getRGB(x, y));
			}
			line++;
		}
		return sagital;
	}
	
	public BufferedImage drawLine(BufferedImage image, int x, int y) {
		BufferedImage newImage = deepCopy(image);
		Color red = new Color(255,0,0);
		Color green = new Color(0,255,0);
		for (int i = 0; i < newImage.getHeight(); i++) {
			newImage.setRGB(x, i, red.getRGB());
		}
		for (int i = 0; i < newImage.getWidth(); i++) {
			newImage.setRGB(i, y, green.getRGB());
		}
		return newImage;
	}
	
	public BufferedImage deepCopy(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
}

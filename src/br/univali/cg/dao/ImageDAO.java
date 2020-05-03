package br.univali.cg.dao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;

public class ImageDAO {
	
	private static ImageDAO instance;
	
	public static ImageDAO getInstance() {
		if (instance == null)
			instance = new ImageDAO();
		return instance;
	}
	
	public List<BufferedImage> findAll() {
		List<BufferedImage> images = new ArrayList<>();
		
		File database = new File("C:\\Users\\Alison\\eclipse-workspace\\MPR\\database");
		
		if (database != null) {
			File[] listFiles = database.listFiles();
			
			if (listFiles != null) {
				for (File file : listFiles) {
					try {
						System.out.println("reading image "+file.getName());
						images.add(ImageIO.read(file));
						System.out.println("image "+file.getName()+" read");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return images;
	}
	
	public BufferedImage findFirst(){
		File database = new File("C:\\Users\\Alison\\eclipse-workspace\\MPR\\database");
		
		if (database != null) {
			File[] listFiles = database.listFiles();
			
			if (listFiles != null) {
				for (File file : listFiles) {
					try {
						return ImageIO.read(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return null;
	}
	
	public void save(BufferedImage image, String type) {
        try {
            ImageIO.write(image, "jpg", new File("C:\\Users\\Alison\\eclipse-workspace\\MPR\\results\\"+type+"_"+GregorianCalendar.getInstance().getTimeInMillis()+".jpg"));
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	
}

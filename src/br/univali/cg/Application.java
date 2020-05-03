package br.univali.cg;


import java.awt.image.BufferedImage;
import java.util.List;

import br.univali.cg.GUI.ImageGUI;
import br.univali.cg.dao.ImageDAO;

public class Application {

	public static void main(String[] args) {
		System.out.println("Started reading images");
		List<BufferedImage> images = ImageDAO.getInstance().findAll();
		System.out.println("finished reading images");
		ImageGUI imageGUI = new ImageGUI(images);
		imageGUI.setVisible(true);
		imageGUI.drawImage(ImageDAO.getInstance().findFirst());
	}

}

package br.univali.cg;

import java.awt.image.BufferedImage;
import java.util.List;

import br.univali.cg.dao.ImageDAO;
import br.univali.cg.engine.ImageEngine;

public class Application {

	public static void main(String[] args) {
		System.out.println("Started reading images");
		List<BufferedImage> images = ImageDAO.getInstance().findAll();
		System.out.println("finished reading images");
		if (images != null) {
			ImageEngine imageEngine = new ImageEngine();
			System.out.println("started sagital process");
			BufferedImage sagital = imageEngine.sagital(images);
			System.out.println("finished sagital process");
			System.out.println("started save process");
			ImageDAO.getInstance().save(sagital, "sagital");
			System.out.println("finished save process");
			System.out.println("started coronal process");
			BufferedImage coronal = imageEngine.coronal(images);
			System.out.println("finished coronal process");
			System.out.println("started save process");
			ImageDAO.getInstance().save(coronal, "coronal");
			System.out.println("finished save process");
		}
	}

}

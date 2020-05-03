package br.univali.cg.GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.univali.cg.dao.ImageDAO;
import br.univali.cg.engine.ImageEngine;

public class ImageGUI extends JFrame{

	private JPanel contentPanel;
	private BufferedImage currentImage;
	private BufferedImage originalImage;
	private ImageEngine imageEngine;
	private List<BufferedImage> images;
	
	public ImageGUI(List<BufferedImage> dataBaseImages) {
		imageEngine = new ImageEngine();
		images = dataBaseImages;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 550);
		contentPanel = new JPanel();
		setContentPane(contentPanel);		
		
		contentPanel.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				drawLine(e);
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});
		
		contentPanel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clickedImage(e);
			}
		});
	}
	
	public void drawImage(BufferedImage image) {
		currentImage = image;
		originalImage = image;
		contentPanel.getGraphics().drawImage(image,0,0,null);		
	}
	
	private void drawLine(MouseEvent evt) {
		if (currentImage != null) {
			System.out.println("X: "+evt.getX()+"; Y: "+evt.getY());
			currentImage = imageEngine.drawLine(originalImage, evt.getX(), evt.getY());
			contentPanel.getGraphics().drawImage(currentImage,0,0,null);
			
		}
	}
	
	private void clickedImage(MouseEvent evt) {
		BufferedImage sagital = imageEngine.sagital(images, evt.getX());
		ImageDAO.getInstance().save(sagital, "sagital");
		
		BufferedImage coronal = imageEngine.coronal(images, evt.getY());
		ImageDAO.getInstance().save(coronal, "coronal");
		
		JOptionPane.showMessageDialog(null,"Finish!");
	}
	
}

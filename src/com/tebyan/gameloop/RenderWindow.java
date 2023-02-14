package com.tebyan.gameloop;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.WindowConstants;

public class RenderWindow extends JFrame{

	/**
	 * 
	 */
	public JButton createButton(String text,float xAlignment,float yAlignment) {
		JButton btn=new JButton(text);
		btn.setAlignmentX(xAlignment);
		btn.setAlignmentY(yAlignment);
		
		return btn;
	}
	public JButton addButton(String text,float xAlignment,float yAlignment) {
		JButton btnButton=createButton(text, xAlignment, yAlignment);
		getContentPane().add(btnButton);
		return btnButton;
	}
	public static final int WIDTH=640,HEIGHT=WIDTH*2/3;
	private static final long serialVersionUID = 1L;
	
	public RenderWindow(String title) {
		Dimension sizeDimension=new Dimension(WIDTH,HEIGHT);
		setTitle(title);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setMinimumSize(sizeDimension);
		setLocationRelativeTo(null);
		JPanel contentPanel=new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isOptimizedDrawingEnabled() {
				// TODO Auto-generated method stub
				return false;
			}
		};
		OverlayLayout layout=new OverlayLayout(contentPanel);
		contentPanel.setLayout(layout);
		setContentPane(contentPanel);
		
		
		
//		setExtendedState(JFrame.MAXIMIZED_BOTH);
//		setUndecorated(true);
		pack();
		setVisible(true);
		
	}

}

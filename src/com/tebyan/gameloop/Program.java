package com.tebyan.gameloop;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.LookAndFeel;
import javax.swing.OverlayLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.UnsupportedLookAndFeelException;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		RenderWindow renderWindow=new RenderWindow("RenderWindow");
		
		
		
		
//		renderWindow.add(panel);
		JPanel panel=new JPanel();
		
		JButton zoomInBtn=renderWindow.createButton("zoomIN", .95f, .95f);
		JButton zoomOutBtn=renderWindow.createButton("Zoom out", 0f, 0f);
		
		
		RenderCanvas canvas=new RenderCanvas(renderWindow);
		
		
		
		
		

	}

}

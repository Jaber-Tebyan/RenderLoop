package com.tebyan.gameloop;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;

import javax.swing.JComponent;
import javax.swing.JWindow;


public class RenderCanvas extends Canvas implements Runnable{

	/**
	 * 
	 */
	private RenderWindow window;
	private Thread thread;
	private boolean running=false;
	
	public boolean isRunning() {
		return running;
	}


	private static final long serialVersionUID = 1L;
	
	
	public RenderCanvas(RenderWindow window) {
		this.window=window;
		window.getContentPane().add(this);
		start();
		
		
	}
	private synchronized void start() {
		if(isRunning())return;
		thread=new Thread(this);
		thread.start();
		running=true;
		
	}
	private synchronized void stop() {
		if(!isRunning())return;
		if(thread!=null||!thread.isAlive())return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		running=false;
	}
	@Override
	public void run() {
		final int FPS=60;
		final double period=1e9/FPS;
		double startTime=System.nanoTime();
		double deltaTime=0;
		int currentFPS=0;
		int ups=0;
		long timer=System.currentTimeMillis();
		while(isRunning()) {
			deltaTime+=(System.nanoTime()-startTime);
			startTime=System.nanoTime();
			while(deltaTime>=period) {
				ups+=1;
				tick((float)(deltaTime/1e9));
				deltaTime-=period;
				
			}
			if(isRunning()) {
				render();
			}
			currentFPS++;
			
			if(System.currentTimeMillis()-timer>=1000) {
				timer=System.currentTimeMillis();
				System.out.println("FPS: "+currentFPS+" ------ UPS: "+ups);
				currentFPS=0;
				ups=0;
			}
		}
	}
	private void tick(float deltaTime) {
		
	}
	private void render() {
		BufferStrategy bf=getBufferStrategy();
		if(bf==null) {
			createBufferStrategy(3);
			return;
		}
		Graphics2D g=(Graphics2D) bf.getDrawGraphics();
		g.setRenderingHint(
				RenderingHints.KEY_ANTIALIASING, 
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		Dimension size=window.getSize();
		g.fillRect(0, 0, size.width, size.height);
		g.dispose();
		bf.show();
	}

}

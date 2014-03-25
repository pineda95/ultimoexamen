package com.me.mygdxgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PelotitaMala extends Image{
	public PelotitaMala(int x, int y, Fin adios) {
			super(new Texture("data/pelotitamala.png"));
			addListener(new MiInputMala(this,adios));
			
			this.setX(x);
			this.setY(y);

		
		}
		
		
	public void act(float delta){
		setX(getX()+1);
		if(getX()>500){
			setX(0);
		}
	}
	}



package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MiInputMala extends InputListener{
	PelotitaMala t;
	Fin adios;
	MiInputMala(PelotitaMala param, Fin p)
	{
		super();
		t=param;
		adios = p;
	}
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		if(!pausa.pausar){
		adios.setVisible(true);}
		
		return true;
	}
}


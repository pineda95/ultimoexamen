package com.me.mygdxgame;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class listener  extends InputListener{

 
	inicio p;
	listener(inicio param)
	{
		super();
		p=param;
	}
	
	
	public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
	{
		
	p.setVisible(false);
	return true;
	
	}
}

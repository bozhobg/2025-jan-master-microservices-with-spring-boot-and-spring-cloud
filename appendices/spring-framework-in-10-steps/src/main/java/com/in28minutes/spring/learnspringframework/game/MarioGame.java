package com.in28minutes.spring.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("marioGame")
//@Primary
public class MarioGame implements GamingConsole {

	@Override
	public void up() {
		System.out.println("Up!");
	}

	@Override
	public void down() {
		System.out.println("Go down a hole!");
	}

	@Override
	public void left() {
		System.out.println("Left!");
	}

	@Override
	public void right() {
		System.out.println("Right!");
	}

}

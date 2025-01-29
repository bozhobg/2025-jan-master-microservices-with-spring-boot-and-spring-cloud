package com.in28minutes.spring.learnspringframework.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

//	FIX: unable to autowire just with @Qualifier:
//		if @Autowire and @Qualifier on field injection doesn't recognize
//		if both annos with ctor injection works

    private GamingConsole gamingConsole;

    @Autowired
    public GameRunner(
//            @Qualifier("marioGame")
            GamingConsole game
    ) {
        this.gamingConsole = game;
    }

    public void run() {
        gamingConsole.up();
        gamingConsole.down();
        gamingConsole.left();
        gamingConsole.right();
    }

    public void setGame(GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

}

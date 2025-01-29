package com.in28minutes.spring.learnspringframework;

import com.in28minutes.spring.learnspringframework.enterprise.exapmle.web.MyWebController;
import com.in28minutes.spring.learnspringframework.game.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@ComponentScan("com.in28minutes.spring.learnspringframework1")
//@ComponentScan({"com.package1", "com.package2"})
public class LearnSpringFrameworkApplication {

	public static void main(String[] args) {

		/*
		 * Example of tight-coupling and decoupling through the use of an interface
		 * 
		 * GamingConsole marioGame = new MarioGame(); 
		 * GamingConsole superContraGame = new SuperContraGame(); 
		 * GamingConsole packmanGame = new PackmanGame();
		 * 
		 * GamingConsole marioGame = new MarioGame();
		 * GameRunner runner = new GameRunner(marioGame); 
		 * runner.run();
		 * 
		 * runner.setGame(superContraGame); 
		 * runner.run();
		 * 
		 * runner.setGame(packmanGame); 
		 * runner.run();
		 */

		ConfigurableApplicationContext context = SpringApplication.run(LearnSpringFrameworkApplication.class, args);

		GameRunner runner = context.getBean(GameRunner.class);
		runner.run();

		MyWebController controller = context.getBean(MyWebController.class);
		System.out.println(controller.returnValueFromBusinessService());

	}

}

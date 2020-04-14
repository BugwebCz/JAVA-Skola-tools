package lomeneVyrazy;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Testovani {

	public static void main(String[] args) throws ScriptException {
			
		Scanner sken = new Scanner(System.in, "UTF-8");
		String Vyraz = sken.nextLine();
		String priklad = "var " + Vyraz;
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		 
		float x1 = 10;
		float x2 = -10;
		
		manager.put("x", 10);
		engine.eval(priklad);
		float y1 = (float) engine.get("y");
		
		manager.put("x", -10);
		engine.eval(priklad);
		float y2 = (float) engine.get("y");
		
		System.out.println(y1 + y2);
		
	 

		
	}
	
}

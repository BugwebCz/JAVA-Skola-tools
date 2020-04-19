package lomeneVyrazy;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Testovani {

	public static void main(String[] args) throws ScriptException {
			
		Scanner sken = new Scanner(System.in, "UTF-8");
		String Vyraz = sken.nextLine();
		String priklad = "var " + Vyraz + " + 0.0";
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		 
		Double x1 = 7.0;
		Double x2 = (-7.0);
		
		manager.put("x", 7.0);
		engine.eval(priklad);
		Double y1 = (Double) engine.get("y");
		
		manager.put("x", (-7.0));
		engine.eval(priklad);
		Double y2 = (Double) engine.get("y");
		
		System.out.println(y1 + " " + y2);
		
	 

		
	}
	
}

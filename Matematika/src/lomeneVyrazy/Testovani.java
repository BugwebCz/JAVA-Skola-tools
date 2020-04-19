package lomeneVyrazy;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Testovani {

	public Double x1;
	public Double y1;
	public Double x2;
	public Double y2;
	public String priklad;
	
	public static void main(String[] args) throws ScriptException {
		
		
		
		Scanner sken = new Scanner(System.in, "UTF-8");
		String Vyraz = sken.nextLine();
		
		String priklad = "var " + Vyraz + " + 0.0";
		String priklad2 = priklad;
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		 
		double x1 = 7.0;
		double x2 = -7.0;
		double y1;
		double y2;
		
		manager.put("x", 7.0);
		engine.eval(priklad);
		y1 = (Double) engine.get("y");
		
		manager.put("x", (-7.0));
		engine.eval(priklad);
		y2 = (Double) engine.get("y");
		//odsud oštření boundaries - spočítání x pro y na okraji a nahrazení -> nahradí se ale vždy!
		
		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
		
		
		if (y1 < (-7.0)) { 
          	manager.put("y", (-7.0));
    		engine.eval(priklad2);
    		x1 = (Double) engine.get("x");
    		y1 = (-7.0);
    		
    		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
    		
    	} else if (y1 > 7.0) {
    		manager.put("y", 7.0);
    		engine.eval(priklad2);
    		x1 = (Double) engine.get("x");
    		y1 = 7.0;
    		
    		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
    		
    	}
		
		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
		
    	if (y2 < (-7.0)) { 
          	manager.put("y", (-7.0));
    		engine.eval(priklad2);
    		x2 = (Double) engine.get("x");
    		y2 = (-7.0);
    		
    		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
    		
    	} else if (y2 > 7.0) {
    		
    		System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
    		
    		manager.put("y", 7.0);
    		engine.eval(priklad2);
    		x2 = (Double) engine.get("x");
    		y2 = 7.0;
    	}

    	
    	System.out.println(y1 + " " + y2 + " " +  x1 + " " + x2 + " " );
		
	}
	
}




package lomeneVyrazy;

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Testovani {

	public static void main(String[] args) throws ScriptException {
		
		Scanner sken = new Scanner(System.in, "UTF-8");
		String Vyraz = sken.nextLine();
		String priklad = Vyraz.substring(Vyraz.indexOf("=", 0) + 1, Vyraz.length() + 1);
		
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    
		Object y11 = engine.eval(priklad.replaceAll("x", "10"));
		float y1 = (float) y11;
		    
		Object y22 = engine.eval(priklad.replaceAll("x", "-10"));
		float y2 = (float) y22;
		
		System.out.println(y1 + y2);
		
		
	}
	
}

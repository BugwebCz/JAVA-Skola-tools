package lomeneVyrazy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.utilities.gui.AnnotatedFrame;
import javax.utilities.gui.OnClick;
import javax.utilities.gui.Widget;
import javax.utilities.gui.Window;

@Window(title = "Lomené výrazy", cols = 10, rows = 9)
public class Vykresleni extends AnnotatedFrame {
	public Double x1;
	public Double y1;
	public Double x2;
	public Double y2;
	public String priklad;
	public String priklad2;
	public String priklad3;
	public float x0;
	public float y0;
	
	/*Zakladni GUI*/
	@Widget(text = "Zadej výraz:", x = 1, y = 1, cols = 2)
	JLabel lblVyraz;

	@Widget(x=3, y=1, cols=3)
	JTextField fldVyraz;
	
	@Widget(text="Zadej X:", x=1, y=2, cols=2)
	JLabel lblZadejX;
	
	@Widget(x=3, y=2, cols=3)
	JTextField fldX;
	
	@Widget(text="Zadej Y:", x=1, y=3, cols=2)
	JLabel lblZadejY;
	
	@Widget(x=3, y=3, cols=3)
	JTextField fldY;
	
	@Widget(text="Vykreslit", x=1, y=4, cols=2)
	JButton btnVykreslit;
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		//this.getContentPane().setBackground(Color.WHITE);
	}
	
	////////////////////////////////////////////////////
	
	@OnClick("btnVykreslit")
	public void vypocitat() throws ScriptException {
		
		String Vyraz = fldVyraz.getText();
		priklad = "var " + Vyraz + " + 0.0";
		priklad2 = priklad;
		priklad3 = priklad;
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		 
		x1 = 7.0;
		x2 = -7.0;
		
		manager.put("x", 7.0);
		engine.eval(priklad);
		y1 = (Double) engine.get("y");
		
		manager.put("x", (-7.0));
		engine.eval(priklad);
		y2 = (Double) engine.get("y");
		
		//odsud osetreni boundaries - spocitani x pro y na okraji a nahrazeni x novym -> zde je CHYBA
		
		if (y1 < (-7.0)) { 
          	manager.put("y", (-7.0));
    		engine.eval(priklad2);
    		x1 = (Double) engine.get("x");
    		y1 = (-7.0);
    	} else if (y1 > 7.0) {
    		manager.put("y", 7.0);
    		engine.eval(priklad2);
    		x1 = (Double) engine.get("x");
    		y1 = 7.0;
    	}
		
    	if (y2 < (-7.0)) { 
          	manager.put("y", (-7.0));
    		engine.eval(priklad3);
    		x2 = (Double) engine.get("x");
    		y2 = (-7.0);
    	} else if (y2 > 7.0) {
    		manager.put("y", 7.0);
    		engine.eval(priklad3);
    		x2 = (Double) engine.get("x");
    		y2 = 7.0;
    	}
		
		repaint();
	}

	@Override
	  public void paint(Graphics g) {
		  super.paint(g);
		  Graphics2D stetec = (Graphics2D) g;
	      	for (int x = 310; x <= 570; x += 20) {
	      		for (int y = 50; y <= 310; y += 20) {
	            	g.setColor(Color.WHITE);
	            	g.fillRect(x, y, 20, 20);
	            	g.setColor(Color.BLACK);
	            	g.drawRect(x, y, 20, 20);
	            }
	        }
			stetec.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			stetec.setColor(Color.black);
			//X = 450, Y = 190
			x0 = 450;
			y0 = 190;
	        stetec.drawLine(450, 50, 450, 330);
	        stetec.drawLine(310, 190, 590, 190);
	        
	        Shape linka = new Line2D.Double(x0+x1*20, y0-y1*20, x0+x2*20, y0-y2*20); // VYKRESLOVANI DODELAT
	        stetec.setColor(Color.RED);
	        stetec.draw(linka);
	    }
	  
	public static void main(String[] args) {
		open(Vykresleni.class);
	}

}

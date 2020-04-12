package lomeneVyrazy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;

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
	public float x1;
	public float y1;
	public float x2;
	public float y2;
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
	public void vypocitat() {
		String Vyraz = fldVyraz.getText();
		/*String priklad = Vyraz.substring(Vyraz.indexOf("=", 0) + 1, Vyraz.length() + 1);
		x1 = 0 + 450;
		y1 = Float.valueOf(priklad.replaceAll("x", "0")) + 190;
		x2 = 1 + 450;
		y2 = Float.valueOf(priklad.replaceAll("x", "1")) + 190;*/
		x1 = 40 + 450;
		x2 = 45 + 450;
		y1 = 30 + 190;
		y2 = 45 + 190;
	}
/*
	public void vykreslit(Graphics g) {
		Graphics2D stetec = (Graphics2D) g;
		stetec.setColor(Color.RED);
		stetec.drawLine(120, 50, 360, 50);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        vykreslit(g);
    }
	*/
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
	        stetec.drawLine(450, 50, 450, 330);
	        stetec.drawLine(310, 190, 590, 190);
	        Shape linka = new Line2D.Float(x1, y1, x2, y2); // VYKRESLOVANI DODELAT
	        stetec.setColor(Color.RED);
	        stetec.draw(linka);
	    }
	  
	public static void main(String[] args) {
		open(Vykresleni.class);
	}

}

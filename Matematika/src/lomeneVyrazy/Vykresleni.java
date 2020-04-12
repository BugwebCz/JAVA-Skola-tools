package lomeneVyrazy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.utilities.gui.AnnotatedFrame;
import javax.utilities.gui.OnClick;
import javax.utilities.gui.Widget;
import javax.utilities.gui.Window;

@Window(title = "Lomené výrazy", cols = 10, rows = 5)
public class Vykresleni extends AnnotatedFrame {
	
	boolean stav = false;
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
	
	////////////////////////////////////////////////////
	
	@OnClick("btnVykreslit")
	public void vypocitat() {
		String Vyraz = fldVyraz.getText();
		/*Hledani deleni*/
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
    }*/
	
	public static void main(String[] args) {
		open(Vykresleni.class);

	}

}

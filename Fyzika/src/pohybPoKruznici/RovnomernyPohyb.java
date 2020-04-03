package pohybPoKruznici;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.utilities.gui.AnnotatedFrame;
import javax.utilities.gui.OnClick;
import javax.utilities.gui.Widget;
import javax.utilities.gui.Window;

@Window(title="Rovnoměrný pohyb", rows = 4, cols = 4)
public class RovnomernyPohyb extends AnnotatedFrame {

	@Widget(x=1,y=1,cols = 2, text="Rychlost (v):")
	JLabel lblRychlost;
	
	@Widget(x=3,y=1,cols = 2)
	JTextField txtRychlost;
	
	@Widget(x=1,y=2,cols=2, text="Dráha (s):")
	JLabel lblDraha;
	
	@Widget(x=3,y=2,cols = 2)
	JTextField txtDraha;
	
	@Widget(x=1,y=3,cols=2, text = "Čas (t):")
	JLabel lblCas;
	
	@Widget(x=3,y=3,cols = 2)
	JTextField txtCas;
	
	@Widget(x=1,y=4,cols=4, text="Vypočítat", defaultEnterButton = true)
	JButton btnKalkulace;
	
	@OnClick("btnKalkulace")
	public void kalkulace() {
		if (txtRychlost.getText().trim().length() == 0 && txtCas.getText().trim().length() == 0 && txtDraha.getText().trim().length() == 0)  {
			showErrorDialog("Chyba", "Nebyla zadána ani jedna hodnota");
			return;
		} 
		if (txtRychlost.getText().trim().length() != 0 && txtCas.getText().trim().length() != 0 && txtDraha.getText().trim().length() != 0) {
			showErrorDialog("Chyba", "Není co počítat");
			return;
		}
		
		//Výpočty
		
		///Rychlost
		if (txtRychlost.getText().trim().length() == 0) {
			if (txtCas.getText().trim().length() == 0 || txtDraha.getText().trim().length() == 0) {
				showErrorDialog("Chyba", "Špatně vyplněné hodnoty");
				return;
			}
			float cas = Float.parseFloat(txtCas.getText());
			float draha = Float.parseFloat(txtDraha.getText());
			
			float rychlost = draha / cas;
			
			txtRychlost.setText(""+rychlost); //takhle se obchazi only-String
		}
		///Čas
		if (txtCas.getText().trim().length() == 0) {
			if (txtRychlost.getText().trim().length() == 0 || txtDraha.getText().trim().length() == 0) {
				showErrorDialog("Chyba", "Špatně vyplněné hodnoty");
				return;
			}
			float rychlost = Float.parseFloat(txtRychlost.getText());
			float draha = Float.parseFloat(txtDraha.getText());
			
			float cas = draha / rychlost;
			
			txtCas.setText(""+cas);
		}
		///Dráha
		if (txtDraha.getText().trim().length() == 0) {
			if (txtCas.getText().trim().length() == 0 || txtRychlost.getText().trim().length() == 0) {
				showErrorDialog("Chyba", "Špatně vyplněné hodnoty");
				return;
			}
			float rychlost = Float.parseFloat(txtRychlost.getText());
			float cas = Float.parseFloat(txtCas.getText());
			
			float draha = rychlost * cas;
			
			txtDraha.setText(""+draha);
		}
	}
	
	public static void main(String[] args) {
		open(RovnomernyPohyb.class);
	}

}

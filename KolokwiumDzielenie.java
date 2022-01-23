import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class KolokwiumDzielenie extends JFrame implements ActionListener  {
	
	JButton start;
	JTextField liczba_1;
	JTextField liczba_2;
	JButton podzielne;
	JButton niePodzielne;
	JTextField wynik;
	
    Random losowy = new Random();
	public int minimum = 0;
	public int maksimum = 100;
	public int losowaLiczba_1 = losowy.nextInt(maksimum-minimum) + minimum;
	public int losowaLiczba_2 = losowy.nextInt(maksimum-minimum) + minimum;

	public static void main(String[] args) {
		KolokwiumDzielenie frame = new KolokwiumDzielenie();
		frame.initUI();
	}

	private void initUI() {
		
		start = new JButton("Start");
		start.addActionListener(this);
		liczba_1 = new JTextField();
		liczba_2 = new JTextField();
		podzielne = new JButton("S¹ podzielne bez reszty");
		podzielne.addActionListener(this);
		niePodzielne = new JButton("Nie s¹ podzielne bez reszty");
		niePodzielne.addActionListener(this);
		wynik = new JTextField();
		
		this.add(start);
		this.add(liczba_1);
		this.add(liczba_2);
		this.add(podzielne);
		this.add(niePodzielne);
		this.add(wynik);
		
		this.setLayout(new GridLayout(6, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setTitle("Zgadywanie Liczby");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(start.equals(e.getSource())) {
			rozpocznij();
		}
		else if(podzielne.equals(e.getSource())) {
			czyPodzielne();
		}
		
		else {
			czyNiePodzielne();
		}
		
	}

	public void czyNiePodzielne() {
		
		if (!((losowaLiczba_1 %losowaLiczba_2) == 0)) {
			wynik.setText("Gratulacje! Te liczby nie dziel¹ siê bez reszty ");
		} else {
			wynik.setText("Niestety jesteœ w b³êdzie! Te liczby dziel¹ sie bez reszty.");
		}
	}

	public void czyPodzielne() {
		
		if (losowaLiczba_1 % losowaLiczba_2 == 0) {
			wynik.setText("Gratulacje! Te liczby w rzeczy samej dziel¹ siê bez reszty. ");
		}
		
		else {
			wynik.setText("Niestety jesteœ w b³êdzie! Te liczby nie dziel¹ siê bez reszty. ");
		}
		
	}

	public void rozpocznij() {
		
		liczba_1.setText(String.valueOf(losowaLiczba_1));
		liczba_2.setText(String.valueOf(losowaLiczba_2));
		
	}

}

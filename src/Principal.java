import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		JogoDaVelha janela = new JogoDaVelha();
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(850, 580);
		janela.setVisible(true);
	}
}

class JogoDaVelha extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private GridLayout layout;
	private JButton[] buttons;
	private Boolean isX;
	private Boolean isOver;
	private Font font;

	public JogoDaVelha() {
		super("Jogo da Velha");
		this.layout = new GridLayout(3, 3);
		this.buttons = new JButton[9];
		
		setLayout(this.layout);
		
		this.font = new Font("Serif", Font.PLAIN, 24);
		
		iniciar(true);
	}
	
	private void iniciar(Boolean eInicio) {
		this.isX = false;
		this.isOver = false;
		for(Integer i = 0; i < this.buttons.length; i++) {
			if(eInicio) {
				this.buttons[i] = new JButton();
				this.buttons[i].addActionListener(this);
				this.buttons[i].setFont(this.font);
				add(this.buttons[i]);
			}
			else {
				this.buttons[i].setText("");
			}
			this.buttons[i].setBackground(Color.LIGHT_GRAY);
		}
	}
	
	private Boolean win() {
		return (this.buttons[0].getText().equals(this.buttons[1].getText()) && this.buttons[1].getText().equals(this.buttons[2].getText())) && !this.buttons[2].getText().equals("") ||
		   (this.buttons[3].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[5].getText())) && !this.buttons[5].getText().equals("") ||
		   (this.buttons[6].getText().equals(this.buttons[7].getText()) && this.buttons[7].getText().equals(this.buttons[8].getText())) && !this.buttons[8].getText().equals("") ||
		   (this.buttons[0].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[8].getText())) && !this.buttons[8].getText().equals("") ||
		   (this.buttons[6].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[2].getText())) && !this.buttons[2].getText().equals("") ||
		   (this.buttons[0].getText().equals(this.buttons[3].getText()) && this.buttons[3].getText().equals(this.buttons[6].getText())) && !this.buttons[6].getText().equals("") ||
		   (this.buttons[1].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[7].getText())) && !this.buttons[7].getText().equals("") ||
		   (this.buttons[2].getText().equals(this.buttons[5].getText()) && this.buttons[5].getText().equals(this.buttons[8].getText())) && !this.buttons[8].getText().equals("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)e.getSource();
		if(!this.isOver && buttonPressed.getText().equals("")) {
			if(this.isX) buttonPressed.setText("X");
			else buttonPressed.setText("0");
			if(win()) {
				if(this.buttons[0].getText().equals(this.buttons[1].getText()) && this.buttons[1].getText().equals(this.buttons[2].getText()) && !this.buttons[2].getText().equals("")) {
					this.buttons[0].setBackground(Color.GREEN);
					this.buttons[1].setBackground(Color.GREEN);
					this.buttons[2].setBackground(Color.GREEN);
				}
				else if(this.buttons[3].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[5].getText()) && !this.buttons[5].getText().equals("")) {
					this.buttons[3].setBackground(Color.GREEN);
					this.buttons[4].setBackground(Color.GREEN);
					this.buttons[5].setBackground(Color.GREEN);
				}
				else if(this.buttons[6].getText().equals(this.buttons[7].getText()) && this.buttons[7].getText().equals(this.buttons[8].getText()) && !this.buttons[8].getText().equals("")) {
					this.buttons[6].setBackground(Color.GREEN);
					this.buttons[7].setBackground(Color.GREEN);
					this.buttons[8].setBackground(Color.GREEN);
				}
				else if(this.buttons[0].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[8].getText()) && !this.buttons[8].getText().equals("")) {
					this.buttons[0].setBackground(Color.GREEN);
					this.buttons[4].setBackground(Color.GREEN);
					this.buttons[8].setBackground(Color.GREEN);
				}
				else if(this.buttons[6].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[2].getText()) && !this.buttons[2].getText().equals("")) {
					this.buttons[6].setBackground(Color.GREEN);
					this.buttons[4].setBackground(Color.GREEN);
					this.buttons[2].setBackground(Color.GREEN);
				}
				else if(this.buttons[0].getText().equals(this.buttons[3].getText()) && this.buttons[3].getText().equals(this.buttons[6].getText()) && !this.buttons[6].getText().equals("")) {
					this.buttons[0].setBackground(Color.GREEN);
					this.buttons[3].setBackground(Color.GREEN);
					this.buttons[6].setBackground(Color.GREEN);
				}
				else if(this.buttons[1].getText().equals(this.buttons[4].getText()) && this.buttons[4].getText().equals(this.buttons[7].getText()) && !this.buttons[7].getText().equals("")) {
					this.buttons[1].setBackground(Color.GREEN);
					this.buttons[4].setBackground(Color.GREEN);
					this.buttons[7].setBackground(Color.GREEN);
				}
				else if(this.buttons[2].getText().equals(this.buttons[5].getText()) && this.buttons[5].getText().equals(this.buttons[8].getText()) && !this.buttons[8].getText().equals("")) {
					this.buttons[2].setBackground(Color.GREEN);
					this.buttons[5].setBackground(Color.GREEN);
					this.buttons[8].setBackground(Color.GREEN);
				}
				JOptionPane.showMessageDialog(null, String.format("%s won the match.", (this.isX ? "X" : "O")));
				iniciar(false);
				return;
			}
			this.isX = !this.isX;
		}
	}
}
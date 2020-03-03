import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtGuess;
	private JLabel lblOutput; 
	private int theNumber;
	private int numberOfTries;
	private JButton btnPlayAgain;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		numberOfTries ++ ;
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is too low. Try again.";
			}else if (guess > theNumber) {
				message = guess + " is too high. try again.";
			}else {
				message = guess + " is correct. You win after " + numberOfTries + " tries! Let's play again!";
				btnPlayAgain.setVisible(true);
			}
		} catch (Exception e) {
			message = "WRONG! Please, enter a whole number between 1 and 100";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int) (Math.random() * 100 +1);
		numberOfTries = 0;
		btnPlayAgain.setVisible(false);
		txtGuess.setText("");
		lblOutput.setText("Enter a number above and click Guess!");
	}
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Apple Chancery", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 26, 438, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(6, 82, 252, 16);
		getContentPane().add(lblNewLabel_1);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setBounds(270, 77, 130, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(166, 124, 117, 29);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(6, 179, 438, 16);
		getContentPane().add(lblOutput);
		
		btnPlayAgain = new JButton("Play Again");
		
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnPlayAgain.setBounds(72, 221, 117, 29);
		getContentPane().add(btnPlayAgain);
		
		JButton btnEndGame = new JButton("End Game");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEndGame.setBounds(261, 221, 117, 29);
		getContentPane().add(btnEndGame);
	}

	public static void main(String[] args) {
		GuessingGame theGame =  new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}

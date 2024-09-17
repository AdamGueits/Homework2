package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class Main {

	private JFrame frame;
	private JTextField tileInput;
	private JTextArea outputArea;
	private JButton btn;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		buttonPress();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		outputArea = new JTextArea();
		outputArea.setLineWrap(true);
		outputArea.setBounds(103, 215, 429, 118);
		frame.getContentPane().add(outputArea);

		tileInput = new JTextField();
		tileInput.setBounds(146, 124, 355, 20);
		frame.getContentPane().add(tileInput);
		tileInput.setColumns(10);

		JLabel lblNewLabel = new JLabel("Scrabble Tile Scrambler");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(195, 36, 293, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter 7 Letters");
		lblNewLabel_1.setBounds(146, 99, 269, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Possible Arrangements");
		lblNewLabel_2.setBounds(146, 190, 269, 14);
		frame.getContentPane().add(lblNewLabel_2);

		btn = new JButton("Scramble");
		btn.setBounds(263, 156, 89, 23);
		frame.getContentPane().add(btn);

		scrollPane = new JScrollPane(outputArea);
		scrollPane.setBounds(101, 215, 431, 118);
		frame.getContentPane().add(scrollPane);

	}

	private void buttonPress() {
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tiles = tileInput.getText();
				outputArea.setText("");
				// Check if input is longer than 7 letters
				if (tiles.length() > 7) {
					outputArea.setText("Error: Please Enter No More Than 7 Letters.");
					return;
				}
				// Check if input contains non letter characters
				if (!tiles.matches("[A-Za-z]+")) {
					outputArea.setText("Error: Must Be Letters Only.");
					return;
				}
				// Creates a List of all the possible permutations of the input
				List<String> permutations = getPermutations(tiles);
				if (permutations.isEmpty()) {
					outputArea.setText("No arrangements found.");
				} else {
					for (String permutation : permutations) {
						outputArea.append(permutation + ",");
					}

				}
			}
		});
	}

	// When run, produces a list of all permutations
	private List<String> getPermutations(String str) {
		List<String> permutations = new ArrayList<>();
		permute(str.toCharArray(), 0, permutations);
		return permutations;
	}

	private void permute(char[] arr, int k, List<String> permutations) {
		// Base Case
		if (k == arr.length - 1) {
			permutations.add(new String(arr));
		} else {
			// Swaps letters in input to give new permutations
			for (int i = k; i < arr.length; i++) {
				swap(arr, i, k);
				permute(arr, k + 1, permutations);
				swap(arr, k, i);
			}
		}
	}

	// Method to swap two given characters
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

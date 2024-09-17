package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Main {

	private JFrame frame;
	private JTextField passIn;
	private JButton btn;
	private JTextArea outputArea;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		passIn = new JTextField();
		passIn.setBounds(73, 111, 309, 20);
		frame.getContentPane().add(passIn);
		passIn.setColumns(10);
		
		outputArea = new JTextArea();
		outputArea.setLineWrap(true);
		outputArea.setBounds(73, 175, 333, 52);
		frame.getContentPane().add(outputArea);
		
		JLabel lblNewLabel = new JLabel("Please Enter A Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(111, 25, 252, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Must Be Between 8 and 12 Characters");
		lblNewLabel_1.setBounds(118, 63, 245, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Input");
		lblNewLabel_2.setBounds(17, 114, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Output");
		lblNewLabel_3.setBounds(17, 190, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		btn = new JButton("Check Password");
		btn.setBounds(161, 141, 144, 23);
		frame.getContentPane().add(btn);
	}
	 private static int getLargestBlockLength(String password) {
	        int maxBlockLength = 0;
	        int currentBlockLength = 1;

	        // Iterate through the password to find the largest block
	        for (int i = 1; i < password.length(); i++) {
	            if (password.charAt(i) == password.charAt(i - 1)) {
	                currentBlockLength++;
	            } else {
	                if (currentBlockLength > maxBlockLength) {
	                    maxBlockLength = currentBlockLength;
	                }
	                currentBlockLength = 1;
	            }
	        }
	        if (currentBlockLength > maxBlockLength) {
	            maxBlockLength = currentBlockLength;
	        }

	        return maxBlockLength;
	    }
	        private void buttonPress() {
	    		btn.addActionListener(new ActionListener(){
	    			public void actionPerformed(ActionEvent e) {
	    				String password = passIn.getText();
	    				System.out.println(password);
	    				 if (password.length() < 8 || password.length() > 12) {
	    					 outputArea.setText("Error: Password must be between 8 and 12 characters.");
	    			            return;
	    			        }
	    			        
	    			        if (password.contains(" ")) {
	    			        	outputArea.setText("Error: Password must not contain spaces.");
	    			            return;
	    			        }

	    			        // Compute the length of the largest block
	    			        int largestBlockLength = getLargestBlockLength(password);

	    			        // Display the length of the largest block and suggest actions
	    			        
	    			        
	    			        if (largestBlockLength <= 2) {
	    			        	outputArea.setText(("This is a decent password."));
	    			        } else {
	    			        	outputArea.setText("The largest block is "+largestBlockLength+" Consider shrinking the block to improve password strength.");
	    			        }
	    			    }
	    			        	
	    				
	    					
	    			
	    		});
	    	      }
	        }



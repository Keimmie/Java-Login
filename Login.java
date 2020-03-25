/*
 * Summary: This application will record the login attempts of users
 * 
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   


public class Login extends JFrame {
	static JTextField name,password; // set variables for text fields
	static JButton submit,reset; //set variables to the JButton
	static JFrame frame;
	
	public static void main(String[] args) {
		new Login(); // Open the "login" method
	}
	
	Login (){
		JFrame frame= new JFrame("Homework 1");   //create a new frame
	    
	    name=new JTextField("Insert username Here"); //create the username textfield
	    name.setBounds(50,100,200,30);  // set the size of the username box
	    password=new JTextField("Insert Password Here");   //creates a password textfield
	    password.setBounds(50,150,200,30); // set the size of the password box
	    
	    submit=new JButton("submit"); // Create the submit button 
	    submit.setBounds(50,200,80,30); // Set the size of the submit button  
	    reset = new JButton("Clear Text"); // Creates the reset button
	    reset.setBounds(150,200,100,30); // Set the size of the reset button
	    	   
	    frame.add(name); // Add the name textfield to the frame
	    frame.add(password); // Add the password textfield to the frame
	    frame.add(submit); // Add the submit button to the frame
	    frame.add(reset); // add the reset button to the frame
	    frame.setSize(400,400);  // Set the size of the frame
	    frame.setLayout(null); // set the container layout manager
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Stop the application on close
	    frame.setVisible(true); // set the size of the frame to be visible
	    
	 
	    check(); // Run the "check" method
	}

	public static void check() {
		// Submit button click reaction
		submit.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  // Set the format to display the date/time
    	    LocalDateTime now = LocalDateTime.now();  //Get the current date/time
    	    String username = name.getText(); // set a user name checker
    		String pass = password.getText(); //set a password checker
    		JOptionPane pane = new JOptionPane();
    		FileWriter writer = null;
			try {
				writer = new FileWriter("log.txt", true); // create a text file name log
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedWriter bufferedWriter = new BufferedWriter(writer);

    		 if (username.equals("Keimmie") && pass.equals("password123")) {	
    			 pane.showMessageDialog(frame, "Welcome " + username + "! You have successfully logged in");// Display a message to the user
    			 System.out.println("User: " + username + " successfully logged in" ); // Print in the console log for debugging
    			
    			 try {
 					bufferedWriter.write("Username: " + username + " / Login Status: Success / Time: " + dtf.format(now)); // Print words to the text file 		 	   			    			  	 
 					bufferedWriter.newLine(); // skip a line
 					bufferedWriter.close(); // Close the text file
 					
    			 } catch (IOException e) {
 					e.printStackTrace();
 				}
    			 	    			 
    		 } else {
    			 pane.showMessageDialog(frame,"The information inserted is invalid. Please try again. ");
    			 	System.out.println("Invalid login attempt by "+ username); // Show in the console log for debugging
    			 	try {
						bufferedWriter.write("Username: " + username + " / Login Status: Failed / Time: " + dtf.format(now)); //Enter the output to the text file
						bufferedWriter.newLine(); //Skip a line
	 					bufferedWriter.close(); // Close the file
					} catch (IOException e) {
						e.printStackTrace();
					} 		 	   			    			  	 
    		 	}
    	}	    	
    });
    
	    //Reset button click reaction
	    reset.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            name.setText(null); // clear the name textfield
	            password.setText(null); //clear the password textfield
	        }
	    }); 
    
    }

}

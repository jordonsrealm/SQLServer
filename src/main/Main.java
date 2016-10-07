package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Main extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JTextField first_name,
					   last_name,
					   middle_name,
					   birth_date,
					   favorite_color,
					   address,
					   city,
					   state,
					   zip_code,
					   email,
					   phone,
					   v_make,
					   v_model,
					   v_year;
	
	private JButton save_button;
	
	
	public Main(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		populate(this);		// populate the JFrame with 
		this.pack();
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		Main main = new Main();
		
	}
	
	private void populate(Main m){
		
		first_name = new JTextField(30);
		first_name.setBorder(BorderFactory.createTitledBorder("First Name"));
		
		last_name = new JTextField(30);
		last_name.setBorder(BorderFactory.createTitledBorder("Last Name"));
		
		middle_name = new JTextField(30);
		middle_name.setBorder(BorderFactory.createTitledBorder("Middle Initial"));
		
		birth_date = new JTextField(30);
		birth_date.setBorder(BorderFactory.createTitledBorder("Birth Date"));
		
		favorite_color = new JTextField(30);
		favorite_color.setBorder(BorderFactory.createTitledBorder("Favorite Color"));
		
		address = new JTextField(30);
		address.setBorder(BorderFactory.createTitledBorder("Address"));
		
		city = new JTextField(30);
		city.setBorder(BorderFactory.createTitledBorder("City"));
		
		state = new JTextField(30);
		state.setBorder(BorderFactory.createTitledBorder("State"));
		
		zip_code = new JTextField(30);
		zip_code.setBorder(BorderFactory.createTitledBorder("Zip Code"));
		
		email = new JTextField(30);
		email.setBorder(BorderFactory.createTitledBorder("Email"));
		
		phone = new JTextField(30);
		phone.setBorder(BorderFactory.createTitledBorder("Phone"));
		
		v_make = new JTextField(30);
		v_make.setBorder(BorderFactory.createTitledBorder("Vehicle Make"));
		
		v_model = new JTextField(30);
		v_model.setBorder(BorderFactory.createTitledBorder("Vehicle Model"));
		
		v_year = new JTextField(30);
		v_year.setBorder(BorderFactory.createTitledBorder("Vehicle Year"));
		
		this.setLayout(new GridLayout( 15, 1));
		
		// 15th cell is used for the button which is
		// contained in a new 
		save_button = new JButton("Save");
		
		save_button.addActionListener(this);		// Adds actionlistener to button
		
		// Adds the fields to the JFrame
		this.add(this.first_name);
		this.add(this.last_name);
		this.add(this.middle_name);
		this.add(this.birth_date);
		this.add(this.favorite_color);
		this.add(this.address);
		this.add(this.city);
		this.add(this.state);
		this.add(this.zip_code);
		this.add(this.email);
		this.add(this.phone);
		this.add(this.v_make);
		this.add(this.v_model);
		this.add(this.v_year);
		this.add(save_button);
		
	}
	
	private void readInformation(){
		
		Connection con = null;
		
		String newjdbcurl = "jdbc:sqlserver://"
				+ "RTIJERINA6520\\SQL2014:"
				+ "62165;"
				+ "databaseName=MyDataBase;"
				+ "integratedSecurity=true;";
		
		//
		// Used to ensure that the class can be found for the JDBC driver
		//
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
		//
		// Used for creating a connection to communicate with SQL Server
		//
		try{
			con = DriverManager.getConnection(newjdbcurl);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		//
		// Executes the query we want to update/get the information we want
		//
		try {
			PreparedStatement pst = con.prepareStatement("select * from Personal_Information");
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				String value = rs.getString("First_Name");
				first_name.setText( value );
				
				value = rs.getString("Last_Name");
				last_name.setText( value );
				
				value = rs.getString("Middle_Name");
				middle_name.setText( value );
				
				value = rs.getString("Birth_Date");
				birth_date.setText(value);
				
				value = rs.getString("Favorite_Color");
				favorite_color.setText(value);
				
				value = rs.getString("Address");
				address.setText(value);
				
				value = rs.getString("City");
				city.setText(value);
				
				value = rs.getString("State");
				state.setText( value );
				
				value = rs.getString("Zip_Code");
				zip_code.setText(value);
				
				value = rs.getString("Email");
				email.setText(value);
				
				value = rs.getString("Phone");
				phone.setText(value);
				
				value = rs.getString("V_Make");
				v_make.setText(value);
				
				value = rs.getString("V_Model");
				v_model.setText( value );
				
				value = rs.getString("V_Year");
				v_year.setText(value);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		
		//
		// Ensures to close the connection to the database
		//
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//
	// Saves any information that is contained in the textfields
	//
	public void saveInformation(){
		Connection con = null;
		
		String newjdbcurl = "jdbc:sqlserver://"
				+ "RTIJERINA6520\\SQL2014:"
				+ "62165;"
				+ "databaseName=MyDataBase;"
				+ "integratedSecurity=true;";
		
		//
		// Used to ensure that the class can be found for the JDBC driver
		//
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
		//
		// Used for creating a connection to communicate with SQL Server
		//
		try{
			con = DriverManager.getConnection(newjdbcurl);
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		//
		// Executes the query we want to update/get the information we want
		//
		
		/**
		 * PreparedStatement pst = con.prepareStatement("select * from Personal_Information");
		 * ResultSet rs = pst.executeQuery();  //For getting back results
		 * pst.execute();		//Just for updating or inserting information into the DB
		 * */
		
		
		try {
			PreparedStatement pst = con.prepareStatement("");
			
			String FIRST_NAME = first_name.getText();
			String LAST_NAME = last_name.getText();
			String MIDDLE_INITIAL = middle_name.getText();
			String BIRTH_DATE = birth_date.getText();
			String FAVORITE_COLOR = favorite_color.getText();
			String ADDRESS = address.getText();
			String CITY = city.getText();
			String ZIP_CODE = zip_code.getText();
			String EMAIL = email.getText();
			String PHONE = phone.getText();
			String V_MAKE = v_make.getText();
			String V_MODEL = v_model.getText();
			String V_YEAR = v_year.getText();
				
			
			
				pst = con.prepareStatement("INSERT INTO Personal_Information "
										   + "VALUES (" + FIRST_NAME +  ","
										   				+ LAST_NAME +  ","
										   				+ MIDDLE_INITIAL +  ","
										   				+ BIRTH_DATE +  ","
										   				+ FAVORITE_COLOR +  ","
										   				+ ADDRESS +  ","
										   				+ CITY +  ","
										   				+ ZIP_CODE +  ","
										   				+ EMAIL + ","
										   				+ PHONE +  ","
										   				+ V_MAKE +  ","
										   				+ V_MODEL +  ","
										   				+ V_YEAR);
				pst.execute();
			
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		
		//
		// Ensures to close the connection to the database
		//
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// Takes care of the button click
		saveInformation();
	}
	
	

}

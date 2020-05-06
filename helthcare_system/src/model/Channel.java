package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Channel {

	public Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/healthcare", "root", "");

			System.out.print("\nSuccessfully connected");
		} catch (Exception e) {
			System.out.print("\nNot connected");

			e.printStackTrace();
		}
		return con;
	}

	public String insertChannels(String patient_name, String patient_age, String contact, String doctor_name, String hospital_name, String date, String time) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "\nError while connecting to the database";
			}

			String query = "insert into doctor_channeling values(?, ?, ?, ?, ?, ?,?,?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, patient_name);
			preparedStmt.setString(3, patient_age);
			preparedStmt.setString(4, contact);
			preparedStmt.setString(5, doctor_name);
			preparedStmt.setString(6, hospital_name);
			preparedStmt.setString(7, date);
			preparedStmt.setString(8, time);

			preparedStmt.execute();
			con.close();

			String newChannels = readChannels(); 
			output = "\nYou have Inserted successfully";
			output = "{\"status\":\"success\", \"data\": \"" + newChannels + "\"}"; 

		} catch (Exception e) {
			/*output = "\nError while inserting12";*/
			
			/*output = "{\"status\":\"error\", \"data\": \"Error while inserting the Channeling Details.\"}"; 
			System.err.println(e.getMessage());
			System.out.println("not inserted");*/
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the item.\"}";
			System.err.println(e.getMessage());  
		}

		return output;

	}

	public String updateChannels(String channeling_id, String patient_name, String patient_age,String contact,String doctor_name,String hospital_name, String date, String time) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "\nError while connecting to the database";
			}

			String query = "update doctor_channeling set patient_name=?, patient_age=?, contact=?, doctor_name=?, hospital_name=?, date=?,time=? where channeling_id=?";

			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, patient_name);
			preparedStmt.setString(2, patient_age);
			preparedStmt.setString(3, contact);
			preparedStmt.setString(4, doctor_name);
			preparedStmt.setString(5, hospital_name);
			preparedStmt.setString(6, date);
			preparedStmt.setString(7, time);
			preparedStmt.setInt(8, Integer.parseInt(channeling_id));

			preparedStmt.execute();
			con.close();

			String newChannels = readChannels();
			 output = "{\"status\":\"success\", \"data\": \"" +	 newChannels + "\"}"; 
			 
			/*output = "\nYou have Updated successfully";
			System.out.print("Updated");*/

		} catch (Exception e) {
			output = "\nError while updatinf";
			//System.out.println("not ups");

			output = "{\"status\":\"error\", \"data\":"
					+ "\"Error while updating the Channel.\"}";
					 System.err.println(e.getMessage()); 
		}

		return output;

	}

	public String readChannels() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			output = "<table border=\"1\"><tr><th>Patient Name</th>" + "<th>Patient Age</th>"
					+ "<th>Contact</th>" + "<th>Doctor</th>" + "<th>Hospital</th>" + "<th>Date</th><th>Time</th>" + "<th>Update</th><th>Remove</th>"
					+ "</tr>";

			String query = "select * from doctor_channeling";
			Statement stmt = (Statement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String channeling_id = Integer.toString(rs.getInt("channeling_id"));
				String patient_name = rs.getString("patient_name");
				String patient_age = rs.getString("patient_age");
				String contact = rs.getString("contact");
				String doctor_name = rs.getString("doctor_name");
				String hospital_name = rs.getString("hospital_name");
				String date = rs.getString("date");
				String time = rs.getString("time");
				
				
				

				output += "<tr><td><input id=\"hidChannelIDUpdate\" name=\"hidChannelIDUpdate\"     type=\"hidden\" value=\""
						+ channeling_id + "\">" + patient_name + "</td>";
				output += "<td>" + patient_age + "</td>";
				output += "<td>" + contact + "</td>";
				output += "<td>" + doctor_name + "</td>";
				output += "<td>" + hospital_name + "</td>";
				output += "<td>" + date + "</td>";
				output += "<td>" + time + "</td>";

				output += "<td><input name='btnUpdate' type='button'    value='Update' class='btnUpdate btn btn-secondary'></td>"
						+ "<td><input name='btnRemove' type='button' 	value='Remove' class='btnRemove btn btn-danger' data-channeling_id='" 
						+ channeling_id + "'>" + "</td></tr>"; 
			}

			con.close();

			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the items.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteChannels(String channeling_id) {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "delete from doctor_channeling where channeling_id=?";

			PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);

			// binding values
			preparedStmt.setInt(1, Integer.parseInt(channeling_id));
			// execute the statement preparedStmt.execute(); con.close();

			// execute the statement
			preparedStmt.execute();
			con.close();

			String newChannels = readChannels();
			 output = "{\"status\":\"success\", \"data\": \"" + newChannels + "\"}"; 

			/*output = "You have Deleted successfully";*/
			

		} catch (Exception e) {
			/*output = "Error while deleting the channel.";
			System.err.println(e.getMessage());*/
			
			output = "{\"status\":\"error\", \"data\": \"Error while deleting the channeling details.\"}";
					 System.err.println(e.getMessage()); 
		}
		return output;
	}

}

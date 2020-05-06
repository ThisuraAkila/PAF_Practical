<%@page import="model.Channel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Doctor Appointments</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">


</head>
<body>
<h1>Make an Appointment</h1>

	<form id="formChannel" name="formChannel" method="post" action="channels.jsp">
	
	
		
					<!-- PATIENT NAME -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Patient Name :
							</span>
						</div>
						<input type="text" id="patient_name" name="patient_name">
					</div>
					
					
					
		 			<!-- PATIENT AGE -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName"> Age :
							</span>
						</div>
						<input type="text" id="patient_age" name="patient_age">
					</div>
					
					
					
					<!-- CONTACT NUMBER -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Contact Number :
							</span>
						</div>
						<input type="text" id="contact" name="contact">
					</div>
					
					
					
					<!-- DOCTOR NAME -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Doctor Name :
							</span>
						</div>
						<input type="text" id="doctor_name" name="doctor_name">
					</div>
					
					
					
					<!-- HOSPITAL NAME -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Hospital Name :
							</span>
						</div>
						<input type="text" id="hospital_name" name="hospital_name">
					</div>
					
					
					
					
		 			<!-- DATE -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">

						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Channeling Date : </span>
						</div>
						<input type="text" id="date" name="date">
					</div>
		 
		 
		 
		 
		 			<!-- TIME -->
					<div class="input-group input-group-sm mb-3" style="margin-left: 80px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="lblName">Channeling Time : </span>
						</div>
						<select id="time" name="time">
							<option value="">----- Select Time -----</option>
							<option value="6.00 - 9.00 AM">6.00 - 9.00 AM</option>
							<option value="9.00 - 12.00 AM">9.00 - 12.00 AM</option>
							<option value="12.00 - 3.00 PM">12.00 - 3.00 PM</option>
							<option value="3.00 - 6.00 PM">3.00 - 6.00 PM</option>
						</select>
						<!--  <input type="text" id="time" name="time">-->
					</div>
		 
		 
		
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					
					<input name="btnReset" type="reset" value="Reset" class="btn btn-primary"  style="margin-left: 80px;width: 140px;"></th></tr>
					<input	id="btnSave" name="btnSave" type="button" value="Save"class="btn btn-primary" style="width: 140px;">
					<input type="hidden"id="hidChannelIDSave" name="hidChannelIDSave" value="">
	</form>
	
<div id="alertSuccess" class="alert alert-success"></div>
	<div id="alertError" class="alert alert-danger"></div>
	
	<br>
	
	<br>
	<div id="divChannnelsGrid">
	<%
		Channel channelObj = new Channel();
		out.print(channelObj.readChannels());
	%>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="Components/main.js"></script> 
	
</body>
</html>
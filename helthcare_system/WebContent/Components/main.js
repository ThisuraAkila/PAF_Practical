
$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "")  
	{  
		$("#alertSuccess").hide();  
	}  
	$("#alertError").hide();
});

$(document).on("click","#btnSave",function(event) 
		{
			$("#alertSuccess").text("");
			$("#alertSuccess").hide();
			$("#alertError").text("");
			$("#alertError").hide();

			var status = validateChannelForm();

			if (status != true) {
				$("#alertError").text(status);
				$("#alertError").show();
				return;
			}
			
			$("#formChannel").submit();
	
		});

$(document).on("click",".btnUpdate",function(event) 
		{
			$("#hidChannelIDSave").val($(this).closest("tr").find('#hidChannelIDUpdate').val());
			$("#patient_name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#patient_age").val($(this).closest("tr").find('td:eq(1)').text());
			$("#contact").val($(this).closest("tr").find('td:eq(2)').text());
			$("#doctor_name").val($(this).closest("tr").find('td:eq(3)').text());
			$("#hospital_name").val($(this).closest("tr").find('td:eq(4)').text());
			$("#date").val($(this).closest("tr").find('td:eq(5)').text());
			$("#time").val($(this).closest("tr").find('td:eq(6)').text());
		});


$(document).on("click", ".btnRemove", function(event) 
{ 
	$(this).closest(".channel").btnRemove();  
	$("#alertSuccess").text("Removed successfully.");
	$("#alertSuccess").show();
}); 


function validateChannelForm() 
{
	if ($("#patient_name").val().trim() == "") 
	{
		return "Insert Patient Name.";
	}
	
	if ($("#patient_age").val().trim() == "") 
	{
		return "Insert Patient Age.";
	}
	
	if ($("#contact").val().trim() == "") 
	{
		return "Insert Contact number.";
	}
	
	if ($("#doctor_name").val().trim() == "") 
	{
		return "Insert Doctor name.";
	}

	if ($("#hospital_name").val().trim() == "") 
	{
		return "Insert Hospital name.";
	}

	if ($("#date").val().trim() == "")
	{
		return "Insert Date.";
	}
	if ($("#time").val().trim() == "") 
	{
		return "Insert Channeling Time.";
	}
	
	return true;
}

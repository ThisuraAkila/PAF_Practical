
$(document).ready(function() {
	//if ($("#alertSuccess").text().trim() == "")  
	 
	$("#alertSuccess").hide();  	 
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
			console.log("\nTryingto process...");

			var type = ($("#hidChannelIDSave").val() == "") ? "POST" : "PUT";
			console.log(type);
			
			$.ajax({
					 url : "ChannelsAPI",
					 type : type,
					 data : $("#formChannel").serialize(),
					 dataType : "text",
					 complete : function(response, status)
					 {
						 onChannelSaveComplete(response.responseText, status);
					 }
					
					});
			
			$("#formChannel").submit();
	
		});

function onChannelSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			
			$("#divChannelsGrid").html(resultSet.data);
			
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}	
	
	$("#hidChannelIDSave").val("");
	$("#formChannel")[0].reset();
}



$(document).on("click",".btnUpdate",function(event) 
		{
			$("#hidChannelIDSave").val($(this).closest("tr").find('#hidChannelIDUpdate').val());
			$("#patient_name").val($(this).closest("tr").find('td:eq(0)').text());
			$("#patient_age").val($(this).closest("tr").find('td:eq(1)').text());
			$("#contact").val($(this).closest("tr").find('td:eq(2)').text());
			$("#doctor_name").val($(this).closest("tr").find('td:eq(3)').text());
			$("#hospital_name").val($(this).closest("tr").find('td:eq(4)').text());
			$("#date").val($(this).closest("tr").find('td:eq(5)').text());
			//$("#time").val($(this).closest("tr").find('td:eq(6)').text());
		});


/*$(document).on("click", ".btnRemove", function(event) 
{ 
	$(this).closest(".channel").btnRemove();  
	$("#alertSuccess").text("Removed successfully.");
	$("#alertSuccess").show();
}); 
*/


$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "ChannelsAPI",
		 type : "DELETE",
		 data : "channeling_id=" + $(this).data("channeling_id"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onChannelDeleteComplete(response.responseText, status);
		 }
		 
		});
});


function onChannelDeleteComplete(response, status)
{
if (status == "success")
 	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			
			$("#divChannelsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
 	} else if (status == "error")
 	{
 		$("#alertError").text("Error while deleting.");
 		$("#alertError").show();
 	} else
 	{
 		$("#alertError").text("Unknown error while deleting..");
 		$("#alertError").show();
 	}
}



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

package com;

import model.Channel;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For JSON 
import com.google.gson.*;

//For XML 
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Channels")
public class ChannelService {
	Channel channelObj = new Channel();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readChannels() {
		return channelObj.readChannels();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertChannel(@FormParam("patient_name") String patient_name,
			@FormParam("patient_age") String patient_age, @FormParam("contact") String contact, @FormParam("doctor_name") String doctor_name, @FormParam("hospital_name") String hospital_name, @FormParam("date") String date,
			@FormParam("time") String time) {
		String output = channelObj.insertChannels(patient_name, patient_age, contact, doctor_name, hospital_name, date, time);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateChannels(String channelData) {

		JsonObject channelObject = new JsonParser().parse(channelData).getAsJsonObject();

		String channeling_id = channelObject.get("channeling_id").getAsString();
		String patient_name = channelObject.get("patient_name").getAsString();
		String patient_age = channelObject.get("patient_age").getAsString();
		String contact = channelObject.get("contact").getAsString();
		String doctor_name = channelObject.get("doctor_name").getAsString();
		String hospital_name = channelObject.get("hospital_name").getAsString();
		String date = channelObject.get("date").getAsString();
		String time = channelObject.get("time").getAsString();
		
		
		String output = channelObj.updateChannels(channeling_id, patient_name, patient_age, contact, doctor_name, hospital_name, date, time);

		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String channelData) 
	{ 
		Document doc = Jsoup.parse(channelData, "", Parser.xmlParser());

		String channeling_id = doc.select("channeling_id").text();

		String output = channelObj.deleteChannels(channeling_id);

		return output;
	}
}

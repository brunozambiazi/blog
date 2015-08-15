
package com.brunozambiazi;

import com.brunozambiazi.deserializer.DateStringToCalendarDeserializer;
import com.brunozambiazi.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Calendar;


public class DeserializationTest {

	public static void main(String[] args) throws Exception {
		String json = "{\"id\":1,\"name\":\"User\",\"birthDate\":\"08/15/2015\",\"emails\":[\"user@yahoo.com\",\"user@gmail.com\"]}";
		
		SimpleModule module = new SimpleModule();
		module.addDeserializer(Calendar.class, new DateStringToCalendarDeserializer());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(module);

		User user = mapper.readValue(json, User.class);
		System.out.println(user.getName()+" - "+user.getId());
	}
	
}

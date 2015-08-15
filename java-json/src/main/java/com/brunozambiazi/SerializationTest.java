
package com.brunozambiazi;

import com.brunozambiazi.model.User;
import com.brunozambiazi.serializer.CalendarToDateStringSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Calendar;
import java.util.HashSet;


public class SerializationTest {

	public static void main(String[] args) throws Exception {
		User user = new User();
		user.setId(1L);
		user.setName("User");
		user.setBirthDate(Calendar.getInstance());
		user.setEmails(new HashSet<String>());
		user.getEmails().add("user@gmail.com");
		user.getEmails().add("user@yahoo.com");
		
		SimpleModule module = new SimpleModule();
		module.addSerializer(Calendar.class, new CalendarToDateStringSerializer());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(module);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		String json = mapper.writeValueAsString(user);
		System.out.println(json);
	}
	
}

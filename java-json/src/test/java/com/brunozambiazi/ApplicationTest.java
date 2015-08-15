
package com.brunozambiazi;

import com.brunozambiazi.deserializer.DateStringToCalendarDeserializer;
import com.brunozambiazi.model.User;
import com.brunozambiazi.serializer.CalendarToDateStringSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.Calendar;
import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;


public class ApplicationTest {

	private ObjectMapper getMapper() {
		SimpleModule module = new SimpleModule();
		module.addSerializer(Calendar.class, new CalendarToDateStringSerializer());
		module.addDeserializer(Calendar.class, new DateStringToCalendarDeserializer());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(module);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		return mapper;
	}
	
	@Test
	public void objectToStringToObject() throws Exception {
		Calendar birthDate = Calendar.getInstance();
		
		User originalUser = new User();
		originalUser.setId(1L);
		originalUser.setName("User");
		originalUser.setBirthDate(birthDate);
		originalUser.setEmails(new HashSet<String>());
		originalUser.getEmails().add("user@gmail.com");
		originalUser.getEmails().add("user@yahoo.com");
		
		String json = getMapper().writeValueAsString(originalUser);
		Assert.assertNotNull(json);
		
		User convertedUser = getMapper().readValue(json, User.class);
		Assert.assertNotNull(convertedUser);

		Assert.assertEquals(convertedUser.getId(), originalUser.getId());
		Assert.assertEquals(convertedUser.getName(), originalUser.getName());
		
		Assert.assertNotNull(convertedUser.getBirthDate());
		Assert.assertEquals(convertedUser.getBirthDate().get(Calendar.DAY_OF_MONTH), originalUser.getBirthDate().get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(convertedUser.getBirthDate().get(Calendar.MONTH), originalUser.getBirthDate().get(Calendar.MONTH));
		Assert.assertEquals(convertedUser.getBirthDate().get(Calendar.YEAR), originalUser.getBirthDate().get(Calendar.YEAR));
		
		Assert.assertNotNull(convertedUser.getEmails());
		for (String email : originalUser.getEmails()) {
			Assert.assertTrue(convertedUser.getEmails().contains(email));
		}
	}
	
}

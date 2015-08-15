
package com.brunozambiazi.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CalendarToDateStringSerializer extends JsonSerializer<Calendar> {

	@Override
	public void serialize(Calendar value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {
		if (value == null) {
			return;
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		gen.writeString(sdf.format(value.getTime()));
	}

}

package com.amphibian.weather.response;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
import org.junit.Test;

public class AlertTest {

	@Test
	public void testJson() {
		
		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		mapper.setAnnotationIntrospector(introspector);
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Alert a = null;
		try {
			a = mapper.readValue(new FileReader(new File("src/test/java/com/amphibian/weather/response/alert.json")), Alert.class);
		} catch (Exception e) {
			fail();
		}

		assertEquals("HEA", a.getType());
		assertEquals("Heat Advisory", a.getDescription());
		assertEquals("11:14 am CDT on July 3, 2012", a.getDate());
		assertEquals(1341332040, a.getDateEpoch());
		assertEquals("7:00 AM CDT on July 07, 2012", a.getExpires());
		assertEquals(1341662400, a.getExpiresEpoch());
		assertEquals("there is some bad weather coming!", a.getMessage());
		assertEquals("HT", a.getPhenomena());
		assertEquals("Y", a.getSignificance());
		
	}
	
}

package com.amphibian.weather;

import java.io.File;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import com.amphibian.weather.response.WeatherResponse;

public class UnmarshalTest {

	
	public static void main(String[] args) {
		
		JAXBContext jc;
		try {
			
			jc = JAXBContext.newInstance(new Class[]{WeatherResponse.class});
			Unmarshaller u = jc.createUnmarshaller();
			WeatherResponse r = (WeatherResponse) u.unmarshal( new File( "src/test/java/com/amphibian/weather/17082.xml" ) );
			System.out.println(r);
			
			ObjectMapper mapper = new ObjectMapper();
			AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
			mapper.setAnnotationIntrospector(introspector);
			mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			WeatherResponse r2 = mapper.readValue(new FileReader(new File("src/test/java/com/amphibian/weather/17084.json")), WeatherResponse.class);
			System.out.println(r2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

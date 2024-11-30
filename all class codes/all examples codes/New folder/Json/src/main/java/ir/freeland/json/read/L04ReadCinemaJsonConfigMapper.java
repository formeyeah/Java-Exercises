package ir.freeland.json.read;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.json.JsonMapper;

import ir.freeland.json.model.Cinema;

import java.io.File;

//Config mapper
public class L04ReadCinemaJsonConfigMapper {
	public static void main(String[] args) throws Exception {
		File file = new File("data-cinema.json");
		
		ObjectMapper mapper2= 
				JsonMapper.builder()
				.enable( MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS )
				.enable( MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES ) //see cinema json LOCATION
				.build()
				.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
		
		Cinema cinema = mapper2.readValue(file, Cinema.class);
		System.out.println("Cinema record: " + cinema);

	}
}
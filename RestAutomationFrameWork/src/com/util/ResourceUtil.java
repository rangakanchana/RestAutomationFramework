package com.util;


import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;



public class ResourceUtil {
	
	public static <X>X retrieveResource(HttpResponse response,Class<X>cl){
		
		String json;
		
		try {
			json = EntityUtils.toString(response.getEntity());
			
			ObjectMapper mapper = new ObjectMapper();
			int l=json.length()-1;
			String json2=json.substring(1, l);
			
			
			
			return mapper.readValue(json2, cl);
		
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;

	}
	


}

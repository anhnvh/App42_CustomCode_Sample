package com.shephertz.app42.paas.customcode.sample;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.shephertz.app42.paas.customcode.Executor;
import com.shephertz.app42.paas.customcode.HttpRequestObject;
import com.shephertz.app42.paas.customcode.HttpResponseObject;
import com.shephertz.app42.paas.sdk.java.ServiceAPI;
import com.shephertz.app42.paas.sdk.java.log.LogService;


public class MyCustomCode implements Executor {

	 private ServiceAPI sp = new ServiceAPI(	  	
			     "<YOUR_APIKEY>",
			      "<YOUR_SECRET_KEY>");
	 

	private final int HTTP_STATUS_SUCCESS = 200;

	private String moduleName = "App42CustomCodeTest";

	
	/** 
	 * Write your custom code inside this method 
	 */
	@Override
	public HttpResponseObject execute(HttpRequestObject request) {
		JSONObject body = request.getBody();

		// Build Log Service For logging in Your Code
		LogService logger = sp.buildLogService();
		logger.debug(" Recieved Request Body : :" + body.toString(), moduleName);

		// Write Your Custom Code Here
		// ......//

		logger.info("Running Custom Code Hello World  ", moduleName);
		
		// Create JSON Response Based on Your business logic
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("name", "App42CustomCodeTest");
			//....//
			//....//
		} catch (JSONException e) {
			// Do exception Handling for JSON Parsing
		}
		// Return JSON Response and Status Code
		return new HttpResponseObject(HTTP_STATUS_SUCCESS, jsonResponse);
	}

}

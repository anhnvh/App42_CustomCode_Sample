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

	// private ServiceAPI sp = new ServiceAPI("YOUR_API_Key",
	// "YOUR_SECRET_KEY");
	private ServiceAPI sp = new ServiceAPI(
			"5692c0ccfbae90543587fd9281e983d4687b82fe2ebf973ff79ab7cb7c58d44a",
			"8a27b3add931b582827a92e59ffaa89e2195082b91bc39c12af64a693e8b8e5e");
	//

	private final int HTTP_STATUS_SUCCESS = 200;

	private String moduleName = "MyCustomCode";

	/* (non-Javadoc)
	 * @see com.shephertz.app42.paas.customcode.Executor#execute(com.shephertz.app42.paas.customcode.HttpRequestObject)
	 */
	@Override
	public HttpResponseObject execute(HttpRequestObject request) {

		JSONObject body = request.getBody();

		HashMap<String, String> requestParamMap = request.getParameterMap();

		// Build Log Service For logging in Your Code
		LogService logger = sp.buildLogService();
		logger.debug(" Recieved Request Body : " + body.toString(), moduleName);
		logger.debug(" Recieved Request Parameter : " + requestParamMap, moduleName);

		// Write Your Custom Code
		// ......//

		logger.info("Running Custom Code Hello World  ", moduleName);
		// Create JSON Response Based on Your business logic
		JSONObject jsonResponse = new JSONObject();
		try {
			jsonResponse.put("name", "John");
			jsonResponse.put("age", 30);
			//....//
			//....//
		} catch (JSONException e) {
			// Do exception Handling for JSON Parsing
		}
		// Return JSON Response and Status Code
		return new HttpResponseObject(HTTP_STATUS_SUCCESS, jsonResponse);
	}

}

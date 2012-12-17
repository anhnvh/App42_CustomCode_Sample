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

	 private ServiceAPI sp = new ServiceAPI("68127343b272cf795247487265de2c2eddb0ef345913b1bf38ef008c32d088d1", "43bd5eb25e402c703d876acc1ee787597fa1ac8617b65be8e34ecb1d58fba805");
	 

	private final int HTTP_STATUS_SUCCESS = 200;

	private String moduleName = "MyCustomCode";

	/* (non-Javadoc)
	 * @see com.shephertz.app42.paas.customcode.Executor#execute(com.shephertz.app42.paas.customcode.HttpRequestObject)
	 */
	@Override
	public HttpResponseObject execute(HttpRequestObject request) {
		sp.setBaseURL("http://", "localhost", 8090);
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

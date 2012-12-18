/**
 * 
 */
package com.myapp;

import java.util.HashMap;

import org.json.JSONObject;

import com.shephertz.app42.paas.customcode.Executor;
import com.shephertz.app42.paas.customcode.HttpRequestObject;
import com.shephertz.app42.paas.customcode.sample.MyCustomCode;

/**
 * Local Setup Tester
 * @author Ajay Tiwari
 *
 */
public class TestMyCustomCode {
	
	/**
	 * Sets the param and body and call the execute method for test
	 * @throws Exception
	 */
	public static void testMyCode() throws Exception {
		
		Executor executor = new MyCustomCode();
		HashMap<String, String> parameterMap  = new HashMap<String, String>(); 
		parameterMap.put("param1", "myCustomCodeParam");
		//Create Request Body 
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("name", "John");
		jsonBody.put("age", 30);
		jsonBody.put("SSN", "XXXXXXXXX");
		
		HttpRequestObject request = new HttpRequestObject(parameterMap, jsonBody );
		executor.execute(request);
	}
	
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		testMyCode();
	}

}

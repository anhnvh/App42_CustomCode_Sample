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

		//Create Request Body 
		JSONObject jsonBody = new JSONObject();
		jsonBody.put("Gamename", "XXXX");
		jsonBody.put("Username", "ABCDXYZ");
		jsonBody.put("Score", 2 );
		
		HttpRequestObject request = new HttpRequestObject(new HashMap<String, String>(), jsonBody );
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

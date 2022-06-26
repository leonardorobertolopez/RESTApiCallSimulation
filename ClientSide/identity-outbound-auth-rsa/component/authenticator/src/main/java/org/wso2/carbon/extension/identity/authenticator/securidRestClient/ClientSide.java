package org.wso2.carbon.extension.identity.authenticator.securidRestClient;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.wso2.carbon.extension.identity.authenticator.auxiliary.Tools;
import org.wso2.carbon.extension.identity.authenticator.entities.cancel.JSONObjectCancel;
import org.wso2.carbon.extension.identity.authenticator.entities.initialize.CollectedInputs;
import org.wso2.carbon.extension.identity.authenticator.entities.initialize.SubjectCredentials;
import org.wso2.carbon.extension.identity.authenticator.entities.status.JSONObjectStatus;
import org.wso2.carbon.extension.identity.authenticator.entities.verify.ContextVerify;
import org.wso2.carbon.extension.identity.authenticator.entities.verify.JSONObjectVerify;
import org.wso2.carbon.extension.identity.authenticator.initialize.Context;
import org.wso2.carbon.extension.identity.authenticator.initialize.JSONInitializeObj;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientSide {

	private static String attemptId;
	private static String messageId = "1d3b6ac5-8e18-4e4c-b7f9-becab1f73ad0";

	public static void principal(String value) {
		//Hello World (only to show the connection)
		if (Tools.box("Hello World") == 0) //Initialize the flow. Create a new authnAttemptId
		{try {helloWorld();	} catch (IOException e) {e.printStackTrace();}}

		//Check the value selected by the user in the Front and goes to proper method.
		switch(value){
			case "0":
				if (Tools.box("Initialize") == 0) //Initialize the flow. Create a new authnAttemptId
					initialize();
				break;
			case "1":
				if (Tools.box("Verify") == 0) //Here returns a JSON flow according to an authnAttemptId
					verify();
				break;
			case "2":
				if (Tools.box("Cancel") == 0) //Cancel the authAttemptId from the DDBB
					cancel();
				break;
			case "3":
				if (Tools.box("Status.") == 0) //It says if an auth flow was successfull or not. If exists an authnAttemptId in the DDBB means was successfull
					status();
				break;

		}


    //METHODS
	}

	// Hello World METHOD
	private static void helloWorld() throws IOException {
		String query_url = "http://localhost:8083/RSARestServer/serverapi/rsa/helloworld";

		URL urlForGetRequest = new URL("http://localhost:8083/RSARestServer/serverapi/rsa/helloworld");
		String readLine = null;
		HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
		conection.setRequestMethod("GET");
		conection.setRequestProperty("userId", "a1bcdef"); // set userId its a sample here
		int responseCode = conection.getResponseCode();


		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(
					new InputStreamReader(conection.getInputStream()));
			StringBuffer response = new StringBuffer();
			while ((readLine = in .readLine()) != null) {
				response.append(readLine);
			} in .close();
			// print result
			System.out.println("\n"+response.toString()+"\n");
			//GetAndPost.POSTRequest(response.toString());
		} else {
			System.out.println("GET NOT WORKED");
		}
	}

	// INITIALIZE METHOD
	private static void initialize() {
		String query_url = "http://localhost:8083/RSARestServer/serverapi/rsa/initialize";

		JSONInitializeObj jsonObject = new JSONInitializeObj("180", "authclient.corp.com1", "lrlopez", "us_EN",
				"standard-web", new Context(messageId));
		// Create a map to order the elements because of the lack of order that JSON
		// object has
		JSONObject sampleObject = null;
		try{
			 sampleObject = new JSONObject(jsonObject);

		}catch(Exception e){
			e.printStackTrace();
		}

		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			os.write(sampleObject.toString().getBytes("UTF-8"));
			os.close();

			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");
			// Print the complete Json
			System.out.println("\n"+"Complete JSON: " + result+"\n");

			// Transform the String in a Json
			JSONObject myResponse = new JSONObject(result);
			// Obtain the Json context
			JSONObject context = myResponse.getJSONObject("context");
			// Obtain the attemptID value
			String attemptID = context.getString("authnAttemptId");
			System.out.println("\n"+"Attempt ID: " + attemptID +"\n");
			// Store the attemptID value in an static variable for the rest of the flow
			if (null == attemptId)
				attemptId = attemptID;

			in.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// VERIFY METHOD
	private static void verify() {
		String query_url = "http://localhost:8083/RSARestServer/serverapi/rsa/verify";
		// Generate SubjCred array and object for JSONObjectVerify Constructor
		SubjectCredentials[] subjectCred = new SubjectCredentials[1];
		// Create Collected Inputs object for SubjectCredentials constructor
		CollectedInputs[] coll = new CollectedInputs[1];
		CollectedInputs collObj = new CollectedInputs("name", "value", "dataType");
		coll[0] = collObj;
		// Generate SubjectCredentials object for JSONObjectVerify constructor
		SubjectCredentials sub = new SubjectCredentials("methodId", "refereceId", "versionID", coll);
		subjectCred[0] = sub;
		// Generate Context object for JSONObjectVerify Constructor here receives the
		// attemptId value from static variable
		ContextVerify ctx = new ContextVerify(attemptId, messageId, "inResponseTo");

		// Generate JSONObject which is the one that will be send
		JSONObjectVerify jsonObject = new JSONObjectVerify(subjectCred, ctx);

		// Transform POJO to JSON
		JSONObject sampleObject = new JSONObject(jsonObject);

		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			os.write(sampleObject.toString().getBytes("UTF-8"));
			os.close();

			// RESPONSE (Read)
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");
			// Print the complete Json
			System.out.println("/n"+ "Complete JSON: " + result +"/n");

			// Transform the String to Json
			JSONObject myResponse = new JSONObject(result);
			// Obtain the context to show then the "authnAttemptID"
			JSONObject context = myResponse.getJSONObject("context");
			// Obtain the attemptID value
			String attemptID = context.getString("authnAttemptId");
			System.out.println("\n"+"Attempt ID: " + attemptID +"\n");
			// Store the attemptID value in an static variable for the rest of the flow
			if (attemptId.equalsIgnoreCase(attemptID)) {
				System.out.println("\n"+"We are in the same authentication flow"+"\n");
			} else {
				System.out.println("\n"+ "We are not in the same authentication flow. The attemptID is different"+"\n");
			}
			;

			in.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// CANCEL METHOD
	private static void cancel() {
		String query_url = "http://localhost:8083/RSARestServer/serverapi/rsa/cancel";

		JSONObjectCancel jsonObject = new JSONObjectCancel("cancel the flow", attemptId, true);
		JSONObject sampleObject = new JSONObject(jsonObject);

		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			os.write(sampleObject.toString().getBytes("UTF-8"));
			os.close();

			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");
			// Print the complete Json
			System.out.println("\n"+"Cancelled JSON: " + result +"\n");

			in.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// STATUS METHOD
	private static void status() {
		String query_url = "http://localhost:8083/RSARestServer/serverapi/rsa/status";

		String authnAttemptId = Tools.boxInput("Introduce the authnAttemptId code: ");
		JSONObjectStatus jsonObject = new JSONObjectStatus(authnAttemptId, "removeAttemptId");
		JSONObject sampleObject = new JSONObject(jsonObject);

		try {
			URL url = new URL(query_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");

			OutputStream os = conn.getOutputStream();
			os.write(sampleObject.toString().getBytes("UTF-8"));
			os.close();

			// read the response
			InputStream in = new BufferedInputStream(conn.getInputStream());
			String result = IOUtils.toString(in, "UTF-8");
			// Print the complete Json
			System.out.println("\n"+"Authenticated Successfull JSON: " + result+"\n");

			in.close();
			conn.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

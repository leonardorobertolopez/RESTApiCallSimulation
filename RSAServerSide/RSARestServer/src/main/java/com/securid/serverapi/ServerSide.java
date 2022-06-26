package com.securid.serverapi;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.securid.auxiliars.RandomNumbers;
import com.securid.dao.AuthenticationImplementacion;
import com.securid.entities.JSONObjectInitialize;
import com.securid.entities.cancel.JSONObjectCancel;
import com.securid.entities.response.Initialize.AuthnAttributes;
import com.securid.entities.response.Initialize.ChallengeMethods;
import com.securid.entities.response.Initialize.Challenges;
import com.securid.entities.response.Initialize.Context;
import com.securid.entities.response.Initialize.CredentialValidationResults;
import com.securid.entities.response.Initialize.MethodAttributes;
import com.securid.entities.response.Initialize.MyPojo;
import com.securid.entities.response.Initialize.Prompt;
import com.securid.entities.response.Initialize.RequiredMethods;
import com.securid.entities.response.Initialize.Versions;
import com.securid.entities.status.MyPojoStatus;
import com.securid.entities.status.Status;
import com.securid.entities.verify.JSONObjectVerify;

@Path("/rsa")
@Produces(MediaType.APPLICATION_JSON)
public class ServerSide {

	private static String attemptId;
	private static String messageId;

	// holaMundo
	@GET
	@Path("/helloworld")
	public String responderHolaMundo() {
		return "Hello World";
	}

	// Initialize
	@POST
	@Path("/initialize")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response initialize(String aux) {
		ObjectMapper objectMapper = new ObjectMapper();
		// Returns the same object as received
		JSONObjectInitialize obj = null;
		// returns the proper response
		MyPojo obj1 = null;
		try {
			// object from the request
			obj = objectMapper.readValue(aux, JSONObjectInitialize.class);
			// obtain the messageId and store it in an static variable
			String messageID = obj.getContext().getMessageId();
			messageId = messageID;

			// context, credentialValidationResults, attemptResponseCode, attemptReasonCode,
			// challengeMethods
			AuthnAttributes atr = new AuthnAttributes("name", "value", "dataType");
			AuthnAttributes[] authnAttributes = new AuthnAttributes[1];
			authnAttributes[0] = atr;
			CredentialValidationResults[] cred = new CredentialValidationResults[1];
			CredentialValidationResults crObj = new CredentialValidationResults("methodId",
					"methodResponseCode-OKorFAIL", "methodReasonCode", authnAttributes);
			cred[0] = crObj;
			Challenges[] chall = new Challenges[1];
			// fill the methods Attributes to accomplish with Versions constructor
			MethodAttributes meth = new MethodAttributes("name", "value", "dataType");
			MethodAttributes[] methArray = { meth };
			// Obtain Prompt args
			String[] pr = { "string" };

			// obtain Prompt object to fill the vs constructor
			Prompt ps = new Prompt("promptResourceId", "string", "string", "string", "false", "true", "0", "0", pr);

			// fill the versions object to accomplish with meth constructor
			Versions vs = new Versions("1.0.0", methArray, "valorRequired", "string", ps);
			Versions[] vsArray = { vs };

			// fill the required methods to accomplish with cha object constructor
			RequiredMethods meth1 = new RequiredMethods("string", "string", "1", vsArray);
			RequiredMethods[] methArray1 = new RequiredMethods[1];
			methArray1[0] = meth1;

			// fill the ChallengesMethods to accomplish with MyPojo constructor
			Challenges cha = new Challenges("string", methArray1);
			chall[0] = cha;
			ChallengeMethods ch = new ChallengeMethods(chall);

			// Generate random for AttemptId if hasn't got a value
			if (null == attemptId)
				attemptId = RandomNumbers.random();

			// Most important object to send back to the client in response
			obj1 = new MyPojo(new Context(attemptId, messageId, "inResponseTo"), cred, "OK", "string", ch);
			// save the new MyPojo object (server object) which is the response and the
			// messageId
			AuthenticationImplementacion auth = new AuthenticationImplementacion();

			// Check if the attemptId exists, if not insert it
			if (null == auth.buscar(attemptId)) {
				auth.insertar(obj1);
				RandomNumbers.box("attemptId will be persisted on the DDBB");
			}

			// returns the new object
			System.out.println(obj1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Responds to client
		return Response.ok(obj1).build();
	}

	// VERIFY(ServerSide)
	@POST
	@Path("/verify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response verify(String aux) {
		ObjectMapper objectMapper = new ObjectMapper();
		// Returns the same object as received
		JSONObjectVerify obj = null;
		// returns the proper response
		MyPojo obj1 = null;
		try {
			// object from the request
			obj = objectMapper.readValue(aux, JSONObjectVerify.class);
			// obtain the messageId
			String messageID = obj.getContext().getMessageId();
			if (!messageID.equalsIgnoreCase(messageId)) {
				System.out.println("There is a problem with the flow, or has been cancelled.");
			}

			// obtain the attemptId
			// context, credentialValidationResults, attemptResponseCode, attemptReasonCode,
			// challengeMethods
			AuthnAttributes atr = new AuthnAttributes("string", "string", "string");
			AuthnAttributes[] authnAttributes = new AuthnAttributes[1];
			authnAttributes[0] = atr;
			CredentialValidationResults[] cred = new CredentialValidationResults[1];
			CredentialValidationResults crObj = new CredentialValidationResults("string", "OK", "string",
					authnAttributes);
			cred[0] = crObj;
			Challenges[] chall = new Challenges[1];
			// fill the methods Attributes to accomplish with Versions constructor
			MethodAttributes meth = new MethodAttributes("string", "string", "STRING");
			MethodAttributes[] methArray = { meth };
			// Obtain Prompt args
			String[] pr = { "string" };

			// obtain Prompt object to fill the vs constructor
			Prompt ps = new Prompt("string", "string", "string", "string", "false", "true", "0", "0", pr);

			// fill the versions object to accomplish with meth constructor
			Versions vs = new Versions("1.0.0", methArray, "valorRequired", "string", ps);
			Versions[] vsArray = { vs };

			// fill the required methods to accomplish with cha object constructor
			RequiredMethods meth1 = new RequiredMethods("string", "string", "1", vsArray);
			RequiredMethods[] methArray1 = new RequiredMethods[1];
			methArray1[0] = meth1;

			// fill the ChallengesMethods to accomplish with MyPojo constructor
			Challenges cha = new Challenges("string", methArray1);
			chall[0] = cha;
			ChallengeMethods ch = new ChallengeMethods(chall);

			// Most important object to send back to the client in response
			obj1 = new MyPojo(new Context(attemptId, messageId, ""), cred, "OK", "string", ch);
			// save the new MyPojo object (server object) which is the response and the
			// messageId
			AuthenticationImplementacion auth = new AuthenticationImplementacion();
//	                auth.guardar(obj1);
			// returns the new object
			System.out.println(obj1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok(obj1).build();
	}

	// CANCEL(ServerSide)
	@POST
	@Path("/cancel")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cancel(String aux) {
		int chk = 0; // auxiliary variable to check the existence of the flow
		ObjectMapper objectMapper = new ObjectMapper();
		// Returns the same object as received
		JSONObjectCancel obj = null;
		// returns the proper response
		MyPojo obj1 = null;
		try {
			// object from the request
			obj = objectMapper.readValue(aux, JSONObjectCancel.class);
			// obtain the messageId
			String authnAttemptID = obj.getAuthnAttemptId();
			// Search in the DDBB if the authnAttemptId exists
			AuthenticationImplementacion auth = new AuthenticationImplementacion();
			if(auth.buscar(authnAttemptID)!=null) attemptId=authnAttemptID;
			
			if (authnAttemptID.equalsIgnoreCase(attemptId)) {
				attemptId = null; // this avoid the verify method
				System.out.println("The authentication flow has been cancelled, please start the flow again.");
				// obtain the attemptId
				// context, credentialValidationResults, attemptResponseCode, attemptReasonCode,
				// challengeMethods
				AuthnAttributes atr = new AuthnAttributes("string", "string", "string");
				AuthnAttributes[] authnAttributes = new AuthnAttributes[1];
				authnAttributes[0] = atr;
				CredentialValidationResults[] cred = new CredentialValidationResults[1];
				CredentialValidationResults crObj = new CredentialValidationResults("string", "OK", "string",
						authnAttributes);
				cred[0] = crObj;
				Challenges[] chall = new Challenges[1];
				// fill the methods Attributes to accomplish with Versions constructor
				MethodAttributes meth = new MethodAttributes("string", "string", "STRING");
				MethodAttributes[] methArray = { meth };
				// Obtain Prompt args
				String[] pr = { "string" };

				// obtain Prompt object to fill the vs constructor
				Prompt ps = new Prompt("string", "string", "string", "string", "false", "true", "0", "0", pr);

				// fill the versions object to accomplish with meth constructor
				Versions vs = new Versions("1.0.0", methArray, "valorRequired", "string", ps);
				Versions[] vsArray = { vs };

				// fill the required methods to accomplish with cha object constructor
				RequiredMethods meth1 = new RequiredMethods("string", "string", "1", vsArray);
				RequiredMethods[] methArray1 = new RequiredMethods[1];
				methArray1[0] = meth1;

				// fill the ChallengesMethods to accomplish with MyPojo constructor
				Challenges cha = new Challenges("string", methArray1);
				chall[0] = cha;
				ChallengeMethods ch = new ChallengeMethods(chall);

				// Most important object to send back to the client in response
				obj1 = new MyPojo(new Context(authnAttemptID, messageId, ""), cred, "OK", "string", ch);
				// save the new MyPojo object (server object) which is the response and the
				// messageId
				
				// ask user if wants to cancell the flow
				RandomNumbers.box("Authentication will cancelled and attemptID will be deleted from DDBB. Proceed?");
				// cancel the flow
				if (auth.eliminar(obj1) == true)
					System.out.println("The following flow has been CANCELLED." + "\n" + obj1);

			} else {
				chk = 1;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (chk == 0) {
			return Response.ok(obj1).build();

		} else {
			return Response.ok("There is not an authentication flow with that attemptID").build();

		}

	}

	// STATUS(ServerSide)
	@POST
	@Path("/status")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response status(String aux) {
		// Create the mapper to map string - JSON
		ObjectMapper objectMapper = new ObjectMapper();
		// Receiving Object
		Status obj = null;
		// Response Object
		MyPojoStatus obj1 = null;
		// DAO Object
		AuthenticationImplementacion authDAO = new AuthenticationImplementacion();

		try {
			obj = objectMapper.readValue(aux, Status.class);
			// Obtain the authnAttemptID
			String authnAttemptID = obj.getAuthnAttemptId();
			// Check if the authnAttemptID has been a successfull authentication (is in the
			// DDBB)
			if (authDAO.buscarStatus(authnAttemptID) != null)RandomNumbers.box("The authentication flow for the authnAttemptID nr: " + authnAttemptID + " was successfull");

			// RESPONSE
            
			obj1 = new MyPojoStatus("attemptResponseCode", "attemptReasoncode", "subjectName", "authnPolicyId", "assuranceLevel", null, null, "attemptExpires");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok(obj1).build();

	}

}

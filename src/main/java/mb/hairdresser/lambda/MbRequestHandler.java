package mb.hairdresser.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import mb.hairdresser.model.InputLambdaRequest;

public class MbRequestHandler implements RequestHandler<InputLambdaRequest, String> {

	
	public String handleRequest(InputLambdaRequest input, Context context) {
		String output = "Yes, come on!! " + input.getName();
		
		return output;
	}

}

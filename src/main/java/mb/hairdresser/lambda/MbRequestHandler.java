package mb.hairdresser.lambda;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import mb.hairdresser.model.CalendarEvent;
import mb.hairdresser.model.InputLambdaRequest;
import mb.hairdresser.model.OutputLambdaResponse;

public class MbRequestHandler implements RequestHandler<InputLambdaRequest, OutputLambdaResponse> {

	public OutputLambdaResponse handleRequest(InputLambdaRequest input, Context context) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(Regions.EU_WEST_3).build();

		DynamoDB dynamoDB = new DynamoDB(client);

		GetItemSpec spec = new GetItemSpec().withPrimaryKey("eventid", "1");

		Table table = dynamoDB.getTable("events");
		Item item = table.getItem(spec);
		System.out.println(item.toJSONPretty());
		
		CalendarEvent event = new CalendarEvent();
		event.setName(item.getString("name"));
		
		List<CalendarEvent> events = new ArrayList<>();
		events.add(event);
		
		OutputLambdaResponse result = new OutputLambdaResponse();		
		result.setEvents(events);

		// return item.toJSONPretty();
		return result;
	}

}

package mb.hairdresser.dynamodb;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

public class DynamoDBTest {

	public static void main(String args[]) {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.EU_WEST_3).build();
		
				DynamoDB dynamoDB = new DynamoDB(client);
				
				GetItemSpec spec = new GetItemSpec() 
						   .withPrimaryKey("eventid", "1") 
						   ;

				Table table = dynamoDB.getTable("events");
				Item item = table.getItem(spec);
				System.out.println(item.toJSONPretty());

				/*
				QuerySpec spec = new QuerySpec()
				    .withKeyConditionExpression("eventId = :v_id")
				    .withValueMap(new ValueMap()
				        .withString(":v_id", "1"));

				ItemCollection<QueryOutcome> items = table.query(spec);

				Iterator<Item> iterator = items.iterator();
				Item item = null;
				while (iterator.hasNext()) {
				    item = iterator.next();
				    System.out.println(item.toJSONPretty());
				}
				*/
	}
}

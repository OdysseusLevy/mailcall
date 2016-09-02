package org.mailcall.dynamodb

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Item
import com.amazonaws.services.dynamodbv2.document.PrimaryKey
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec
import java.util.*

/**
 * Created by odysseus on 6/10/16.
 */
class DynamoDbHelper {

    fun createWho() {
        val client = AmazonDynamoDBClient()


        val dynamoDB = DynamoDB(client);

        val table = dynamoDB.getTable("Tags");

        val infoMap = HashMap<String, Any>();
        infoMap.put("tags",  setOf("whitelist"))
        infoMap.put("values",  mapOf(Pair("category", "family")))

        try {
            println("Adding a new item...");
            val outcome = table.putItem( Item()
                    .withPrimaryKey("account", "odysseus@cosmosgame.org", "key", "vfitzharris@netscape.net")
                    .withMap("values", mapOf(Pair("category", "family")))
                    .with("tags", setOf("whitelist")))

            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());

        } catch( e: Exception) {
            System.err.println("Unable to add item: ");
            System.err.println(e.message);
        }
    }

    fun getWho() {
        val client = AmazonDynamoDBClient()
        val dynamoDB = DynamoDB(client);

        val table = dynamoDB.getTable("Tags");
        val spec =  GetItemSpec()
                .withPrimaryKey("account", "odysseus@cosmosgame.org", "key", "vfitzharris@netscape.net");

        try {
            System.out.println("Attempting to read the item...");
            val outcome = table.getItem(spec);
            System.out.println("GetItem succeeded: " + outcome);

        } catch ( e: Exception) {
            System.err.println("Unable to read item: ");
            System.err.println(e.message);
        }
    }

}

fun main(args : Array<String>) {

    val client = AmazonDynamoDBClient()
    val mapper = DynamoDBMapper(client);

    val item = mapper.load(DynamoTagsRecord::class.java, "odysseus@cosmosgame.org", "vfitzharris@netscape.net")

    System.out.println(item)
}
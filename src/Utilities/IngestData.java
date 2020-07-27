package Utilities;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class IngestData {
	
	private static final String URL = "http://jarvis.pm669114-multi-master.dhcp.broadcom.net/ingestion";
	private static final String tenant_id = "INSIGHT-USERSTORE";
	private static final String doc_type_id = "itoa_metrics_custom";
	private static final String doc_type_version = "3";

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		WebResource.Builder builder = getBuilder();
		for(int i = 0; i < 1; i++) {
			String requestBodyJsonStr = getPayload();
			ClientResponse response = builder.post(ClientResponse.class, requestBodyJsonStr);
			System.out.println("requestBodyJsonStr : \n" + requestBodyJsonStr);
		}
		
		System.out.println("\n" + "Ingestion Finished !!!");
	}
	
	
	public static WebResource.Builder getBuilder() {
		Client client = Client.create();
		WebResource webResource = client.resource(URL);
		WebResource.Builder builder = webResource.accept(MediaType.APPLICATION_JSON);
		builder.type(MediaType.APPLICATION_JSON);
		return builder;
	}
	
	public static String getPayload() {
		JsonObject header = new JsonObject();
		header.addProperty("product_id", "ao");
		header.addProperty("tenant_id", tenant_id);
		header.addProperty("doc_type_id", doc_type_id);
		header.addProperty("doc_type_version", doc_type_version);

		JsonArray bodyArr = new JsonArray();
		
		for(int i = 0; i < 2; i++) {
			JsonObject body = new JsonObject();
			body.addProperty("timestamp", "2019-04-30T10:54:01+0000");
			body.addProperty("metric_unique_id", "metric_unique_id_"+ i);
			body.addProperty("product", "Custom_Product_1");
			body.addProperty("host", "host1");
			body.addProperty("ip", "10.100.11.100");
			body.addProperty("metric_name", "MN"+(i%5000));
			body.addProperty("metric_type", "MT");
			body.addProperty("configuration_item", "Ci");
			body.addProperty("metric_value", "15");
			
			bodyArr.add(body);
		}
		
		JsonObject header_n_body = new JsonObject();
		header_n_body.add("header", header);
		header_n_body.add("body", bodyArr);

		JsonArray documentsArr = new JsonArray();
		documentsArr.add(header_n_body);
		
		JsonObject mainJson = new JsonObject();
		mainJson.add("documents", documentsArr);
		
		return new Gson().toJson(mainJson);
	}

}
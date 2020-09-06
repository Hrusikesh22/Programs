package es.read;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.elasticsearch.ElasticsearchStatusException;
import org.elasticsearch.action.admin.cluster.snapshots.delete.DeleteSnapshotRequest;
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsRequest;
import org.elasticsearch.action.admin.cluster.snapshots.get.GetSnapshotsResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SnapshotHandler {

	ClientService clientService = new ClientService();
	private static final String GET = "GET";

	// Repo==Jarvis-ES-Backup-gcpdev
	// ,Host_name==nginx-route-8883-ao-jarvis.app.gdue4.saasdev.broadcom.com
	public static void main(String args[]) throws IOException {
		SnapshotHandler snapshotHandler = new SnapshotHandler();
        //System.out.println(snapshotHandler.getSnapshotsListFromEs().toString());
		snapshotHandler.deleteSnapsots();
	}

	public List<String> getSnapshotsListFromEs() throws IOException {
		List<String> indices = getListOfIndices();
		Set<String> snapshotNames = new HashSet<String>();
		indices.forEach(index -> getSnapshotName(index, snapshotNames));
		return new ArrayList<String>(snapshotNames);
	}

	private Set<String> getSnapshotName(String index, Set<String> snapshotNames) {
		try {
			//index=index.substring(0, index.lastIndexOf("_"));
			//index=index.substring(0, index.lastIndexOf("_"));
			GetSnapshotsResponse response = getRestHighLevelClient().snapshot().get(
					new GetSnapshotsRequest(SnapshotConstants.REPOSITORY_NAME, new String[] { index + "*" }).ignoreUnavailable(true),
					RequestOptions.DEFAULT);
			response.getSnapshots().forEach(snapshotInfo -> snapshotNames.add(snapshotInfo.snapshotId().getName()));
		} catch (ElasticsearchStatusException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return snapshotNames;
	}

	private List<String> getListOfIndices() throws IOException {
		GetIndexResponse response = getRestHighLevelClient().indices().get(new GetIndexRequest("*"),
				RequestOptions.DEFAULT);
		String[] indices = response.getIndices();
		return Arrays.asList(indices);
	}

	public String deleteSnapsots() throws IOException {
		 List<String> snapshots=getListofSnapshots();
		 //List<String> snapshots=getSnapshotsListFromEs();
		//List<String> snapshots = getsnapshotsFromString();
		System.out.println("count of snapshots::"+snapshots.size());
		System.out.println("List of snapshosts::\n" + snapshots.toString());
		List<String> failedSnapshots = new ArrayList<String>();
		for (String snapshot : snapshots) {
			try {
				AcknowledgedResponse deleteresponse = getRestHighLevelClient().snapshot().delete(
						new DeleteSnapshotRequest(SnapshotConstants.REPOSITORY_NAME, snapshot), RequestOptions.DEFAULT);
				System.out.println("snapshot status:" + snapshot + "==" + deleteresponse.isAcknowledged());
				if (!deleteresponse.isAcknowledged()) {
					failedSnapshots.add(snapshot);
				}
			} catch (ElasticsearchStatusException e) {
				failedSnapshots.add(snapshot);
				e.printStackTrace();
				if(e.status().getStatus()==503) {
					System.out.println("503 exit stop the snapshots");
					
				}
				
				if(e.status().getStatus()==404) {
					System.out.println("Continuing to next snapshots.As it is already deleted");
					continue;
					
				}
				
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	private List<String> getsnapshotsFromString() {
		return Arrays.asList(SnapshotConstants.PROD_SNAPSHOTS_NAMES.replaceAll(" ", "").split(","));
	}

	private List<String> getListofSnapshots() throws IOException {
		URL url = Resources.getResource(SnapshotConstants.SNAPSHOT_LIST);
		String text = Resources.toString(url, StandardCharsets.UTF_8);
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode json = objectMapper.readTree(text);
		Iterator<JsonNode> jsonMapIterator = json.iterator();
		List<String> snapshots = new ArrayList<String>();
		while (jsonMapIterator.hasNext()) {
			JsonNode json_id = jsonMapIterator.next();
			snapshots.add(json_id.get("id").asText());
		}
		return snapshots;

	}

	public RestHighLevelClient getRestHighLevelClient() {
		return clientService.getRestClient(SnapshotConstants.HOST_NAME);
	}

}

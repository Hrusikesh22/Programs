package es.read;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ClientService {

	RestHighLevelClient restHighLevelClient = null;

	RestClientBuilder createRestClientBuilder(final CredentialsProvider credentialsProvider, HttpHost httpHosts) {
		return RestClient.builder(httpHosts)
				.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
					@Override
					public HttpAsyncClientBuilder customizeHttpClient(
							HttpAsyncClientBuilder httpClientBuilder) {
						return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
					}
				})
				.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {

					@Override
					public Builder customizeRequestConfig(Builder requestConfigBuilder) {
						RequestConfig.Builder buidler = RequestConfig.custom().setConnectTimeout(60000)
								.setSocketTimeout(60000).setConnectionRequestTimeout(60000);
						return buidler;
					}
				});
	}

	public RestHighLevelClient getRestClient(String hostName) {
		if (null == restHighLevelClient) {
			final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
			credentialsProvider.setCredentials(AuthScope.ANY,new UsernamePasswordCredentials("USER_NAME", "PASSWORD"));

			RestClientBuilder client = createRestClientBuilder(credentialsProvider,new HttpHost(hostName));
			restHighLevelClient = new RestHighLevelClient(client);
		}
		return restHighLevelClient;

	}
}

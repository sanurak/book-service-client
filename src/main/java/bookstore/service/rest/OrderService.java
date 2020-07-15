package bookstore.service.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bookstore.service.model.BuyDetail;
import bookstore.service.model.CustomerDetail;
import bookstore.service.model.OrderDetail;
import bookstore.service.model.Response;

/**
 * 
 * @author Anurak Sirivoravit
 *
 *
 *         Implementation for IOrderService
 */
class OrderService implements IOrderService {
	private static ParameterizedTypeReference<Response<List<OrderDetail>>> typeRefList = new ParameterizedTypeReference<Response<List<OrderDetail>>>() {
	};

	private static ParameterizedTypeReference<Response<OrderDetail>> typeRef = new ParameterizedTypeReference<Response<OrderDetail>>() {
	};

	private RestTemplate restTemplate = new RestTemplate();

	private URI orderUri = null;
	private URI historyUri = null;

	OrderService(String restOrderUrl) throws URISyntaxException {
		orderUri = new URI(restOrderUrl);
		historyUri = new URI(restOrderUrl + "/history");
	}

	@Override
	public Response<List<OrderDetail>> getHistoryOrder(CustomerDetail customerDetail) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("token", customerDetail.getToken());

		OrderDetail orderDetail = new OrderDetail();

		HttpEntity<OrderDetail> request = new HttpEntity<OrderDetail>(orderDetail, headers);
		ResponseEntity<Response<List<OrderDetail>>> resultResponse = this.restTemplate.exchange(historyUri,
				HttpMethod.GET, request, typeRefList);

		if (resultResponse.getStatusCode() == HttpStatus.OK) {
			Response<List<OrderDetail>> orderResponse = (Response<List<OrderDetail>>) resultResponse.getBody();

			return orderResponse;

		} else {
			return Response.createError(resultResponse.getStatusCode().toString());
		}
	}

	@Override
	public Response<OrderDetail> saveOrder(CustomerDetail customerDetail, BuyDetail buyCommand) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("token", customerDetail.getToken());

		HttpEntity<BuyDetail> request = new HttpEntity<BuyDetail>(buyCommand, headers);
		ResponseEntity<Response<OrderDetail>> resultResponse = this.restTemplate.exchange(orderUri, HttpMethod.POST,
				request, typeRef);

		if (resultResponse.getStatusCode() == HttpStatus.OK) {
			Response<OrderDetail> orderResponse = (Response<OrderDetail>) resultResponse.getBody();

			return orderResponse;

		} else {
			return Response.createError(resultResponse.getStatusCode().toString());
		}
	}
}

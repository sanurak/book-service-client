package bookstore.service.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import bookstore.service.model.CustomerDetail;
import bookstore.service.model.Response;
import bookstore.service.model.SignIn;

/**
 * 
 * @author Anurak Sirivoravit
 *
 *
 *         Implementation for ICustomerService
 */
class CustomerService implements ICustomerService {
	private RestTemplate restTemplate = new RestTemplate();

	private URI restUrl = null;

	private static ParameterizedTypeReference<Response<CustomerDetail>> typeRef = new ParameterizedTypeReference<Response<CustomerDetail>>() {
	};

	CustomerService(String restAuthenUrl) throws URISyntaxException {
		restUrl = new URI(restAuthenUrl);
	}

	@Override
	public Response<CustomerDetail> doAuthen(SignIn signIn) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<SignIn> request = new HttpEntity<SignIn>(signIn, headers);
		ResponseEntity<Response<CustomerDetail>> resultResponse = this.restTemplate.exchange(restUrl, HttpMethod.POST,
				request, typeRef);

		if (resultResponse.getStatusCode() == HttpStatus.OK) {
			Response<CustomerDetail> customerResponse = (Response<CustomerDetail>) resultResponse.getBody();

			return customerResponse;
		} else {
			return Response.createError(resultResponse.getStatusCode().toString());
		}
	}
}

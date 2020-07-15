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

import bookstore.service.model.BookDetail;
import bookstore.service.model.Response;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         Implementation for IBookService
 */
class BookService implements IBookService {
	private static ParameterizedTypeReference<Response<List<BookDetail>>> typeRefList = new ParameterizedTypeReference<Response<List<BookDetail>>>() {
	};

	private static ParameterizedTypeReference<Response<BookDetail>> typeRef = new ParameterizedTypeReference<Response<BookDetail>>() {
	};

	private RestTemplate restTemplate = new RestTemplate();

	private String restBookUrl;
	private URI bookUri = null;

	BookService(String restBookUrl) throws URISyntaxException {
		bookUri = new URI(restBookUrl);

		this.restBookUrl = restBookUrl;
	}

	public Response<List<BookDetail>> getRandomBooks() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		BookDetail bookDetail = new BookDetail();

		HttpEntity<BookDetail> request = new HttpEntity<BookDetail>(bookDetail, headers);
		ResponseEntity<Response<List<BookDetail>>> resultResponse = this.restTemplate.exchange(bookUri, HttpMethod.GET,
				request, typeRefList);

		if (resultResponse.getStatusCode() == HttpStatus.OK) {
			Response<List<BookDetail>> bookResponse = (Response<List<BookDetail>>) resultResponse.getBody();

			return bookResponse;

		} else {
			return Response.createError(resultResponse.getStatusCode().toString());
		}
	}

	@Override
	public Response<BookDetail> getBook(long bookId) {
		try {
			URI bookUri = new URI(restBookUrl + "/" + bookId);

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			BookDetail bookDetail = new BookDetail();

			HttpEntity<BookDetail> request = new HttpEntity<BookDetail>(bookDetail, headers);
			ResponseEntity<Response<BookDetail>> resultResponse = this.restTemplate.exchange(bookUri, HttpMethod.GET,
					request, typeRef);

			if (resultResponse.getStatusCode() == HttpStatus.OK) {
				Response<BookDetail> bookResponse = (Response<BookDetail>) resultResponse.getBody();

				return bookResponse;
			} else {
				return Response.createError(resultResponse.getStatusCode().toString());
			}
		} catch (URISyntaxException e) {
			return Response.createError(e.getMessage(), e);
		}

	}
}

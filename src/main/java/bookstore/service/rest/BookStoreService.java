package bookstore.service.rest;

import java.net.URISyntaxException;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         main book store service
 *
 */
public class BookStoreService {
	private ICustomerService customerService;
	private IBookService bookService;
	private IOrderService orderService;

	/**
	 * 
	 * @param url
	 * @throws IllegalArgumentException when url is null or empty
	 * @throws URISyntaxException
	 */
	public BookStoreService(String url) throws IllegalArgumentException, URISyntaxException {
		if (url == null || url.isEmpty()) {
			throw new IllegalArgumentException("url cannot be null or empty");
		}

		bookService = new BookService(url + "/book");
		customerService = new CustomerService(url + "/authen");
		orderService = new OrderService(url + "/order");
	}

	public ICustomerService getCustomerService() {
		return this.customerService;
	}

	public IBookService getBookService() {
		return this.bookService;

	}

	public IOrderService getOrderService() {
		return this.orderService;
	}
}

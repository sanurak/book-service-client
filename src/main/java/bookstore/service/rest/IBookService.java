package bookstore.service.rest;

import java.util.List;

import bookstore.service.model.BookDetail;
import bookstore.service.model.Response;

public interface IBookService {
	public Response<List<BookDetail>> getRandomBooks();

	public Response<BookDetail> getBook(long bookId);

}

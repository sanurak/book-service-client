package bookstore.service.model;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         class for book buying detail
 *
 */
public class BuyDetail {
	private long bookId;
	private int quantity;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

package bookstore.service.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         class for order detail
 *
 */
public class OrderDetail {
	private long id;
	private CustomerDetail customerDetail;
	private BookDetail bookDetail;
	private int quantity;
	private Timestamp orderDate;
	private BigDecimal totalAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CustomerDetail getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(CustomerDetail customerDetail) {
		this.customerDetail = customerDetail;
	}

	public BookDetail getBookDetail() {
		return bookDetail;
	}

	public void setBookDetail(BookDetail bookDetail) {
		this.bookDetail = bookDetail;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}

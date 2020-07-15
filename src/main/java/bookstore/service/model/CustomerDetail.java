package bookstore.service.model;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         class for customer detail
 *
 */
public class CustomerDetail {
	private int id;
	private String name;
	private String token;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

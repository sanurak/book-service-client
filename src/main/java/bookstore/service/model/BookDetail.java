package bookstore.service.model;

import java.math.BigDecimal;

/**
 * 
 * @author Anurak Sirivoravit
 * 
 *         Class for Book Detail
 *
 */
public class BookDetail {
	private long id;
	private String name;
	private String description;
	private BigDecimal priceUsd;
	private String coverImageUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(BigDecimal priceUsd) {
		this.priceUsd = priceUsd;
	}

	public String getCoverImageUrl() {
		return coverImageUrl;
	}

	public void setCoverImageUrl(String coverImageUrl) {
		this.coverImageUrl = coverImageUrl;
	}

}

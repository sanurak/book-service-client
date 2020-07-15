package bookstore.service.rest;

import java.util.List;

import bookstore.service.model.BuyDetail;
import bookstore.service.model.CustomerDetail;
import bookstore.service.model.OrderDetail;
import bookstore.service.model.Response;

public interface IOrderService {
	public Response<List<OrderDetail>> getHistoryOrder(CustomerDetail customerDetail);

	public Response<OrderDetail> saveOrder(CustomerDetail customerDetail, BuyDetail buyCommand);
}

package bookstore.service.rest;

import bookstore.service.model.CustomerDetail;
import bookstore.service.model.Response;
import bookstore.service.model.SignIn;

public interface ICustomerService {
	public Response<CustomerDetail> doAuthen(SignIn signIn);
}

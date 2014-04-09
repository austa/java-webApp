import java.util.HashMap;
import java.util.Map;

public class CustomerSimpleMap implements CustomerLookupService {

	private Map<String, BankCustomer> customers;

	public CustomerSimpleMap() {
		customers = new HashMap<String, BankCustomer>();
		BankCustomer a = new BankCustomer("id001", "Çağatay",  "Saltan", 150);
		BankCustomer b = new BankCustomer("id002", "Ender",  "ÇAlış", 670);
		BankCustomer c = new BankCustomer("id003", "Osman",  "Elipek", -123);
		customers.put("id001", a);
		customers.put("id002", b);
		customers.put("id003", c);

	}

	public BankCustomer findCustomer(String id) {

		if (id != null) {

			return (customers.get(id.toLowerCase()));

		} else {

			return (null);

		}

	}

}

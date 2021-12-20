package com.bhatman.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bhatman.learn.model.Product;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

@Service
public class ProductService {

	public Product getProductById(UUID prodId) {
		StringBuilder sb = new StringBuilder("SELECT * FROM test_faizal.product_catalog WHERE prod_id = ")
				.append(prodId);

		final String query = sb.toString();

		CassConnector client = new CassConnector();
		client.connect("10.101.36.214", 9042);
		Session session = client.getSession();
		ResultSet rs = session.execute(query);

		List<Product> prods = new ArrayList<Product>();

		for (Row r : rs) {
			Product p = new Product(r.getUUID("prod_id"), "", r.getString("description"),
					r.getString("dimensions"), r.getString("location"), r.getString("name"), "",
					1);

			prods.add(p);
		}

		return prods.get(0);
	}

}

package com.cg.bookauthor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Book elecProduct = new Book();
		elecProduct.setId(1);
		elecProduct.setName("LED TV");
		elecProduct.setPrice(45000);

		Book beautyProduct = new Book();
		beautyProduct.setId(2);
		beautyProduct.setName("Face Wash");
		beautyProduct.setPrice(80);

		Book babyProduct = new Book();
		babyProduct.setId(3);
		babyProduct.setName("Pampers");
		babyProduct.setPrice(15);

		Book eleProduct = new Book();
		eleProduct.setId(4);
		eleProduct.setName("CFL Bulb");
		eleProduct.setPrice(250);

		// now define first order and add few products in it
		Author firstOrder = new Author();
		firstOrder.setId(1000);
		firstOrder.setName("golu");

		firstOrder.addProduct(babyProduct);
		firstOrder.addProduct(elecProduct);
		firstOrder.addProduct(beautyProduct);

		// now define second order and add few products in it
		Author secondOrder = new Author();
		secondOrder.setId(1001);
		secondOrder.setName("title do");

		secondOrder.addProduct(babyProduct);
		secondOrder.addProduct(elecProduct);
		secondOrder.addProduct(eleProduct);

		// save orders using entity manager

		em.persist(firstOrder);
		em.persist(secondOrder);

		System.out
				.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
	}

}

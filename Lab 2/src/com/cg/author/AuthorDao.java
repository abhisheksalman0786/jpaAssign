package com.cg.author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AuthorDao {
	

	

		public static void main (String args[]) {

			EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
			EntityManager em = factory.createEntityManager();

			 Author author = new Author ();
			
			 author.setFirstName("John");
			author.setMiddleName("murgan");
			author.setLastName("kumar");
			author.setPhoneNo("7017048831");
			 em.getTransaction().begin();
			 em.persist(author);
			 em.getTransaction().commit();
			System.out.println("Added one student to database.");

			 int id = 2;
			 author = em.find(Author.class, id);
			author.setFirstName("Arshia");
			author.setMiddleName("murgan");
			author.setLastName("kumar");
			author.setPhoneNo("7017048831");
			 em.getTransaction().begin();
			 em.merge(author);
			 em.getTransaction().commit();
			System.out.println("Updated author to database.");

			id=2;
			 author = em.find(Author.class, id);
			 em.getTransaction().begin();
			 em.remove(author);
			 em.getTransaction().commit();
			 System.out.println("Removed student from database.");

			em.close();
			factory.close();
		}}
	


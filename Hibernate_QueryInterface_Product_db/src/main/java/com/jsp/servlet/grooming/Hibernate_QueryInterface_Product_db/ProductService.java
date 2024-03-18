package com.jsp.servlet.grooming.Hibernate_QueryInterface_Product_db;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class ProductService {
	/*
	 * public static Session getSession() {
	 * 
	 * Configuration cfg = new
	 * Configuration().configure().addAnnotatedClass(Product.class); SessionFactory
	 * sf = cfg.buildSessionFactory(); Session session = sf.openSession(); return
	 * session; } public void addProduct() { Scanner sc = new Scanner(System.in);
	 * System.out.
	 * println("Enter Product ID, Product Name, Product Brand, Product Price , Product Category , Product Status"
	 * ); int productId = sc.nextInt(); String productName = sc.next(); String
	 * productBrand = sc.next(); String productCategory=sc.next(); int productPrice
	 * = sc.nextInt(); String productStatus =sc.next();
	 * 
	 * 
	 * Product p = new Product(); p.setProductId(productId);
	 * p.setProductName(productName); p.setProductBrand(productBrand);
	 * p.setProductCategory(productCategory); p.setProductPrice(productPrice);
	 * p.setProductStatus(productStatus);
	 * 
	 * Session session = ProductService.getSession(); Transaction trans =
	 * session.getTransaction(); trans.begin(); session.save(p);
	 * 
	 * trans.commit(); session.close();
	 * System.out.println("Data saved Succesfully!!!");
	 * 
	 * }
	 * 
	 */

	Scanner sc= new Scanner(System.in);
	Product p= new Product();
	public EntityManager getEntityManager() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("arjun");
		EntityManager entityManager = emf.createEntityManager();
		return entityManager;
	}
	public void addProduct() {
		System.out.println("Enter the product Id:");
		int productId=sc.nextInt();
		p.setProductId(productId);
		System.out.println("Enter the product Name:");
		String productName=sc.next();
		p.setProductName(productName);
		System.out.println("Enter the product Brand");
		String productBrand=sc.next();
		p.setProductBrand(productBrand);
		System.out.println("Enter the product Category");
		String productCategory=sc.next();
		p.setProductCategory(productCategory);
		System.out.println("Enter the product Price");
		int productPrice= sc.nextInt();
		p.setProductPrice(productPrice);
		System.out.println("Enter the product Status(Availabel/Not Available)");
		String productStatus=sc.next();
		p.setProductStatus(productStatus);
		EntityManager entityManager = getEntityManager();
		EntityTransaction trans= entityManager.getTransaction();
		trans.begin();
		entityManager.persist(p);
		trans.commit();
		entityManager.close();
	}

	public void findProductById() {
		System.out.println("Enter the product Id:");
		int productId=sc.nextInt();
		p.setProductId(productId);
		EntityManager entityManager = getEntityManager();
		EntityTransaction trans= entityManager.getTransaction();
		trans.begin();
		Query query= entityManager.createQuery("From Productdb where productId=:?");
		query.setParameter("x", productId);
		List<Product> resultList = query.getResultList();
		for(Product p:resultList) {
			System.out.println("Product Id: "+p.getProductId());
			System.out.println("Product Name: "+p.getProductName());
			System.out.println("Product Brand: "+p.getProductBrand());
			System.out.println("Product Category: "+p.getProductCategory());
			System.out.println("Product Price: "+p.getProductPrice());
			System.out.println("Product Status: "+p.getProductStatus());

		}
		trans.commit();
		entityManager.close();
	}
	public void findProductByName() {
		System.out.println("Enter the product Name:");
		String productName=sc.next();
		p.setProductName(productName);
		EntityManager entityManager = getEntityManager();
		EntityTransaction trans= entityManager.getTransaction();
		trans.begin();

		Query query= entityManager.createQuery("From Product p where p.productName=:x");
		query.setParameter("x", productName);
		List<Product> resultList = query.getResultList();
		for(Product p:resultList) {
			System.out.println("Product Id: "+p.getProductId());
			System.out.println("Product Name: "+p.getProductName());
			System.out.println("Product Brand: "+p.getProductBrand());
			System.out.println("Product Category: "+p.getProductCategory());
			System.out.println("Product Price: "+p.getProductPrice());
			System.out.println("Product Status: "+p.getProductStatus());
		}
		trans.commit();
		entityManager.close();
	}
	public void findProductBetweenPrices() {
		System.out.println("Enter the product Price:");
		int start=sc.nextInt();
		int end=sc.nextInt();
		EntityManager entityManager = getEntityManager();
		EntityTransaction trans= entityManager.getTransaction();
		trans.begin();
		Query query = entityManager.createQuery("FROM Product p WHERE p.productPrice BETWEEN :x AND :y");
		query.setParameter("x", start);
		query.setParameter("y", end);
		List<Product> resultList = query.getResultList();

		for(Product p:resultList) {

			System.out.println("Product Id: "+p.getProductId());

			System.out.println("Product Name: "+p.getProductName());

			System.out.println("Product Brand: "+p.getProductBrand());

			System.out.println("Product Category: "+p.getProductCategory());

			System.out.println("Product Price: "+p.getProductPrice());

			System.out.println("Product Status: "+p.getProductStatus());

		}



		trans.commit();

		entityManager.close();



	}



	public void findProductsByCategory() {

		System.out.println("Enter the product Category:");

		String productCategory=sc.next();

		p.setProductCategory(productCategory);



		EntityManager entityManager = getEntityManager();

		EntityTransaction trans= entityManager.getTransaction();

		trans.begin();



		Query query= entityManager.createQuery("From Product p where p.productCategory=:x");

		query.setParameter("x", productCategory);

		List<Product> resultList = query.getResultList();

		for(Product p:resultList) {

			System.out.println("Product Id: "+p.getProductId());

			System.out.println("Product Name: "+p.getProductName());

			System.out.println("Product Brand: "+p.getProductBrand());

			System.out.println("Product Category: "+p.getProductCategory());

			System.out.println("Product Price: "+p.getProductPrice());

			System.out.println("Product Status: "+p.getProductStatus());

		}



		trans.commit();

		entityManager.close();



	}





	public void updateProductsStatus() {

		EntityManager entityManager = getEntityManager();

		EntityTransaction trans= entityManager.getTransaction();

		trans.begin();



		Query query = entityManager.createQuery("update Product p set p.productStatus = 'Not Available'  where p.productStatus = 'Available'");

		query.executeUpdate();

		System.out.println("Updated Successfully!!");



		trans.commit();

		entityManager.close();





	}



	public void updateProductPriceByName() {

		System.out.println("Enter the Product Name:");

		String name=sc.next();

		System.out.println("Enter the new Price of the product:");

		int price =sc.nextInt();



		EntityManager entityManager = getEntityManager();

		EntityTransaction trans= entityManager.getTransaction();

		trans.begin();



		Query query = entityManager.createQuery("update Product p set p.productPrice =:x  where p.productName =:y");

		query.setParameter("x", price);

		query.setParameter("y", name);

		query.executeUpdate();

		System.out.println("Updated Successfully!!");



		trans.commit();

		entityManager.close();



	}



	public void deleteProductByBrand() {

		System.out.println("Enter the product Brand:");

		String brand=sc.next();



		EntityManager entityManager = getEntityManager();

		EntityTransaction trans= entityManager.getTransaction();

		trans.begin();



		Query query = entityManager.createQuery("delete from Product p where p.productBrand =:x");

		query.setParameter("x", brand);

		query.executeUpdate();

		System.out.println("Deleted Successfully!!");



		trans.commit();

		entityManager.close();





	}



	public void deleteProductByCategory() {

		System.out.println("Enter the product Category:");

		String category=sc.next();



		EntityManager entityManager = getEntityManager();

		EntityTransaction trans= entityManager.getTransaction();

		trans.begin();



		Query query = entityManager.createQuery("delete from Product p where p.productCategory =:x");

		query.setParameter("x", category);

		query.executeUpdate();

		System.out.println("Deleted Successfully!!");



		trans.commit();

		entityManager.close();



	}




}

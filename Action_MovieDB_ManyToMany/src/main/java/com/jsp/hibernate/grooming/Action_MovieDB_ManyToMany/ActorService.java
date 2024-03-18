package com.jsp.hibernate.grooming.Action_MovieDB_ManyToMany;

import java.util.List;
import java.util.Scanner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;


public class ActorService {

static Scanner scanner = new Scanner(System.in);
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prajwal");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public static void addActor() {
		System.out.println("Enter Actor ID:");
		int actorId = scanner.nextInt();
		
		System.out.println("Enter Actor Name:");
		String actorName = scanner.next();
		
		System.out.println("Enter Actor Age:");
		int actorAge = scanner.nextInt();
		
		System.out.println("Enter Actor Address:");
		String actorAddress = scanner.next();
		System.out.println("Enter Actor Industry:");
		String industry = scanner.next();
		
		System.out.println("Enter Actor Nationality:");
		String nationality = scanner.next();
		
		Actor actor = new Actor();
		actor.setActorId(actorId);
		actor.setActorName(actorName);
		actor.setActorAge(actorAge);
		actor.setActorAddress(actorAddress);
		actor.setIndustry(industry);
		actor.setNationality(nationality);
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(actor);
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Actor saved successfully");
	}
	
	public static void findActorByName() {
		System.out.println("Enter Actor Name:");
		String actorName = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("actorName"), actorName));
		criteriaQuery.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actor = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println(actor);
	}
	
	public static void findAllActorsByIndustry() {
		System.out.println("Enter Actor Industry:");
		String industry = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("industry"), industry));
		criteriaQuery.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actor = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println(actor);
	}
	public static void findAllActorsByMovieTitle() {
		System.out.println("Enter Movie Title:");
		String movieTitle = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("movieTitle"), movieTitle));
		criteriaQuery.select(root);
		TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Movie> movie = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println(movie);
	}
	public static void findAllActorsBetweenAge() {
		System.out.println("Enter Age Range of Actor:");
		int actorAge1 = scanner.nextInt();
		int actorAge2 = scanner.nextInt();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.where(criteriaBuilder.between(root.get("actorAge"), actorAge1, actorAge2));
		criteriaQuery.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actor = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println(actor);
	}
	
	public static void updateActorAgeById() {
		System.out.println("Enter Actor ID:");
		int actorId = scanner.nextInt();
		
		System.out.println("Enter Actor Age:");
		int actorAge = scanner.nextInt();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Actor> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Actor.class);
		Root<Actor> root = criteriaUpdate.from(Actor.class);
		criteriaUpdate.set("actorAge", actorAge);
		criteriaUpdate.where(criteriaBuilder.equal(root.get("actorId"), actorId));
		Query query = entityManager.createQuery(criteriaUpdate);
		query.executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Actor Updated Successfully");
	}
	public static void updateAllActorIndustryByAddress() {
		System.out.println("Enter Actor Address:");
		String actorAddress = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Actor> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Actor.class);
		Root<Actor> root = criteriaUpdate.from(Actor.class);
		criteriaUpdate.set("actorAddress", actorAddress);
		Query query = entityManager.createQuery(criteriaUpdate);
		query.executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Actor Updated Successfully");
	}
	
	public static void deleteActorByName() {
		System.out.println("Enter Actor Name:");
		String actorName = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Actor> criteriaDelete = criteriaBuilder.createCriteriaDelete(Actor.class);
		Root<Actor> root = criteriaDelete.from(Actor.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("actorName"), actorName));
		Query query = entityManager.createQuery(criteriaDelete);
		query.executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Actor Deleted Successfully");
	}
	
	public static void deleteAllActorsByMoviesName() {
		System.out.println("Enter Movie Name:");
		String movieTitle = scanner.next();
		
		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Movie> criteriaDelete = criteriaBuilder.createCriteriaDelete(Movie.class);
		Root<Movie> root = criteriaDelete.from(Movie.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("movieTitle"), movieTitle));
		Query query = entityManager.createQuery(criteriaDelete);
		query.executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Actors Deleted Successfully");
	}
	
	
}

package com.jsp.hibernate.grooming.Action_MovieDB_ManyToMany;

import java.util.ArrayList;
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

public class MovieService {

	static Scanner sc = new Scanner(System.in);
	public static EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prajwal");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void addMovie() {
		System.out.println("Enter Movie Id");
		int movieId = sc.nextInt();
		System.out.println("Enter Movie Tittle");
		String movieTittle = sc.next();
		System.out.println("Enter the Movie Genere");
		String movieGenere = sc.next();
		System.out.println("Enter The Movie Director...");
		String movieDirector = sc.next();
		System.out.println("Enter the Box office collection");
		int boxofficeCollection = sc.nextInt();
		System.out.println("Enter box office Verdict");
		String boxofficeVerdict = sc.next();
		System.out.println("Enter Movie Language:");
		String movieLanguage = sc.next();


		System.out.println("Enter Number of Actors in this Movie:");
		int n = sc.nextInt();

		int[] actorIds = new int[n];

		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actorsList = typedQuery.getResultList();

		System.out.println("Enter Actor ID's to add them in the Movie");
		for (Actor actor : actorsList) {
			System.out.println(actor);
		}

		for (int i = 0; i < actorIds.length; i++) {
			actorIds[i] = sc.nextInt();
		}
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		movie.setMovieTittle(movieTittle);
		movie.setMovieGenere(movieGenere);
		movie.setMovieDirector(movieDirector);
		movie.setBoxofficeCollection(boxofficeCollection);
		movie.setBoxofficeVerdict(boxofficeVerdict);
		movie.setMovieLanguage(movieLanguage);

		ArrayList<Actor> actors = new ArrayList<Actor>();
		movie.setA(actors);

		for (Integer actorId : actorIds) {
			criteriaQuery.where(criteriaBuilder.equal(root.get("actorId"), actorId));
			typedQuery = entityManager.createQuery(criteriaQuery);
			Actor actor = typedQuery.getResultList().get(0);
			actor.getM().add(movie);
			actors.add(actor);
		}

		entityManager.persist(movie);
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Movie saved successfully");
	}


	public void findMovieById() {
		System.out.println("Enter Movie Id:");
		int movieId = sc.nextInt();

		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("movieId"), movieId));
		criteriaQuery.select(root);
		TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Movie> movies = typedQuery.getResultList();

		entityTransaction.commit();
		entityManager.close();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public void findMovieByName() {
		System.out.println("Enter Movie Name: ");
		String movieTittle=sc.next();

		EntityManager entityManager = ActorService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("movieTittle"), movieTittle));
		criteriaQuery.select(root);
		TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Movie> movie = typedQuery.getResultList();

		entityTransaction.commit();
		entityManager.close();
		System.out.println(movie);
	}
	
	public static void findAllMoviesByDirector() {
		System.out.println("Enter Movie Director: ");
		String movieDirector = sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("movieDirector"), movieDirector));
		criteriaQuery.select(root);
		
		TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Movie> movies = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		
		for (Movie movie : movies) {
			System.out.println(movies);
		}
	}
	
	public static void findAllMoviesByGenre() {
		System.out.println("Enter Movie Genere Name");
		String movieGenere = sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
		Root<Movie> root = criteriaQuery.from(Movie.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("movieGenere"), movieGenere));
		criteriaQuery.select(root);
		
		TypedQuery<Movie> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Movie> movies = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}
	
	public static void findAllMoviesByActorName() {
		System.out.println("Enter Actor Name:");
		String actorName=sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("actorName"), actorName));
		criteriaQuery.select(root);
		
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actors = typedQuery.getResultList();
		
		entityTransaction.commit();
		entityManager.close();
		for (Actor actor : actors) {
			List<Movie> movies = actor.getM();
			for (Movie movie : movies) {
				System.out.println(movie);
			}
		}
	}

	public static void updateAllMoviesByBoxOfficeCollection() {
		System.out.println("Enter the Range of Box Office Collection");
		int boxOfficeCollection1 = sc.nextInt();
		int boxOfficeCollection2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Box Office Verdict:");
		String boxOfficeVerdict = sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Movie> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Movie.class);
		
		Root<Movie> root = criteriaUpdate.from(Movie.class);
		criteriaUpdate.set("boxOfficeVerdict", boxOfficeVerdict);
		criteriaUpdate.where(criteriaBuilder.between(root.get("boxOfficeCollection"), boxOfficeCollection1, boxOfficeCollection2));
//		Query query = entityManager.createQuery(criteriaUpdate);
//		query.executeUpdate();
		Query query = entityManager.createQuery(criteriaUpdate);
		query.executeUpdate();
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Movies Updated Successfully");
	}

	
	public static void updateAllMoviesByBoxOfficeCollection1() {
		System.out.println("Enter the Range of Box Office Collection");
		int boxOfficeCollection1 = sc.nextInt();
		int boxOfficeCollection2 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Box Office Verdict:");
		String boxOfficeVerdict = sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaUpdate<Movie> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Movie.class);
		Root<Movie> root = criteriaUpdate.from(Movie.class);
		criteriaUpdate.set("boxOfficeVerdict", boxOfficeVerdict);
		criteriaUpdate.where(criteriaBuilder.between(root.get("boxOfficeCollection"), boxOfficeCollection1, boxOfficeCollection2));
		Query query = entityManager.createQuery(criteriaUpdate);
		query.executeUpdate();

		entityTransaction.commit();
		entityManager.close();
		System.out.println("Movie/s Updated Successfully");
	}
	
	public static void deleteMovieByName() {
		System.out.println("Enter Movie Name:");
		String movieTitle = sc.nextLine();

		EntityManager entityManager = MovieService.getEntityManager();
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
		System.out.println("Movie Deleted Successfully");
	}
	
	public static void deleteAllMoviesByDirector() {
		System.out.println("Enter Director Name:");
		String movieDirector = sc.nextLine();
		
		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<Movie> criteriaDelete = criteriaBuilder.createCriteriaDelete(Movie.class);
		Root<Movie> root = criteriaDelete.from(Movie.class);
		criteriaDelete.where(criteriaBuilder.equal(root.get("movieDirector"), movieDirector));
		Query query = entityManager.createQuery(criteriaDelete);
		query.executeUpdate();
		
		entityTransaction.commit();
		entityManager.close();
		System.out.println("Movie/s Deleted Successfully");
	}
	

	public static void deleteAllMoviesByActorName() {
		System.out.println("Enter Actor Name:");
		String actorName = sc.nextLine();

		EntityManager entityManager = MovieService.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
		Root<Actor> root = criteriaQuery.from(Actor.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get("actorName"), actorName));
		criteriaQuery.select(root);
		TypedQuery<Actor> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Actor> actors = typedQuery.getResultList();

		for (Actor actor : actors) {
			List<Movie> movies = actor.getM();
			for (Movie movie : movies) {
				CriteriaDelete<Movie> criteriaDelete = criteriaBuilder.createCriteriaDelete(Movie.class);
				Root<Movie> rootActor = criteriaDelete.from(Movie.class);
				criteriaDelete.where(criteriaBuilder.equal(rootActor.get("movieId"), movie.getMovieId()));
				Query query = entityManager.createQuery(criteriaDelete);
				query.executeUpdate();
			}
		}

		entityTransaction.commit();
		entityManager.close();
		System.out.println("Movie/s Deleted Successfully");
	}


}

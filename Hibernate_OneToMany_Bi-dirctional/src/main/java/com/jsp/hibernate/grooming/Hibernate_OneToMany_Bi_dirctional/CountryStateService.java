package com.jsp.hibernate.grooming.Hibernate_OneToMany_Bi_dirctional;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CountryStateService {
	public static Session getSession() {
	
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Country.class).addAnnotatedClass(State.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		return session;
	}
	
	public static void addCountry(Country country) {
	Session session = CountryStateService.getSession();
	Transaction trans = session.beginTransaction();
	session.save(country);
	trans.commit();
	session.close();
	System.out.println("Country Data Saved Succesfully!");
	}
	public static void findCountryById(int countryId) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryId = " + countryId);
		List<Country> country = query.getResultList();
		System.out.println(country);
		transaction.commit();
		session.close();
	}
	
	public static void findCountryByName(String countryName) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryName = '" + countryName + "'");
		List<Country> country = query.getResultList();
		System.out.println(country);
		transaction.commit();
		session.close();
	}
	
	public static void findAllCountries() {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country");
		List<Country> countryList = query.getResultList();
		for (Country country : countryList) {
			System.out.println(country);
		}
		transaction.commit();
		session.close();
	}
	
	public static void findCountryByContinent(String countryContinent) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryContinent = '" + countryContinent + "'");
		List<Country> country = query.getResultList();
		System.out.println(country);
		transaction.commit();
		session.close();
	}
	
	public static void findCountryByPresident(String countryPresident) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryPresident = '" + countryPresident + "'");
		List<Country> country = query.getResultList();
		System.out.println(country);
		transaction.commit();
		session.close();
	}
	
	public static void addState(State state, int countryId) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		
		try {
			Country country = session.get(Country.class, countryId);
			state.setCountry(country);
			List<State> states = country.getStates();
			states.add(state);
			session.save(state);
			System.out.println("State Saved Succesfully");
		} catch (Exception e) {
			System.out.println("There is no Country available");
		}
		
		transaction.commit();
		session.close();
	}
	
	public static void deleteCountryById(int countryId) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Country country = session.get(Country.class, countryId);
		List<State> states = country.getStates();
		for (State state : states) {
			session.delete(state);
		}
		session.delete(country);
		transaction.commit();
		session.close();
		System.out.println("Country deleted Succesfully");
	}
	
	public static void deleteCountryByName(String countryName) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryName = '" + countryName + "'");
		List<Country> countryList = query.getResultList();
		Country country = countryList.get(0);
		List<State> states = country.getStates();
		for (State state : states) {
			session.delete(state);
		}
		session.delete(country);
		transaction.commit();
		session.close();
		System.out.println("Country deleted Succesfully");
	}
	
	public static void updatePresidentByCountryName(String countryName, String countryPresident) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryName = '" + countryName + "'");
		List<Country> countryList = query.getResultList();
		Country country = countryList.get(0);
		country.setCountryPresident(countryPresident);
		session.update(country);
		transaction.commit();
		session.close();
		System.out.println("Country updated Succesfully");
	}
	
	public static void updatePopulationByCountryId(int countryId, int countryPopulation) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Country country = session.get(Country.class, countryId);
		country.setCountryPopulation(countryPopulation);
		session.update(country);
		transaction.commit();
		session.close();
		System.out.println("Country updated Succesfully");
	}
	
	public static void findStateById(int stateId) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<State> query = session.createQuery("from State where stateId = " + stateId);
		List<State> state = query.getResultList();
		System.out.println(state);
		transaction.commit();
		session.close();
	}
	
	public static void findStateByName(String stateName) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<State> query = session.createQuery("from State where stateName = '" + stateName + "'");
		List<State> state = query.getResultList();
		System.out.println(state);
		transaction.commit();
		session.close();
	}
	
	public static void findStateByChiefMinister(String stateChiefMinister) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<State> query = session.createQuery("from State where stateChiefMinister = '" + stateChiefMinister + "'");
		List<State> state = query.getResultList();
		System.out.println(state);
		transaction.commit();
		session.close();
	}
	
	public static void findStatesByCountryId(int countryId) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Country country = session.get(Country.class, countryId);
		List<State> list = country.getStates();
		for (State state : list) {
			System.out.println(state);
		}
		transaction.commit();
		session.close();
	}
	
	public static void findStatesByCountryName(String countryName) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<Country> query = session.createQuery("from Country where countryName = '" + countryName + "'");
		List<Country> countryList = query.getResultList();
		Country country = countryList.get(0);
		List<State> list = country.getStates();
		for (State state : list) {
			System.out.println(state);
		}
		transaction.commit();
		session.close();
	}
	
	public static void updateStatePopulationByName(String stateName, int statePopulation) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<State> query = session.createQuery("from State where stateName = '" + stateName + "'");
		List<State> stateList = query.getResultList();
		State state = stateList.get(0);
		state.setStatePopulation(statePopulation);
		session.update(state);
		transaction.commit();
		session.close();
		System.out.println("State updated Succesfully");
		
	}
	
	public static void deleteStateByName(String stateName) {
		Session session = CountryStateService.getSession();
		Transaction transaction = session.beginTransaction();
		Query<State> query = session.createQuery("from State where stateName = '" + stateName + "'");
		List<State> stateList = query.getResultList();
		State state = stateList.get(0);
		session.delete(state);
		transaction.commit();
		session.close();
		System.out.println("State deleted Succesfully");
	}
	
}

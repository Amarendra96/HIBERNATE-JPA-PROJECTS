package com.jsp.hibernate.grooming.Hibernate_OneToMany_Bi_dirctional;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{

		/*
		 * State s1 = new State(); s1.setStateId(201); s1.setStateName("Odisha");
		 * s1.setStatePopulation(45); s1.setStateChiefMinister("Naveen Patnaik");
		 * 
		 * State s2 = new State(); s2.setStateId(202); s2.setStateName("Delhi");
		 * s2.setStatePopulation(32); s2.setStateChiefMinister("Arvind Kejriwal");
		 * 
		 * State s3 = new State(); s3.setStateId(203); s3.setStateName("Telangana");
		 * s3.setStatePopulation(10); s3.setStateChiefMinister("Revanth Reddy");
		 * 
		 * State s4 = new State(); s4.setStateId(206); s4.setStateName("Scotland");
		 * s4.setStatePopulation(5466000); s4.setStateChiefMinister("Hamza Yousaf");
		 * 
		 * State s5 = new State(); s5.setStateId(208);
		 * s5.setStateName("NorthernIreland"); s5.setStatePopulation(1895510);
		 * s5.setStateChiefMinister("Michelle O'Neil");
		 * 
		 * Country c1 = new Country(); c1.setCountryId(101); c1.setCountryName("India");
		 * c1.setContinent("Asia"); c1.setCountryPopulation(150);
		 * c1.setCountryPresident("Droupadi Murmu");
		 * c1.setCountryPrimeMinister("Narendra Modi"); c1.setStates(Arrays.asList(s1 ,
		 * s2 , s3));
		 * 
		 * 
		 * Country c2 = new Country(); c2.setCountryId(102);
		 * c2.setCountryName("United Kingdom"); c2.setContinent("Europe");
		 * c2.setCountryPopulation(67081234); c2.setCountryPresident("Rishi Sunak");
		 * c2.setCountryPrimeMinister("Rishi Sunak"); c2.setStates(Arrays.asList(s4 ,
		 * s5));
		 * 
		 * s1.setCountry(c1); s2.setCountry(c1); s3.setCountry(c1);
		 * 
		 * s4.setCountry(c2); s5.setCountry(c2);
		 * 
		 * Configuration cfg = new
		 * Configuration().configure().addAnnotatedClass(Country.class).
		 * addAnnotatedClass(State.class); SessionFactory sf =
		 * cfg.buildSessionFactory(); Session session = sf.openSession(); Transaction
		 * trans = session.beginTransaction();
		 * 
		 * session.save(s1); session.save(s1); session.save(s2); session.save(s3);
		 * session.save(s4); session.save(s5); session.save(c1); session.save(c2);
		 * 
		 * trans.commit(); session.close();
		 */

//				    	CountryStateService.findStatesByCountryId(101);
		CountryStateService.findCountryById(101);
	}
}

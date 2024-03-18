package com.jsp.hibernate.grooming.Action_MovieDB_ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieTittle;
	private String movieGenere;
	private String movieDirector;
	private int boxofficeCollection;
	private String boxofficeVerdict;
	private String movieLanguage;
	@ManyToMany(mappedBy = "m")
	private List<Actor>a;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieTittle() {
		return movieTittle;
	}
	public void setMovieTittle(String movieTittle) {
		this.movieTittle = movieTittle;
	}
	public String getMovieGenere() {
		return movieGenere;
	}
	public void setMovieGenere(String movieGenere) {
		this.movieGenere = movieGenere;
	}
	public String getMovieDirector() {
		return movieDirector;
	}
	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}
	public int getBoxofficeCollection() {
		return boxofficeCollection;
	}
	public void setBoxofficeCollection(int boxofficeCollection) {
		this.boxofficeCollection = boxofficeCollection;
	}
	public String getBoxofficeVerdict() {
		return boxofficeVerdict;
	}
	public void setBoxofficeVerdict(String boxofficeVerdict) {
		this.boxofficeVerdict = boxofficeVerdict;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public List<Actor> getA() {
		return a;
	}
	public void setA(List<Actor> a) {
		this.a = a;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTittle=" + movieTittle + ", movieGenere=" + movieGenere
				+ ", movieDirector=" + movieDirector + ", boxofficeCollection=" + boxofficeCollection
				+ ", boxofficeVerdict=" + boxofficeVerdict + ", movieLanguage=" + movieLanguage + ", a=" + a + "]";
	}
	

}

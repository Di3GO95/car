package org.diego.tutorial.car.databases.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import org.diego.tutorial.car.model.Car;

/**
 * Implementation of the JPA persistence with specific
 * car methods
 */
@Stateless
public class JPAImplCar extends JPAImpl {
	/**
	 * Method that retrieves all the car objects from the database, that are
	 * from a certain country.
	 * @param country Country searched
	 * @return List of cars from the country searched
	 */
	public List<Car> getAllCarsFromCountry(String country){
		String countryLowerCase = country.toLowerCase();
		
		String query = "SELECT car FROM Car car WHERE car.country='" + countryLowerCase + "'";
		TypedQuery<Car> createQuery = em.createQuery(query, Car.class);
		
		List<Car> carsFromCountry = createQuery.getResultList();
		return carsFromCountry;
	}

	/**
	 * Method that queries the database and retrieves all the non checked cars
	 * @return List of non checked cars.
	 */
	public List<Car> getAllNonCheckedCars() {
		String query = "SELECT car FROM Car car WHERE car.checked='false'";
		
		TypedQuery<Car> createQuery = em.createQuery(query, Car.class);
		List<Car> nonCheckedCars = createQuery.getResultList();
		return nonCheckedCars;
	}
}

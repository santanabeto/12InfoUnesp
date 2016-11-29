package br.unesp.infounesp;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unesp.infounesp.util.PersistenceManager;
import model.City;

public class TesteFunctionsWithJavaCode {
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query query = em.createQuery("select c from City c "
				+ " join fetch c.country pais ");		
		List<City> cityList = query.getResultList();
		
		
		Map<String, Integer> mapPopulacao =  cityList.stream().collect(
				Collectors.groupingBy(city -> city.getCountry().getContinent(), 
							Collectors.summingInt(City::getPopulation)
						)				
				);
		
		System.out.println(mapPopulacao);
		
	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
}

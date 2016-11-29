package br.unesp.infounesp;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unesp.infounesp.util.PersistenceManager;

public class TesteFunctionsWithHQL {
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query query = em.createQuery("select c.country.continent, sum(c.population) from City c "				
				+ " group by c.country.continent ");		
		List<Object[]> cityList = query.getResultList();
		
		//Soma total da população
		cityList.stream().forEach(e -> System.out.println("Continente:"+e[0]+" População:"+e[1]));
		
	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
}

package br.unesp.infounesp;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unesp.infounesp.bos.CountryBO;
import br.unesp.infounesp.util.PersistenceManager;

public class TesteCountriesWithNewObject {
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query query = em.createQuery("select new br.unesp.infounesp.bos.CountryBO(c.name, c.population) from Country c");
		
		List<CountryBO> countryList = query.getResultList();
		
		System.out.println(countryList);
		
	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
	
	
}

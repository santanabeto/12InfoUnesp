package br.unesp.infounesp;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unesp.infounesp.util.PersistenceManager;
import model.Country;

public class TesteCountriesSemN1 {
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query query = em.createQuery("select c from Country c join fetch c.capital ca ");
		
		List<Country> countryList = query.getResultList();
		
		System.out.println(countryList);
		
	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
}

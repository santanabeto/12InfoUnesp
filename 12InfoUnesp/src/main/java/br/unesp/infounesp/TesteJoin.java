package br.unesp.infounesp;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unesp.infounesp.util.PersistenceManager;

public class TesteJoin {
	@SuppressWarnings("unchecked")
	public static void main(String args[])
	{
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		
		Query query = em.createQuery("select c.name from City c "
				+ " join c.country.linguas lingua "
				+ " where lingua.language='English' "
				);
		
		List<String> cityList = query.getResultList();
		
		System.out.println(cityList);
		
	    em.close();
	    PersistenceManager.INSTANCE.close();
	}
}

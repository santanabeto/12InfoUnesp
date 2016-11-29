package br.unesp.infounesp.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.City;

@Stateless
@LocalBean
public class CityBusiness {
	@PersistenceContext(unitName="infoUnespPU")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<City> todasAsCidades()
	{
		Query query = getEm().createQuery("select c from City c");
		List<City> cidades = query.getResultList(); 
		return cidades;		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}

package br.unesp.infounesp.business;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import br.unesp.infounesp.bos.CityBO;

@Stateless
@LocalBean
public class CityBusiness {
	@PersistenceContext(unitName="infoUnespPU")
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<CityBO> todasAsCidades(int first, int pageSize, String sortField, String sortOrder,
			Map<String, Object> filters)
	{
		StringBuffer sqlQuery = new StringBuffer("select new br.unesp.infounesp.bos.CityBO(c.name, c.country.name, c.population) from City c ");
		//sqlQuery.append(" join fetch c.country pais ");
		
		if (StringUtils.isNotEmpty(sortField))
		{
			sqlQuery.append(" order by "+sortField);
			
			if ("ASCENDING".equals(sortOrder))
				sqlQuery.append(" asc ");
			else if ("DESCENDING".equals(sortOrder))
				sqlQuery.append(" desc ");
		}
		
		Query query = getEm().createQuery(sqlQuery.toString());
		query.setFirstResult(first);
		query.setMaxResults(pageSize);
		
		List<CityBO> cidades = query.getResultList(); 
		return cidades;		
	}
	
	public Long quantidadeDeCidades()
	{
		Query query = getEm().createQuery("select count(c) from City c");
		Long qtdCidades = (Long) query.getSingleResult(); 
		return qtdCidades;		
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}

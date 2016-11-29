package br.unesp.infounesp.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import br.unesp.infounesp.business.CityBusiness;
import model.City;

@Named
@RequestScoped
public class CityMB {
	@EJB private CityBusiness cityBusiness;
	
	private List<City> listaDeCidades;

	public List<City> getListaDeCidades() {
		return listaDeCidades;
	}
	
	@PostConstruct
	public void init()
	{
		listaDeCidades = cityBusiness.todasAsCidades();
	}

	public void setListaDeCidades(List<City> listaDeCidades) {
		this.listaDeCidades = listaDeCidades;
	}

	public CityBusiness getCityBusiness() {
		return cityBusiness;
	}

	public void setCityBusiness(CityBusiness cityBusiness) {
		this.cityBusiness = cityBusiness;
	}
	
	
}

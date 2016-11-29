package br.unesp.infounesp.managedbeans;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.unesp.infounesp.bos.CityBO;
import br.unesp.infounesp.business.CityBusiness;

@Named
@RequestScoped
public class CityMB {
	@EJB private CityBusiness cityBusiness;
	
	private LazyDataModel<CityBO> listaDeCidades;

	public LazyDataModel<CityBO> getListaDeCidades() {
		return listaDeCidades;
	}
	
	@SuppressWarnings("serial")
	@PostConstruct
	public void init()
	{
		listaDeCidades = new LazyDataModel<CityBO>() {
			@Override
			public List<CityBO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				return cityBusiness.todasAsCidades(first, pageSize, sortField, sortOrder.name(), filters);
			}
		};
		
		listaDeCidades.setRowCount(cityBusiness.quantidadeDeCidades().intValue());
	}

	public void setListaDeCidades(LazyDataModel<CityBO> listaDeCidades) {
		this.listaDeCidades = listaDeCidades;
	}

	public CityBusiness getCityBusiness() {
		return cityBusiness;
	}

	public void setCityBusiness(CityBusiness cityBusiness) {
		this.cityBusiness = cityBusiness;
	}
	
	
}

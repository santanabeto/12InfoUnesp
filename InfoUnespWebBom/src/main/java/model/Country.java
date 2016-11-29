package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String code;

	private String code2;

	private String continent;

	private BigDecimal gnp;

	private BigDecimal gnpold;

	private String governmentform;

	private String headofstate;

	private Integer indepyear;

	private Float lifeexpectancy;

	private String localname;

	private String name;

	private Integer population;

	private String region;

	private float surfacearea;

	@ManyToOne
	@JoinColumn(name="capital")	
	private City capital;
	
	@OneToMany(mappedBy="country")	
	private List<Countrylanguage> linguas;
	
	@OneToMany(mappedBy="country")
	private List<City> cidades;

	public Country() {
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode2() {
		return this.code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getContinent() {
		return this.continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public BigDecimal getGnp() {
		return this.gnp;
	}

	public void setGnp(BigDecimal gnp) {
		this.gnp = gnp;
	}

	public BigDecimal getGnpold() {
		return this.gnpold;
	}

	public void setGnpold(BigDecimal gnpold) {
		this.gnpold = gnpold;
	}

	public String getGovernmentform() {
		return this.governmentform;
	}

	public void setGovernmentform(String governmentform) {
		this.governmentform = governmentform;
	}

	public String getHeadofstate() {
		return this.headofstate;
	}

	public void setHeadofstate(String headofstate) {
		this.headofstate = headofstate;
	}

	public Integer getIndepyear() {
		return this.indepyear;
	}

	public void setIndepyear(Integer indepyear) {
		this.indepyear = indepyear;
	}

	public float getLifeexpectancy() {
		return this.lifeexpectancy;
	}

	public void setLifeexpectancy(float lifeexpectancy) {
		this.lifeexpectancy = lifeexpectancy;
	}

	public String getLocalname() {
		return this.localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPopulation() {
		return this.population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public float getSurfacearea() {
		return this.surfacearea;
	}

	public void setSurfacearea(float surfacearea) {
		this.surfacearea = surfacearea;
	}

	public City getCapital() {
		return this.capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public List<Countrylanguage> getLinguas() {
		return linguas;
	}

	public void setLinguas(List<Countrylanguage> linguas) {
		this.linguas = linguas;
	}

	public List<City> getCidades() {
		return cidades;
	}

	public void setCidades(List<City> cidades) {
		this.cidades = cidades;
	}
}
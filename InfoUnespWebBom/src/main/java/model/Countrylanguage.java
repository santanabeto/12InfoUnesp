package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@NamedQuery(name="Countrylanguage.findAll", query="SELECT c FROM Countrylanguage c")
public class Countrylanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CountrylanguagePK id;

	private Boolean isofficial;

	private float percentage;

	@ManyToOne
	@JoinColumn(name="countrycode", insertable=false, updatable=false)
	private Country country;
	
	@Column(insertable=false, updatable=false)
	private String language;

	public Countrylanguage() {
	}

	public CountrylanguagePK getId() {
		return this.id;
	}

	public void setId(CountrylanguagePK id) {
		this.id = id;
	}

	public Boolean getIsofficial() {
		return this.isofficial;
	}

	public void setIsofficial(Boolean isofficial) {
		this.isofficial = isofficial;
	}

	public float getPercentage() {
		return this.percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	
}
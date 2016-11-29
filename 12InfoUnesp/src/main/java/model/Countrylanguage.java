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
	
	@Embeddable
	public static class CountrylanguagePK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;
		
		@Column(columnDefinition = "bpchar(2)")
		private String countrycode;

		private String language;

		public CountrylanguagePK() {
		}
		
		public String getLanguage() {
			return this.language;
		}
		public void setLanguage(String language) {
			this.language = language;
		}

		public String getCountrycode() {
			return countrycode;
		}

		public void setCountrycode(String countrycode) {
			this.countrycode = countrycode;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((countrycode == null) ? 0 : countrycode.hashCode());
			result = prime * result + ((language == null) ? 0 : language.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CountrylanguagePK other = (CountrylanguagePK) obj;
			if (countrycode == null) {
				if (other.countrycode != null)
					return false;
			} else if (!countrycode.equals(other.countrycode))
				return false;
			if (language == null) {
				if (other.language != null)
					return false;
			} else if (!language.equals(other.language))
				return false;
			return true;
		}
		
		
		

	}

}
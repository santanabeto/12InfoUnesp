package br.unesp.infounesp.bos;

public class CityBO
{
	public CityBO(String nome,String pais, Integer populacao)
	{
		this.nome=nome;
		this.populacao=populacao;
		this.pais=pais;
	}

	private String nome;
	private Integer populacao;
	private String pais;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPopulacao() {
		return populacao;
	}
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
}


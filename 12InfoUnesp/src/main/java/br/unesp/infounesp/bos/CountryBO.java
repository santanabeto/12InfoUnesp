package br.unesp.infounesp.bos;

public class CountryBO
{
	public CountryBO(String nome, Integer populacao)
	{
		this.nome=nome;
		this.populacao=populacao;
	}

	private String nome;
	private Integer populacao;
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
}


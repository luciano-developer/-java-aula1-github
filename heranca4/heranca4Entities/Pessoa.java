package heranca4Entities;

public abstract class Pessoa {

	protected String nome;
	protected Double renda;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Pessoa(String nome, Double renda) {
		this.nome = nome;
		this.renda = renda;
	}

	public Pessoa() {
		
	}

	public abstract Double calculoImposto();
}

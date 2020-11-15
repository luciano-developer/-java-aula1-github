package heranca4Entities;

public class PJ extends Pessoa {

	private Integer numFuncionarios;
	
	public Integer getNumFuncionarios() {
		return numFuncionarios;
	}

	public void setNumFuncionarios(Integer numFuncionarios) {
		this.numFuncionarios = numFuncionarios;
	}

	public PJ(String nome, Double renda, Integer numFuncionarios) {
		super(nome, renda);
		this.numFuncionarios = numFuncionarios;
	}

	public PJ() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calculoImposto() {
		double imposto = 0;
		
		if(numFuncionarios<10)
			imposto = (renda * 0.16);
		else
			imposto = (renda * 0.14);
			
			return imposto;
	}

}

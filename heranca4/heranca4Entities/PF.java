package heranca4Entities;

public class PF extends Pessoa {

	private Double gastosSaude;
	
	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	public PF(String nome, Double renda, Double gastosSaude) {
		super(nome, renda);
		this.gastosSaude = gastosSaude;
	}

	public PF() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double calculoImposto() {
		double imposto = 0;
		
		if(renda < 20000.0)		
			imposto = (renda * 0.15) - (gastosSaude * 0.5);
		else
			imposto = (renda * .25) - (gastosSaude * 0.5);
				
		if(imposto<0)
			imposto =0;
		
		return imposto;
	}

}

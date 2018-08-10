package pt.aubay.cv.models;

public enum Status{
	
	INICIADO("Em Análise"),
	PREAPROVADO("Aguarda Aprovação"),
	APROVADO ("Aprovado"), 
	REPROVADO("Reprovado");
	
	public String label;
	
	Status(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

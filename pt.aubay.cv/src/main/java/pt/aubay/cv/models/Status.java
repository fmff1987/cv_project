package pt.aubay.cv.models;

public enum Status{
	PREAPROVADO("preAprovado"),
	APROVADO ("aprovado"), 
	REPROVADO("reprovado");
	
	public String label;
	
	Status(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

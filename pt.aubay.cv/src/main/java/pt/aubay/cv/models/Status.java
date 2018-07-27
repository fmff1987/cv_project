package pt.aubay.cv.models;

public enum Status{
	PREAPROVADO("preAprovado"),
	APROVADO ("aprovado"), 
	REPROVADO("reprovado");
	
	private String label;
	
	private Status(String label) {
		this.label = label;
	}
	public String getLabel() {
		return label;
	}
}

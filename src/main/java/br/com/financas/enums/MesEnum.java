package br.com.financas.enums;

public enum MesEnum {
	janeiro(1, "Janeiro"), 
	fevereiro(2, "Fevereiro"), 
	marco(3, "Março"), 
	abril(4, "Abril"), 
	maio(5, "Maio"),
	junho(6, "Junho"), 
	julho(7, "Julho"), 
	agosto(8, "Agosto"), 
	setembro(9, "Setembro"), 
	outubro(10, "Outubro"),
	novembro(11, "Novembro"), 
	dezembro(12, "Dezembro");

	private Integer codMes;
	private String descricaoMes;

	private MesEnum(Integer codMes, String descricaoMes) {
		this.codMes = codMes;
		this.descricaoMes = descricaoMes;
	}

	public Integer getCodMes() {
		return codMes;
	}

	public void setCodMes(Integer codMes) {
		this.codMes = codMes;
	}

	public String getDescricaoMes() {
		return descricaoMes;
	}

	public void setDescricaoMes(String descricaoMes) {
		this.descricaoMes = descricaoMes;
	}

}

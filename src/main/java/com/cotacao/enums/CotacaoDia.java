package com.cotacao.enums;

public enum CotacaoDia {
	DOLAR("dolar", "0,19", "Dólar"), EURO("euro", "0,16", "Euro");

	private String chave;
	private String valor;
	private String descricao;

	CotacaoDia(String chave, String valor, String descricao) {
		this.chave = chave;
		this.valor = valor;
		this.descricao = descricao;
	}

	public static String getCotacaoDia(final String chave) {
		for (CotacaoDia c : CotacaoDia.values()) {
			if (c.getChave().equals(chave)) {
				return "1 Real brasileiro igual a " + c.getValor() + " " + c.getDescricao();
			}
		}

		return "chave inválida";
	}

	public String getChave() {
		return chave;
	}

	public String getValor() {
		return valor;
	}

	public String getDescricao() {
		return descricao;
	}

}

package br.com.financas.controle.exception.handler;

public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	private Throwable cause;
	
	public ApiException(String mensagem, Throwable cause) {
		super(mensagem, cause);
	}
	
	public ApiException(String mensagem) {
		super(mensagem);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}
	
	
	

}

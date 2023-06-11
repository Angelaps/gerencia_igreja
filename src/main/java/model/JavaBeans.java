package model;

public class JavaBeans {
	private String  id_membro;
	private String nome;
	private String cargo;
	private String dizimista;
		
	public JavaBeans() {
		super();
	}
	public JavaBeans(String id_membro, String nome, String cargo, String dizimista) {
		super();
		this.id_membro = id_membro;
		this.nome = nome;
		this.cargo = cargo;
		this.dizimista = dizimista;
	}
	public String getId_membro() {
		return id_membro;
	}
	public void setId_membro(String id_membro) {
		this.id_membro = id_membro;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDizimista() {
		return dizimista;
	}
	public void setDizimista(String dizimista) {
		this.dizimista = dizimista;
	}
	
 
}

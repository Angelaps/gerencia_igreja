package model;

public class Setor {
    private String id_setor;
    private String nome;
    // Outros atributos do setor
    
    public Setor() {
        super();
    }
    
    public Setor(String id_setor, String nome /*, outros parâmetros do setor */) {
        super();
        this.id_setor = id_setor;
        this.nome = nome;
        // Inicialize outros atributos do setor
    }
    
    public String getId_setor() {
        return id_setor;
    }
    
    public void setId_setor(String id_setor) {
        this.id_setor = id_setor;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    // Outros getters e setters para os atributos do setor
}

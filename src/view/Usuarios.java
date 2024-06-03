package view;

public class Usuarios {

    private int id;
    private String nome_do_Episodio;
    private String NumeroEp;
    private int DURACAO;
    private String URLRepo;
    private String produtor;

    public Usuarios() {
    }

    public Usuarios(int id, String nome_do_Episodio, String NumeroEp, int DURACAO, String URLRepo, String produtor) {
        this.id = id;
        this.nome_do_Episodio = nome_do_Episodio;
        this.NumeroEp = NumeroEp;
        this.DURACAO = DURACAO;
        this.URLRepo = URLRepo;
        this.produtor = produtor;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_do_Episodio() {
        return nome_do_Episodio;
    }

    public void setNome_do_Episodio(String nome_do_Episodio) {
        this.nome_do_Episodio = nome_do_Episodio;
    }

    public String getNumeroEp() {
        return NumeroEp;
    }

    public void setNumeroEp(String NumeroEp) {
        this.NumeroEp = NumeroEp;
    }

    public int getDURACAO() {
        return DURACAO;
    }

    public void setDURACAO(int DURACAO) {
        this.DURACAO = DURACAO;
    }

    public String getURLRepo() {
        return URLRepo;
    }

    public void setURLRepo(String URLRepo) {
        this.URLRepo = URLRepo;
    }

    public String getProdutor() {
    return produtor;
}
   public void setProdutor(String produtor) {
    this.produtor = produtor;
}
}

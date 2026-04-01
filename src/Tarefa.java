public class Tarefa {
	private String nomeTarefa;
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNomeTarefa() {
		return nomeTarefa;
	}
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}
	
	@Override
	public String toString() {

	    return "Nome      : " + nomeTarefa + "\n" +
	           "Descrição : " + descricao;
	}
}

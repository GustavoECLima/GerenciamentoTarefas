import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GerenciadorDeTarefas {
    
	List<Tarefa>listaDeTarefas = new ArrayList<>();
    int concluidas = 0;
    
    
    
    public boolean adicionaTarefa(String nomeTarefa, String descricaoTarefa){
    	if (nomeTarefa.isEmpty() || descricaoTarefa.isEmpty()) {
    		return false;
		}else{
	    	Tarefa tarefa = new Tarefa();
	        tarefa.setNomeTarefa(nomeTarefa);
	        tarefa.setDescricao(descricaoTarefa);
	        listaDeTarefas.add(tarefa);
	        concluidas++;
	        return true;
		}
    }
    
    
    
    public int getConcluidas() {
    	return concluidas;
    }
    
    
    
    public boolean atualizarTarefa(int posicao) {

    	if(posicao >= 0 && posicao < listaDeTarefas.size()) {
            Tarefa tarefa = listaDeTarefas.get(posicao);
            excluirTarefa(posicao);
            return true;
    	}
    	return false;
    	
    }

    
    
    public Tarefa getTarefa(int posicao) {
    	return listaDeTarefas.get(posicao);
    }
    
    
    
    public boolean excluirTarefa(int indiceTarefa){
    	indiceTarefa--;
        if (indiceTarefa >= 0 && indiceTarefa <= listaDeTarefas.size()){
        	listaDeTarefas.remove(indiceTarefa);
	        concluidas--;
        	return true;
        } else {
        	return false;
        }
    }
    
    
    
    public List<Tarefa> listarTarefas() {
    	return listaDeTarefas;
    }
}

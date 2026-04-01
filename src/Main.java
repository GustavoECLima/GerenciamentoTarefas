import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        GerenciadorDeTarefas service = new GerenciadorDeTarefas();

        System.out.println("""
                Escolha uma opção:

                1 - Adicionar tarefa
                2 - Remover tarefa
                3 - Listar tarefas
                4 - Atualizar tarefa
                5 - Sair
                """);
        
        int opcaoDeTarefa = sc.nextInt();
        
        while (opcaoDeTarefa != 5) {

            switch (opcaoDeTarefa){
            
                case 1:
                    
                    sc.nextLine();
                    System.out.print("\nInsira o nome da tarefa: ");
                    String nomeTarefa = sc.nextLine();

                    System.out.print("Insira a descricao dela: ");
                    String descricaoTarefa = sc.nextLine();

                    boolean retornoAdicionar = service.adicionaTarefa(nomeTarefa, descricaoTarefa);
                    
                    if (retornoAdicionar) {
                        System.out.println("\n-- Tarefa incluida na lista de tarefas! --\n");
                    } else {
                        System.out.println("\nTarefa vazia!\n");
                    }
                    break;
                    
                case 2:
                    if (service.listaDeTarefas.isEmpty()) {
                        System.out.println("\nLista vazia.\n");
                        break;
                    }

                    System.out.println("\nDigite a posicao da tarefa que deseja excluir\n");
                    int indiceTarefa = sc.nextInt();
                    
                    System.out.println("\nDeseja mesmo excluir a tarefa: " + service.getTarefa(indiceTarefa-1).getNomeTarefa() + "? (s/n)");
                    char opcao = sc.next().toLowerCase().charAt(0);
                    
                    if (opcao == 's') {
                        boolean retornoExcluir = service.excluirTarefa(indiceTarefa);
                        
                        if (retornoExcluir) {
                            System.out.println("\nTarefa removida com sucesso!\n"
                            		+ "Numero atual de tarefas a concluir: "+service.getConcluidas()+"\n");
                            break;
                        } else {
                            System.out.println("\nNão foi possivel remover tarefa da lista, tente novamente!\n");
                            break;
                        }
                    } else {
                        System.out.println("\nOperacao cancelada!\n");    
                        break;
                    }
                                                            
                case 3:
                    
                    List<Tarefa> tarefas = service.listarTarefas();

                    System.out.println("\n-- LISTA DE TAREFAS --\n");

                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println("Tarefa " + (i + 1));
                        System.out.println(tarefas.get(i));
                        System.out.println("----------------------\n");
                    }
                    break;
                    
                case 4:          

                    if (service.listaDeTarefas.isEmpty()) {
                        System.out.println("\nLista vazia.\n");
                        break;
                    }
                    
                    System.out.print("\nQual tarefa deseja atualizar?: ");
                    int posicao = sc.nextInt();
                    sc.nextLine();

                    boolean retoroAtualizar = service.atualizarTarefa(posicao);
                    
                    if (retoroAtualizar) {
                        System.out.println("\nTarefa concluida!\n"
                		+ "Numero atual de tarefas a concluir: "+service.getConcluidas()+"\n");
                    } else {
                        System.out.println("\nEssa tarefa nao existe\n");
                    }
                    break;

                default:
                    System.out.println("\nOpcao invalida\n");
            }

            System.out.println("""
                    
Qual ação deseja realizar?

1 - Adicionar Tarefa
2 - Remover Tarefa
3 - Exibir Lista de Tarefas
4 - Atualizar Tarefa
5 - Sair
""");
            opcaoDeTarefa = sc.nextInt();
        }

        System.out.println("\nLista final:\n");

        List<Tarefa> tarefas = service.listarTarefas();

        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("Tarefa " + (i + 1));
            System.out.println(tarefas.get(i));
            System.out.println("----------------------\n");
        }
    }
}
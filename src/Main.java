import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = 0;


        String file = "C:\\Users\\gabri\\Downloads\\JogosDesordenados.csv";
        String localSalvado = "C:\\Users\\gabri\\Documents\\";


        do {
            System.out.println("[1] Ler Arquivo");
            System.out.println("[2] Organizar por Categoria");
            System.out.println("[3] Organizar por Avaliação");
            System.out.println("[4] Sair");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:

                    Item[] itens = LeitorCSV.lerArquivo(file);
                    // Verifica se os itens foram lidos com sucesso
                    if (itens != null) {
                        // Itera sobre os itens e imprime as informações
                        for (Item item : itens) {
                            if (item != null) {
                                System.out.println("Jogo: " + item.getJogos());
                                System.out.println("Categoria: " + item.getCategoria());
                                System.out.println("Avaliação: " + item.getAvaliacao());
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("Não foi possível ler o arquivo.");
                    }
                    break;



                case 2:

                    Item[] archive = LeitorCSV.lerArquivo(file);
                    assert archive != null;
                    SelectionSort.ordenarPorCategoria(archive);
                    SelectionSort.alfabetico(archive);

                    String nomeSalvado = "JogosOrdenadoCategoriaAlfabetico.csv";



                    System.out.println(SelectionSort.toString(archive));
                    SelectionSort.salvarJogosOrdenadosPorCategoria(archive,nomeSalvado,localSalvado);


                    break;




                case 3:
                    Item[] arquivo = LeitorCSV.lerArquivo(file);
                    BubbleSort.bubbleSort(arquivo, arquivo != null ? arquivo.length : 0);


                    int auxiliar = 1;
                    assert arquivo != null;
                    for (Item item : arquivo) {
                        if (item != null) {
                            System.out.println(auxiliar + ":");
                            System.out.println("Jogo: " + item.getJogos());
                            System.out.println("Categoria: " + item.getCategoria());
                            System.out.println("Avaliação: " + item.getAvaliacao());
                            System.out.println();
                            auxiliar++;
                        }
                    }


                    String nomeArquivo = "JogosOrdenadosPorAvaliação.csv";


                    BubbleSort.salvarArquivoCSV(arquivo,nomeArquivo,localSalvado);
                    break;






                case 4:


                    System.out.println("Bye Bye!!!");
                break;




                default:
                    System.out.println("Insira um numero válido");

            }


        } while (opcao != 4);






    }







}




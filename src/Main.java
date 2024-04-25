

public class Main {

    public static void main(String[] args) {
        String file = "C:\\Users\\gabri\\Downloads\\JogosDesordenados.csv";

        // Chamando o método lerArquivo da classe leitorCSV
        Item[] arquivo = LeitorCSV.lerArquivo(file);

        
        System.out.println("+++ Ordenado por avaliação +++");

        BubbleSort.bubbleSort(arquivo, index);
        int auxiliar = 1;
        for(Item item : arquivo){
            if(item !=null){

                System.out.println(auxiliar+ ". " + item);

                System.out.println("----------------------------------------------------------");
               auxiliar++;
            }
        }
    }




}
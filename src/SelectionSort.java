import java.io.FileWriter;
import java.io.IOException;

public class SelectionSort {

    public static void ordenarPorCategoria(Item[] arquivo) {

        int n = arquivo.length;

        //Loop para pecorrer os elementos do array
        for(int i = 0; i < n; i++){
            int minIndex = i;
            for(int j = i+1; j < n; j++){
                if(arquivo[j].getCategoria().compareTo(arquivo[minIndex].getCategoria()) < 0){
                    minIndex = j;
                }
            }
            //Trocar o menor elemento com o primeiro não ordenado

            Item temp = arquivo[minIndex];
            arquivo[minIndex] = arquivo[i];
            arquivo[i] = temp;
        }
    }

    public static void alfabetico(Item[] arquivo){
        int n = arquivo.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i -1; j++){
                if(arquivo[j].getCategoria().equals(arquivo[j+i].getCategoria()) &&
                    arquivo[j].getJogos().compareToIgnoreCase(arquivo[j+1].getJogos()) > 0){

                    //troca

                    Item temp = arquivo[j];
                    arquivo[j] = arquivo[j+1];
                    arquivo[j+1] = temp;
                }
            }
        }


    }

    public static String toString(Item[] itens) {
        StringBuilder builder = new StringBuilder();
        if (itens == null || itens.length == 0) {
            return "No items to display.";
        }
        String lastCategory = "";

        for (Item item : itens) {
            if (!item.getCategoria().equals(lastCategory)) {
                lastCategory = item.getCategoria();
                builder.append("\nCategoria: ").append(lastCategory).append("\n");
            }
            builder.append(item.toString()).append("\n");
        }

        return builder.toString();



    }

    public static void salvarJogosOrdenadosPorCategoria(Item[] itens, String nomeArquivo,String local){
        ordenarPorCategoria(itens);
        alfabetico(itens);

        //salvando os arquivos

        try(FileWriter escritor = new FileWriter(local + nomeArquivo)){
            escritor.write(toString(itens));
            System.out.println("Jogos ordenados e salvos com sucesso no : " + local + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }



}


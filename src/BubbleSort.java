import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class BubbleSort {



    public static void  bubbleSort(Item[] arquivo, int tamanho){

        for(int i = 0; i < tamanho -1; i++){
            for(int j = 0; j < tamanho - i -1; j++){
                if (arquivo[j].getAvaliacao() < arquivo[j+1].getAvaliacao()) {
                    Item temp = arquivo[j];
                    arquivo[j] = arquivo[j+1];
                    arquivo[j+1] = temp;
                }
            }
        }

    }

    public static void salvarArquivoCSV(Item[] arquivo, String nomeArquivo, String local){
        try(BufferedWriter escritor = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(local + nomeArquivo)), "UTF-8"))){

            //Escrevendo o cabeçalho

            escritor.write("Nome do Jogo; Avaliação; Categoria \n");

            //Escrevendo os dados de cada jogo

            for (Item item : arquivo) {
                escritor.write(String.format("%s;%.2f;%s\n", item.getJogos(), item.getAvaliacao(), item.getCategoria()));
            }

            System.out.println("Arquivo salvo com sucesso em ' "+ local+ "'.");

        }catch (IOException e){
            System.err.println("Erro ao salvar o arquivo CSV: " + e.getMessage());
        }

    }

}

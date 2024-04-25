import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorCSV {
    public static Item[] lerArquivo(String caminhoArquivo){
        Item[] itens = new Item[40];
        int index = 0;
        File arquivo = new File(caminhoArquivo);
        Scanner sc = null;


        try{
            sc = new Scanner(arquivo);
            while(sc.hasNextLine() && index < itens.length){
                String linha = sc.nextLine();
                String[]dados = linha.split(",");
                String jogos = dados[0];
                String categoria = dados[1];
                double avaliacao = Double.parseDouble(dados[2]);

                itens[index] = new Item(jogos,categoria,avaliacao);
                index++;

            }
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally{
            if(sc != null){
                sc.close();
            }
        }


        return itens ;
    }
}

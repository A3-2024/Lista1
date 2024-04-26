import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class LeitorCSV {
    public static Item[] lerArquivo(String caminhoArquivo) {

        Item[] itens = new Item[40];
        int index = 0;
        File arquivo = new File(caminhoArquivo);
        Scanner sc = null;

        // if para conferir se o caminho é válido
        if (arquivo.isAbsolute()) {
            try {
                sc = new Scanner(new InputStreamReader(new FileInputStream(arquivo),"UTF-8"));
                while (sc.hasNextLine() && index < itens.length) {
                    String linha = sc.nextLine();
                    String[] dados = linha.split(",");
                    String jogos = dados[0];
                    String categoria = dados[1];
                    double avaliacao = Double.parseDouble(dados[2]);

                    itens[index] = new Item(jogos, categoria, avaliacao);
                    index++;

                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            } finally {
                if (sc != null) {
                    sc.close();
                }
            }


            return itens;
        } else {
            //Caso der errado, será avisado

            System.out.println("Erro no caminho fornecido!");

            return  null ;
        }


    }
}

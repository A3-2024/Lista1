<img src="https://github.com/S4-2024/Lista1/blob/main/arquivos/lista1.png">

<h1 align="center">  💗 Ordenação de Jogos 💗  </h1>

### Classe Item
<p > 
Optamos por começar desenvolvendo a classe `Item`, estabelecendo assim todos os parâmetros necessários para a classe `LeitorCSV`. 
</p>

<details> 
<summary>  ⭐ Código </summary>

```

public class Item {
    private String jogos;
    private String categoria;
    private double avaliacao;

    public Item(String jogos, String categoria, double avaliacao) {
        this.jogos = jogos;
        this.categoria = categoria;
        this.avaliacao = avaliacao;
    }
    public String getJogos() {
        return jogos;
    }
    public void setJogos(String jogos) {
        this.jogos = jogos;
    }
    public double getAvaliacao() {
        return avaliacao;
    }
    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString(){
        return "| Jogo:" + jogos + "| Categoria:" +  categoria + "| Avaliação:" +  avaliacao + " |";
    }
}

```

</details>

### Classe LeitorCSV

<p > 
 Em seguida, criamos a classe `LeitorCSV`, responsável por ler o arquivo `JogosDesordenados.csv`. Esta classe organiza as informações contidas no CSV em vetores, utilizando o método `linha.split(",")` para separar e distinguir cada célula delimitada por vírgulas. Os dados são então armazenados em um vetor do tipo `Item[]`, facilitando a passagem desses parâmetros para a classe `Item`.
</p>

<details>
<summary>  ⭐ Código </summary>

```
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

```
</details>



<img   width=60% src="https://github.com/S4-2024/Lista1/blob/main/arquivos/codigo_funcionando.gif">




### SelectionSort

<p>
Posteriormente, utilizamos o algoritmo de  SelectionSort  para organizar os itens por categorias. Dentro de cada categoria, os jogos foram organizados em ordem alfabética usando o `BubbleSort`. Além disso, criamos um método para salvar os dados ordenados em um novo arquivo CSV.
</p>

<details>
  <summary>  ⭐Código </summary>

```
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

```    
</details>

### BubbleSort

<p> Continuando com as melhorias, desenvolvemos outra função de `BubbleSort` para ordenar os jogos por avaliação, em ordem decrescente. Após finalizar essa lógica, implementamos um método que permite salvar o arquivo ordenado em um novo CSV. </p>


<details>
  <summary>  ⭐ Código </summary>

```import java.io.BufferedWriter;
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

```

    
</details>

<img  width=60% src="https://github.com/S4-2024/Lista1/blob/main/arquivos/opcao_1%262.gif">


<p> O primeiro componente implementado no `Main` foi a lógica do menu. E após
confirmamos o funcionamento de todos as classes de ordenação, finalmente integramos
todas essas funcionalidades ao menu do `Main`, permitindo uma interação fluida e eficaz
com o usuário, capaz de executar todas as operações previstas de maneira organizada
e estruturada.</p>

<details>

### Main
    
  <summary>  ⭐Main </summary>

```
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
```

    
</details>


<p>

<em>   
É importante ressaltar que ao ler os arquivos, precisamos garantir o tratamento
adequado para que as Strings sejam interpretadas corretamente em UTF-8. Isso é
fundamental para evitar discrepâncias na exibição de caracteres especiais ao salvar os
arquivos. No entanto, é importante mencionar que o Excel pode apresentar algumas
complicações próprias ao lidar com arquivos UTF-8.

Por isso, disponibilizamos um link que pode auxiliar nesse aspecto: [Tutorial](https://support.microsoft.com/pt-br/office/abrir-arquivos-utf-8-do-csv-corretamente-no-excel-8a935af5-3416-4edd-ba7e-3dfd2bc4a032)
</em> 
</p>

<img width=60% src="https://github.com/S4-2024/Lista1/blob/main/arquivos/excel.gif">


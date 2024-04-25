
public class BubbleSort {
    public static void  bubbleSort(Item[] arquivo, int tamanho){

        for(int i = 0; i < tamanho -1; i++){
            for(int j = 0; j < tamanho - i -1; j++){
                if (arquivo[j].getAvaliacao() > arquivo[j+1].getAvaliacao()) {
                    Item temp = arquivo[j];
                    arquivo[j] = arquivo[j+1];
                    arquivo[j+1] = temp;
                }
            }
        }

    }
}

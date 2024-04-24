import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\gabri\\Downloads\\JogosDesordenados.csv");

        Scanner sc = null;

        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                String linha = sc.nextLine();
                System.out.println(linha);

            }

        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }finally {
            if(sc != null){
                sc.close();
            }
        }

    }
}
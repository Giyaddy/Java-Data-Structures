import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StackMain{

    public static void main(String[] args){

        String fileName = "teks1.txt" ;
        String dataArit = null; 
        
        Stack stack = new Stack();
        Scanner masukan = new Scanner(System.in);
        String kalimat, kata[], namaFile;

        try{
            // membaca file
            File myFile = new File(fileName);
            Scanner fileReader = new Scanner(myFile);
            
            // cetak isi file
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                dataArit = data;
                kata = dataArit.split(" ");

                String hasil = stack.toPostfix(kata);
                System.out.println(hasil);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Terjadi Kesalahan: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
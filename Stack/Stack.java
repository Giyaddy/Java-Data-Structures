import java.util.Arrays;
import java.lang.*;

public class Stack{
	
	private String ekspresi[];
	private int top;

	//Untuk menginisiasi object Stack
	public Stack(){
		this.top = -1;
		ekspresi = new String[100];
	}

	//Dengan function ini, kita akan melakukan push ke dalam stack
	public void push(String simbol){
		ekspresi[++top] = simbol;
	}

	//Ambil bagian teratas dari Stack
	public String getTop(){
		return ekspresi[top];
	}

	//Membuang bagian teratas dari stack
	public void pop(){
		ekspresi[top--]=null;
	}

	public int getSize(){
		return this.top+1;
	}

	public String toPostfix(String[] rumus){

		String hasil="";
		for (int i=0; i<rumus.length; i++){

			//cek jika ia adalah bilangan, maka simpan ke dalam String dan jangan push
			if (isInteger(rumus[i])){
				String temp=rumus[i]+" ";
				hasil+=temp;
			}
			//jika ia bukan "(" atau ")" maka push, karena itu adalah operator
			else if (!rumus[i].equals("(") && !rumus[i].equals(")")){
				push(rumus[i]);
			}
			//jika ditemukan tutup kurung, maka ambil elemen teratas dari stack
			//lalu gabungkan ke dalam string, kemudian pop
			else if (rumus[i].equals(")")){
				String temp=getTop()+" ";
				hasil+=temp;
				pop();
			}
			else{
				continue;
			}

		}

		//jika stack masih belum kosong, maka ambil elemen teratas satu per satu
		//sebelum stack di-pop
		if (getSize()!=0){
			for (int i=0; i<getSize()+1; i++){
				String temp=getTop()+" ";
				hasil+=temp;
				pop();
			}
		}
		return hasil;
	}

	//function ini untuk mengecek apakah sebuah string bisa diubah menjadi bilangan.
	public static boolean isInteger(String str){
    	try {
        	Integer.parseInt(str);
        	return true;
    	} catch (NumberFormatException nfe) {
        	return false;
    	}
	}
}
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<String> outputs = new ArrayList<>();

        String line;
        int size;
        String books;
        int money;
        boolean finish = false;
        line = br.readLine();
        do{
            if(!line.equals("")){
                size = Integer.parseInt(line);
                line = br.readLine();
                books = line;
                line = br.readLine();
                money = Integer.parseInt(line);
                //outputs.add(searchSum(size, books, money));
                bw.write(searchSum(size, books, money));
            }
            line = br.readLine();
        } while(line != null);

        //writeArray(outputs, bw);

        br.close();
        bw.close();
    }

    public static String searchSum(int size, String books, int money){
        int[] intBooks = toIntArray(books);
        int i;
        int j;
        int m;
        int founded;
        int toFound;
        int difference = money;
        int pos;
        int excI = 0;
        int excJ = 0;
        for(int a = 0; a<size; a++){
            i = 0;
            j = size-1;
            pos = -1;
            founded = intBooks[a];
            toFound = money-founded;
            while(i <= j && pos<0){
                m = (i+j)/2;
                if(intBooks[m] == toFound && a!=m){
                    pos = m;
                } else if(intBooks[m] < toFound){
                    i = m + 1;
                } else{
                    j = m - 1;
                }
            }
            if(!(pos<0)){
                if (Math.abs(founded - intBooks[pos]) < difference) {
                    excI = founded;
                    excJ = intBooks[pos];
                    difference = Math.abs(founded - intBooks[pos]);
                }
            }
        }
        String output = "Peter should buy books whose prices are "+excI+" and "+excJ+".\n\n";
        return output;
    }

    public static int[] toIntArray(String books){
        String[] strBooks = books.split(" ");
        int[] intBooks = new int[strBooks.length];
        for(int i = 0; i< strBooks.length; i++){
            intBooks[i] = Integer.parseInt(strBooks[i]);
        }
        Arrays.sort(intBooks);
        return intBooks;
    }

    public static void writeArray(ArrayList<String> array, BufferedWriter bw) throws IOException {
        for(int i = 0; i<array.size(); i++){
            bw.write(array.get(i));
        }
    }
}

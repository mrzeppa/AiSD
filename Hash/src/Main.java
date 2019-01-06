import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        ArrayList<Record> a = new ArrayList<>();
        ArrayList<EmptyRecord> b = new ArrayList<>();
        ArrayList<LastFewRecords> c = new ArrayList<>();
        ArrayList<ControlRecords> d = new ArrayList<>();
        ArrayList<EmptyControlRecords> e = new ArrayList<>();

        Hash h = new Hash();
        FileSupport f = new FileSupport();

        f.getRecordsFromFile(a, b, c, d, e);
        System.out.println("Wydruk kontrolny.");
        System.out.println("Tablica przed hashowaniem");
        for(ControlRecords x: d){
            System.out.println(x);
        }
        h.codeControlElements(d, e);
        System.out.println("\nTablica po hashowaniu");
        for(EmptyControlRecords x: e){
            System.out.println(x);
        }
        System.out.println("\n");
        h.codeElement(a, b);
        f.saveRecordsToFile(b, "out.txt");
        h.hashSearch(c, b);
//        for(EmptyRecord x: b){
//            System.out.println(x);
//
//        }
    }
}


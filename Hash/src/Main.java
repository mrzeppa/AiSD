import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        ArrayList<Record> a = new ArrayList<>();
        ArrayList<EmptyRecord> b = new ArrayList<>();
        ArrayList<LastFewRecords> c = new ArrayList<>();

        Hash h = new Hash();
        FileSupport f = new FileSupport();

        f.getRecordsFromFile(a, b, c);
        h.codeElement(a, b);
        f.saveRecordsToFile(b, "out.txt");
        h.hashSearch(c, b);
//        for(EmptyRecord x: b){
//            System.out.println(x);
//
//        }
    }
}


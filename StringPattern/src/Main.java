import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        long timeStart1, timeStart2, timeStart3, timeEnd1, timeEnd2, timeEnd3;

        Naive n = new Naive(FileSupport.getElemFromFile("pattern.txt"), FileSupport.getElemFromFile("text.txt"));
        RabinKarp rk = new RabinKarp(FileSupport.getElemFromFile("pattern.txt"), FileSupport.getElemFromFile("text.txt"));
        KMP kmp = new KMP(FileSupport.getElemFromFile("pattern.txt"), FileSupport.getElemFromFile("text.txt"));
        System.out.println("KMP");
        timeStart1 = System.nanoTime();
        kmp.KMPSearch();
        timeEnd1 = System.nanoTime();
        System.out.println("----------------------");
        System.out.println("RK");
        timeStart2 = System.nanoTime();
        rk.search(101);
        timeEnd2 = System.nanoTime();
        System.out.println("----------------------");
        System.out.println("Naive");
        timeStart3 = System.nanoTime();
        n.findPattern();
        timeEnd3 = System.nanoTime();




        System.out.println("CZASY:");
        System.out.println("KMP: " + ((double)((timeEnd1 - timeStart1) / 100)));
        System.out.println("RK: " + ((double)((timeEnd2 - timeStart2)) / 100));
        System.out.println("Naive: " + ((double)((timeEnd3 - timeStart3)) / 100));
    }
}

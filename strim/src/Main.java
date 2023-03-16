public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int size = 10000;
        double oddRatio = RandomStream.getOddRatio(size);
        System.out.println("Odd ratio: " + oddRatio);



    }
}
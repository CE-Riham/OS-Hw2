package part1;

public class MainClass1 {
    //N for Amjad's ID = 12028467
    //N = 467 + 500
    //Riham's ID = 12029366
    private static int N = 967, shared_mem = 0;
    public static void increase(){
        shared_mem++;
    }
    public static int getShared_mem(){
        return shared_mem;
    }

    public static int getN() {
        return N;
    }

    public static void main(String[] args){
        Thread[] threads = new Thread[N];
        int expected_value = N * N;

        for (int i = 0; i < N; i++) {
            Part1Thread tmp = new Part1Thread();
            threads[i] = new Thread(tmp);
            threads[i].start();
        }

        for (int i = 0; i < N; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Expected value = "+expected_value);
        System.out.println("Real value = "+getShared_mem());
    }
}
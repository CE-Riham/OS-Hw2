package part2;

public class Part2Thread extends Thread implements Runnable {



    public int sleepFor() {
        return (int) (getId() % 10);
    }

    public void printDelayAndSleep() {
        try {
            System.out.println("I am thread " + getId() + "; about to go to sleep for " + sleepFor() + " nanoseconds");
            Thread.sleep(sleepFor());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void increaseSharedMemory(){
        System.out.println("I am thread "+getId()+"; about to increment the counter, old value was "+ SharedMemory.getShared_mem());
        SharedMemory.increase();
        System.out.println("I am thread "+getId()+"; finished incrementing the counter, new value is "+ SharedMemory.getShared_mem());
    }

    @Override
    public void run() {
        for(int i = 0; i< MainClass2.getN(); i++){
            printDelayAndSleep();
            increaseSharedMemory();
        }
    }
}
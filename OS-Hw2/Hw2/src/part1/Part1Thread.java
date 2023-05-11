package part1;

public class Part1Thread extends Thread implements Runnable {

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
        System.out.println("I am thread "+getId()+"; about to increment the counter, old value was "+ MainClass1.getShared_mem());
        MainClass1.increase();
        System.out.println("I am thread "+getId()+"; finished incrementing the counter, new value is "+ MainClass1.getShared_mem());
    }

    @Override
    public void run() {
        for(int i = 0; i< MainClass1.getN(); i++){
            printDelayAndSleep();
            increaseSharedMemory();
        }
    }
}
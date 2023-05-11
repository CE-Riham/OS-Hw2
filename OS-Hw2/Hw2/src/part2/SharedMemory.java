package part2;

public class SharedMemory {
    private static int shared_mem = 0;
    public static synchronized void increase(){
        shared_mem++;
    }
    public static int getShared_mem(){
        return shared_mem;
    }
}

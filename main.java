class EvenThread extends Thread {
    private int n;

    public EvenThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 2; i <= n; i += 2) {
            System.out.println("Even Thread: " + i);
        }
    }

    @Override
    public String toString() {
        return "Even Thread";
    }
}

class OddThread extends Thread {
    private int m;

    public OddThread(int m) {
        this.m = m;
    }

    @Override
    public void run() {
        for (int i = 1; i <= m; i += 2) {
            System.out.println("Odd Thread: " + i);
        }
    }

    @Override
    public String toString() {
        return "Odd Thread";
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 10; // Print even numbers up to n
        int m = 15; // Print odd numbers up to m

        EvenThread evenThread = new EvenThread(n);
        OddThread oddThread = new OddThread(m);

        System.out.println("Starting threads...");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Threads finished.");
    }
}
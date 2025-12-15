
class thread extends Thread{
    String threadPrint;
    int time;
    thread(String name,int time){
        this.threadPrint=name;
        this.time=time;
    }
    public void run(){
        while (true) {
            System.out.println(threadPrint);
            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                System.out.println(threadPrint + " interrupted.");
                break;
            }
        }
    }
}

public class threadexample{
    public static void main(String[] args) {
        thread thread1=new thread("BMS College of Engineering",10);
        thread thread2=new thread("CSE",2);

        thread1.start();
        thread2.start();

        System.out.println("Main thread finished starting child threads.");
    }
}
package Controller.Thraed;

import java.util.Timer;
import java.util.TimerTask;
public class TimerTest {

    Timer timer;
    boolean time=false;

    public boolean isTime() {
        return time;
    }

    public TimerTest(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*1000);
    }
    public TimerTest()
    {}

    public void EndTimerTest()
    {  timer.cancel();}

    class RemindTask extends TimerTask {
        public void run() {
            //  System.out.println("Time's up!");
            timer.cancel(); //Terminate the timer thread
            time=true;
        }

    }

}

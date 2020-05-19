package cons;

import java.util.Timer;
import java.util.TimerTask;
//定时器
public class MyTimerTask extends TimerTask {

    private String taskName;

    @Override
    public void run() {

        System.out.println("task" + taskName);

    }

    public MyTimerTask(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public class TimerTest{
        public static void main(String[] arge){
            Timer timer = new Timer();
            MyTimerTask mytask = new MyTimerTask("TimeTask1");
            timer.schedule(mytask,2000L,1000L);
        }
    }
}

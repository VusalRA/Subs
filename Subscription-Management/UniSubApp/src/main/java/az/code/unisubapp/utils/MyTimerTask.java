package az.code.unisubapp.utils;

import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class MyTimerTask {

    CheckRepo checkRepo;

    public MyTimerTask(CheckRepo checkRepo) {
        this.checkRepo = checkRepo;
    }

    public void timerForCheckData() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 06);
        c.set(Calendar.MINUTE, 03);
        c.set(Calendar.SECOND, 03);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                checkRepo.checkDate();
            }
        }, c.getTime(), 86400000);
    }
}

package MVC;

import javax.swing.*;

import java.util.*;
import java.util.Timer;
import java.text.SimpleDateFormat;
//coté graphique jcalendar
class Clock {
    final JLabel time = new JLabel();
    private final SimpleDateFormat sdf  = new SimpleDateFormat("hh:mm");
    private int   currentSecond;
    private Calendar calendar;

    public static void main( String [] args ) {
        JFrame frame = new JFrame();
        Clock clock = new Clock();
        frame.add( clock.time );
        frame.pack();
        frame.setVisible( true );
        clock.start();
    }
    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = calendar.get(Calendar.SECOND);
    }
    public void start(){
        reset();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate( new TimerTask(){
            public void run(){
                if( currentSecond == 60 ) {
                    reset();
                }
                time.setText( String.format("%s:%02d", sdf.format(calendar.getTime()), currentSecond ));
                currentSecond++;
            }
        }, 0, 1000 );
    }
}
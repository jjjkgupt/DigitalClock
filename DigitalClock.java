package com.mycompany.digitalclockawt;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jitendra
 */



public class DigitalClockAWT extends Frame {
    private Label timeLabel;

    public DigitalClockAWT() {
        super("Digital Clock");
        timeLabel = new Label();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(timeLabel);
        setSize(300, 150);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        Thread updateThread = new Thread(() -> {
            while (true) {
                updateTime();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateThread.start();
    }

    private void updateTime() {
        Date currentTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = dateFormat.format(currentTime);
        timeLabel.setText(formattedTime);
    }

    public static void main(String[] args) {
        new DigitalClockAWT();
    }
}

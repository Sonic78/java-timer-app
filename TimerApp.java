import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerApp extends JFrame {
    private JLabel timeLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    
    private Timer timer;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    
    public TimerApp() {
        setTitle("Java Timer App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        
        initializeComponents();
        layoutComponents();
        setupEventHandlers();
        
        setVisible(true);
    }
    
    private void initializeComponents() {
        // Initialize the time display label
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timeLabel.setForeground(Color.BLUE);
        
        // Initialize buttons
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        
        // Set button properties
        Dimension buttonSize = new Dimension(80, 30);
        startButton.setPreferredSize(buttonSize);
        stopButton.setPreferredSize(buttonSize);
        resetButton.setPreferredSize(buttonSize);
        
        // Initially disable stop button
        stopButton.setEnabled(false);
        
        // Initialize timer (updates every 1000ms = 1 second)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
    }
    
    private void layoutComponents() {
        setLayout(new BorderLayout());
        
        // Add time label to center
        add(timeLabel, BorderLayout.CENTER);
        
        // Create button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        
        // Add button panel to bottom
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Add some padding
        JPanel topPadding = new JPanel();
        topPadding.setPreferredSize(new Dimension(0, 20));
        add(topPadding, BorderLayout.NORTH);
    }
    
    private void setupEventHandlers() {
        // Start button event handler
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });
        
        // Stop button event handler
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });
        
        // Reset button event handler
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTimer();
            }
        });
    }
    
    private void startTimer() {
        timer.start();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }
    
    private void stopTimer() {
        timer.stop();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    
    private void resetTimer() {
        timer.stop();
        seconds = 0;
        minutes = 0;
        hours = 0;
        updateTimeDisplay();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    
    private void updateTime() {
        seconds++;
        if (seconds >= 60) {
            seconds = 0;
            minutes++;
            if (minutes >= 60) {
                minutes = 0;
                hours++;
            }
        }
        updateTimeDisplay();
    }
    
    private void updateTimeDisplay() {
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeString);
    }
    
    public static void main(String[] args) {
        // Set the look and feel to the system default
        try {
            //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the timer app
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimerApp();
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BannerApp extends JFrame {

    private String bannerText = "";
    private int xCoordinate = 0;
    private Timer timer;

    public BannerApp() {
        setTitle("Latihan Banner Sederhana");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JTextField textField = new JTextField(20);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bannerText = textField.getText();
                xCoordinate = 0;
                startAnimation();
            }
        });

        add(textField, BorderLayout.NORTH);
        setVisible(true);
    }

    public void startAnimation() {
        timer = new Timer(250, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                xCoordinate += 5;
                if (xCoordinate > getWidth()) {
                    xCoordinate = -100; 
                }
                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(bannerText, xCoordinate, 60);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BannerApp());
    }
}

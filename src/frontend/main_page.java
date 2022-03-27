package frontend;

import backend.Main;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main_page extends JFrame{
    public JPanel main_jpl;
    public JPanel jpl1;
    public JPanel jpl2;
    public JPanel jpl3;
    public JPanel jpl4;
    public JPanel jpl5;
    public JPanel jpl6;
    private JButton start_btn;
    private JButton stop_btn;
    private JButton point_btn;
    public ArrayList<JPanel>panels = new ArrayList<>();
    public ArrayList<ArrayList<JButton>> buttons = new ArrayList<>();

    public main_page() {
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(main_jpl);
        panels.add(jpl1);
        panels.add(jpl2);
        panels.add(jpl3);
        panels.add(jpl4);
        panels.add(jpl5);
        panels.add(jpl6);

        start_btn.addActionListener(e -> {
            if (Main.s_main.main_thread.isAlive()) {
                try {
                    Main.s_main.main_thread.join();
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                System.out.println("thread is alive");
            }
            new Thread(() -> Main.s_main.main_thread.start()).start();
            JOptionPane.showMessageDialog(null, "Game started!");
        });
        point_btn.addActionListener(e -> new Thread(() -> {
            try {
                new points_page().setVisible(true);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        }).start());
        stop_btn.addActionListener(e -> Main.s_main.statues = false);
    }
    public void set_game_size(int column) {
        for (JPanel p:panels) {
            buttons.add(new ArrayList<>());
            for (int i = 0; i < column; i++) {
                JButton temp = new JButton("");
                buttons.get(buttons.size()-1).add(temp);
                p.add(temp);
            }
        }
    }
}

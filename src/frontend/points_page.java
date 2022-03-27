package frontend;

import backend.Hero;
import backend.Main;

import javax.swing.*;
import java.io.*;

public class points_page extends JFrame{
    private JPanel main_jpl;
    private JLabel team_A_lbl;
    private JLabel team_B_lbl;
    private JButton save_btn;
    public FileOutputStream fout = new FileOutputStream("D:\\programming practice\\java\\last_project\\src\\files\\file.txt");
    public FileInputStream fin = new FileInputStream("D:\\programming practice\\java\\last_project\\src\\files\\file.txt");
    public points_page() throws FileNotFoundException {
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(main_jpl);
        int total_score = 0;
        for (Hero h: Main.s_main.heroes_A)
            total_score += h.point;
        StringBuilder temp = new StringBuilder();
        for (Hero h: Main.s_main.heroes_A)
            temp.append(h.properties.name()).append(": ").append(h.point);
        team_A_lbl.setText("Team A\nTotal score: " + total_score + "\nHeroes:\n"+temp);

        total_score = 0;
        for (Hero h: Main.s_main.heroes_A)
            total_score += h.point;
        temp = new StringBuilder();
        for (Hero h: Main.s_main.heroes_B)
            temp.append(h.properties.name()).append(": ").append(h.point);
        team_B_lbl.setText("Team B\nTotal score: " + total_score + "\nHeroes:\n"+temp);

        //_________________________________
        save_btn.addActionListener(e -> {
            try {
                if (fin.readAllBytes().length == 0) {
                    PrintStream ps = new PrintStream(fout);
                    ps.println(team_A_lbl.getText());
                    ps.println(team_B_lbl.getText());
                    JOptionPane.showMessageDialog(null, "Info saved!");
                }
                else
                    JOptionPane.showMessageDialog(null,"File already saved!","Error",JOptionPane.ERROR_MESSAGE);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}

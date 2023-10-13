import javax.swing.*;
public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Riki-Game");
        GamePanel gamePanel = new GamePanel();

        frame.add(gamePanel);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);



    }
}
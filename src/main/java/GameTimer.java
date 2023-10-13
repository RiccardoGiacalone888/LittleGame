import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer implements ActionListener {
    private GamePanel gamePanel;

    public GameTimer(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gamePanel.isJumping()) {
            if (gamePanel.getPlayerY() > gamePanel.getJumpHeight()) {
                int newY = gamePanel.getPlayerY() - 5;
                gamePanel.setPlayerY(newY); // Alza il giocatore
            } else {
                gamePanel.setJumping(false);
            }
        } else if (gamePanel.getPlayerY() < 300) {
            int newY = gamePanel.getPlayerY() + 5;
            gamePanel.setPlayerY(newY); // Fai scendere il giocatore
        }

        if (gamePanel.isLeftArrowPressed()) {
            int newX = gamePanel.getPlayerX() - 5;
            if (newX >= 0) {
                gamePanel.setPlayerX(newX); // Sposta il giocatore a sinistra
            }
        }
        if (gamePanel.isRightArrowPressed()) {
            int newX = gamePanel.getPlayerX() + 5;
            if (newX + 30 <= gamePanel.getWidth()) {
                gamePanel.setPlayerX(newX); // Sposta il giocatore a destra
            }
        }

        gamePanel.repaint();
    }
}

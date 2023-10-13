import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GamePanel extends JPanel {
    private int playerX, playerY;
    private boolean jumping = false;
    private int jumpHeight = 100;
    private boolean enchantressMovingLeft = false;
    private boolean enchantressMovingRight = false;
    private boolean enchantressJumping = false;
    private Image enchantressImage, catImage, dogImage; // Immagini degli sprite
    private String catMovement;
    private String dogMovement;

    public boolean isJumping() {
        return jumping;
    }
    public int getPlayerY() {
        return playerY;
    }

    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    public int getPlayerX() {
        return playerX;
    }

    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(int jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    private boolean leftArrowPressed = false;
    private boolean rightArrowPressed = false;
    public boolean isLeftArrowPressed() {
        return leftArrowPressed;
    }

    public boolean isRightArrowPressed() {
        return rightArrowPressed;
    }

    public GamePanel() {
        playerX = 50;
        playerY = 300;
        enchantressImage = new ImageIcon("resources/Enchantress.png").getImage(); // Carica lo sprite di Eleonora
        catImage = new ImageIcon("resources/cat2.png").getImage(); // Carica lo sprite del gatto
        dogImage = new ImageIcon("resources/dog2.png").getImage(); // Carica lo sprite del cane

        Timer timer = new Timer(10, new GameTimer(this));
        timer.start();
        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        // Inizializza i movimenti per il cane e il gatto
        initializeCharacterMovements();
    }

    // Inizializza i movimenti per il cane e il gatto
    private void initializeCharacterMovements() {
        catMovement = "Idle";
        dogMovement = "Idle";
    }

    // Genera casualmente i movimenti per il cane e il gatto
    private void generateRandomMovements() {
        String[] catMovements = {"Attack", "Idle", "Walk"};
        String[] dogMovements = {"Attack", "Idle", "Walk"};

        Random random = new Random();
        catMovement = catMovements[random.nextInt(catMovements.length)];
        dogMovement = dogMovements[random.nextInt(dogMovements.length)];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegna lo sfondo dell'appartamento
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Disegna Eleonora (Enchantress)
        if (enchantressMovingLeft) {
            g.drawImage(enchantressImage, playerX, playerY, this);
        } else if (enchantressMovingRight) {
            g.drawImage(enchantressImage, playerX, playerY, this);
        } else if (enchantressJumping) {
            g.drawImage(enchantressImage, playerX, playerY, this);
        }

        // Disegna il gatto
        if (catMovement.equals("Attack")) {
            g.drawImage(catImage, playerX, playerY, this);
        } else if (catMovement.equals("Idle")) {
            g.drawImage(catImage, playerX, playerY, this);
        } else if (catMovement.equals("Walk")) {
            g.drawImage(catImage, playerX, playerY, this);
        }

        // Disegna il cane
        if (dogMovement.equals("Attack")) {
            g.drawImage(dogImage, playerX, playerY, this);
        } else if (dogMovement.equals("Idle")) {
            g.drawImage(dogImage, playerX, playerY, this);
        } else if (dogMovement.equals("Walk")) {
            g.drawImage(dogImage, playerX, playerY, this);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE && !jumping) {
                jumping = true;
            }
            if (key == KeyEvent.VK_LEFT) {
                enchantressMovingLeft = true;
            }
            if (key == KeyEvent.VK_RIGHT) {
                enchantressMovingRight = true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT) {
                enchantressMovingLeft = false;
            }
            if (key == KeyEvent.VK_RIGHT) {
                enchantressMovingRight = false;
            }
        }
    }
}

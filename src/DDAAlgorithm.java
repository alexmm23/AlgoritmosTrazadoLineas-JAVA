import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DDAAlgorithm extends JFrame {
    private BufferedImage buffer;

    public static void main(String[] args) {
        DDAAlgorithm window = new DDAAlgorithm();
        window.setWindow();
    }

    public void setWindow() {
        setTitle("DDA Algorithm");
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        setVisible(true);
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Ejemplo de uso del algoritmo DDA
        drawLineDDA(50, 50, 200, 300, Color.RED);
    }

    public void drawLineDDA(int x1, int y1, int x2, int y2, Color color) {
        int dx = x2 - x1;
        int dy = y2 - y1;

        int steps = Math.max(Math.abs(dx), Math.abs(dy));

        float xIncrement = (float) dx / steps;
        float yIncrement = (float) dy / steps;

        float x = x1;
        float y = y1;

        for (int i = 0; i < steps; i++) {
            try {
                putPixel(Math.round(x), Math.round(y), color);
                x += xIncrement;
                Thread.sleep(50);
                y += yIncrement;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

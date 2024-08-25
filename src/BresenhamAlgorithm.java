import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BresenhamAlgorithm extends JFrame {
    private BufferedImage buffer;

    public static void main(String[] args) {
        BresenhamAlgorithm window = new BresenhamAlgorithm();
        window.setWindow();
    }

    public void setWindow() {
        setTitle("Bresenham Algorithm");
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

        // Ejemplo de uso del algoritmo de Bresenham
        drawLineBresenham(50, 50, 400, 450, Color.RED);
    }

    // Implementación del algoritmo de Bresenham para trazar una línea
    public void drawLineBresenham(int x1, int y1, int x2, int y2, Color color) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1; // Dirección del incremento de x
        int sy = (y1 < y2) ? 1 : -1; // Dirección del incremento de y
        int err = dx - dy;

        while (true) {
            try {
                Thread.sleep(50);
                putPixel(x1, y1, color);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x1 == x2 && y1 == y2) {
                break;
            }

            int e2 = 2 * err;

            // Ajuste de error
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
    }
}

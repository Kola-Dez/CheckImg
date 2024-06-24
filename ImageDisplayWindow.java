import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageDisplayWindow extends JFrame {

    private BufferedImage image;

    public ImageDisplayWindow(File imageFile) {
        super("Изображение");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        try {
            image = ImageIO.read(imageFile);
            setSize(image.getWidth() + 50, image.getHeight() + 70);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при открытии изображения: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        SizeLabelPanel sizeLabelPanel = new SizeLabelPanel();
        sizeLabelPanel.updateSizeLabel(image.getWidth(), image.getHeight());
        contentPane.add(sizeLabelPanel, BorderLayout.NORTH);

        JLabel imageLabel = new JLabel(new ImageIcon(image));
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        setContentPane(contentPane);
        setLocationRelativeTo(null);
    }
}

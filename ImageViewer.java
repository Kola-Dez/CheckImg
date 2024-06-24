import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ImageViewer extends JFrame {
    public ImageViewer() {
        super("CheckImage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 65);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        JLabel imageLabel = new JLabel();
        JScrollPane scrollPane = new JScrollPane(imageLabel);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JButton openButton = new JButton("Открыть изображение");
        openButton.addActionListener(e -> openImage());
        contentPane.add(openButton, BorderLayout.NORTH);

        setContentPane(contentPane);
    }

    private void openImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Изображения", "jpg", "jpeg", "png", "gif", "bmp"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageDisplayWindow imageDisplayWindow = new ImageDisplayWindow(selectedFile);
            imageDisplayWindow.setVisible(true);
        }
    }
}

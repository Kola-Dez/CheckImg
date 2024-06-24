import javax.swing.*;
import java.awt.*;

public class SizeLabelPanel extends JPanel {

    private final JLabel sizeLabel;

    public SizeLabelPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        sizeLabel = new JLabel("Размеры: ");
        add(sizeLabel);
    }

    public void updateSizeLabel(int width, int height) {
        sizeLabel.setText("Размеры: " + width + "x" + height + " пикселей");
    }
}

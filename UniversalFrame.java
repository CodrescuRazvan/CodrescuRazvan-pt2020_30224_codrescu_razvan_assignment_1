import javax.swing.*;
import java.awt.*;
public class UniversalFrame extends JFrame{
    protected JPanel contentPanel;
    protected Color background = new Color(0, 170, 0);
    protected Font writing = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

    public UniversalFrame(String title){
        setTitle(title);
        setSize(700, 325);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(background);
        add(contentPanel, BorderLayout.CENTER);
    }
}

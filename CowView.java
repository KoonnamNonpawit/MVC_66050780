import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CowView extends JFrame{
    private JTextField codeField;
    private JLabel messageLabel;
    private List<Cow> cowList;

    public CowView(List<Cow> cowList) {
        this.cowList = cowList;
        
        setTitle("Cow Strike");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));

        JLabel promptLabel = new JLabel("Enter an 8-digit code:");
        add(promptLabel);

        codeField = new JTextField(10);
        add(codeField);

        JButton submitButton = new JButton("Submit");
        add(submitButton);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        add(messageLabel);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateCode();
            }
        });
    }

    private void validateCode() {
        String code = codeField.getText().trim();

        if (!code.matches("\\d+") || code.length() != 8 || code.charAt(0) == '0') {
            messageLabel.setText("Invalid code. Must be 8 digits, no leading 0.");
            return;
        }

        int cowNumber = Integer.parseInt(code);
        Cow foundCow = null;
        for (Cow cow : cowList) {
            if (cow.getNumber() == cowNumber) {
                foundCow = cow;
                break;
            }
        }

        if (foundCow == null) {
            messageLabel.setText("Cow not found.");
            return;
        }

        CowController controller = new CowController(foundCow);
        int milkProduced = controller.getMilk();
        
        messageLabel.setText("Milk produced: " + milkProduced + " liters");
    }
}

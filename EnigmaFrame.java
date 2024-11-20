import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class EnigmaFrame extends JFrame {

    JTextField startPosition = new JTextField("AAA", 10);
    JComboBox<String> inner = new JComboBox<String>(rotorNums);
    JComboBox<String> middle = new JComboBox<String>(rotorNums);
    JComboBox<String> outer = new JComboBox<String>(rotorNums);
    JButton encrypt = new JButton("Encrypt");
    JButton decrypt = new JButton("Decrypt");
    JTextArea input = new JTextArea(5, 85);
    JTextArea output = new JTextArea(5, 85);

    private static final String[] rotorNums = {
        "1", "2", "3", "4", "5"
    };

    public EnigmaFrame() {      
        super();
  
        JPanel dpanel = new JPanel(new FlowLayout()); 
        dpanel.add(new JLabel("Inner"));
        dpanel.add(inner);
        dpanel.add(new JLabel("Middle"));
        dpanel.add(middle);
        dpanel.add(new JLabel("Out"));
        dpanel.add(outer);
        dpanel.add(new JLabel("Initial Positions"));
        dpanel.add(startPosition);
        dpanel.add(encrypt);
        dpanel.add(decrypt);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Input"));
        inputPanel.add(input);

        JPanel outputPanel = new JPanel(new FlowLayout());
        outputPanel.add(new JLabel("Output"));
        outputPanel.add(output);

        JPanel panelBrdLayout = new JPanel(new BorderLayout());
        panelBrdLayout.add(dpanel, BorderLayout.NORTH);
        panelBrdLayout.add(inputPanel, BorderLayout.CENTER);
        panelBrdLayout.add(outputPanel, BorderLayout.SOUTH);

        EncryptActionListener e = new EncryptActionListener();
        encrypt.addActionListener(e);
           
        this.add(panelBrdLayout);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class EncryptActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            int innerIdx = inner.getSelectedIndex() + 1;
            int middleIdx = middle.getSelectedIndex() + 1;
            int outerIdx = outer.getSelectedIndex() + 1;
            String startIdx = startPosition.getText();
            String inputData = input.getText();
            
            Enigma enigma = new Enigma(innerIdx, middleIdx, outerIdx, startIdx);
            String encryptedText = enigma.encrypt(inputData);
            output.setText(encryptedText);
        }
    }
}

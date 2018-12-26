package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIWindows extends JFrame {
    JTextArea jTextArea;
    JScrollPane jScroll;
    JTextField jTextField;
    JButton jButton;
    public UIWindows(){
        setTitle("Chat++");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 500);
        setResizable(false);

        setLayout(new BorderLayout());

        jTextArea = new JTextArea(27, 50);
        jTextArea.setEditable(false);
        JScrollPane jScroll = new JScrollPane(jTextArea);
        jScroll.setLocation(0,0);
        jTextArea.setLineWrap(true);
        add(BorderLayout.NORTH, jScroll);

        jTextField = new JTextField();
        add(BorderLayout.CENTER, jTextField);

        jButton = new JButton("Send");
        add(BorderLayout.EAST, jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAction();
            }
        });

        jTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendAction();
            }
        });

        setVisible(true);
    }


    private void sendAction(){
        String text = jTextField.getText();
        jTextField.setText("");
        jTextArea.append(text + "\r\n");
        jTextArea.setCaretPosition(jTextArea.getText().length());
    }
}

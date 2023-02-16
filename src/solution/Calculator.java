package solution;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator
{
    public final int LOCATION = 300;
    public final int LOCATION2 = 200;
    public final int SIZE = 400;
    public final int SIZE2 = 150;

    private JFrame frame;

    private JPanel topPanel;
    private JPanel middlePanel;
    private JPanel buttonPanel;
    private JLabel resultLabel;

    private JButton addButton;
    private JButton subButton;
    private JButton multiButton;
    private JButton divButton;

    private JTextField input1;
    private JTextField input2;

    public JFrame getFrame()
    {
        return frame;
    }

    public Calculator()
    {
        initialize();
        frame.setVisible(true);

    }

    public void initialize()
    {
        // frame
        frame = new JFrame();
        frame.setLocation(LOCATION, LOCATION2);
        frame.setSize(SIZE, SIZE2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My Simple Calculator");
        // buttons
        addButton = new JButton("ADD");
        subButton = new JButton("SUB");
        multiButton = new JButton("MULTI");
        divButton = new JButton("DIV");
        // input boxes
        input1 = new JTextField(10);
        input2 = new JTextField(10);
        // result label
        resultLabel = new JLabel("Result = ");
        // top panel
        topPanel = new JPanel();
        topPanel.add(input1, BorderLayout.LINE_START);
        topPanel.add(input2, BorderLayout.LINE_START);
        // middle panel
        middlePanel = new JPanel();
        middlePanel.add(resultLabel, BorderLayout.WEST);
        // bottom Panel (buttons)
        buttonPanel = new JPanel();
        buttonPanel.add(addButton, BorderLayout.WEST);
        buttonPanel.add(subButton, BorderLayout.WEST);
        buttonPanel.add(multiButton, BorderLayout.CENTER);
        buttonPanel.add(divButton, BorderLayout.EAST);
        // put together
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // create button actions
        try
        {
            addButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resultLabel.setText(String.format("= %-10.2f",
                        (Double.parseDouble(input1.getText()))
                            + (Double.parseDouble(input2.getText()))));
                }
            });

            subButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resultLabel.setText(String.format("= %-10.2f",
                        (Double.parseDouble(input1.getText()))
                            - (Double.parseDouble(input2.getText()))));
                }
            });

            multiButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resultLabel.setText(String.format("= %-10.2f",
                        (Double.parseDouble(input1.getText()))
                            * (Double.parseDouble(input2.getText()))));
                }
            });
            divButton.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    resultLabel.setText(String.format("= %-10.2f",
                        (Double.parseDouble(input1.getText()))
                            / (Double.parseDouble(input2.getText()))));
                }
            });
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String args[])
    {
        Calculator calc = new Calculator();
    }

}

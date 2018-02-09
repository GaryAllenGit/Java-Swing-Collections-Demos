import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SandwichSelector {
    private JPanel panel1;
    private JButton placeOrderButton;
    private JList sandwichList;

    public SandwichSelector() {

        String[] listOfButties = {"Cheese", "Cheese Salad", "Cheese and Tomato",
                "Cheese and Pickle", "Cheese and Onion", "Ploughman's", "Plain Salad"};
        sandwichList.setListData(listOfButties);


        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectionNumber = sandwichList.getSelectedIndex();
                if (selectionNumber == -1){
                    JOptionPane.showMessageDialog(panel1, "Please select a butty");
                } else {
                    String orderedSarnie = (String) sandwichList.getSelectedValue();
                    JOptionPane.showMessageDialog(panel1, "You have ordered a "
                            + orderedSarnie + " sandwich");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SandwichSelector");
        frame.setContentPane(new SandwichSelector().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

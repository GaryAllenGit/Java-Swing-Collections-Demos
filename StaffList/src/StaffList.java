import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StaffList {
    private JPanel panel1;
    private JList<String> staffList;
    private JButton deleteButton;
    private JTextField staffName;
    private JButton addButton;

    private DefaultListModel<String> allStaff;

    public StaffList() {
        allStaff = new DefaultListModel<String>();
        allStaff.addElement("Gary Allen");
        allStaff.addElement("Diane Kitchin");
        allStaff.addElement("Tony Jenkins");
        allStaff.addElement("Simon Parkinson");

        staffList.setModel(allStaff);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectionNumber = staffList.getSelectedIndex();
                if (selectionNumber == -1) {
                    JOptionPane.showMessageDialog(panel1, "Please select someone to sack");
                } else {
                    allStaff.removeElementAt(selectionNumber);
                    staffName.setText("");
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = staffName.getText();

                if (newName.equals("")) {
                    JOptionPane.showMessageDialog(panel1, "Please enter a name to add");
                } else {
                    allStaff.addElement(newName);
                    staffName.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Staff List");
        frame.setContentPane(new StaffList().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

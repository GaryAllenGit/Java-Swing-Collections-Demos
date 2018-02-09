import javax.swing.*;
import java.awt.event.*;

public class StaffList2 {
    private JPanel panel1;
    private JList<Employee> allStaff;
    private JTextField idTF;
    private JTextField surnameTF;
    private JTextField firstnameTF;
    private JTextField deptTF;
    private JButton addButton;
    private JButton removeButton;
    private JButton findButton;
    private JButton clearButton;

    private StaffList stafflist;

    public StaffList2() {

        stafflist = new StaffList();

        //add some sample test data
        stafflist.addEmployee("S001", "Adrian", "Jackson", "C&MS");
        stafflist.addEmployee("S002", "Gary", "Allen", "C&MS");
        stafflist.addEmployee("S003", "Diane", "Kitchen", "C&MS");
        stafflist.addEmployee("S004", "Peter", "Hood", "C&MS");
        stafflist.addEmployee("S005", "Paula", "Sturdy", "C&MS");

        allStaff.setModel(stafflist);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newID = idTF.getText();
                String newSurname = surnameTF.getText();
                String newFirstname = firstnameTF.getText();
                String newDept = deptTF.getText();

                if (newID.equals("") || newSurname.equals("") ||
                        newFirstname.equals("") || newDept.equals("")) {
                    JOptionPane.showMessageDialog(panel1, "Please Enter Full Details");
                } else {
                    stafflist.addEmployee(newID, newFirstname, newSurname, newDept);
                    Employee newEmp = stafflist.findEmployeeByID(newID);
                    allStaff.setSelectedValue(newEmp, true);
                    clearAllTextFields();
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = allStaff.getSelectedIndex();

                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(panel1, "Select An Employee");
                } else {
                    Employee toGo = stafflist.getElementAt(selectedIndex);
                    if (JOptionPane.showConfirmDialog(panel1, "Really Delete Employee: " + toGo,
                            "Delete Confirmation", JOptionPane.YES_NO_OPTION)
                            == JOptionPane.YES_OPTION) {
                        stafflist.removeEmployee(toGo.getID());
                        clearAllTextFields();
                        allStaff.clearSelection();
                    }
                }
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee searchedFor;

                String findID = idTF.getText();
                String findName = surnameTF.getText();

                if (findID.equals("") && findName.equals("")) {
                    JOptionPane.showMessageDialog(panel1, "Enter Either an ID or a Surname");
                } else {
                    if (!findID.equals("")) {
                        searchedFor = stafflist.findEmployeeByID(findID);
                    } else {
                        searchedFor = stafflist.findEmployeeByName(findName);
                    }
                    if (searchedFor == null) {
                        JOptionPane.showMessageDialog(panel1, "Employee Not Found");
                    } else {
                        setAllTextFields(searchedFor);
                        allStaff.setSelectedValue(searchedFor, true);
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAllTextFields();
                allStaff.clearSelection();
            }
        });

        allStaff.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                allStaffItemSelected();
            }
        });

        allStaff.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                allStaffItemSelected();
            }
        });
    }

    private void allStaffItemSelected() {
        Employee selectedEmp = allStaff.getSelectedValue();
        if (selectedEmp != null) {
            setAllTextFields(selectedEmp);
        }
    }

    private void clearAllTextFields() {
        idTF.setText("");
        firstnameTF.setText("");
        surnameTF.setText("");
        deptTF.setText("");
    }

    private void setAllTextFields(Employee e){
        idTF.setText(e.getID());
        firstnameTF.setText(e.getFirstname());
        surnameTF.setText(e.getSurname());
        deptTF.setText(e.getDepartment());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StaffList2");
        frame.setContentPane(new StaffList2().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

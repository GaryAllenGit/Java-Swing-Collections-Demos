import javax.swing.DefaultListModel;

public class StaffList extends DefaultListModel<Employee> {
	public StaffList(){
		super();
	}

	public void addEmployee(String id, String  firstname, String surname, String dept){
		super.addElement(new Employee(id, firstname, surname, dept));
	}

	public Employee findEmployeeByName(String name){
		Employee temp;
		int indexLocation = -1;
		for (int i = 0; i < super.size(); i++) {
			temp = (Employee)super.elementAt(i);
			if (temp.getSurname().equals(name)){
				indexLocation = i;
				break;
			}
		}

		if (indexLocation == -1) {
			return null;
		} else {
			return (Employee)super.elementAt(indexLocation);
		}
	}

	public Employee findEmployeeByID(String id){
		Employee temp;
		int indexLocation = -1;
		for (int i = 0; i < super.size(); i++) {
			temp = (Employee)super.elementAt(i);
			if (temp.getID().equals(id)){
				indexLocation = i;
				break;
			}
		}

		if (indexLocation == -1) {
			return null;
		} else {
			return (Employee)super.elementAt(indexLocation);
		}
	}

	public void removeEmployee(String id){
		Employee empToGo = this.findEmployeeByID(id);
		super.removeElement(empToGo);
	}
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MainProgram extends ApplicationFrame implements ActionListener
{
	JMenuBar mainBar;
	JMenu Employees;
	JMenuItem addEmployee,editEmployee,searchEmployee,deleteEmployee,exitItem;
	MainProgram()
	{
		mainBar=new JMenuBar();
		Employees=new JMenu("Employees");
		addEmployee=new JMenuItem("Add Employee");
		editEmployee=new JMenuItem("Edit Employee");
		searchEmployee=new JMenuItem("Search Employee");
		deleteEmployee=new JMenuItem("Delete Employee");
		exitItem=new JMenuItem("Exit");
		Employees.add(addEmployee);
		Employees.add(editEmployee);
		Employees.add(searchEmployee);
		Employees.add(deleteEmployee);
		Employees.addSeparator();
		Employees.add(exitItem);
		mainBar.add(Employees);
		addEmployee.addActionListener(this);
		editEmployee.addActionListener(this);
		deleteEmployee.addActionListener(this);
		searchEmployee.addActionListener(this);
		exitItem.addActionListener(this);
		setJMenuBar(mainBar);
		setBounds(10,10,400,400);
		setVisible(true);
	}
public void actionPerformed(ActionEvent e)
{
	Object obj=e.getSource();
	if(obj==addEmployee){
		AddEmployee ad=new AddEmployee();
	}
	if(obj==searchEmployee){
		ViewEmployee ad=new ViewEmployee();
	}

	if(obj==editEmployee){
		EditEmployee ad=new EditEmployee();}

	if(obj==deleteEmployee){
		DeleteEmployee ad=new DeleteEmployee();}
	if(obj==exitItem)
		dispose();
}


public static void main(String args[])

{
	
		
	MainProgram mp=new MainProgram();
}

}

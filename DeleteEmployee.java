import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DeleteEmployee extends ApplicationFrame implements ActionListener
{
	JLabel nameLabel,ageLabel,codeLabel,addressLabel,genderLabel,phoneLabel,mobileLabel,emailLabel,departmentLabel,designationLabel;
	JTextField nameText,ageText,codeText,phoneText,mobileText,emailText,designationText;
	JTextArea addressArea;
	JComboBox genderCombo,departmentCombo;
	JButton searchButton,cancelButton,deleteButton;
	int selectedRecord=0;
	DeleteEmployee()
	{
		nameLabel=new JLabel("Name");
		ageLabel=new JLabel("Age");
		codeLabel=new JLabel("Employee Code");
		addressLabel=new JLabel("Address");
		genderLabel=new JLabel("Gender");
		phoneLabel=new JLabel("Phone");
		emailLabel=new JLabel("Email Address");
		mobileLabel=new JLabel("Mobile");
		departmentLabel=new JLabel("Department");
		designationLabel=new JLabel("Designation");
		nameText=new JTextField(10);
		ageText=new JTextField(10);
		codeText=new JTextField(10);
		addressArea=new JTextArea(5,15);
		genderCombo=new JComboBox();
		genderCombo.addItem("Male");
		genderCombo.addItem("Female");
		departmentCombo=new JComboBox();
		departmentCombo.addItem("Electronics");
		departmentCombo.addItem("IT");
		departmentCombo.addItem("Finance");
		departmentCombo.addItem("Marketng");
		phoneText=new JTextField(10);
		mobileText=new JTextField(10);
		emailText=new JTextField(10);
		designationText=new JTextField(10);
		searchButton=new JButton("Search");
		cancelButton=new JButton("Cancel");
		deleteButton=new JButton("Delete");	
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		setLayout(gbl);
		gbc.gridx=0;
		gbc.gridy=0;
		gbl.setConstraints(codeLabel,gbc);
		add(codeLabel);

		gbc.gridx=1;
		gbc.gridy=0;
		gbl.setConstraints(codeText,gbc);
		add(codeText);


		gbc.gridx=0;
		gbc.gridy=1;
		gbl.setConstraints(nameLabel,gbc);
		add(nameLabel);

		gbc.gridx=1;
		gbc.gridy=1;
		gbl.setConstraints(nameText,gbc);
		add(nameText);

		gbc.gridx=0;
		gbc.gridy=2;
		gbl.setConstraints(ageLabel,gbc);
		add(ageLabel);

		gbc.gridx=1;
		gbc.gridy=2;
		gbl.setConstraints(ageText,gbc);
		add(ageText);

		gbc.gridx=0;
		gbc.gridy=3;
		gbl.setConstraints(genderLabel,gbc);
		add(genderLabel);

		gbc.gridx=1;
		gbc.gridy=3;
		gbl.setConstraints(genderCombo,gbc);
		add(genderCombo);

		gbc.gridx=0;
		gbc.gridy=4;
		gbl.setConstraints(phoneLabel,gbc);
		add(phoneLabel);

		gbc.gridx=1;
		gbc.gridy=4;
		gbl.setConstraints(phoneText,gbc);
		add(phoneText);

		gbc.gridx=0;
		gbc.gridy=5;
		gbl.setConstraints(mobileLabel,gbc);
		add(mobileLabel);

		gbc.gridx=1;
		gbc.gridy=5;
		gbl.setConstraints(mobileText,gbc);
		add(mobileText);

		gbc.gridx=0;
		gbc.gridy=6;
		gbl.setConstraints(emailLabel,gbc);
		add(emailLabel);

		gbc.gridx=1;
		gbc.gridy=6;
		gbl.setConstraints(emailText,gbc);
		add(emailText);

		gbc.gridx=0;
		gbc.gridy=7;
		gbl.setConstraints(addressLabel,gbc);
		add(addressLabel);

		gbc.gridx=1;
		gbc.gridy=7;
		gbl.setConstraints(addressArea,gbc);
		add(addressArea);


		gbc.gridx=0;
		gbc.gridy=8;
		gbl.setConstraints(departmentLabel,gbc);
		add(departmentLabel);

		gbc.gridx=1;
		gbc.gridy=8;
		gbl.setConstraints(departmentCombo,gbc);
		add(departmentCombo);

		gbc.gridx=0;
		gbc.gridy=9;
		gbl.setConstraints(designationLabel,gbc);
		add(designationLabel);

		gbc.gridx=1;
		gbc.gridy=9;
		gbl.setConstraints(designationText,gbc);
		add(designationText);

		gbc.gridx=0;
		gbc.gridy=10;
		gbl.setConstraints(searchButton,gbc);
		add(searchButton);

		gbc.gridx=1;
		gbc.gridy=10;
		gbl.setConstraints(deleteButton,gbc);
		add(deleteButton);


		gbc.gridx=2;
		gbc.gridy=10;
		gbl.setConstraints(cancelButton,gbc);
		add(cancelButton);

		//setBounds(10,10,400,400);
		pack();
		searchButton.addActionListener(this);
		cancelButton.addActionListener(this);
		deleteButton.addActionListener(this);
		setVisible(true);
	}
public void actionPerformed(ActionEvent e)
{

	Object obj=e.getSource();
	if(obj==cancelButton)
		dispose();
	if(obj==searchButton)
	{
		JOptionPane jp=new JOptionPane();
		Connect cc=new Connect();
		cc.searchEmployee(codeText.getText());
		try
		{
		if(cc.rs.next())
		{
		nameText.setText(cc.rs.getString("Name"));
		ageText.setText(cc.rs.getString("Age"));
		addressArea.setText(cc.rs.getString("Address"));
		genderCombo.setSelectedItem(cc.rs.getString("gender"));
		phoneText.setText(cc.rs.getString("Phone"));
		mobileText.setText(cc.rs.getString("Mobile"));
		emailText.setText(cc.rs.getString("EmailAddress"));
		departmentCombo.setSelectedItem(cc.rs.getString("Department"));
		designationText.setText(cc.rs.getString("Designation"));
		selectedRecord=cc.rs.getInt("EmployeeID");
		}
		else
		{
		selectedRecord=0;
		nameText.setText("");
		ageText.setText("");
		addressArea.setText("");
		phoneText.setText("");
		mobileText.setText("");
		emailText.setText("");
		designationText.setText("");

		jp.showMessageDialog(this,"No Such Record");
		}
		
		}catch(Exception ee){

		System.out.println(ee);
		}
	}
	if(obj==deleteButton)
	{
		JOptionPane jp=new JOptionPane();
		if(selectedRecord==0)
		{
			jp.showMessageDialog(this,"Please select a Record");
			return;
		}
		Connect cc=new Connect();
		boolean result=cc.deleteEmployee(selectedRecord);
		if(result==true)
			jp.showMessageDialog(this,"Thanks for saving record");
		else
				jp.showMessageDialog(this,"Error in saving record");	
	}
}

public static void main(String args[])
{
	new DeleteEmployee();
}

}






		
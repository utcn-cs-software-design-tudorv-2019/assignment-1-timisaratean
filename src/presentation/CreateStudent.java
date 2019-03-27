package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businessLogic.ProfileBLL;
import model.Profile;

public class CreateStudent extends JFrame{
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	JLabel l1,l2,l3;
	JLabel l4,l5,l6,l7;
	 JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	 JButton btn1;
	 public CreateStudent() {
	  JFrame frame = new JFrame("Create student");
	  l1 = new JLabel("Id");
	  l2 = new JLabel("Name");
	  l3 = new JLabel("Address");
	  l4= new JLabel("CNP");
	  l5=new JLabel("Id User");
	  l6=new JLabel("Username");
	  l7=new JLabel("Password");
	  tf1 = new JTextField();
	  tf2 = new JTextField();
	  tf3 = new JTextField();
	  tf4 = new JTextField();
	  tf5 = new JTextField();
	  tf6 = new JTextField();
	  tf7 = new JTextField();
	  btn1=new JButton("Create student!");
	 
	  l1.setBounds(80, 30, 200, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  l4.setBounds(80, 150, 200, 30);
	  l5.setBounds(80, 190, 200, 30);
	  l6.setBounds(80, 230, 200, 30);
	  l7.setBounds(80, 270, 200, 30);
	  tf1.setBounds(300, 30, 200, 30);
	  tf2.setBounds(300, 70, 200, 30);
	  tf3.setBounds(300, 110, 200, 30);
	  tf4.setBounds(300, 150, 200, 30);
	  tf5.setBounds(300, 190, 200, 30);
	  tf6.setBounds(300, 230, 200, 30);
	  tf7.setBounds(300, 270, 200, 30);
	  scrollPane.setBounds(10, 370, 530, 160);
		frame.add(scrollPane);
	  
	 btn1.setBounds(180, 330, 200, 30);
	
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(l5);
	  frame.add(l6);
	  frame.add(l7);
	  frame.add(tf1);
	  frame.add(tf2);
	  frame.add(tf3);
	  frame.add(tf4);
	  frame.add(tf5);
	  frame.add(tf6);
	  frame.add(tf7);
	  frame.add(l3);
	  frame.add(btn1);
	  frame.add(l4);
	  frame.setSize(580, 600);
	  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  thehandler handler=new thehandler();
	 	btn1.addActionListener(handler);
}
	 private <T> JTable createTable(List<T> object) {
			JTable table = null;
			int numberOfColumns = object.get(0).getClass().getDeclaredFields().length;
			String columns[] = new String[numberOfColumns];
			int i=0;
			for (Field field : object.get(0).getClass().getDeclaredFields()) {
				columns[i] = field.getName();
				i++;
			
			}
			String rows[][] = new String[object.size()][numberOfColumns];
			int row = 0;
			for (Object obj : object) {
				int col = 0;
				for (Field field : obj.getClass().getDeclaredFields()) {
					field.setAccessible(true);
					Object value;
					try {
						value = field.get(obj);
						rows[row][col] = value.toString();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
					col++;
				}
				row++;
			}
			table = new JTable(rows,columns);
			return table;
		}
	 public void setTable(JTable newTable) {
			this.table = newTable;
			scrollPane.setViewportView(table);
			repaint();
			revalidate();
		}
	 private class thehandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				ProfileBLL profile=new ProfileBLL();
				int id1=Integer.parseInt(String.valueOf(tf1.getText()));
				String name=String.valueOf(tf2.getText());
				String address=String.valueOf(tf3.getText());
				String cnp=String.valueOf(tf4.getText());
				int idC=Integer.parseInt(String.valueOf(tf5.getText()));
				String username=String.valueOf(tf6.getText());
				String pass=String.valueOf(tf7.getText());
				Profile p=new Profile(id1,idC,name,address,cnp);
				profile.register(p,username,pass);
				//JOptionPane.showMessageDialog(null, "Your account has been created!");
				setTable(createTable(ProfileBLL.list()));
			}
			}
}
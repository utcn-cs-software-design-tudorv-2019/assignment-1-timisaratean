package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.CourseBLL;
import businessLogic.ProfileCourseBLL;
import businessLogic.UserBLL;
import model.Course;
import model.ProfileCourse;
public class Enroll extends JFrame {
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	 JButton btn1;
	 public Enroll() {
		 	JFrame frame = new JFrame("Courses you are not enrolled in");
			scrollPane.setBounds(10, 30, 530, 160);
			frame.add(scrollPane);
			
			btn1=new JButton("Enroll");
			btn1.setBounds(150,230,200,30);
			frame.add(btn1);
			 
			frame.setSize(580, 550);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setLayout(null);
			frame.setVisible(true);
			setTable(createTable(CourseBLL.list()));
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
	 public JTable getTable() {
			return table;
		}
	 private class thehandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				int ok=0;
				if (event.getSource()==btn1){
					
					int idU=Integer.parseInt(getTable().getValueAt(getTable().getSelectedRow(), 0).toString());
					ProfileCourse p=new ProfileCourse((idU+Login.idd)*10,Login.idd,idU,0,0);
					List<ProfileCourse> list=ProfileCourseBLL.list();
					for(ProfileCourse pc:list) {
						System.out.println(pc.toString());
						if (pc.getidS()==Login.idd && pc.getidC()==idU) {
							System.out.println(ok);
							ok=1;
						}
					}
					if (ok==0) {
					ProfileCourseBLL.insertProfile(p);
					JOptionPane.showMessageDialog(null, "You enrolled to the course");
					}
					else {
					JOptionPane.showMessageDialog(null, "You are already enrolled to this course");
					}
					
					
				}
			}
	 }
	 
	 
}

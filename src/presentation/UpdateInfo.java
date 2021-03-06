package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import businessLogic.ProfileBLL;
import model.Profile;

public class UpdateInfo extends JFrame {
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	 private JButton btn1;
	 public UpdateInfo() {
		 JFrame frame = new JFrame("Update my info");
		 btn1=new JButton("Update!");
		 scrollPane.setBounds(10, 30, 530, 160);
			frame.add(scrollPane);
		 btn1.setBounds(150,210,200,30);
		 	frame.add(btn1);
		 
		  frame.setSize(580, 400);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setLayout(null);
		  frame.setVisible(true);
		  
		  thehandler handler=new thehandler();
		  btn1.addActionListener(handler);
		  List<Profile> list=new ArrayList<>();
		  Profile p = ProfileBLL.findProfilebyuser(Login.idd);
			list.add(p);
			setTable(createTable(list));
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
				int idU=Integer.parseInt(getTable().getValueAt(getTable().getSelectedRow(), 0).toString());
				int idU1=Integer.parseInt(getTable().getValueAt(getTable().getSelectedRow(), 1).toString());
				String name=getTable().getValueAt(getTable().getSelectedRow(), 2).toString();
				String address=getTable().getValueAt(getTable().getSelectedRow(), 3).toString();
				String cnp=getTable().getValueAt(getTable().getSelectedRow(), 4).toString();
				Profile p=new Profile(idU,idU1,name,address,cnp);
				ProfileBLL.updateProfile(p);
				 List<Profile> list=new ArrayList<>();
					list.add(p);
					setTable(createTable(list));
			}
	 }
	 
}

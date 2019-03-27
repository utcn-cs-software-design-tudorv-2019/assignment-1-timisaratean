package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import businessLogic.ProfileBLL;
import model.Profile;



public class ReadStudent extends JFrame {
	public JLabel l1;
	public JTextField tf1;
	public JButton btn1;
	private JTable table;
	 private JScrollPane scrollPane=new JScrollPane();
	 public ReadStudent() {
		 JFrame frame = new JFrame("Read student");
		 l1=new JLabel("Introduceti id-ul studentului");
		 btn1=new JButton("Cauta!");
		 tf1=new JTextField();
		 l1.setBounds(80, 30, 200, 30);
		 tf1.setBounds(310, 30,200,30);
		 btn1.setBounds(150, 80,200,30);
		 
		 frame.add(l1);
		 frame.add(tf1);
		 frame.add(btn1);
		 
		 scrollPane.setBounds(10, 170, 530, 160);
			frame.add(scrollPane);
		 
		 frame.setSize(580, 400);
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
				List<Object> list2=new ArrayList<Object>();
				int id1=Integer.parseInt(String.valueOf(tf1.getText()));
				Object p=ProfileBLL.findProfile(id1);
				list2.add(p);
				setTable(createTable(list2));
			}
	 }
			
}

package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ViewTeacher extends JFrame {
	JButton btn1,btn2,btn3,btn4;
	public ViewTeacher() {
		JFrame frame = new JFrame("Admin page");
		btn1=new JButton("Create student");
		btn2=new JButton("Read student information");
		btn3=new JButton("Update student information");
		btn4=new JButton("Delete student");
		
		btn1.setBounds(80, 30, 200, 30);
		btn2.setBounds(80, 70, 200, 30);
		btn3.setBounds(80, 110, 200, 30);
		btn4.setBounds(80, 150, 200, 30);
		
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn4);
		
		  frame.setSize(400, 350);
		  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  frame.setLayout(null);
		  frame.setVisible(true);
		
		  thehandler handler=new thehandler();
		 	btn1.addActionListener(handler);
		 	
		 	thehandler2 handler2=new thehandler2();
		 	btn2.addActionListener(handler2);
		 	
		 	thehandler3 handler3=new thehandler3();
		 	btn4.addActionListener(handler3);
		 	
		 	thehandler4 handler4=new thehandler4();
		 	btn3.addActionListener(handler4);
	}
	private class thehandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			CreateStudent c=new CreateStudent();
			
		}}
		private class thehandler2 implements ActionListener{	
		public void actionPerformed(ActionEvent event){
			ReadStudent c=new ReadStudent();
			
		}
		}
		private class thehandler3 implements ActionListener{	
			public void actionPerformed(ActionEvent event){
				DeleteStudent c=new DeleteStudent();
				
			}
			}
		private class thehandler4 implements ActionListener{	
			public void actionPerformed(ActionEvent event){
				UpdateStudent c=new UpdateStudent();
				
			}
			}
}
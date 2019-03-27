package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ViewStudent extends JFrame{
	JButton btn1,btn2,btn3,btn4;
	JLabel l1;
	public ViewStudent() {
	JFrame frame = new JFrame("Student page");
	l1 = new JLabel("Enroll to another course");
	  l1.setForeground(Color.blue);
	 l1.setBounds(100,120,200,100);
	 frame.add(l1);
	btn1=new JButton("View my courses");
	btn1.setBounds(80, 30, 200, 30);
	frame.add(btn1);
	
	btn2=new JButton("View my information");
	btn2.setBounds(80,70,200,30);
	frame.add(btn2);
	
	btn3=new JButton("Update my information");
	btn3.setBounds(80,110,200,30);
	frame.add(btn3);
	
	btn4=new JButton("Enroll");
	btn4.setBounds(80,190,200,30);
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
	 btn3.addActionListener(handler3);
	 
	 thehandler4 handler4=new thehandler4();
	 btn4.addActionListener(handler4);
	}
	private class thehandler implements ActionListener{
	public void actionPerformed(ActionEvent event){
		ViewCourses c=new ViewCourses();
		
	}}
	
	private class thehandler2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			ViewInfo c=new ViewInfo();
			
		}}
	private class thehandler3 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			UpdateInfo c=new UpdateInfo();
			
		}}
	private class thehandler4 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			Enroll c=new Enroll();
			
		}}
}

package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import businessLogic.UserBLL;



public class Login extends JFrame {
	JLabel l1, l2, l3;
	JLabel l4;
	 static JTextField tf1;
	public static int idd;
	 JButton btn1;
	 JButton btn2;
	 JPasswordField p1;
	 public Login() {
	  JFrame frame = new JFrame("Login Form");
	  l1 = new JLabel("Login Form");
	  l1.setForeground(Color.blue);
	 
	 
	  l2 = new JLabel("Username");
	  l3 = new JLabel("Password");
	  l4= new JLabel("Create your account");
	  l4.setForeground(Color.blue);
	  tf1 = new JTextField();
	  p1 = new JPasswordField();
	  btn1 = new JButton("Login");
	  btn2=new JButton("Register");
	 
	  l1.setBounds(250, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  p1.setBounds(300, 110, 200, 30);
	  btn1.setBounds(250, 160, 100, 30);
	  btn2.setBounds(250,200,100,30);
	  l4.setBounds(100,200 , 150, 30);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(tf1);
	  frame.add(l3);
	  frame.add(p1);
	  frame.add(btn1);
	  frame.add(btn2);
	  frame.add(l4);
	  frame.setSize(600, 300);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  
	  thehandler handler=new thehandler();
		btn1.addActionListener(handler);
		
	 thehandler2 handler2=new thehandler2();
	 	btn2.addActionListener(handler2);
	 
}
	
	 private class thehandler implements ActionListener{
			
			public void actionPerformed(ActionEvent event){
				if (event.getSource()==btn1){
					idd=UserBLL.findId(String.valueOf(tf1.getText()));
					if(UserBLL.login(String.valueOf(tf1.getText() ),String.valueOf(p1.getPassword()))==0)
					{
						System.out.println("Login as teacher");
						ViewTeacher g2=new ViewTeacher();
						
					} else {
						System.out.println("Login as student");
						ViewStudent g=new ViewStudent();
						
				
					}
				}
			}
	 }
	 private class thehandler2 implements ActionListener{
		 public void actionPerformed(ActionEvent event) {
			 Register r=new Register();
		 }
	 }
}

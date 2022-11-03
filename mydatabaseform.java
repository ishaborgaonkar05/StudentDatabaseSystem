import java.awt.*;
import java.sql.*;
import java.util.*;
import java.awt.event.*;
class mydatabaseform extends Frame implements ActionListener,ItemListener
{
// Declaration of AWT Components
Label l1,l2,l3,l4,l5,l6,l7,l8;
TextField t1,t2,t3,t4,t5,t6;
Button b1,b2,b3,b4,b5;
CheckboxGroup cg=new CheckboxGroup();
Checkbox cbr= new Checkbox("male",cg,true);
Checkbox cbr1= new Checkbox("Female",cg,false);
PreparedStatement st,st2,st3;
ResultSet rs,rs2,rs3;
String Name,Address,Branch,Gender;
int RollNo,MobNumber,num;
Choice c1= new Choice();

// Default Constructor				
		mydatabaseform()
		{
				// Creating instances for all Lables and TextFields 
				Font f= new Font("Algerian",Font.BOLD,15);
				l1=new Label("Student Database System",Label.CENTER);
				l1.setBackground(Color.GREEN);
				l1.setFont(f);
				
				l8=new Label();
				l8.setBackground(Color.GREEN);
				
				
				l7=new Label("RollNo");
				l2=new Label("Name");
				l3=new Label("Address");
				l4=new Label("Branch");
				l5=new Label("Gender");
				l6=new Label("Contact No:");

				t6=new TextField(20);
				t1=new TextField(20);
				t2=new TextField(10);
				t3=new TextField(10);
				t4=new TextField(10);
				t5=new TextField(100);
				b1=new Button("Submit");
				b2=new Button("View Next");
				b3=new Button("Update");
				b4=new Button("Delete");
				//b5=new Button("Previous");

				// Fixing Components in Frame 
				setLayout(null); //No Layout
				//setBounds needs 4 parameters=left,top,width,height
				//Setting Bounds for Lables and text areas in Window(fixing in window)
				l1.setBounds(225,60,250,50);
				add(l1);

				l7.setBounds(100,130,100,30);
				add(l7);
				
				l2.setBounds(100,200,100,30);
				add(l2);


				l3.setBounds(100,280,100,30);
				add(l3);

				l4.setBounds(100,360,100,30);
				add(l4);

				l5.setBounds(100,440,100,30);
				add(l5);

				l6.setBounds(100,520,100,30);
				add(l6);

 
				t6.setBounds(350,130,100,30);
				add(t6);
 
				t1.setBounds(350,200,100,30);
				add(t1);

				t2.setBounds(350,280,100,30);
				add(t2);



				t4.setBounds(350,360,100,30);
				add(t4);

				Panel p1=new Panel();
				p1.setLayout(new GridLayout(1,2,40,40));

				p1.add(cbr);
				p1.add(cbr1);

				p1.setBounds(350,440,200,40);
				add(p1);

				t3.setBounds(350,520,100,30);
				add(t3);

				b1.setBounds(100,600,90,30);
				add(b1);
				
				b2.setBounds(200,600,90,30);
				add(b2);
				
				b3.setBounds(300,600,90,30);
				add(b3);
				
				b4.setBounds(400,600,90,30);
				add(b4);
				
				/*b5.setBounds(500,600,90,30);
				add(b5);*/
				/*c1.setBounds(700,200,200,300);
				this.add(c1);*/
				Update();
				
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				b4.addActionListener(this);
				//b5.addActionListener(this);
				
				
				
			
							
			// Adding Window Listener
			// This is for Closing Window after Clicking on Cross symbol at right top corner
			this.addWindowListener(new WindowAdapter()
					{
						public void windowClosing(WindowEvent w )
						{
							dispose();
						}
					});
					
			//  Creating database connection
						
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/ javaform","root","");
			st=con.prepareStatement("select * from jform2");
			rs=st.executeQuery();		
			}
			catch(Exception e)
			{
				System.out.println(e);
			}								
			c1.addItemListener(this);
				
		}//End of Constructor

 // Function to Update databse 
	void Update()
	{
		try
		{
			while(rs.next())
			{
			c1.add(rs.getString("Name"));
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
		
 		public void itemStateChanged(ItemEvent ae)
			{
				try
				{
					String a = c1.getSelectedItem();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/javaform","root","");
					// Selecting database and showing on Frame window
					st3=con.prepareStatement("select * from jform2 where name=?");
					
					st3.setString(1,a);
					rs3=st3.executeQuery();	
					rs3.next();
					t1.setText(rs3.getString(1)); 
					t2.setText(rs3.getString(2)); 
					t3.setText(rs3.getString(3));
					// Selects Gernder from radio button which is Ticked
					 if(rs3.getString(4).equals("male"))
							{
								cbr.setState(true);
							}
							else
							{
								cbr1.setState(true);
							}
					t4.setText(rs3.getString(5));
					
				
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			}	
		//Action Event for each click	
		public void actionPerformed(ActionEvent ae)
		{
			//Code to insert Data
			if(ae.getSource()==b1)
				{
						
					try{
						
						Checkbox g1;
						RollNo=Integer.parseInt(t6.getText());
						
						Name=t1.getText();
						Address=t2.getText();
						Branch=t4.getText();
						// selected radio button get inserted into database
						g1=cg.getSelectedCheckbox();
						Gender=g1.getLabel();
						MobNumber=Integer.parseInt(t3.getText());
						
						
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/javaform","root","");
			PreparedStatement st=con.prepareStatement("insert into jform2(RollNo,Name,Address,Branch,Gender,MobNumber) values(?,?,?,?,?,?)");
						
						//Insert data into Rows in database 
						st.setInt(1,RollNo);
						st.setString(2,Name);
						st.setString(3,Address);
						st.setString(4,Branch);
						st.setString(5,Gender);
						st.setInt(6,MobNumber);
						
						//Prapared Statement 
						st.executeUpdate();
						System.out.println("Record Inserted Succesfully");
						
						l8.setBounds(700,200,250,100);
			            l8.setText("Record Inserted Successfully");
				        this.add(l8);
			
						con.close();
						
						
					}
					catch(Exception e)
					{
						System.out.println(e);
						
					}	
				}
				//Code to view records one by one
				else if(ae.getSource()==b2)
				{
				    try
					{	
					//retriving data from resultset and setting to each textField
			        	rs.next();
						{
						
							t6.setText(rs.getString(1));
						    t1.setText(rs.getString(2)); 
							t2.setText(rs.getString(3)); 
							t3.setText(rs.getString(6));
							if(rs.getString(5).equals("male"))
							{
								cbr.setState(true);
							}
							else
							{
								cbr1.setState(true);
							}
							t4.setText(rs.getString(4));
								
						}
						
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
				}
				//Code to update phone database 
				else if(ae.getSource()==b3)
				{
						
					try
					{						
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/javaform","root","");
			
					String n=t6.getText();
					
					num=Integer.parseInt(t3.getText());
	
					PreparedStatement st2=con.prepareStatement("update  jform2 set MobNumber='"+num+"' where RollNo='"+n+"'");
				
					st2.executeUpdate();
					con.close();


					System.out.println("Updated succesfully");
					l8.setBounds(700,200,250,100);
			l8.setText("Phone Number Updated Succesfully");
				this.add(l8);
			
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
						
				}
				//Deleting row from database
		      else if(ae.getSource()==b4)
			{ 
				try
					{
												
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:MySQL://localhost:3306/javaform","root","");
			
			String n=t6.getText();
			PreparedStatement st=con.prepareStatement("delete from jform2 where RollNo='"+n+"'");
			st.executeUpdate();
			System.out.println("Query deleted succesfully");
			l8.setBounds(700,200,250,100);
			l8.setText("Record Deleted Successfully");
				this.add(l8);
				
				
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					
			}
			//View Previous record 
				/*else if(ae.getSource()==b5)
				{
					
					try
					{
						
						if(rs.previous())
						{
						
							t1.setText(rs.getString(1)); 
							t2.setText(rs.getString(2)); 
							t4.setText(rs.getString(3));
							if(rs.getString(4).equals("male"))
							{
								cbr.setState(true);
							}
							else
							{
								cbr1.setState(true);
							}
							t3.setText(rs.getString(5));
						
						}
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
						
				}*/

}	//End of action event		
				
public static void main(String args[])
{
mydatabaseform ol= new mydatabaseform();
ol.setSize(1000,5500);
ol.show();
}
}
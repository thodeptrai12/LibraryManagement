package cuoiky;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



public class Student extends JFrame {
	private  JPanel contentPane;
	private  JLabel label;
	private  JLabel label1;
	private  JLabel label2;
	private  JLabel label3;
	private  JLabel label4;
	private  JLabel label5;
     
	private  JTextField textField;
	private  JTextField textField1;
	private  JTextField textField2;
	private  JTextField textField3;
	private  JTextField textField4;
	private  JTextField textField5;
     
	private  JButton buttonAdd ;
	private  JButton buttonUpdate;
	private  JButton buttonDelete;
	private  JButton buttonCancle;
	private  JButton buttonSearch;
	private  JButton buttonReset;
	private  JScrollPane scrollpane;
	private  JTable table;
	private  DefaultTableModel model;
	private  Connection connection;
	private   String url = "jdbc:mysql://localhost:3307/librarymanagement ";
	private   String user = "ranko";
	private   String password = "123456789";
	private  Statement statement;
	private  ResultSet resultset;
	private  PreparedStatement preparedStatement;
    public static void main (String[]args) {
	    	Student kk =new Student();
	    	kk.setVisible(true); 
	         
	    }
    private void listSelectionModel() {
 		ListSelectionModel selectModel = table.getSelectionModel(); 
 		selectModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = table.getSelectedRow();
	 				if (selectedRow != -1) {// TODO Auto-generated method stub
			
			 textField1.setText(model.getValueAt(selectedRow, 0).toString());
			 textField2.setText(model.getValueAt(selectedRow, 1).toString());
			 textField3.setText(model.getValueAt(selectedRow, 2).toString());
			 textField4.setText(model.getValueAt(selectedRow, 3).toString());
				
			}
 				}
 			 
 			 
 			 
 		});
    }
    
      
	
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1300,740);
	    contentPane = new JPanel();
	    contentPane.setLayout(null);
	
	
	    
	    String [] columns = {"StudentID","StudentName","Address","Phone"};
		Object [][] rows = {} ;
	       table = new JTable();
	       model = new DefaultTableModel(rows,columns);
	       table.setModel(model);
	      /* DefaultTableModel cung cấp add method addRow(),removeRow(),setValueAt() update lại , getValueAt lấy giá trị .
	      mô hình quản lý dữ liệu tương tác JTable ArrayList ,Vector dễ dàng thay đổi giá trị trong bảng ,quản ly tự động .
	      */
         
	      JScrollPane scrollPane = new JScrollPane(table);
	 	  scrollPane.setBounds(512, 11, 666, 615);
	 	  contentPane.add(scrollPane);	
	    
	 	    try {
		    	connection = DriverManager.getConnection(url,user,password);
	 	        statement =  connection.createStatement();
	 	        String sql = "SELECT * FROM student ;";
	 	        resultset = statement.executeQuery(sql);
	 	        while(resultset.next()) {
	 	        	String StudentID = resultset.getString("StudentID");
	 	        	String StudentName = resultset.getString("StudentName");
	 	        	String Address = resultset.getString("Address");
	 	        	String Phone = resultset.getString("Phone");
	 	            model.addRow(new Object []{StudentID,StudentName,Address,Phone});
	 	        }
	 		}
	 		catch(SQLException e) {
	 			e.printStackTrace();
	 		}
	 	 
		 
	    label = new JLabel("Student");
		label.setFont(new Font("Tahoma",Font.BOLD,30));
		label.setBounds(42, 32, 131, 51);
		contentPane.add(label);
		
		label1 = new JLabel("Student ID");
		label1.setFont(new Font("Tahoma",Font.BOLD,16));
		label1.setBounds(42, 118, 90, 25);
		contentPane.add(label1);
		
		
		label2 = new JLabel("Student Name");
		label2.setFont(new Font("Tahoma",Font.BOLD,16));
		label2.setBounds(20, 174, 150, 35);
		contentPane.add(label2);
		
		
		label3 = new JLabel("Address");
		label3.setFont(new Font("Tahoma",Font.BOLD,16));
		label3.setBounds(42, 239, 90, 25);
		contentPane.add(label3);
		
		
		label4 = new JLabel("Phone");
		label4.setFont(new Font("Tahoma",Font.BOLD,16));
		label4.setBounds(42, 308, 90, 25);
		contentPane.add(label4);
		
		
		label5 = new JLabel("Find");
		label5.setBounds(55,412, 90, 25);
		label5.setFont(new Font("Tahoma",Font.BOLD,16));
		contentPane.add(label5);
		
		textField1 = new JTextField();
		textField1.setBounds(133, 117, 250, 30);
		contentPane.add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(145, 174, 234, 42);
		contentPane.add(textField2);
		
		textField3 = new JTextField();
		textField3.setBounds(130,239, 255, 42);
		contentPane.add(textField3);
		
		textField4 = new JTextField();
		textField4.setBounds(137, 308, 223, 30);
		contentPane.add(textField4);
		
		textField5 = new JTextField();
		textField5.setBounds(137, 412, 223, 30);
		contentPane.add(textField5);	
		
		buttonAdd = new JButton("ADD");
		buttonAdd.setBounds(79, 501, 115, 51);
		buttonAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonAdd.addActionListener(new ActionListener() {
			String studentID = textField1.getText();
			String studentName = textField2.getText();
			String address = textField3.getText();
			String phone = textField4.getText();
			@Override
			public void actionPerformed(ActionEvent e) {
		   		
		 		String studentID = textField1.getText();
				String studentName = textField2.getText();
				String address = textField3.getText();
				String phone = textField4.getText();
				 if(!studentID.isEmpty()&& !studentName.isEmpty()&& !address.isEmpty() && !phone.isEmpty()) {
				String addQuery = "INSERT INTO student(StudentID,StudentName,Address,Phone)VALUES(?,?,?,?);";
				         try {
					      preparedStatement = connection.prepareStatement(addQuery);
					      preparedStatement.setString(1, studentID);
					      preparedStatement.setString(2, studentName);
					      preparedStatement.setString(3, address);
					      preparedStatement.setString(4, phone);
				          preparedStatement.executeUpdate();
			         	} catch (SQLException e1) {
					// TODO Auto-generated catch block
					         e1.printStackTrace();
				          } 
				           model.addRow(new Object[] {studentID,studentName,address,phone});
		    }
		    else {
		    	JOptionPane.showMessageDialog(null, "You haven't entered all rows","Error",JOptionPane.ERROR_MESSAGE);
		    }
		    
		    }
			
			
		});  
		contentPane.add(buttonAdd);
	    
		buttonUpdate = new JButton("UPDATE");
		buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonUpdate.setBounds(231, 501, 115, 51);
		buttonUpdate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				// TODO Auto-generated method stub
			if(selectedRow != -1) {
			 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to update","Confirm",JOptionPane.YES_NO_OPTION);
				if(confirm == JOptionPane.YES_OPTION) {
				
				String studentID = textField1.getText();
			    String studentName = textField2.getText();
			    String address = textField3.getText();
			    String phone = textField4.getText();
			    
			    String updateQuery = "UPDATE student SET StudentID = ?, StudentName = ? ,Address = ? ,Phone = ? WHERE StudentID = ?";
			    try {
					preparedStatement = connection.prepareStatement(updateQuery);
					preparedStatement.setString(1, studentID);
					preparedStatement.setString(2, studentName);
					preparedStatement.setString(3, address);
					preparedStatement.setString(4, phone);
					preparedStatement.setString(5, model.getValueAt(selectedRow, 0).toString());

				    preparedStatement.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    model.setValueAt(studentID, selectedRow, 0);
			    model.setValueAt(studentName, selectedRow, 1);
				model.setValueAt(address, selectedRow, 2);
				model.setValueAt(phone, selectedRow, 4);
				    JOptionPane.showMessageDialog(null, "Update SuccessFul");
				}else {
					JOptionPane.showMessageDialog(null, "Update not SuccessFul");
				}
			}else {
				JOptionPane.showMessageDialog(null, "You haven't choose row","Error",JOptionPane.ERROR_MESSAGE);
			}
			}		
		});
		
		contentPane.add(buttonUpdate);
		
		buttonDelete = new JButton("DELETE");
		buttonDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonDelete.setBounds(79, 575, 115, 51);
		buttonDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			int selectedRow = table.getSelectedRow();
			  
			    if(selectedRow != -1) {
			    	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to Delete","Confirm",JOptionPane.YES_NO_OPTION);
      			    	if(confirm == JOptionPane.YES_OPTION ) {
      			    	  try {
      						String studentID = model.getValueAt(selectedRow, 0).toString();        	 
      						String deleteQuery = "DELETE FROM student WHERE StudentID = ? ;";
      						preparedStatement = connection.prepareStatement(deleteQuery);
      						preparedStatement.setString(1, studentID);
      						preparedStatement.executeUpdate();
      					    JOptionPane.showMessageDialog(null, "Delete SuccessFul");
      					    
      						model.removeRow(selectedRow);
      					            } catch (SQLException e1) {
      						                          e1.printStackTrace();}
      						
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(null, "Delete not SuccessFul");
			    	}
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "You haven't choose row","ERROR",JOptionPane.ERROR_MESSAGE);
			    }
			}		
		});
		contentPane.add(buttonDelete);
		
		buttonCancle = new JButton("CANCLE");
		buttonCancle.setBounds(231, 575, 115, 51);
		buttonCancle.setFont(new Font("Tahoma", Font.BOLD, 20));
		buttonCancle.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
			
			
			
		});
		contentPane.add(buttonCancle);
		
		
		buttonSearch = new JButton("Search");
		buttonSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonSearch.setBounds(390, 412, 115, 30);
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
	    try {
	    
	    	String search = textField5.getText();
	    	String sql = "SELECT * FROM student WHERE StudentID = ? ;";
	    	model.setRowCount(0);
	    	preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, search);
	         resultset = preparedStatement.executeQuery();
	        while(resultset.next()) {
	        	String studentID = resultset.getString("StudentID");
	        	String studentName = resultset.getString("StudentName");
	        	String address = resultset.getString("Address");
	        	String phone = resultset.getString("Phone");
	        	model.addRow(new Object [] {studentID,studentName,address,phone});
			
	        }
	    }
	        catch(SQLException e1) {
		    	e1.printStackTrace();
	        }
			}	
		});
		
		contentPane.add(buttonSearch);
		 
		 buttonReset = new JButton("Reset");
		    buttonReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		    buttonReset.setBounds(391, 459, 99, 30);
		    buttonReset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					model.setRowCount(0);
					try {
						String sql ="SELECT * FROM student;";
						statement = connection.createStatement();
				        resultset = statement.executeQuery(sql);
				        while(resultset.next()) {
				        	String StudentID = resultset.getString("StudentID");
				        	String StudentName = resultset.getString("StudentName");
				        	String Address = resultset.getString("Address");
				        	String Phone = resultset.getString("Phone");
				        	model.addRow(new Object[]{StudentID,StudentName,Address,Phone});
				        	
				        }
					}catch(SQLException e4) {
						e4.printStackTrace();
					}
		    	
				}
		    	
		    });
		    contentPane.add(buttonReset);
	    
	    
	    
	    
	    
	    
		listSelectionModel();
	    
	    
	    
	    
	    setContentPane(contentPane);
	}





	
}

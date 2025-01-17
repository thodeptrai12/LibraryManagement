package cuoiky;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import cuoiky.Book;
import cuoiky.LibraryManageMenet;

public class Borrow extends JFrame {
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
	
     
	private  JButton buttonAdd ;
	private  JButton buttonUpdate;
	private  JButton buttonReturned;
	private  JButton buttonCancle;
	private  JButton buttonSearch;
	private  JButton buttonReset;
	private  JScrollPane scrollPane;
	private  JTable table;
	private  DefaultTableModel model;
	private  Connection connection;
	private   String url = "jdbc:mysql://localhost:3307/librarymanagement";
	private   String user = "ranko";
	private   String password = "123456789";
	private  Statement statement;
	private  ResultSet resultset;
	private JDateChooser borrowDate;
	private JDateChooser returnDate;
	
	private  PreparedStatement preparedStatement;
	public static void main(String[] args) {

                Borrow frame = new Borrow();
                frame.setVisible(true);  
    }
	private void listSelectionModel() {
	    ListSelectionModel selectModel = table.getSelectionModel(); 
	    selectModel.addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            int selectedRow = table.getSelectedRow();
	            if (selectedRow != -1) {
	                
	                String studentID = model.getValueAt(selectedRow, 0).toString();
	                String bookID = model.getValueAt(selectedRow, 1).toString();
	                String borrow = model.getValueAt(selectedRow, 2).toString();
	                String returned = model.getValueAt(selectedRow, 3).toString();
	                textField1.setText(studentID);
	                textField2.setText(bookID);
	               try {
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                Date borrowparse = format.parse(borrow);
	                Date returnparse= format.parse(returned);
	                borrowDate.setDate(borrowparse);
	                returnDate.setDate(returnparse);
	               } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	        }   
	    });
	}
	public Borrow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,1300,740);
	    contentPane = new JPanel();
	    contentPane.setLayout(null);
	    String columns[] = {"StudentID","BookID","BorrowDate","ReturnDate","Fine"} ;
	    Object rows [][] = {};
	    table = new JTable();
	    model = new DefaultTableModel(rows,columns);
	    table.setModel(model);
	    scrollPane = new JScrollPane(table); 	    
	    scrollPane.setBounds(401, 20, 591, 522);
        contentPane.add(scrollPane);
	   
        try {
        	connection = DriverManager.getConnection(url,user,password);
        	statement = connection.createStatement();
        	resultset = statement.executeQuery("SELECT * FROM borrow");
        	while(resultset.next()) {
        		String studentID = resultset.getString("StudentID");
        		String bookID = resultset.getString("BookID");
        		String borrow = resultset.getString("BorrowDate");
        		String returned = resultset.getString("ReturnDate");
        		String fine = resultset.getString("Fine");
           model.addRow(new Object[] {studentID,bookID,borrow,returned,fine});
        	}
       }
        catch(SQLException e) {
        	e.printStackTrace();
        }

	        label = new JLabel("BORROW BOOK");
	        label.setFont(new Font("Tahoma", Font.BOLD, 30));
	        label.setBounds(30, 20, 250, 50);
	        contentPane.add(label);

	        label1= new JLabel("Student ID");
	        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
	        label1.setBounds(30, 90, 100, 25);
	        contentPane.add(label1);

	        textField1 = new JTextField();
	        textField1.setBounds(150, 90, 200, 25);
	        contentPane.add(textField1);

	        label1 = new JLabel("Book ID");
	        label1.setFont(new Font("Tahoma", Font.BOLD, 16));
	        label1.setBounds(30, 126, 100, 25);
	        contentPane.add(label1);

	        textField2 = new JTextField();
	        textField2.setBounds(150, 126, 200, 25);
	        contentPane.add(textField2);

	        label2 = new JLabel("Borrow Date");
	        label2.setFont(new Font("Tahoma", Font.BOLD, 16));
	        label2.setBounds(30, 179, 120, 25);
	        contentPane.add(label2);

	        borrowDate = new JDateChooser();
	        borrowDate.setDateFormatString("yyyy-MM-dd");
	        borrowDate.setBounds(150, 179, 200, 25);
	        contentPane.add(borrowDate);

	        label3 = new JLabel("Return Date");
	        label3.setFont(new Font("Tahoma", Font.BOLD, 16));
	        label3.setBounds(30, 257, 120, 25);
	        contentPane.add(label3);

	        returnDate = new JDateChooser();
	        returnDate.setDateFormatString("yyyy-MM-dd");
	        returnDate.setBounds(150, 257, 200, 25);
	        contentPane.add(returnDate);

	        label4= new JLabel("Find");
	        label4.setFont(new Font("Tahoma", Font.BOLD, 16));
	        label4.setBounds(30, 335, 68, 25);
	        contentPane.add(label4);

	        textField3 = new JTextField();
	        textField3.setBounds(87, 339, 205, 20);
	        contentPane.add(textField3);

	        JButton btnSearch = new JButton("SEARCH");
	        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 13));
	        btnSearch.setBounds(302, 337, 89, 23);
	        btnSearch.addActionListener(new ActionListener() {
            
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					 try {    
					    	String search = textField3.getText();
					    	String sql = "SELECT * FROM borrow WHERE StudentID = ? ;";
					    	model.setRowCount(0);
					    	preparedStatement = connection.prepareStatement(sql);
					        preparedStatement.setString(1, search);
					         resultset = preparedStatement.executeQuery();
					        while(resultset.next()) {
					        	String studentID = resultset.getString("StudentID");
					        	String bookID = resultset.getString("BookID");
					        	String borrow = resultset.getString("BorrowDate");
					        	String returned = resultset.getString("ReturnDate");
					        	String fine = resultset.getString("Fine");
					        	model.addRow(new Object [] {studentID,bookID,borrow,returned,});
					        }
					    }
					        catch(SQLException e1) {
						    	e1.printStackTrace();
					        }
							}	
	        });
	        contentPane.add(btnSearch);

	        JButton buttonAdd = new JButton("Add");
	        buttonAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
	        buttonAdd.setBounds(30, 401, 100, 30);
	    
	            buttonAdd.addActionListener(new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    String studentID = textField1.getText();
	                    String bookID = textField2.getText();
	                    Date borrowDateInput = borrowDate.getDate();
	                    Date returnDateInput = returnDate.getDate();

	                    try {
	                        
	                        String checkQuery = "SELECT COUNT(*) FROM borrow WHERE StudentID = ? ;";
	                        preparedStatement = connection.prepareStatement(checkQuery);	
	                        preparedStatement.setString(1,studentID);
	                        ResultSet countset = preparedStatement.executeQuery();
	                        countset.next();
	                        int borrowedBooks =countset.getInt(1);
                         
	               
	                        if (borrowedBooks >= 3) {
	                            JOptionPane.showMessageDialog(null, "This student has already borrowed 3 books. Cannot borrow more.");
	                            return;
	                        }

	                       
	                        String sql = "INSERT INTO borrow (StudentID, BookID, BorrowDate, ReturnDate) VALUES (?, ?, ?, ?)";
	                        preparedStatement = connection.prepareStatement(sql);
	                        Timestamp borrowDatetem = new Timestamp(borrowDateInput.getTime());
	                        Timestamp returnDatetem = new Timestamp(returnDateInput.getTime());

	                        preparedStatement.setString(1, studentID);
	                        preparedStatement.setString(2, bookID);
	                        preparedStatement.setTimestamp(3, borrowDatetem);
	                        preparedStatement.setTimestamp(4, returnDatetem);
	                        preparedStatement.executeUpdate();
	                        JOptionPane.showMessageDialog(null, "Record added successfully!");
	                        model.addRow(new Object[]{studentID, bookID, borrowDatetem, returnDatetem});
	                    } catch (SQLException ex) {
	                        ex.printStackTrace();
	                        JOptionPane.showMessageDialog(null, "ERROR: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                    }
	                }
	            });

	        contentPane.add(buttonAdd);

	        
	     
	       
	        JButton buttonUpdate = new JButton("Update");
	        buttonUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
	        buttonUpdate.setBounds(150, 401, 100, 30);
	        buttonUpdate.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				      	// TODO Auto-generated method stub
					int selectedRow = table.getSelectedRow();
					// TODO Auto-generated method stub
				if(selectedRow != -1) {
				 int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to update","Confirm",JOptionPane.YES_NO_OPTION);
					if(confirm == JOptionPane.YES_OPTION) {
					
					String studentID= textField1.getText();
				    String bookID = textField2.getText();
				    Date borrow = borrowDate.getDate();
			        Date returned = returnDate.getDate();
				    String updateQuery = "UPDATE borrow SET StudentID = ?, BookID = ? ,BorrowDate = ? ,ReturnDate = ? WHERE StudentID = ? AND BookID = ? ;";
				    
				    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		            String borrowDate = format.format(borrow);
		            String returnDate = format.format(returned);
				    try {
						preparedStatement = connection.prepareStatement(updateQuery);
						preparedStatement.setString(1, studentID);
						preparedStatement.setString(2, bookID);
						preparedStatement.setString(3, borrowDate);
						preparedStatement.setString(4, returnDate);
						preparedStatement.setString(5, model.getValueAt(selectedRow,0).toString());
						preparedStatement.setString(6, model.getValueAt(selectedRow,1).toString());
					    preparedStatement.executeUpdate();
					    JOptionPane.showMessageDialog(null, "Update SuccessFul");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    model.setValueAt(studentID, selectedRow, 0);
				    model.setValueAt(bookID, selectedRow, 1);
					model.setValueAt(borrowDate, selectedRow, 2);
					model.setValueAt(returnDate, selectedRow, 3);
					    
					}else {
						JOptionPane.showMessageDialog(null, "Update not SuccessFul");
					}
				}else {
					JOptionPane.showMessageDialog(null, "You haven't choose row","Error",JOptionPane.ERROR_MESSAGE);
				}
				}		
	        });
	        contentPane.add(buttonUpdate);
	        
	        JButton buttonReturned = new JButton("Returned ");
	        buttonReturned.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int selectedRow = table.getSelectedRow();
					  
				    if(selectedRow != -1) {
				    	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure want to Delete","Confirm",JOptionPane.YES_NO_OPTION);
	      			    	if(confirm == JOptionPane.YES_OPTION ) {
	      			    	  try {
	      						String studentID = model.getValueAt(selectedRow, 0).toString();        	 
	      						String deleteQuery = "DELETE FROM borrow WHERE StudentID = ? ;";
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
	    
	        buttonReturned.setFont(new Font("Tahoma", Font.BOLD, 16));
	        buttonReturned.setBounds(20, 459, 120, 30);
	       
	        contentPane.add(buttonReturned);
	        
	        JButton buttonCancel = new JButton("Cancel");
	        buttonCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
	        buttonCancel.setBounds(150, 459, 100, 30);
	        buttonCancel.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	 LibraryManageMenet library = new  LibraryManageMenet();
	            library.setVisible(true);
	            dispose();
	        }
	    });
	        contentPane.add(buttonCancel);
	        JButton buttonreset = new JButton("RESET");
	        buttonreset.setFont(new Font("Tahoma", Font.BOLD, 13));
	        buttonreset.setBounds(302, 371, 89, 23);
	        buttonreset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					model.setRowCount(0);
					try {
						String sql ="SELECT * FROM borrow;";
						statement = connection.createStatement();
				        resultset = statement.executeQuery(sql);
				        while(resultset.next()) {
				        	String studentID = resultset.getString("StudentID");
				        	String bookID = resultset.getString("BookID");
				        	Date borrowDate = resultset.getDate( "BorrowDate");
				        	Date returnDate = resultset.getDate("ReturnDate");
				        	Double fine = resultset.getDouble("Fine");
				        	model.addRow(new Object[]{studentID,bookID,borrowDate,returnDate,fine});
				        	
				        }
					}catch(SQLException e4) {
						e4.printStackTrace();
					}
		    	
				
				}
	        	
	        });
	        contentPane.add(buttonreset);
	        

	        listSelectionModel();
		setContentPane(contentPane);
	}
	protected void loadDataFromDatabase() {
		// TODO Auto-generated method stub
		
	}

}

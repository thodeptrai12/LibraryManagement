package cuoiky;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import cuoiky.Book;

import cuoiky.Borrow;
import cuoiky.Student;


public class LibraryManageMenet extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		LibraryManageMenet frame = new LibraryManageMenet();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	public LibraryManageMenet() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setBounds(100, 100, 445, 605);
	    contentPane = new JPanel();
	    setContentPane(contentPane);
	    contentPane.setLayout(null);

	    JPanel panel = new JPanel();
	    panel.setBounds(452, 96, 0, 0);
	    contentPane.add(panel);
	    panel.setLayout(null);

	    JPanel mainPanel = new JPanel();
	    mainPanel.setBounds(10, 22, 411, 539);
	    contentPane.add(mainPanel);
	    mainPanel.setLayout(null);

	    JButton btnBookManagement = new JButton("BOOK");
	    btnBookManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnBookManagement.setBounds(117, 74, 176, 77);
	    btnBookManagement.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Book bookFrame = new Book();
	            bookFrame.setVisible(true);
	            dispose();
	        }
	    });
	    mainPanel.add(btnBookManagement);

	    JButton btnStudentManagement = new JButton("STUDENT");
	    btnStudentManagement.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnStudentManagement.setBounds(117, 186, 176, 77);
	    btnStudentManagement.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Student studentFrame = new Student();
	            studentFrame.setVisible(true);
	            dispose();
	        }
	    });
	    mainPanel.add(btnStudentManagement);

	    JButton btnBorrowBook = new JButton("BORROW BOOK");
	    btnBorrowBook.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnBorrowBook.setBounds(117, 298, 176, 77);
	    btnBorrowBook.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            Borrow borrowFrame = new Borrow();
	            borrowFrame.setVisible(true);
	            dispose();
	        }
	    });
	    mainPanel.add(btnBorrowBook);

	    JButton btnLogout = new JButton("LOG OUT");
	    btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
	    btnLogout.setBounds(117, 416, 176, 77);
	    btnLogout.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            dispose();
	        }
	    });
	    mainPanel.add(btnLogout);

	    JLabel lblLibraryManagement = new JLabel("LIBRARY MANAGEMENT");
	    lblLibraryManagement.setFont(new Font("Arial", Font.BOLD, 31));
	    lblLibraryManagement.setBounds(20, -21, 417, 110);
	    mainPanel.add(lblLibraryManagement);
	}
}

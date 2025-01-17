import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quanlysinhvien extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public quanlysinhvien() {
        setTitle("Student Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table setup
        String []columns = { "ID","Name","GPA"};
        tableModel = new DefaultTableModel(columns,0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddDialog();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String id = (String) tableModel.getValueAt(selectedRow, 0);
                    String name = (String) tableModel.getValueAt(selectedRow, 1);
                    String gpa = (String) tableModel.getValueAt(selectedRow, 2);
                    showEditDialog(selectedRow, id, name, gpa);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to edit.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Layout setup
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void showAddDialog() {
        JDialog dialog = new JDialog(this, "Add Student", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));
        dialog.setLocationRelativeTo(this);

        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField gpaField = new JTextField();

        dialog.add(new JLabel("ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("GPA:"));
        dialog.add(gpaField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String gpa = gpaField.getText().trim();
                if (!id.isEmpty() && !name.isEmpty() && !gpa.isEmpty()) {
                    tableModel.addRow(new Object[]{id, name, gpa});
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(okButton);
        dialog.add(cancelButton);
        dialog.setVisible(true);
    }

    private void showEditDialog(int rowIndex, String id, String name, String gpa) {
        JDialog dialog = new JDialog(this, "Edit Student", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(4, 2, 10, 10));
        dialog.setLocationRelativeTo(this);

        JTextField idField = new JTextField(id);
        JTextField nameField = new JTextField(name);
        JTextField gpaField = new JTextField(gpa);

        dialog.add(new JLabel("ID:"));
        dialog.add(idField);
        dialog.add(new JLabel("Name:"));
        dialog.add(nameField);
        dialog.add(new JLabel("GPA:"));
        dialog.add(gpaField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newId = idField.getText().trim();
                String newName = nameField.getText().trim();
                String newGpa = gpaField.getText().trim();
                if (!newId.isEmpty() && !newName.isEmpty() && !newGpa.isEmpty()) {
                    tableModel.setValueAt(newId, rowIndex, 0);
                    tableModel.setValueAt(newName, rowIndex, 1);
                    tableModel.setValueAt(newGpa, rowIndex, 2);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Please fill in all fields.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(okButton);
        dialog.add(cancelButton);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new quanlysinhvien().setVisible(true);
            }
        });
    }
}

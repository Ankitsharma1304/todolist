import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleToDoApp extends JFrame {
    private JTextField taskInput;
    private DefaultListModel<String> taskModel;
    private JList<String> taskList;
    private JButton addButton, deleteButton;

    public SimpleToDoApp() {
        setTitle("Simple To-Do App");
        setSize(350, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setLayout(new BorderLayout());

        // Top panel with input and add button
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskInput = new JTextField();
        addButton = new JButton("Add");
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Center task list
        taskModel = new DefaultListModel<>();
        taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel with delete button
        JPanel bottomPanel = new JPanel();
        deleteButton = new JButton("Delete");
        bottomPanel.add(deleteButton);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                taskInput.setText("");
            }
        });

        // Delete button action
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                taskModel.remove(index);
            } else {
                JOptionPane.showMessageDialog(this, "Select a task to delete.");
            }
        });

        // Press Enter to add task
        taskInput.addActionListener(e -> addButton.doClick());

        setVisible(true);
    }

    public static void main(String[] args) {
        // Run GUI on Event Dispatch Thread
        SwingUtilities.invokeLater(SimpleToDoApp::new);
    }
}

  

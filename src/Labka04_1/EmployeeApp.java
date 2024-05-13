package Labka04_1;
import javax.swing.*;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeApp extends JFrame {
    private DefaultListModel<String> model;
    private JList<String> list;
    private JTextField nameField, positionField, salaryField, filterField;
    private EmployeeList employeeList = new EmployeeList();

    public EmployeeApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        model = new DefaultListModel<>();
        list = new JList<>(model);
        add(new JScrollPane(list));

        // Форма для добавления и удаления сотрудников
        JPanel form = createFormPanel();
        add(form);

        // Панель для фильтрации
        JPanel filterPanel = createFilterPanel();
        add(filterPanel);

        setVisible(true);
    }

    private JPanel createFormPanel() {
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        nameField = new JTextField(20);
        positionField = new JTextField(20);
        salaryField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton removeButton = new JButton("Remove");

        addButton.addActionListener(e -> {
            try {
                double salary = Double.parseDouble(salaryField.getText());
                Employee emp = new Employee(nameField.getText(), positionField.getText(), salary);
                employeeList.addEmployee(emp);
                model.addElement(emp.toString());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid salary input!");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex != -1) {
                employeeList.removeEmployee(employeeList.getEmployees().get(selectedIndex));
                model.remove(selectedIndex);
            }
        });

        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Position:"));
        form.add(positionField);
        form.add(new JLabel("Salary:"));
        form.add(salaryField);
        form.add(addButton);
        form.add(removeButton);
        return form;
    }

    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel();
        filterField = new JTextField(20);
        JButton filterButton = new JButton("Filter");

        filterButton.addActionListener(e -> {
            double salaryThreshold;
            try {
                salaryThreshold = Double.parseDouble(filterField.getText());
                List<Employee> filteredList = employeeList.getEmployees().stream()
                        .filter(emp -> emp.getSalary() > salaryThreshold)
                        .collect(Collectors.toList());
                model.clear();
                filteredList.forEach(emp -> model.addElement(emp.toString()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid salary threshold!");
            }
        });

        filterPanel.add(new JLabel("Filter salary greater than:"));
        filterPanel.add(filterField);
        filterPanel.add(filterButton);
        return filterPanel;
    }

    public static void main(String[] args) {
        new EmployeeApp();
    }
}





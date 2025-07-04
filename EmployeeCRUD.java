import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Database App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            
            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next(); // clear invalid input
            }
            choice = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            switch (choice) {
                case 1: addEmployee(sc); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(sc); break;
                case 4: deleteEmployee(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close(); // close only once here
    }

    static void addEmployee(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            String sql = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.executeUpdate();
            System.out.println("Employee added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewEmployees() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.printf("%-5s %-20s %-20s %-10s%n", "ID", "Name", "Designation", "Salary");
            System.out.println("-------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-20s %-10.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("designation"),
                        rs.getDouble("salary"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void updateEmployee(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();
            System.out.print("Enter New Designation: ");
            String designation = sc.nextLine();
            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // consume newline

            String sql = "UPDATE employees SET name=?, designation=?, salary=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, designation);
            ps.setDouble(3, salary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee updated!" : "Employee not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteEmployee(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Employee ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            String sql = "DELETE FROM employees WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee deleted!" : "Employee not found!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

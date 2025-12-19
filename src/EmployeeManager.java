import java.io.FileWriter;
import java.util.Scanner;
import java.nio.file.Paths;
import java.util.Formatter;
public class EmployeeManager {
    Scanner reader = null;
    Formatter f = null;
    FileWriter fw = null;

    private Employee[] employees;
    private int count;

    public EmployeeManager(int size){
        employees = new Employee[size];
        count = 0;
    }

    public void loadEmployeesFromFile(String filePath){
        try {
            reader = new Scanner(Paths.get("q3.txt"));
            while (reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(",");

                String name = parts[0].trim();
                String department = parts[1].trim();
                String email = parts[2].trim();

                employees[count++] = new Employee(name,department,email);
            }
        }catch (Exception e){
            System.out.println("Something went wrong.");
        }finally {
            if (reader != null){
                reader.close();
            }
        }
    }

    public void displayEmployees(){
        for (int i=0; i<count; i++){
            System.out.println(employees[i]);
        }
    }

    public void addEmployee(String name, String department, String email){
        Employee e1 = new Employee(name,department,email);
        employees[count++] = e1;

        try {
            fw = new FileWriter("q3.txt",true);
            f = new Formatter(fw);
            f.format("%s, %s, %s\n", name, department, email);
        }catch (Exception e){
            System.out.println("Something went wrong.");
        }finally {
            if (f != null){
                f.close();
            }
        }
    }

    public void searchEmployee(String name){
        boolean found = false;
        for (int i=0; i<count; i++){
            if (employees[i].getName().equalsIgnoreCase(name)){
                System.out.println(employees[i]);
                found = true;
                break;
            }
        }
        if (!found){
            System.out.println("Employee not found.");
        }
    }
}

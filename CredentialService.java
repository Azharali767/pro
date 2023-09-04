package firstjava;
import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;



class Employee {
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;

    public Employee(String firstName, String lastName, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = generateEmailAddress();
        this.password = generatePassword();
    }

    private String generateEmailAddress() {
        String domain = "abc.com";
        String email = firstName.toLowerCase() + lastName.toLowerCase() + "@" + department.toLowerCase() + "." + domain;
        return email;
    }

    private String generatePassword() {
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_+=<>?";

        String allCharacters = uppercase + lowercase + numbers + specialChars;

        StringBuilder password = new StringBuilder();
        Random rand = new Random();

    
        password.append(uppercase.charAt(rand.nextInt(uppercase.length())));
        password.append(lowercase.charAt(rand.nextInt(lowercase.length())));
        password.append(numbers.charAt(rand.nextInt(numbers.length())));
        password.append(specialChars.charAt(rand.nextInt(specialChars.length())));

    
        for (int i = 4; i < 8; i++) {
            password.append(allCharacters.charAt(rand.nextInt(allCharacters.length())));
        }

        return password.toString();
    }

    public void showCredentials() {
        System.out.println("Dear " + firstName + " " + lastName + ", your generated credentials are as follows: ");
        System.out.println("Employee Name: " + firstName + " " + lastName);
        System.out.println("Department: " + department);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }
}

class CredentialService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the employee's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the employee's last name: ");
        String lastName = scanner.nextLine();

       // System.out.println("Enter the department :");
       // String department = scanner.nextLine();

        System.out.println("Choose the employee's department: \n 1.TECHNICAL \n 2.ADMIN \n 3.HUMAN RESOURCE \n 4.Legal");
       
        int departmentChoice = scanner.nextInt();

       String department;
        switch (departmentChoice) {
            case 1:System.out.println(" Technical ");
                department = "tech";
                break;
            case 2:System.out.println(" Admin ");
                department= "AD";
                break;
            case 3: System.out.println(" Human resource ");
                department = "HR";
                break;
            case 4: System.out.println(" Legal ");
                department = "lg";
                break;
            default:
                System.out.println("Invalid department choice");
                scanner.close();
                return;
        }

        Employee newEmployee = new Employee(firstName, lastName, department);
        newEmployee.showCredentials();

        scanner.close();
    }
}

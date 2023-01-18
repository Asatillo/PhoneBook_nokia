import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        PhoneBook phonebook = new PhoneBook("^\\d{3}-\\d{3}-\\d{4}$");
        Scanner scanner = new Scanner(System.in);
        String name, number;
        boolean flag = true;
        while(flag){
            System.out.println("1. Add item\n" +
                    "2. Remove item\n" +
                    "3. Find by number\n" +
                    "4. Find by name\n" +
                    "5. End\n" +
                    "Enter your choice: ");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option){
                case 1:
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    number = scanner.nextLine();
                    try{
                        phonebook.add(name, number);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter name:");
                    name = scanner.nextLine();
                    System.out.println("Enter phone number: ");
                    number = scanner.nextLine();
                    try{
                        phonebook.delete(name, number);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Enter phone number: ");
                    number = scanner.nextLine();
                    try{
                        System.out.println(phonebook.searchByNumber(number));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter the name:");
                    name = scanner.nextLine();
                    try{
                        System.out.println(phonebook.searchBySubscriber(name));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Choose number between 1-5!!!");
                    break;
            }
        }
        scanner.close();
    }
}

import java.util.Scanner;

public class main3Class {
    public static void main(String[] args) {
        modelMenu model = new modelMenu();
        viewMenu view = new viewMenu();
        model.insertStaticData();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Menu Management ===");
            System.out.println("1. Create Menu");
            System.out.println("2. Read All Menus");
            System.out.println("3. Read Menu By ID");
            System.out.println("4. Update Menu");
            System.out.println("5. Delete Menu");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    view.tambahMenu();
                    break;
                case 2:
                    view.tampilSemuaMenu();
                    break;
                case 3:
                    view.tampilMenuById();
                    break;
                case 4:
                    view.updateMenu();
                    break;
                case 5:
                    System.out.print("Masukkan ID menu yang ingin dihapus: ");
                    int id = scanner.nextInt();
                    view.hapusMenu(id);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
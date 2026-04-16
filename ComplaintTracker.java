import java.util.*;
class Complaint {
    int id;
    String name;
    String complaint;
    String status;
    Complaint(int id, String name, String complaint, String status) {
        this.id = id;
        this.name = name;
        this.complaint = complaint;
        this.status = status;
    }
}
public class ComplaintTracker {
    static ArrayList<Complaint> list = new ArrayList<>();
    static int idCounter = 1;
    static void addComplaint(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Complaint: ");
        String comp = sc.nextLine();
        list.add(new Complaint(idCounter++, name, comp, "Pending"));
        System.out.println(" Complaint Added!");
    }
    static void viewComplaints() {
        if (list.isEmpty()) {
            System.out.println("No complaints found!");
            return;
        }
        System.out.println("\nID | Name | Complaint | Status");
        System.out.println("--------------------------------");
        for (Complaint c : list) {
            System.out.println(c.id + " | " + c.name + " | " + c.complaint + " | " + c.status);
        }
    }
    static void updateStatus(Scanner sc) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Complaint c : list) {
            if (c.id == id) {
                System.out.print("Enter New Status: ");
                c.status = sc.nextLine();
                System.out.println(" Status Updated!");
                return;
            }
        }
        System.out.println(" Complaint not found!");
    }
    static void deleteComplaint(Scanner sc) {
        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        Iterator<Complaint> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().id == id) {
                it.remove();
                System.out.println(" Complaint Deleted!");
                return;
            }
        }
        System.out.println(" Complaint not found!");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Public Complaint Tracker =====");
            System.out.println("1. Add Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Update Status");
            System.out.println("4. Delete Complaint");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    addComplaint(sc);
                    break;
                case 2:
                    viewComplaints();
                    break;
                case 3:
                    updateStatus(sc);
                    break;
                case 4:
                    deleteComplaint(sc);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
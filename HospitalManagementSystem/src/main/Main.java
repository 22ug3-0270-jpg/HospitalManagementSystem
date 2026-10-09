1package main;

import bst.PatientBST;
import queue.EmergencyQueue;
import stack.TreatmentStack;
import linkedlist.VisitLinkedList;
import model.Patient;
import model.Treatment;
import model.Visit;

import java.util.Scanner;

public class Main {

    static PatientBST patientBST = new PatientBST();
    static EmergencyQueue emergencyQueue = new EmergencyQueue();
    static TreatmentStack treatmentStack = new TreatmentStack();
    static VisitLinkedList visitList = new VisitLinkedList();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        patientBST.insert(new Patient(101, "Kamal Perera", 35, "0771234567", "Fever"));
        patientBST.insert(new Patient(102, "Nimal Silva", 45, "0712345678", "Diabetes"));
        patientBST.insert(new Patient(103, "Saman Kumara", 28, "0765432109", "Fracture"));
        patientBST.insert(new Patient(104, "Amali Fernando", 52, "0755555555", "Hypertension"));

        int choice;
        do {
            System.out.println("\n===== Hospital Management System =====");
            System.out.println("1. Patient Records (BST)");
            System.out.println("2. Emergency Queue");
            System.out.println("3. Treatment History (Stack)");
            System.out.println("4. Patient Visit History (Linked List)");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> emergencyMenu();
                case 3 -> treatmentMenu();
                case 4 -> visitMenu();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void patientMenu() {
        int choice;
        do {
            System.out.println("\n--- Patient Records (BST) ---");
            System.out.println("1. Insert Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Display All (In-order)");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Patient ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Medical Condition: ");
                    String condition = scanner.nextLine();
                    patientBST.insert(new Patient(id, name, age, contact, condition));
                    System.out.println("Patient inserted.");
                }
                case 2 -> {
                    System.out.print("Enter Patient ID to search: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    Patient p = patientBST.search(id);
                    if (p != null) System.out.println("Found: " + p);
                    else System.out.println("Patient not found.");
                }
                case 3 -> {
                    System.out.print("Enter Patient ID to delete: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    patientBST.delete(id);
                    System.out.println("Delete operation completed.");
                }
                case 4 -> patientBST.inOrder();
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void emergencyMenu() {
        int choice;
        do {
            System.out.println("\n--- Emergency Queue ---");
            System.out.println("1. Enqueue Patient");
            System.out.println("2. Dequeue Patient");
            System.out.println("3. Display Queue");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Patient ID: ");
                    int id = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Age: ");
                    int age = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Condition: ");
                    String condition = scanner.nextLine();
                    emergencyQueue.enqueue(new Patient(id, name, age, contact, condition));
                }
                case 2 -> emergencyQueue.dequeue();
                case 3 -> emergencyQueue.display();
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void treatmentMenu() {
        int choice;
        do {
            System.out.println("\n--- Treatment History (Stack) ---");
            System.out.println("1. Push Treatment");
            System.out.println("2. Pop Treatment");
            System.out.println("3. Display All");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Treatment ID: ");
                    int tid = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Patient ID: ");
                    int pid = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Patient Name: ");
                    String pname = scanner.nextLine();
                    System.out.print("Treatment Details: ");
                    String details = scanner.nextLine();
                    System.out.print("Completed Date: ");
                    String date = scanner.nextLine();
                    treatmentStack.push(new Treatment(tid, pid, pname, details, date));
                }
                case 2 -> treatmentStack.pop();
                case 3 -> treatmentStack.display();
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    static void visitMenu() {
        int choice;
        do {
            System.out.println("\n--- Patient Visit History (Linked List) ---");
            System.out.println("1. Add Visit");
            System.out.println("2. Remove Visit");
            System.out.println("3. Search Visit");
            System.out.println("4. Display All Visits");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Visit ID: ");
                    int vid = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Visit Date: ");
                    String date = scanner.nextLine();
                    System.out.print("Doctor Name: ");
                    String doctor = scanner.nextLine();
                    System.out.print("Diagnosis: ");
                    String diagnosis = scanner.nextLine();
                    System.out.print("Treatment: ");
                    String treatment = scanner.nextLine();
                    visitList.addVisit(new Visit(vid, date, doctor, diagnosis, treatment));
                }
                case 2 -> {
                    System.out.print("Enter Visit ID to remove: ");
                    int vid = scanner.nextInt(); scanner.nextLine();
                    visitList.removeVisit(vid);
                }
                case 3 -> {
                    System.out.print("Enter Visit ID to search: ");
                    int vid = scanner.nextInt(); scanner.nextLine();
                    Visit v = visitList.searchVisit(vid);
                    if (v != null) System.out.println("Found: " + v);
                    else System.out.println("Visit not found.");
                }
                case 4 -> visitList.display();
                case 0 -> System.out.println("Returning...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}
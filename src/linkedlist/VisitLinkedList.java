package linkedlist;

import model.Visit;

public class VisitLinkedList {

    class Node {
        Visit visit;
        Node next;

        Node(Visit visit) {
            this.visit = visit;
            next = null;
        }
    }

    private Node head;

    public VisitLinkedList() {
        head = null;
    }

    public void addVisit(Visit visit) {
        Node newNode = new Node(visit);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Visit added: " + visit.getVisitId());
    }

    public void removeVisit(int visitId) {
        if (head == null) {
            System.out.println("No visits to remove.");
            return;
        }
        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            System.out.println("Visit " + visitId + " removed.");
            return;
        }
        Node current = head;
        while (current.next != null && current.next.visit.getVisitId() != visitId) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Visit ID " + visitId + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Visit " + visitId + " removed.");
        }
    }

    public Visit searchVisit(int visitId) {
        Node current = head;
        while (current != null) {
            if (current.visit.getVisitId() == visitId) {
                return current.visit;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No visit history.");
            return;
        }
        System.out.println("--- Visit History ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.visit);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
}
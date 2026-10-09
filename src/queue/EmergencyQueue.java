package queue;

import model.Patient;

public class EmergencyQueue {

    class Node {
        Patient patient;
        Node next;

        Node(Patient patient) {
            this.patient = patient;
            next = null;
        }
    }

    private Node front, rear;
    private int size;

    public EmergencyQueue() {
        front = rear = null;
        size = 0;
    }

    public void enqueue(Patient patient) {
        Node newNode = new Node(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Patient " + patient.getName() + " added to emergency queue.");
    }

    public Patient dequeue() {
        if (front == null) {
            System.out.println("Emergency queue is empty!");
            return null;
        }
        Patient patient = front.patient;
        front = front.next;
        if (front == null) rear = null;
        size--;
        System.out.println("Treating patient: " + patient.getName());
        return patient;
    }

    public void display() {
        if (front == null) {
            System.out.println("Emergency queue is empty.");
            return;
        }
        System.out.println("--- Emergency Queue ---");
        Node current = front;
        int pos = 1;
        while (current != null) {
            System.out.println(pos + ". " + current.patient);
            current = current.next;
            pos++;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }
}
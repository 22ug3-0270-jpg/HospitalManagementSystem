package bst;

import model.Patient;

public class PatientBST {

    class Node {
        Patient patient;
        Node left, right;

        Node(Patient patient) {
            this.patient = patient;
            left = right = null;
        }
    }

    private Node root;

    public PatientBST() {
        root = null;
    }

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private Node insertRec(Node root, Patient patient) {
        if (root == null) {
            root = new Node(patient);
            return root;
        }
        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        } else {
            System.out.println("Patient with ID " + patient.getPatientId() + " already exists!");
        }
        return root;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(Node root, int patientId) {
        if (root == null) return null;
        if (root.patient.getPatientId() == patientId) return root.patient;
        if (patientId < root.patient.getPatientId()) return searchRec(root.left, patientId);
        return searchRec(root.right, patientId);
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private Node deleteRec(Node root, int patientId) {
        if (root == null) return null;

        if (patientId < root.patient.getPatientId()) {
            root.left = deleteRec(root.left, patientId);
        } else if (patientId > root.patient.getPatientId()) {
            root.right = deleteRec(root.right, patientId);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            root.patient = minValue(root.right);
            root.right = deleteRec(root.right, root.patient.getPatientId());
        }
        return root;
    }

    private Patient minValue(Node root) {
        Patient min = root.patient;
        while (root.left != null) {
            min = root.left.patient;
            root = root.left;
        }
        return min;
    }

    public void inOrder() {
        if (root == null) {
            System.out.println("No patients in the system.");
            return;
        }
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }
}
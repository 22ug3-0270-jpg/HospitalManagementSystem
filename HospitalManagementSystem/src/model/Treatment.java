package model;

public class Treatment {
    private int treatmentId;
    private int patientId;
    private String patientName;
    private String treatmentDetails;
    private String completedDate;

    public Treatment(int treatmentId, int patientId, String patientName,
                     String treatmentDetails, String completedDate) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.completedDate = completedDate;
    }

    public int getTreatmentId() { return treatmentId; }
    public int getPatientId() { return patientId; }
    public String getPatientName() { return patientName; }
    public String getTreatmentDetails() { return treatmentDetails; }
    public String getCompletedDate() { return completedDate; }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId +
                " | Patient ID: " + patientId +
                " | Patient: " + patientName +
                " | Details: " + treatmentDetails +
                " | Date: " + completedDate;
    }
}
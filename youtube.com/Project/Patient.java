import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
    private int patientID;
    private String name;
    private int age;
    private String gender;
    private String contactDetails;
    private String medicalHistory;

    public Patient(String name, int age, String gender, String contactDetails, String medicalHistory) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactDetails = contactDetails;
        this.medicalHistory = medicalHistory;
    }

    public void addPatient(Connection conn) throws SQLException {
        String query = "INSERT INTO patients (name, age, gender, contact_details, medical_history) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, this.name);
        ps.setInt(2, this.age);
        ps.setString(3, this.gender);
        ps.setString(4, this.contactDetails);
        ps.setString(5, this.medicalHistory);
        ps.executeUpdate();
        System.out.println("Patient added successfully.");
    }

    public static ResultSet getPatientDetails(Connection conn, int patientID) throws SQLException {
        String query = "SELECT * FROM patients WHERE patient_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, patientID);
        return ps.executeQuery();
    }
}

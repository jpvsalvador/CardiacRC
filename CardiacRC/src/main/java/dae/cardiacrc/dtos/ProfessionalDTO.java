package dae.cardiacrc.dtos;

import java.util.ArrayList;
import java.util.List;

public class ProfessionalDTO {
    private String username;
    private String password;
    private String name;
    private String email;
    private int licenseNumber;
    private List<PrescriptionDTO> activePrescriptionDTOs;
    private List<PrescriptionDTO> inactivePrescriptionDTOs;
    private List<PatientDTO> patientDTOS;

    public ProfessionalDTO() {
        this.activePrescriptionDTOs = new ArrayList<PrescriptionDTO>();
        this.inactivePrescriptionDTOs = new ArrayList<PrescriptionDTO>();
        this.patientDTOS = new ArrayList<PatientDTO>();
    }

    public ProfessionalDTO(String username, String password, String name, String email, int licenseNumber) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.licenseNumber = licenseNumber;
        this.activePrescriptionDTOs = new ArrayList<PrescriptionDTO>();
        this.inactivePrescriptionDTOs = new ArrayList<PrescriptionDTO>();
        this.patientDTOS = new ArrayList<PatientDTO>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public List<PrescriptionDTO> getActivePrescriptionDTOs() {
        return activePrescriptionDTOs;
    }

    public List<PrescriptionDTO> getInactivePrescriptionDTOs() {
        return inactivePrescriptionDTOs;
    }

    public List<PatientDTO> getPatientDTOs() {
        return patientDTOS;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setActivePrescriptionDTOs(List<PrescriptionDTO> prescriptionDTOs) {
        this.activePrescriptionDTOs = prescriptionDTOs;
    }

    public void setInactivePrescriptionDTOs(List<PrescriptionDTO> prescriptionDTOs) {
        this.inactivePrescriptionDTOs = prescriptionDTOs;
    }

    public void setPatientDTOs(List<PatientDTO> patientDTOS) {
        this.patientDTOS = patientDTOS;
    }
}

package dae.cardiacrc.entities;

import io.smallrye.common.constraint.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "getAllProfessionals",
                query = "SELECT p FROM Professional p ORDER BY p.name"
        )
})
@Table(name = "professionals")
public class Professional extends Person implements Serializable {
    @NotNull
    private int licenseNumber;

    @ManyToMany(mappedBy = "professionals")
    private List<Patient> patients;

    @OneToMany(mappedBy = "professional", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Prescription> prescriptions;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Program> programs;

    @NotNull
    @OneToOne
    private Type type;

    public Professional(String username, int licenseNumber, String name, String password, String email, Type type) {
        super(username, name, password, email);
        this.licenseNumber = licenseNumber;
        this.type = type;
        patients = new ArrayList<Patient>();
        prescriptions = new ArrayList<Prescription>();
        programs = new ArrayList<Program>();
    }

    public Professional() {
        patients = new ArrayList<Patient>();
        prescriptions = new ArrayList<Prescription>();
        programs = new ArrayList<Program>();
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(Patient patient) {
        if (this.patients.contains(patient)) {
            this.patients.remove(patient);
        }
    }

    public void addPrescription(Prescription prescription) {
        this.prescriptions.add(prescription);
    }

    public void removePrescription(Prescription prescription) {
        if (this.prescriptions.contains(prescription)) {
            this.prescriptions.remove(prescription);
        }
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void addProgram(Program program){
        if (program != null) {
            this.programs.add(program);
        }
    }

    public void removeProgram(Program program){
        if (programs.contains(program)) {
            this.programs.remove(program);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professional professional = (Professional) o;
        return getUsername() == professional.getUsername() && Objects.equals(getName(), professional.getName()) && Objects.equals(licenseNumber, professional.licenseNumber) && Objects.equals(patients, professional.patients) && Objects.equals(prescriptions, professional.prescriptions);
    }

}

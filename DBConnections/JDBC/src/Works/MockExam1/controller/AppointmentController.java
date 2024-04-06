package Works.MockExam1.controller;


import Works.MockExam1.entity.Appointment;
import Works.MockExam1.entity.Patient;
import Works.MockExam1.entity.Physician;
import Works.MockExam1.model.AppointmentModel;
import Works.MockExam1.model.PatientModel;
import Works.MockExam1.model.PhysicianModel;

import javax.swing.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class AppointmentController {

    public AppointmentModel instanceModel() {
        return new AppointmentModel();
    }

    public void add() {
        try {
            Date appointmentDate = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of the Appointment (YYYY-MM-DD)"));
            Time appointmentTime = Time.valueOf(JOptionPane.showInputDialog(null, "Enter the hour of the Appointment (HH:MM:SS)"));
            String reason = JOptionPane.showInputDialog(null, "Enter the reason of the Appointment");
            Object[] optionsPatient = new PatientModel().findAll().toArray();
            if (optionsPatient.length > 0) {
                Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                        null,
                        "Select a Patient:\n",
                        "Selecting a Patient",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        optionsPatient,
                        optionsPatient[0]);
                if (patientSelected == null) {
                    JOptionPane.showMessageDialog(null, "No option selected");
                } else {
                    Object[] optionsPhysician = new PhysicianModel().findAll().toArray();
                    if (optionsPhysician.length > 0) {
                        Physician physicianSelected = (Physician) JOptionPane.showInputDialog(
                                null,
                                "Select a Physician:\n",
                                "Selecting a Physician",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                optionsPhysician,
                                optionsPhysician[0]);
                        if (physicianSelected == null) {
                            JOptionPane.showMessageDialog(null, "No option selected");
                        } else {
                            instanceModel().insert(new Appointment(appointmentDate, appointmentTime, reason, patientSelected.getId(), physicianSelected.getId()));
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "There is no Physicians yet");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "There is no Patients yet");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error >> Not a valid format");
        }
    }

    public void update() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(
                    null,
                    "Select the Appointment that you want to update:\n",
                    "Updating an Appointment",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (appointmentSelected == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {
                try {
                    appointmentSelected.setAppointmentDate(Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of the Appointment (YYYY-MM-DD)", appointmentSelected.getAppointmentDate())));
                    appointmentSelected.setAppointmentTime(Time.valueOf(JOptionPane.showInputDialog(null, "Enter the hour of the Appointment (HH:MM:SS)", appointmentSelected.getAppointmentTime())));
                    appointmentSelected.setReason(JOptionPane.showInputDialog(null, "Enter the reason of the Appointment", appointmentSelected.getReason()));
                    Object[] optionsPatient = new PatientModel().findAll().toArray();
                    if (optionsPatient.length > 0) {
                        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                                null,
                                "Select the new Patient:\n",
                                "Selecting a Patient",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                optionsPatient,
                                optionsPatient[0]);
                        if (patientSelected == null) {
                            JOptionPane.showMessageDialog(null, "No option selected");
                        } else {
                            Object[] optionsPhysician = new PhysicianModel().findAll().toArray();
                            if (optionsPhysician.length > 0) {
                                Physician physicianSelected = (Physician) JOptionPane.showInputDialog(
                                        null,
                                        "Select the new Physician:\n",
                                        "Selecting a Physician",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        optionsPhysician,
                                        optionsPhysician[0]);
                                if (physicianSelected == null) {
                                    JOptionPane.showMessageDialog(null, "No option selected");
                                } else {
                                    appointmentSelected.setIdPatient(patientSelected.getId());
                                    appointmentSelected.setIdPhysician(physicianSelected.getId());
                                    if (instanceModel().update(appointmentSelected)) {
                                        JOptionPane.showMessageDialog(null, "Appointment Updated successfully");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Couldn't update the Appointment");
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "There is no Physicians yet");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "There is no Patients yet");
                    }


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error >> Not a valid format");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Appointments yet");
        }
    }

    public void delete() {
        Object[] options = instanceModel().findAll().toArray();
        if (options.length > 0) {
            Appointment selectedOption = (Appointment) JOptionPane.showInputDialog(
                    null,
                    "Select the Appointment that you want to delete:\n",
                    "Deleting an Appointment",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            if (selectedOption == null) {
                JOptionPane.showMessageDialog(null, "No option selected");
            } else {

                int confirm = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete this Appointment?");
                if (confirm == 0) {
                    if (instanceModel().delete(selectedOption.getId())) {
                        JOptionPane.showMessageDialog(null, "Appointment successfully deleted");
                    } else {
                        JOptionPane.showMessageDialog(null, "Couldn't delete the Appointment");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Appointment was deleted");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "There is no Appointments yet");
        }
    }

    public void getAll() {
        JOptionPane.showMessageDialog(null, this.getAll(instanceModel().findAll()));
    }

    public StringBuilder getAll(List<Object> objectsList) {
        StringBuilder list = new StringBuilder("                                                                           ==== Appointments List ====                                                                           \n");
        if (objectsList.isEmpty()) {
            list.append("No Appointments registered");
        } else {
            for (Object obj : objectsList) {
                Appointment objAppointment = (Appointment) obj;
                list.append(objAppointment.toString()).append("\n");
            }
        }
        return list;
    }

    public void getByDate() {
        StringBuilder list = new StringBuilder("                                                                           ==== Results List ====                                                                           \n");
        try {
            Date dateSearched = Date.valueOf(JOptionPane.showInputDialog(null, "Enter the Date of the Appointments you want to search for (YYYY-MM-DD)"));
            list.append("Filtered by Date: ").append(dateSearched).append("\n");
            list.append(getAll(instanceModel().findByDate(dateSearched)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error >> Not a valid format");
        }
        JOptionPane.showMessageDialog(null, list);
    }
}

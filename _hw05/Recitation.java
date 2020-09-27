//I worked on this homework alone, using only course materials
/**
* A recitation that a student is taking. Implements ClassPeriod interface
*@author Alex Saad-Falcon
*@version 1
*/

public class Recitation implements ClassPeriod {
    /** The grade in the recitation */
    private double grade;
    /** The number of hours the recitation is worth */
    private int hours;
    /** If the recitation is collaborative or not */
    private boolean isCollaborative;
    /** The recitation subject */
    private String subject;
    /** The recitation professor */
    private String professor;
    /** The recitation teaching assistant */
    private String teachingAssistant;

    //Constructors

    /**
    * Instantiates an object of Student with no-args
    * Sets parameters to default values
    */
    public Recitation() {
        this("None", "None", 0, "None", false);
    }

    /**
    * Instantiates an object of Recitation
    * @param professor The recitation professor
    * @param teachingAssistant The recitation teaching assistant
    * @param hours The number of hours the recitation is worth
    * @param subject The subject of the recitation
    * @param isCollaborative A boolean of if the recitation is collaborative
    */
    public Recitation(String professor, String teachingAssistant,
        int hours, String subject, boolean isCollaborative) {
        this.professor = professor;
        this.teachingAssistant = teachingAssistant;
        this.hours = hours;
        this.subject = subject;
        this.isCollaborative = isCollaborative;
        grade = 0;
    }

    //Other methods

    /**
    * Changes recitation grade to the new grade
    * if it is in the valid range (0-50)
    * @param newGrade The new grade for the recitation
    * @return A boolean of if the grade could be changed to new grade
    */
    public boolean setGrade(double newGrade) {
        if ((newGrade <= 50) && (newGrade >= 0)) {
            grade = Math.round(newGrade);
            return true;
        } else {
            System.out.println("Grade must be from 0 to 50.");
            return false;
        }
    }

    /**
    * Returns if the recitation is collaborative
    * @return Returns true if the reciation is collaborative
    */
    public boolean isRecitationCollaborative() {
        return isCollaborative;
    }

    /**
    * Output for when a recitation is printed
    * @return A String giving information about the recitation
    */
    public String toString() {
        String out = "Recitation for " + subject + " taught by " + professor
            + ". The Teaching Assistant is " + teachingAssistant
            + ". This recitation is " + hours
            + " hour(s) and your current grade is " + grade
            + ". The work in this recitation is ";
        if (isCollaborative) {
            out += "collaborative.";
        } else {
            out += "not collaborative.";
        }
        return out;
    }

    //Interface methods

    /**
    * Gets the subject of a Recitation
    * @return the subject
    */
    public String getSubject() {
        return subject;
    }
    /**
    * Gets the hours of a Recitation
    * @return the hours
    */
    public int getHours() {
        return hours;
    }
    /**
    * Gets the Student's grade for a Recitation
    * @return the grade
    */
    public double getGrade() {
        return grade;
    }
    /**
    * Gets the Professor for a Recitation
    * @return the professor's name
    */
    public String getProfessor() {
        return professor;
    }
    /**
    * Sets the professor for a Recitation
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
//I worked on this homework alone, using only course materials
/**
* A lecture that a student is taking. Implements ClassPeriod interface
*@author Alex Saad-Falcon
*@version 1
*/

public class Lecture implements ClassPeriod {
    /** The grade in the lecture */
    private double grade;
    /** The number of hours the lecture is worth */
    private int hours;
    /** A boolean of if the lecture is mandatory of not */
    private boolean isMandatory;
    /** The lecture subject */
    private String subject;
    /** The lecture professor */
    private String professor;


    //Constructors

    /**
    * Instantiates an object of Student with no-args
    * Sets parameters to default values
    */
    public Lecture() {
        this(0, "None", "None", false);
    }

    /**
    * Instantiates an object of Lecture
    * @param hours The number of hours the lecture is worth
    * @param subject The lecture subject
    * @param professor The lecture professor
    * @param isMandatory Boolean of if the Lecture is mandatory (true)
    */
    public Lecture(int hours, String subject,
        String professor, boolean isMandatory) {
        this.hours = hours;
        this.subject = subject;
        this.professor = professor;
        this.isMandatory = isMandatory;
        grade = 0;
    }

    //Other methods

    /**
    * Sets the grade of this lecture to newGrade
    * @param newGrade Grade to be set to
    * @return Returns true if grade is a valid new grade, false if not
    */
    public boolean setGrade(double newGrade) {
        if ((newGrade <= 100) && (newGrade >= 0)) {
            grade = Math.round(newGrade);
            return true;
        } else {
            System.out.println("Grade must be from 0 to 100.");
            return false;
        }
    }

    /**
    * Returns if the lecture is mandatory
    * @return Returns true if the lecture is mandatory
    */
    public boolean isLectureMandatory() {
        return isMandatory;
    }

    /**
    * Output for when a lecture is printed
    * @return A String giving information about the lecture
    */
    public String toString() {
        String out = subject + " taught by " + professor + ". It is a "
            + hours + " hour(s) course and you have received a "
            + grade + ". Lecture is ";
        if (isMandatory) {
            out += "MANDATORY.";
        } else {
            out += "NOT MANDATORY.";
        }
        return out;
    }

    //Interface methods

    /**
    * Gets the subject of a Lecture
    * @return the subject
    */
    public String getSubject() {
        return subject;
    }

    /**
    * Gets the hours of a Lecture
    * @return the hours
    */
    public int getHours() {
        return hours;
    }

    /**
    * Gets the Student's grade for a Lecture
    * @return the grade
    */
    public double getGrade() {
        return grade;
    }

    /**
    * Gets the Professor for a Lecture
    * @return the professor's name
    */
    public String getProfessor() {
        return professor;
    }

    /**
    * Sets the professor for a Lecture
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
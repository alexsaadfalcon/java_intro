//I worked on this homework with Mahalakshmi Srinivasan
/**
*  A lab that a student is taking.
*@author Alex Saad-Falcon
*@version 1
*/

public class Lab implements ClassPeriod {
    /** The class grade */
    private double grade;
    /** The class hour worth */
    private int hours;
    /** The number of grades currently inputted for the lab */
    private int numLabGrades;
    /** The number of safety rules currently inputted for the lab */
    private int numSafetyRules;
    /** A double array of the up to 10 lab grades in the lab */
    private double[] labGrades;
    /** The lab subject */
    private String subject;
    /** The lab professor */
    private String professor;
    /** The lab assistant */
    private String labAssistant;
    /** A String array of the safety rules currently inputted */
    private String[] safetyRules;

    //Constructors

    /**
    * Instantiates an object of Student with no-args
    * Sets parameters to default values
    */
    public Lab() {
        this("None", "None", 0, "None");
    }

    /**
    * Instantiates an object of Lab
    * @param professor The lab professor
    * @param labAssistant The lab assistant
    * @param hours The number of hours the lab is worth
    * @param subject The lab subject
    */
    public Lab(String professor, String labAssistant,
        int hours, String subject) {
        this.professor = professor;
        this.labAssistant = labAssistant;
        this.hours = hours;
        this.subject = subject;
        grade = 0;
        numLabGrades = 0;
        numSafetyRules = 0;
        labGrades = new double[10];
        safetyRules = new String[3];
    }

    //Other Methods
    /**
    * Adds a grade to the array of lab grades (up to 10)
    * @param newGrade the grade to add
    * @return true if grade could be added, false if not
    */
    public boolean addLab(double newGrade) {
        if ((numLabGrades < 10) && (newGrade <= 50) && (newGrade >= 0)) {
            labGrades[numLabGrades] = newGrade;
            numLabGrades++;
            calculateGrade();
            return true;
        } else if (numLabGrades >= 10) {
            System.out.println("There are already 10 lab grades.");
            return false;
        } else {
            System.out.println("The grade must be from 0 to 50.");
            return false;
        }
    }

    /**
    * Calculates the grade in the recitation. Private internal method
    */
    private void calculateGrade() {
        double sum = 0;
        for (int i = 0; i < numLabGrades; i++) {
            sum += labGrades[i];
        }
        grade = sum / 10;
    }

    /**
    * Adds a safety rule to the lab, returning if it could be done
    * @param rule The rule to add
    * @return true if the safety rule could be added
    */
    public boolean addSafetyRule(String rule) {
        if (numSafetyRules < 3) {
            safetyRules[numSafetyRules] = rule;
            numSafetyRules++;
            return true;
        } else {
            System.out.println("There are already 3 safety rules.");
            return false;
        }
    }

    /**
    * Output when a lab is printed
    * @return a String giving information about the lab
    */
    public String toString() {
        String out = "Lab for " + subject + " taught by " + professor
            + ". The Lab Assistant is " + labAssistant + ". This lab is "
            + hours + " hour(s) and your current grade is " + grade
            + ". The safety rules for this lab are: ";
        for (int i = 0; i < numSafetyRules; i++) {
            if (i > 0) {
                out += ", "; //to seperate rules after the first by ", "
            }
            out += (i + 1) + ") " + safetyRules[i];
        }
        out += "."; //ending period
        return out;
    }

    //Interface methods

    /**
    * Gets the subject of a Lab
    * @return the subject
    */
    public String getSubject() {
        return subject;
    }

    /**
    * Gets the hours of a Lab
    * @return the hours
    */
    public int getHours() {
        return hours;
    }

    /**
    * Gets the Student's grade for a Lab
    * @return the grade
    */
    public double getGrade() {
        return grade;
    }

    /**
    * Gets the Professor for a Lab
    * @return the professor's name
    */
    public String getProfessor() {
        return professor;
    }

    /**
    * Sets the professor for a Lab
    * @param professor the professor's name
    */
    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
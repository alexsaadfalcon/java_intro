/**
* An interface describing the functionality of all ClassPeriods
* @author Angie Palm + Ethan Shernan
* @version 42
*/

public interface ClassPeriod {

    /**
    * Gets the subject of a ClassPeriod
    * @return the subject
    */
    String getSubject();

    /**
    * Gets the hours of a ClassPeriod
    * @return the hours
    */
    int getHours();

    /**
    * Gets the Student's grade for a ClassPeriod
    * @return the grade
    */
    double getGrade();

    /**
    * Gets the Professor for a ClassPeriod
    * @return the professor's name
    */
    String getProfessor();

    /**
    * Sets the professor for a ClassPeriod
    * @param professor the professor's name
    */
    void setProfessor(String professor);
}
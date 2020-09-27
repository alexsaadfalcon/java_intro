//I worked on this homework with Mahalakshmi Srinivasan
/**
* A class to model a student.
* A student can take lectures, recitations, and labs.
*@author Alex Saad-Falcon
*@version 1
*/

public class Student {
    /** The number of hours the Student is taking */
    private int totalHours;
    /** The number of classes the Student is taking */
    private int numClasses;
    /** The number of lectures the Student is taking */
    private int numLectures;
    /** The number of labs the Student is taking */
    private int numLabs;
    /** The number of recitations the Student is taking */
    private int numRecitations;
    /** The Student's name */
    private String name;
    /** The Student's school year */
    private String year;
    /** An array of the classes the Student is taking */
    private ClassPeriod[] classes;

    // Constructors

    /**
    * Instantiates an object of Student with no-args
    * Sets parameters to default values
    */
    public Student() {
        this("George P. Burdell", "Senior");
    }

    /**
    * Instantiates an object of Recitation
    * @param name The Student's name
    * @param year The Student's year as a String
    */
    public Student(String name, String year) {
        this.name = name;
        this.year = year;
        totalHours = 0;
        numClasses = 0;
        classes = new ClassPeriod[10];
        numLectures = 0;
        numLabs = 0;
        numRecitations = 0;
    }

    //Other Methods

    /**
    * Adds a new class (in the form of a ClassPeriod) to the Student's classes
    * @param newClass The class to add
    * @return true if the class could be added, false otherwise
    */
    public boolean addClass(ClassPeriod newClass) {
        if ((totalHours + newClass.getHours()) <= 21) {
            if (numClasses < classes.length) {
                classes[numClasses] = newClass;
                numClasses++;
            } else {
                ClassPeriod[] newClasses = new ClassPeriod[2 * classes.length];
                for (int i = 0; i < classes.length; i++) {
                    newClasses[i] = classes[i];
                }
                classes = newClasses; //expands size of classes array
                classes[numClasses] = newClass;
                numClasses++;
            }
            calculateHours();
            if (newClass instanceof Lecture) {
                numLectures++;
            } else if (newClass instanceof Lab) {
                numLabs++;
            } else if (newClass instanceof Recitation) {
                numRecitations++;
            }
            return true;
        } else {
            System.out.println("The class takes you over your 21 hour limit.");
            return false;
        }
    }

    /**
    * Output for when a Student is printed
    * @return A String giving information about the Student
    */
    public String toString() {
        return name + " is taking " + totalHours + " hour(s) as a "
            + year + ".";
    }

    /**
    * Calculates the number of hours the Student is taking
    */
    private void calculateHours() {
        totalHours = 0;
        for (int i = 0; i < numClasses; i++) {
            totalHours += classes[i].getHours();
        }
    }

    /**
    * Gets the number of hours the Student is taking
    * @return the number of hours
    */
    public int getTotalHours() {
        return totalHours;
    }

    /**
    * Gets the lectures the Student is taking
    * @return An array of Lectures
    */
    public Lecture[] getLectures() {
        Lecture[] out = new Lecture[numLectures];
        int lectureCounter = 0;
        for (int i = 0; i < numClasses; i++) {
            if (classes[i] instanceof Lecture) {
                out[lectureCounter] = (Lecture) classes[i];
                lectureCounter++;
            }
        }
        return out;
    }

    /**
    * Gets the labs the Student is taking
    * @return An array of Labs
    */
    public Lab[] getLabs() {
        Lab[] out = new Lab[numLabs];
        int labCounter = 0;
        for (int i = 0; i < numClasses; i++) {
            if (classes[i] instanceof Lab) {
                out[labCounter] = (Lab) classes[i];
                labCounter++;
            }
        }
        return out;
    }

    /**
    * Gets the recitations the Student is taking
    * @return An array of Recitation
    */
    public Recitation[] getRecitations() {
        Recitation[] out = new Recitation[numRecitations];
        int recitationCounter = 0;
        for (int i = 0; i < numClasses; i++) {
            if (classes[i] instanceof Recitation) {
                out[recitationCounter] = (Recitation) classes[i];
                recitationCounter++;
            }
        }
        return out;
    }
    /**
    * Prints out the students schedule, with each class seperated
    * by a new line. Prints out each ClassPeriod a student is taking
    */
    public void printSchedule() {
        for (ClassPeriod c: classes) {
            if (c != null) {
                System.out.println(c + "\n");
            }
        }
    }
}
/*
* PLEASE FILL OUT THE FOLLOWING INFORMATION
* Your Name: Alex Saad-Falcon
* Recitation Time: 4:30-6
*/

public class Pizza {
    public enum Size { SMALL, MEDIUM, LARGE };
    private Size pizzaSize; //To avoid confusion
    private int numVegToppings;
    private int numMeatToppings;
    private static int totalPizzas = 0;

    //CONSTRUCTORS
    public Pizza(Size pizzaSize, int numVegToppings, int numMeatToppings) {
        this.pizzaSize = pizzaSize;
        this.numVegToppings = numVegToppings;
        this.numMeatToppings = numMeatToppings;
        totalPizzas++;
    }
    public Pizza() {
        this(Size.MEDIUM, 0, 0);
    }

    //GETTERS AND SETTERS
    public Size getSize() {
        return pizzaSize;
    }
    public int getNumVegToppings() { //additional
        return numVegToppings;
    }
    public int getNumMeatToppings() { //additional
        return numMeatToppings;
    }
    public int getTotal() {
        return totalPizzas;
    }

    public void setSize(Size newSize) {
        pizzaSize = newSize;
    }
    public void setNumVegToppings(int newNumVegToppings) { //additional
        numVegToppings = newNumVegToppings;
    }
    public void setNumMeatToppings(int newNumMeatToppings) { //additional
        numMeatToppings = newNumMeatToppings;
    }

    //OTHER METHODS
    public double calcCost() {
        double cost = 0;
        switch (pizzaSize) {
        case SMALL:
            cost += 8;
            break;
        case MEDIUM:
            cost += 10;
            break;
        case LARGE:
            cost += 14;
            break;
        default:
            cost += -100; //arbitrary. Gives strong incorrect value
            break;
        }
        cost += 1 * numVegToppings + 2 * numMeatToppings;
        return cost;
    }
    public String toString() {
        String out = "This pizza is a " + pizzaSize.name()
            + " pizza with " + numVegToppings + " vegetable toppings and "
            + numMeatToppings + " meat toppings. It costs $" + calcCost()
            + "0.";
        return out;
    }
}
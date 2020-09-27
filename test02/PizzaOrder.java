/*
* PLEASE FILL OUT THE FOLLOWING INFORMATION
* Your Name: Alex Saad-Falcon
* Recitation Time: 4:30-6
*/

public class PizzaOrder {
    public static final int MAXPIZZAS = 10;
    private String name;
    private Pizza[] pizzas;
    private int numPizzas;

    public PizzaOrder(String name) {
        this(new Pizza[MAXPIZZAS]);
        this.name = name;
    }
    public PizzaOrder(Pizza[] pizzaInput) {
        this.name = "George P. Burdell";
        int inputCounter = 0;
        int numPizzas = 0;
        while ((inputCounter < pizzaInput.length) 
            && (numPizzas < MAXPIZZAS)) {
            if (pizzaInput[inputCounter] != null) {
                pizzas[numPizzas] = pizzaInput[inputCounter];
                numPizzas++;
            }
            inputCounter++; //in case there are valid entries after null
        }
    }
    public double orderCost() {
        double cost = 0;
        for (Pizza p: pizzas) {
            if (p != null) {
                cost += p.calcCost();
            }
        }
        return cost;
    }
}
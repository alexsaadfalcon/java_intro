//I worked on this with Mahalakshmi Srinivasan
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.PrintWriter;

/**
* An adventure in the world of Pokemon
* @author Alexander Saad-Falcon
* @version 1.0.0.0
*/
public class Adventure {

    /** A String array of all the Pokemon the user can encounter */
    private String[] pokemon;

    /** A String array of all the Pokemon the user has encountered */
    private String[] pokedex;

    /** The number of Pokemon the user has encountered */
    private int pokedexNum;

    /** A PrintWriter to write the output Pokedex.txt file */
    private PrintWriter out;

    /** A String array of the Pokemon in the user's party */
    private String[] party;

    /** The number of Pokemon in the user's party */
    private int partySize;

    /** The number of steps the user has gone */
    private int steps;


    /**
    * Instantiates an adventure. Throws UnknownRegionException
    * @param pokemonFilename The name of the file where the list of Pokemon is
    */
    public Adventure(String pokemonFilename) throws UnknownRegionException {
        try {
            File pokemonFile = new File(pokemonFilename);
            if (!pokemonFile.exists()) {
                throw new UnknownRegionException();
            }
            Scanner pokeReader = new Scanner(pokemonFile);
            int length = 0;
            while (pokeReader.hasNext()) { //determine number of pokemon
                pokeReader.nextLine();
                length++;
            }
            pokemon = new String[length];
            pokedex = new String[length];
            party = new String[6];
            partySize = 0;
            pokedexNum = 0;
            pokeReader = new Scanner(pokemonFile);
            int index = 0;
            while (pokeReader.hasNext()) {
                pokemon[index] = pokeReader.nextLine();
                index++;
            }
            File pokedexFile = new File("Pokedex.txt");
            out = new PrintWriter(pokedexFile);
        } catch (UnknownRegionException u) {
            throw u;
        } catch (Exception e) {
            System.out.println("Exception in Adventure constructor: ");
            System.out.println(e.getMessage());
        }
    }

    //Public Methods
    /**
    * Causes the user to walk around.
    * Has a random chance of encountering a Pokemon
    */
    public void walkAround() {
        Random gen = new Random();
        steps += gen.nextInt(10) + 1;
        if (gen.nextDouble() < .9) {
            encounter();
        } else {
            System.out.println("No wild Pokemon encountered!");
        }
    }

    /**
    * Prints the user's party
    */
    public void viewParty() {
        if (partySize == 0) {
            System.out.println("There are no Pokemon in your party!");
        } else {
            System.out.println("Your party:");
            for (int i = 0; i < partySize; i++) {
                System.out.println((i + 1) + ". " + party[i]);
            }
        }
    }

    /**
    * Prints the user's report to Professor Oak
    */
    public void reportToProfessorOak() {
        System.out.println("Hey Professor Oak! So far I've come "
            + steps + " steps and encountered " + pokedexNum + " Pokemon.");
    }

    /**
    * Ends the user's adventure. Writes a file Pokedex.txt with a list
    * of the Pokemon the user has encountered
    */
    public void endAdventure() {
        for (int i = 0; i < pokedex.length; i++) {
            if (pokedex[i] != null) {
                out.println((i + 1) + ". " + pokedex[i]);
            }
        }
        out.close();
    }

    //Helper Methods
    /**
    * Adds a pokemon to the user's party. Throws PartyIsFullException
    * @param name The Pokemon's name
    */
    private void addToParty(String name) throws PartyIsFullException {
        if (partySize < 6) {
            party[partySize] = name;
            partySize++;
        } else {
            throw new PartyIsFullException();
        }
    }

    /**
    * Adds a Pokemon the user encounters to the pokedex
    * @param name The name of the Pokemon
    * @param index The Pokemon's index in the pokemon array
    */
    private void addToPokedex(String name, int index)
        throws PokemonAlreadyExistsException {
        if (pokedex[index] == null) {
            pokedex[index] = name;
            System.out.println("A new Pokedex entry was made for "
                + name + ".");
            pokedexNum++;
        } else {
            throw new PokemonAlreadyExistsException();
        }
    }

    /**
    * Causes the user to encounter a pokemon in the wild
    */
    private void encounter() {
        Random gen = new Random();
        int encounterIndex = gen.nextInt(pokemon.length);
        System.out.println("A wild " + pokemon[encounterIndex]
            + " has appeared!");
        addToPokedex(pokemon[encounterIndex], encounterIndex);
        if (gen.nextDouble() < .7) {
            System.out.print("Would you like to add " + pokemon[encounterIndex]
                + " to your party? (Yes or No) ");
            Scanner kb = new Scanner(System.in);
            String answer = kb.next();
            if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
                addToParty(pokemon[encounterIndex]);
                System.out.println(pokemon[encounterIndex]
                    + " was added to your party!");
            } else {
                System.out.println(pokemon[encounterIndex]
                    + " was not added to your party.");
            }
        }
    }

    /* Old encounter() method with unchecked errors caught
    private void encounter() {
        Random gen = new Random();
        int encounterIndex = gen.nextInt(pokemon.length);
        try {
            addToPokedex(pokemon[encounterIndex], encounterIndex);
        } catch (PokemonAlreadyExistsException p) {
            System.out.println(p.getMessage());
        }
        System.out.println("A wild " + pokemon[encounterIndex]
            + " has appeared!");
        if (gen.nextDouble() < .7) {
            System.out.print("Would you like to add " + pokemon[encounterIndex]
                + " to your party? (Yes or No)");
            Scanner kb = new Scanner(System.in);
            String answer = kb.next();
            if (answer.charAt(0) == 'Y' || answer.charAt(0) == 'y') {
                try {
                    addToParty(pokemon[encounterIndex]);
                    System.out.println(pokemon[encounterIndex]
                        + " was added to your party!");
                } catch(PartyIsFullException p) {
                    System.out.println(p.getMessage());
                }
            } else {
                System.out.println(pokemon[encounterIndex]
                    + " was not added to your party.");
            }
        }
    }
    */
}
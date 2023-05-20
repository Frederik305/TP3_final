import java.util.List;
import java.util.Scanner;
import pack.*;

public class Main {
    public static void main(String[] args) {
        List<Animaux> animalList1 = Methodes.readAnimauxDomestiqueData("src/pack/listeAnimauxDomestiques");
        List<Animaux> animalList2 = Methodes.readAnimauxDomestiqueData("src/pack/listeAnimauxExotiques");
        List<Food> inventory = Methodes.readFoodData("src/pack/listeAliments");
        List<Caretaker> caretakerList = Methodes.readCaretakerData("src/pack/listeEmployes");
        List<Enclos> enclosList = Methodes.readEnclosData("src/pack/listeEnclos");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choisissez une option:");
            System.out.println("1. Ajouter un animal");
            System.out.println("2. Afficher tous les animaux");
            System.out.println("3. Afficher les animaux d'un nourrisseur");
            System.out.println("4. Ajouter des aliments dans l'inventaire");
            System.out.println("5. Modifier une propriété d'animal domestique");
            System.out.println("6. Modifier une propriété d'animal exotique");
            System.out.println("7. Quitter");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> Methodes.addAnimal(enclosList, scanner);
                case 2 -> Methodes.printAllAnimals(enclosList);
                case 3 -> Methodes.displayAnimalsByCaretaker(caretakerList, enclosList, scanner);
                case 4 -> Methodes.manageInventory(inventory);
                case 5 -> Methodes.modifyAnimalProperty(animalList1, scanner);
                case 6 -> Methodes.modifyAnimalProperty(animalList2, scanner);
                case 7 -> {
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Choix invalide! Veuillez entrer une valeur entre 1 et 7.");
            }
        }
    }
}
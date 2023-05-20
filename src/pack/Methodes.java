package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methodes {
    /* Cette methode permet a l'employe du zoo de creer un animal et l'ajouter a un enclos
     Demander les informations sur le nouvel animal a l'utilisateur
     Afficher la liste des enclos et demander a l'utilisateur de choisir un enclos
     Creer un nouvel objet Animaux avec les informations saisies par l'utilisateur et ajouter l'animal a l'enclos selectionne
     Afficher un message indiquant que le nouvel animal a ete ajoute a l'enclos choisi */
    public static void addAnimal(List<Enclos> enclosList, Scanner scanner) {
        System.out.println("Entrez les informations sur le nouvel animal:");
        System.out.print("Nom: ");
        String name = scanner.next();
        System.out.print("Genre: ");
        String gender = scanner.next();
        System.out.print("Est-il domestique ou exotique?: ");
        String type = scanner.next();
        System.out.print("Groupe Social: ");
        String groupeSocial = scanner.next();
        System.out.print("Espece: ");
        String espece = scanner.next();
        System.out.print("Nombre de fois qu'il mange par jour: ");
        int frequence = scanner.nextInt();
        System.out.print("Quantite des portions: ");
        int quantite = scanner.nextInt();
        System.out.print("Omnivore/Herbivore/Carnivore: ");
        String manger = scanner.next();
        System.out.print("OMNIVORE/HERBIVORE/CARNIVORE: ");
        EnclosType zone = EnclosType.valueOf(scanner.next());

        System.out.println("Choisissez l'enclos pour le nouvel animal:");
        for (Enclos enclos : enclosList) {
            System.out.println(enclos.getNumEnclos() + " - " + enclos.getEspece() + " enclosure");
        }
        int enclosureIndex = scanner.nextInt();
        Enclos selectedEnclosure = enclosList.get(enclosureIndex - 1);

        Animaux newAnimal = new Animaux(name, gender, type, groupeSocial, espece, frequence, quantite, zone);
        selectedEnclosure.addAnimal(newAnimal);

        System.out.println("Le nouvel animal a ete ajoute a l'enclos " + selectedEnclosure.getNumEnclos());
    }

    /* Cette methode permet a l'employe du zoo d'afficher tous les animaux dans chaque enclos
       Afficher tous les animaux dans chaque enclos
       Afficher les informations sur chaque animal */
    public static void printAllAnimals(List<Enclos> enclosList) {
        System.out.println("Tous les animaux dans chaque enclos:");
        for (Enclos enclos : enclosList) {
            EnclosType enclosType = enclos.getZone();
            System.out.println("Zone: " + enclosType.getType() + " | Enclos: " + enclos.getNumEnclos());
            List<Animaux> animauxList = enclos.getAnimauxList();
            for (Animaux animal : animauxList) {
                if (animal.getZone() == enclosType) {
                    System.out.println("  - " + animal.getName() + " (" + animal.getGender() + ")");
                }
            }
        }
    }

    /*Cette methode permet a l'employer du zoo d'afficher tous les animaux qu'un nourrisseur s'occupe
    Demande à l'utilisateur d'entrer le numéro de badge du nourrisseur
    Parcours la liste de nourrisseurs
    Vérifie si le numéro de badge du nourrisseur correspond à celui entré par l'utilisateur
    Si oui, affiche tous les animaux pris en charge par ce nourrisseur
    Affiche le numéro et le type de l'enclos
    Parcours la liste des animaux dans l'enclos et les affiche
    sort de la boucle après avoir trouvé le nourrisseur correspondant*/
    public static void displayAnimalsByCaretaker(List<Caretaker> caretakerList, List<Enclos> enclosList, Scanner scanner) {
        System.out.println("Choisissez un soigneur:");
        for (Caretaker caretaker : caretakerList) {
            System.out.println(caretakerList.indexOf(caretaker) + 1 + " - " + caretaker.getName());
        }
        int caretakerIndex = scanner.nextInt();

        if (caretakerIndex >= 1 && caretakerIndex <= caretakerList.size()) {
            Caretaker selectedCaretaker = caretakerList.get(caretakerIndex - 1);
            String caretakerZone = String.valueOf(selectedCaretaker.getZone());

            List<Animaux> caredAnimals = new ArrayList<>();

            for (Enclos enclos : enclosList) {
                if (enclos.getZone().getType().equals(caretakerZone)) {
                    caredAnimals.addAll(enclos.getAnimauxList());
                }
            }

            if (!caredAnimals.isEmpty()) {
                System.out.println("Les animaux pris en charge par " + selectedCaretaker.getName() + " dans la zone " + caretakerZone + ":");
                for (Animaux animal : caredAnimals) {
                    System.out.println(animal.getName());
                }
            } else {
                System.out.println("Aucun animal pris en charge par " + selectedCaretaker.getName() + " dans la zone " + caretakerZone + ".");
            }
        } else {
            System.out.println("Soigneur introuvable. Veuillez choisir un soigneur valide.");
        }
    }

    /*Cette methode permet a l'employer du zoo de modifier l'inventaire de nourriture
     On récupère la commande entrée par l'utilisateur
     On consomme le caractère de fin de ligne pour éviter les problèmes de lecture
     On traite la commande entrée
     On affiche le contenu de l'inventaire
     On ajoute un aliment à l'inventaire
     On modifie la quantité d'un aliment dans l'inventaire
     On quitte la boucle
     La commande entrée n'est pas valide
    */
    public static void manageInventory(List<Food> inventory) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a command (1-4):");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Food to Inventory");
            System.out.println("3. Change Amount of Food in Inventory");
            System.out.println("4. Exit");
            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1 -> {
                    for (Food food : inventory) {
                        System.out.println(food.getType() + ": " + food.getQuantity());
                    }
                }
                case 2 -> {
                    System.out.println("Enter food name:");
                    String name2 = scanner.nextLine();
                    System.out.println("Enter amount:");
                    int amount = scanner.nextInt();
                    scanner.nextLine();
                    inventory.add(new Food(name2, amount));
                }
                case 3 -> {
                    System.out.println("Enter food name:");
                    String foodName = scanner.nextLine();
                    System.out.println("Enter new amount:");
                    int newAmount = scanner.nextInt();
                    scanner.nextLine();
                    for (Food food : inventory) {
                        if (food.getType().equals(foodName)) {
                            food.setQuantity(newAmount);
                            break;
                        }
                    }
                }
                case 4 -> {
                    return;
                }
                default -> System.out.println("Choix invalide! svp entrer une valeur entre 1 et 4.");
            }
        }
    }

    public static List<Food> readFoodData(String filename) {
        List<Food> foodList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String type = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());

                Food food = new Food(type, quantity);
                foodList.add(food);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return foodList;
    }

    public static List<Animaux> readAnimauxExotiqueData(String filename) {
        List<Animaux> animauxExotiqueList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String Name = parts[0].trim();
                String Gender = parts[1].trim();
                String type = parts[2].trim();
                String SocialGroup = parts[3].trim();
                String species = parts[4].trim();
                int frequence = Integer.parseInt(parts[5].trim());
                int quantite = Integer.parseInt(parts[6].trim());
                EnclosType zone = EnclosType.valueOf(parts[7].trim());

                Animaux animauxExotique = new Animaux(Name, Gender, type, SocialGroup, species, frequence, quantite, zone);
                animauxExotiqueList.add(animauxExotique);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return animauxExotiqueList;
    }

    public static List<Animaux> readAnimauxDomestiqueData(String filename) {
        List<Animaux> animauxDomestiqueList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String Name = parts[0].trim();
                String Gender = parts[1].trim();
                String type = parts[2].trim();
                String SocialGroup = parts[3].trim();
                String species = parts[4].trim();
                int frequence = Integer.parseInt(parts[5].trim());
                int quantite = Integer.parseInt(parts[6].trim());
                EnclosType zone = EnclosType.valueOf(parts[7].trim());

                Animaux animauxDomestique = new Animaux(Name, Gender, type, SocialGroup, species, frequence, quantite, zone);
                animauxDomestiqueList.add(animauxDomestique);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return animauxDomestiqueList;
    }

    public static List<Caretaker> readCaretakerData(String filename) {
        List<Caretaker> caretakerList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int badge = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                String role = parts[2].trim();
                EnclosType enclosType = EnclosType.valueOf(parts[3].trim());

                Caretaker caretaker = new Caretaker(badge, name, role, enclosType);
                caretakerList.add(caretaker);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return caretakerList;
    }

    public static List<Enclos> readEnclosData(String filename) {
        List<Enclos> enclosList = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                EnclosType zone = EnclosType.valueOf(parts[0].trim());
                int numEnclos = Integer.parseInt(parts[1].trim());
                String confinement = parts[2].trim();
                EnclosSize grandeurCage = EnclosSize.valueOf(parts[3].trim());
                String espece = parts[4].trim();

                Enclos enclos = new Enclos(zone, numEnclos, confinement, grandeurCage, espece);
                enclosList.add(enclos);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return enclosList;
    }
    public static List<Animaux> modifyAnimalProperty(List<Animaux> animalList, Scanner scanner) {
        System.out.println("Choisissez l'animal que vous souhaitez modifier:");
        for (Animaux animal : animalList) {
            System.out.println(animalList.indexOf(animal) + 1 + " - " + animal.getName());
        }
        int animalIndex = scanner.nextInt();

        if (animalIndex >= 1 && animalIndex <= animalList.size()) {
            Animaux selectedAnimal = animalList.get(animalIndex - 1);

            System.out.println("Choisissez la propriété que vous souhaitez modifier:");
            System.out.println("1. Nom");
            System.out.println("2. Genre");
            System.out.println("3. Type (domestique ou exotique)");
            System.out.println("4. Groupe Social");
            System.out.println("5. Espèce");
            System.out.println("6. Fréquence d'alimentation");
            System.out.println("7. Quantité d'alimentation");

            int propertyChoice = scanner.nextInt();
            scanner.nextLine();

            switch (propertyChoice) {
                case 1:
                    System.out.print("Entrez le nouveau nom: ");
                    String newName = scanner.nextLine();
                    selectedAnimal.setName(newName);
                    break;
                case 2:
                    System.out.print("Entrez le nouveau genre: ");
                    String newGender = scanner.nextLine();
                    selectedAnimal.setGender(newGender);
                    break;
                case 3:
                    System.out.print("Entrez le nouveau type (domestique ou exotique): ");
                    String newType = scanner.nextLine();
                    selectedAnimal.setType(newType);
                    break;
                case 4:
                    System.out.print("Entrez le nouveau groupe social: ");
                    String newSocialGroup = scanner.nextLine();
                    selectedAnimal.setSocialGroup(newSocialGroup);
                    break;
                case 5:
                    System.out.print("Entrez la nouvelle espèce: ");
                    String newSpecies = scanner.nextLine();
                    selectedAnimal.setSpecies(newSpecies);
                    break;
                case 6:
                    System.out.print("Entrez la nouvelle fréquence d'alimentation: ");
                    int newFrequence = scanner.nextInt();
                    selectedAnimal.setFrequence(newFrequence);
                    break;
                case 7:
                    System.out.print("Entrez la nouvelle quantité d'alimentation: ");
                    int newQuantite = scanner.nextInt();
                    selectedAnimal.setQuantite(newQuantite);
                    break;
                default:
                    System.out.println("Choix invalide! Veuillez entrer une valeur entre 1 et 7.");
                    break;
            }

            System.out.println("La propriété de l'animal a été modifiée avec succès.");
            System.out.println(selectedAnimal.toString());
        } else {
            System.out.println("Animal introuvable. Veuillez choisir un animal valide.");
        }
        return animalList;
    }
}
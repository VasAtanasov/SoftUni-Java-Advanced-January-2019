package L20IteratorsAndComparatorsExercises.Ex08PetClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static Map<String, Clinic> clinics;
    private static Map<String, Pet> pets;
    private static BufferedReader reader;

    private enum Command {
        Create, Add, Release, HasEmptyRooms, Print
    }

    static {
        pets = new LinkedHashMap<>();
        clinics = new LinkedHashMap<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Command command = Command.valueOf(tokens[0]);

            switch (command) {
                case Create:
                    create(tokens);
                    break;
                case Add:
                    addPet(tokens);
                    break;
                case Release:
                    releasePet(tokens);
                    break;
                case HasEmptyRooms:
                    checkIfEmptyRooms(tokens);
                    break;
                case Print:
                    printInfo(tokens);
                    break;
            }
        }
    }

    private static void printInfo(String[] tokens) {
        String clinicName = tokens[1];
        if (tokens.length == 3) {
            int roomNumber = Integer.parseInt(tokens[2]);
            System.out.println(clinics.get(clinicName).getRoomInfo(roomNumber - 1));

        } else if (tokens.length == 2) {
            for (Pet pet : clinics.get(clinicName)) {
                if (pet == null) {
                    System.out.println("Room empty");
                } else {
                    System.out.println(pet);
                }
            }
        }
    }

    private static void releasePet(String[] tokens) {
        String clinicName = tokens[1];

        System.out.println(clinics.get(clinicName).release());

    }

    private static void checkIfEmptyRooms(String[] tokens) {
        String clinicName = tokens[1];
        System.out.println(clinics.get(clinicName).hasEmptyRooms());
    }

    private static void addPet(String[] tokens) {
        String petName = tokens[1];
        String clinicName = tokens[2];
        System.out.println(clinics.get(clinicName).add(pets.get(petName)));
    }

    private static void create(String[] tokens) {
        String model = tokens[1];
        if ("Pet".equals(model)) {
            createPet(tokens);
        } else if ("Clinic".equals(model)) {
            creatClinic(tokens);
        }
    }

    private static void creatClinic(String[] tokens) {
        String clinicName = tokens[2];
        int rooms = Integer.parseInt(tokens[3]);
        try {
            clinics.putIfAbsent(clinicName, new Clinic(clinicName, rooms));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createPet(String[] tokens) {
        String petName = tokens[2];
        int petAge = Integer.parseInt(tokens[3]);
        String petKind = tokens[4];
        Pet pet = new Pet(petName, petAge, petKind);
        pets.putIfAbsent(petName, pet);
    }
}
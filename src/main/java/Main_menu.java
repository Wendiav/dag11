import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_menu {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ObjectMapper mapper = new ObjectMapper();
        Path pathNotes = Paths.get("src/main/resources/notes.json");
        List<Notes> notes;
        List<Notes> tempNotes = new ArrayList<>();

        int optionsToChoice = 0;

        //Som entrén får du menyn, där du måste välja mellan 3 alternativ som är följande:
        while (optionsToChoice != 3) {
            System.out.println("""
                    -----------------------------------
                     Välkomna till dagboken!
                          ---MAIN MENU---
                    ------------------------------------
                    1. Visa inlägg som finns i dagbok
                    2. Skapa en ny inlägg
                    3. avsluta programmer
                    ------------------------------------
                    """);
            optionsToChoice = Integer.parseInt(scanner.nextLine());

            switch (optionsToChoice) {
                case 1:
                    try {
                        List<Notes> noteList = List.of(mapper.readValue(pathNotes.toFile(), Notes.class));
                        for (Notes note : noteList) {
                            System.out.println("Title: " + note.getDiaryTitle());
                            System.out.println("Inlägg: " + note.getDiaryEntries());
                            System.out.println("Datum: " + note.getLocalDate());
                        }
                    }catch (IOException e){
                        System.out.println("Dagbokken är tom!");
                    }
                    break;
                case 2:
                    System.out.println("Skriv in title: ");
                    String diaryTitle = scanner.nextLine();

                    System.out.println("Skriv in din Dagboks inlägg: ");
                    String diaryEntries = scanner.nextLine();

                    LocalDateTime currentDateAndTime = LocalDateTime.now();
                    System.out.println("Dagens datum och tid: " + currentDateAndTime);

                    String localDate = LocalDate.now().toString();
                    Notes newNote = new Notes(diaryTitle, diaryEntries, localDate);

                    mapper.writeValue(Paths.get("src/main/resources/notes.json").toFile(), Notes[].class);
                    break;

                case 3:
                    System.out.println("-----programmet stänger!-----");
                    break;
                default:
                    System.out.println("ogiltigt alternativ");


                }

            }
        }
    }


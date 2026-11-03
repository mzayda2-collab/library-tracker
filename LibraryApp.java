import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LibraryApp {
    
    // Adds a new book to the library collection
    public static void addBook(String title, String author) {
        JSONArray books = new JSONArray();
        JSONParser parser = new JSONParser();
        
        try (FileReader reader = new FileReader("books.json")) {
            Object obj = parser.parse(reader);
            if (obj instanceof JSONArray) {
                books = (JSONArray) obj;
            }
        } catch (IOException | ParseException e) {
    
        }
        
        JSONObject book = new JSONObject();
        book.put("title", title);
        book.put("author", author);
        
        books.add(book);
        
        try (FileWriter file = new FileWriter("books.json")) {
            file.write(books.toJSONString());
            file.flush();
            System.out.println("Book '" + title + "' added successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public static void listBooks() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("books.json")) {
            Object obj = parser.parse(reader);
            JSONArray books = (JSONArray) obj;
            
            if (books.isEmpty()) {
                System.out.println("No books found.");
                return;
            }
            
            System.out.println("Library Books List:");
            for (int i = 0; i < books.size(); i++) {
                JSONObject book = (JSONObject) books.get(i);
                System.out.println((i + 1) + ". " + book.get("title") + " by " + book.get("author"));
            }
        } catch (IOException | ParseException e) {
            System.out.println("No books found or error reading file.");
        }
    }
    public static void print_banner() {
    System.out.println("Welcome to Library Tracker - Version A");
}
}
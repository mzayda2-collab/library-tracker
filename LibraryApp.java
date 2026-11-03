import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LibraryApp {

    public static void addBook(String title, String author) {
        JSONArray books = new JSONArray(); 
        
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
}
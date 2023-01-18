import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
import java.util.List;
public class PhonebookTest {
    PhoneBook phonebook = new PhoneBook("^\\d{3}-\\d{3}-\\d{4}$");

    @Test
    public void testAddEmptyName(){
        try{
            phonebook.add("", "123-456-7890");
        }catch (Exception e){
            assertEquals(e.getMessage(), "Name must contain characters");
        }
    }

    @Test
    public void testAddMalformedNumber(){
        try{
            phonebook.add("Karl", "123-111-2-234");
        }catch (Exception e){
            assertEquals(e.getMessage(), "Provided phonenumber is malformed");
        }
    }

    @Test
    public void testAddRecord() {
        try {
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
            assertEquals("Akhmedov Asatillo", phonebook.searchByNumber("123-456-7890"));
        } catch (Exception e) {
        }
    }

    @Test
    public void testAddDuplicateRecord() {
        try {
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Provided phonenumber is already in the book");
        }
    }

    @Test
    public void testSearchByPhoneNumber() {
        try {
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
            assertEquals("Akhmedov Asatillo", phonebook.searchByNumber("123-456-7890"));
        } catch (Exception e) {
        }
    }

    @Test
    void testSearchBySubscriber() {
        try {
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
            phonebook.add("Akhmedov Asatillo", "234-567-8901");
            assertEquals(List.of("123-456-7890", "234-567-8901"), phonebook.searchBySubscriber("Akhmedov Asatillo"));
        } catch (Exception e) {
        }
    }

    @Test
    void testDeleteRecord() {
        try {
            phonebook.add("Akhmedov Asatillo", "123-456-7890");
            phonebook.delete("Akhmedov Asatillo", "123-456-7890");
            phonebook.searchByNumber("123-456-7890");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "No such number in the phonebook!");
        }
    }
}
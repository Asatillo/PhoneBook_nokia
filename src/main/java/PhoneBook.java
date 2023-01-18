import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The class `Phonebook` is a data structure that stores a mapping between subscribers and their phone
 * numbers
 */
class PhoneBook{
    private HashMap<String, ArrayList<String>> subscribers; // key -> subscriber, value -> list of numbers
    private HashMap<String, String> phone_numbers; // key -> number, value -> owner
    private Pattern regex_phonenumber;

    // A constructor.
    public PhoneBook(String regex){
        this.subscribers = new HashMap<String, ArrayList<String>>();
        this.phone_numbers = new HashMap<String, String>();
        this.regex_phonenumber = Pattern.compile(regex);
    }

    /**
     * This function takes a phone number as a parameter and returns the name of the person who owns
     * that phone number
     *
     * @param phoneNumber The phone number to search for.
     * @return phone_numbers.get(phoneNumber)
     */
    public String searchByNumber(String phoneNumber) throws Exception{
        if(!this.phone_numbers.containsKey(phoneNumber)){
            throw new Exception("No such number in the phonebook!");
        }
        return phone_numbers.get(phoneNumber);
    }

    /**
     * It returns a list of phone numbers of a subscriber
     *
     * @param subscriber The name of the subscriber.
     * @return A list of strings.
     */
    public List<String> searchBySubscriber(String subscriber) throws Exception{
        if(!this.subscribers.containsKey(subscriber)){
            throw new Exception("No such subscriber in the phonebook!");
        }
        return subscribers.get(subscriber);
    }

    /**
     * It adds a new subscriber to the phonebook
     *
     * @param name String
     * @param phoneNumber String
     */
    public void add(String name, String phoneNumber) throws Exception{
        if(name.isEmpty()){
            throw new Exception("Name must contain characters");
        }
        if(phone_numbers.containsKey(phoneNumber)){
            throw new Exception("Provided phonenumber is already in the book");
        }
        if(!regex_phonenumber.matcher(phoneNumber).matches()){
            throw new Exception("Provided phonenumber is malformed");
        }

        if(!subscribers.containsKey(name)){
            subscribers.put(name, new ArrayList<String>());
        }
        subscribers.get(name).add(phoneNumber);
        phone_numbers.put(phoneNumber, name);
    }

    /**
     * It removes a phone number from the phone book
     *
     * @param name String
     * @param phoneNumber String
     */
    public void delete(String name, String phoneNumber) throws Exception{
        if(!subscribers.containsKey(name)){
            throw new Exception("No such name in the book");
        }
        if(!subscribers.get(name).contains(phoneNumber)){
            throw new Exception("Provided subscriber doesn\'t have such number");
        }
        if(!phone_numbers.containsKey(phoneNumber)){
            throw new Exception("No such phonenumber in the book");
        }

        subscribers.get(name).remove(phoneNumber);
        phone_numbers.remove(phoneNumber);
    }
}
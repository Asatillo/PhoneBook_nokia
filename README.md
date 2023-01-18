# NokiaPhonebookTask

Write a class in Java or C++ language that meets the following requirements.
It is a phonebook. It should contain phone numbers and subscribers. For any subscriber, one or more phone numbers can be assigned. For any phone number exactly one subscriber can be assigned.
Provide search by phone number function (returns a string or throws an exception).
Provide search by subscriber function (returns a list of phone numbers).
Make both searches as efficient as possible.
The internal representation is up to you, but please do not use any data structures provided by the language or frameworks. Arrays can be used, enums, classes, records, pointers can be used.
Provide a function that expects two parameters (name and phone number) and adds these to your phonebook as a pair. It should throw an exception when the exact same record is already in the phonebook, or if the input is malformed.
Provide another function with these parameters. These function will delete the given record from the phonebook. If no such entry, raise an exception.
Subscriber's name could be anything. Accepted phone number format (regex) should be configured externally (e.g. as a command line argument).
Create a command line app or a unit test set to present the features of your class.
Write clean, well-organized, self documenting code.

# Content of the project
- `src/main/java/Main.java` main class
- `src/main/java/PhoneBook.java` implementation of the phonebook class
- `src/test/java/PhonebookTest.java` unit testing of the class phonebook
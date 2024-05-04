import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> phoneBook = new HashMap<>();

        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Вывести список всех телефонов");
            System.out.println("3. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введите имя:");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона:");
                    String phone = scanner.nextLine();
                    addContact(phoneBook, name, phone);
                    break;
                case 2:
                    displayPhoneBook(phoneBook);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите от 1 до 3.");
            }
        }

        scanner.close();
    }

    // Метод для добавления контакта в телефонную книгу
    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phone) {
        Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
        phones.add(phone);
        phoneBook.put(name, phones);
        System.out.println("Контакт добавлен: " + name + ", " + phone);
    }

    // Метод для вывода списка всех телефонов
    public static void displayPhoneBook(Map<String, Set<String>> phoneBook) {
        System.out.println("Список всех телефонов:");
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            System.out.println("Имя: " + entry.getKey() + ", Телефоны: " + entry.getValue());
        }
    }
}

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();

    }

    public static void task1(){
        List<User> userList = List.of(
                new User("Oleg", "Krawchuk", 41, "oleg.krawchuk@gmail.com"),
                new User("John", "Doe", 30, "john.doe@example.com"),
                new User("Jane", "Smith", 25, "jane.smith@example.com"),
                new User("Robert", "Smietanka", 55, "robert.smietanka@gmail.com"),
                new User("Oleg", "Krawchuk", 44, "oleg.krawchuk2@gmail.com"),
                new User("Oleg", "Krawchuk", 81, "oleg.krawchuk3@gmail.com")
        );

        userList.stream()
                .sorted()
                .map(surname -> surname.getSurname())
                .distinct()
                .forEach(System.out::println);
    }

    public static void task2(){
        /**
         * Используя класс юзер, созданный ранее, отфильтруйте значения по длине фамилии ( должно быть в списке только фамилии менее 8 символов),
         * далее вам нужно выставить так что бы были только имена вашего объекта и выведете первый попавшийся результат,
         * если результата нет - то должно выброситься исключение, вами созданное.
         */

        List<User> userList = List.of(
                new User("Oleg", "Krawchuk", 41, "oleg.krawchuk@gmail.com"),
                new User("John", "Doe", 30, "john.doe@example.com"),
                new User("Jane", "Smith", 25, "jane.smith@example.com"),
                new User("Robert", "Smietanka", 55, "robert.smietanka@gmail.com"),
                new User("Oleg", "Krawiec", 44, "oleg.krawchuk2@gmail.com"),
                new User("Oleg", "Krawchuk", 81, "oleg.krawchuk3@gmail.com")
        );

        Optional<String> optionalS = userList.stream()
                .filter(user -> user.getSurname().length() < 8)
                .map(User::getName)
                .findFirst();

        try {
            System.out.println(optionalS.orElseThrow(()-> new NotFoundNameException("Wasn't find any name")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void task3(){
        List<User> userList = List.of(
                new User("Oleg", "Krawchuk", 41, "oleg.krawchuk@gmail.com"),
                new User("John", "Doe", 30, "john@exa.com"),
                new User("Jane", "Smith", 25, "jane@exa.com"),
                new User("Robert", "Smietanka", 55, "robert.smietanka@gmail.com"),
                new User("Oleg", "Krawiec", 44, "oleg.krawchuk2@gmail.com"),
                new User("Jane", "Smith", 25, "janezsq12313131q21213@exa.com"),
                new User("Oleg", "Krawchuk", 81, "oleg.krawchuk3@gmail.com")
        );

        userList.stream()
                .filter(email->email.getEmail().length() > 12)
                .skip(3)
                .map(User::getBirthYear)
                .forEach(System.out::println);
    }

    /**
     * Task4
     * Рекурсия - это подход при котором функция вызывает сама себя, заходя в бесконичный цикл, но можно создать условия при которых
     * рекурсия оставливается. Например:  вычисления факториала или пример двусторонней рекурсии для вычисления чисел Фибоначчи.
     *
     *
     * Stream - это функциональный интерфейс, предоставляющий возможности для работы с потоками данных и коллекциями в Java.
     * Optional -  это тоже функциональный интерфейс котрый предоставляет удобные методы для работы с возможно пустыми значениями,
     * такие как orElse, orElseGet, orElseThrow.
     */
}


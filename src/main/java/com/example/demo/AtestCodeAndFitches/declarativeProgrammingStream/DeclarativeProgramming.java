package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream;

import com.example.demo.User.User;
import com.example.demo.User.UserRole;
import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.SortHandlerMethodArgumentResolver;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.RegistrationValidator.*;
import static com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.RegistrationValidator.RegistrationUserValidatorResult.SUCCESS;

public class DeclarativeProgramming {
//    List<User> people = List.of(
//            new User("John", "Smith" , "John@Gmail.com", "123", USER),
//            new User("Sara", "Smith" , "Sara@Gmail.com", "123", USER),
//            new User("Omer", "Haiim" , "Omer@Gmail.com", "123", USER),
//            new User("Linda", "Lens" , "Linda@Gmail.com", "123", USER),
//            new User("Joshua", "Mekron" , "Mekron@Gmail.com", "123", USER)
//    );

    List<Person> people = List.of(
            new Person("a", "bb"),
            new Person("b", "123"),
            new Person("d", "ee"),
            new Person("e", "ff")
    );

    @Bean
    public void streamFunction(){
        people.stream()
                .filter(person -> person.getPass().equals("123"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /**
     * STREAM
     *
     * */
    public void streamFunction2(){
        List<Person> personList = people.stream()
                .filter(person -> person.getPass().equals("123"))
                .collect(Collectors.toList());

        personList.forEach(System.out::println);
    }

    public void someFunctionJustTest(){
        //
        RegistrationValidator.RegistrationUserValidatorResult result = isEmailValid()
                .and(isUserNameValid())
                .and(isPasswordValid())
                .apply(new User("ee", "sdf", "sdfsf", UserRole.USER));
        if(!result.equals(SUCCESS))
            throw new IllegalStateException (result.name());
        //
    }

    /**CONSUMER
     * (person) -> {}*/
    static Consumer<Person> printSomePerson = person -> {
        System.out.println(
                "Name of person is: " + person.getName() + "\n" +
                "Pass is: " + person.getPass()
        );
    };

    /**SUPPLIER
     * () -> {return new person()}
     * */
    static Supplier<List<Person>> personsSupplier = () -> {
        return List.of(
                new Person("niv", "123"),
                new Person("nadav", "123"));
    };

    /**PREDICATE
     * () -> {return new person()}
     * */
    static Predicate<Person> predicateValidatorPerson = person -> {
        return person.getName().length() > 2;
    };





}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Person {
    String name;
    String pass;
}

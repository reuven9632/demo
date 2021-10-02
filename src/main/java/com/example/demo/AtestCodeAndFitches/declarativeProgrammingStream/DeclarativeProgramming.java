package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream;

import com.example.demo.User.User;
import com.example.demo.User.UserRole;
import lombok.*;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Predicate;
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

    public void streamFunction2(){
        List<Person> personList = people.stream()
                .filter(person -> person.getPass().equals("123"))
                .collect(Collectors.toList());

        personList.forEach(System.out::println);
    }
    
    public void consumierFuncton(){
        // TODO: 02.10.2021  
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

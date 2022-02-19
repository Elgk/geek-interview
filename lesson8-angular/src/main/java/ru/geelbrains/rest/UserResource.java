package ru.geelbrains.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geelbrains.persist.User;
import ru.geelbrains.persist.UserRepository;

import java.util.List;

//@Profile("test") // исключает класс из теста
@RestController
@RequestMapping("/user")
public class UserResource {
    private final UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> findAll(){
       // return "aaaa";// если просто Controller, то "аааа"воспринимается как имя представления (напр. аааа.html), а наличие @ResponceBody указывает на вывод ответа в json-формате
        return userRepository.findAll();
    }

    @GetMapping("/{id}/id") // может использоваться сначала параметр {id}, затем имя параметра id
    public User findByUser(@PathVariable("id") Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User with id = " + id + " not exists."));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){

        if (user.getId() != null){
            throw new IllegalArgumentException("Can't create new user with not null id");
        }
        return userRepository.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user){
        if (user.getId() == null){
            throw new IllegalArgumentException("Can't update user with null id");
        }
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}/id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        userRepository.deleteById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDto notFoundExceptionHandler(NotFoundException ex){
        return new ErrorDto(ex.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto notFoundExceptionHandler(IllegalArgumentException ex){
        return new ErrorDto(ex.getMessage());
    }
}

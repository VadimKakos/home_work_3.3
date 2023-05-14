package ru.hogwarts.school.service;

import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.Optional;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);

    Optional<Faculty> findFaculty(long id);

    Faculty editFaculty(Faculty faculty);

    void deleteFaculty(long id);

    Collection<Faculty> getFacultyByColor(String color);

    Collection<Faculty> getFaculty();

     Collection<Faculty> findByNameOrColor(String name, String color);

    Collection<Faculty> findByName(String name);
}

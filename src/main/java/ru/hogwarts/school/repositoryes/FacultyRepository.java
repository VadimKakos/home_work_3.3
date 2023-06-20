package ru.hogwarts.school.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);

    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

    Collection<Faculty> findByName(String name);

    Faculty findFacultiesById(long id);
}

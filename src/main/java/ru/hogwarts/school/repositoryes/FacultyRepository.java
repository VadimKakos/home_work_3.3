package ru.hogwarts.school.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.model.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty,Long> {
}

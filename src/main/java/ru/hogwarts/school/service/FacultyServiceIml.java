package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositoryes.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyServiceIml implements FacultyService{
    private final FacultyRepository facultyRepository;

    public FacultyServiceIml(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(FacultyServiceIml.class);
    //create
    public Faculty createFaculty(Faculty faculty) {
        logger.debug("Was invoked method for create faculty");
        if (findFaculty(faculty.getId()).isEmpty()) {
            return facultyRepository.save(faculty);
        }
        return null;
    }

    //find
    public Optional<Faculty> findFaculty(long id) {
        logger.debug("Was invoked method for find faculty by id{}", id);
        return facultyRepository.findById(id);
    }


    //edit
    public Faculty editFaculty(Faculty faculty) {
        logger.debug("Was invoked method for edit faculty{}", faculty);
        if (findFaculty(faculty.getId()).isEmpty()) {
            logger.warn("faculty not found");
            return null;
        }
        return facultyRepository.save(faculty);
    }
    //delete
    public void deleteFaculty(long id) {
        logger.debug("Was invoked method for delete faculty by id{}", id);
        facultyRepository.deleteById(id);
    }
    //getAll

    public Collection<Faculty> getFaculty() {
        logger.debug("Was invoked method for get all faculty");
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> findByNameOrColor(String nameOrColor) {
        logger.debug("Was invoked method for find faculty by name or color{}", nameOrColor);
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    //findByName
    @Override
    public Collection<Faculty> findByName(String name) {
        logger.debug("Was invoked method for find by name{}", name);
        return facultyRepository.findByName(name);
    }

    //studentsOfFaculty
    @Override
    public Collection<Student> findStudentsOfFaculty(long id) {
        logger.debug("Was invoked method for find student with id {} of faculty", id);
        return facultyRepository.findFacultiesById(id).getStudents();
    }

    //findByColor
    public Collection<Faculty> getFacultyByColor(String color) {
        logger.debug("Was invoked method for get faculty by color{}", color);
        return facultyRepository.findByColor(color);
    }
}



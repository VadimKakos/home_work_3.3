package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositoryes.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyServiceIml implements FacultyService{
    private final FacultyRepository facultyRepository;

    public FacultyServiceIml(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    //create
    public Faculty createFaculty(Faculty faculty) {
        if (findFaculty(faculty.getId()).isEmpty()) {
            return facultyRepository.save(faculty);
        }
        return null;
    }

    //find
    public Optional<Faculty> findFaculty(long id) {
        return facultyRepository.findById(id);
    }


    //edit
    public Faculty editFaculty(Faculty faculty) {
        if (findFaculty(faculty.getId()).isEmpty()) {
            return null;
        }
        return facultyRepository.save(faculty);
    }
    //delete
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }
    //getAll

    public Collection<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }
    //findByColor
    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findByColor(color);
    }
}



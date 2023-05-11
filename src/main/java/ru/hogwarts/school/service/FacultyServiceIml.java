package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repositoryes.FacultyRepository;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class FacultyServiceIml implements FacultyService{
    private final FacultyRepository facultyRepository;

    public FacultyServiceIml(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    //create
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    //find
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    //edit
    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
    //delete
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFaculty() {
        return facultyRepository.findAll();
    }
    //findByColor
    public Collection<Faculty> getFacultyByColor(String color) {
        return facultyRepository.findAll().stream()
                .filter(faculty -> Objects.equals(faculty
                        .getColor(), color))
                .collect(Collectors.toList());
    }
}



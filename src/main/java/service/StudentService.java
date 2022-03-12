package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public Student get(Long id){
        return studentRepository.findById(id).get();
    }
    public void delete(Long id){
        studentRepository.deleteById(id);
    }
}
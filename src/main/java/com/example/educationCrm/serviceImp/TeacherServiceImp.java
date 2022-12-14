package com.example.educationCrm.serviceImp;

import com.example.educationCrm.helper.ModelMapperHelper;
import com.example.educationCrm.model.entity.Lesson;
import com.example.educationCrm.model.entity.School;
import com.example.educationCrm.model.entity.Student;
import com.example.educationCrm.model.entity.Teacher;
import com.example.educationCrm.repository.LessonRepository;
import com.example.educationCrm.repository.SchoolRepository;
import com.example.educationCrm.repository.TeacherRepository;
import com.example.educationCrm.service.StudentService;
import com.example.educationCrm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImp implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ModelMapperHelper modelMapperHelper;

    @Transactional
    @Override
    public void save(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void update(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Transactional
    @Override
    public void delete(Teacher teacher) {
        this.teacherRepository.delete(teacher);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Teacher> findAll() {
        return this.teacherRepository.findAll();
    }


    @Override
    public Teacher withStudents(Long id)
            throws Exception {
        return this.teacherRepository.findById(id).orElse(null);
    }

    @Override
    public List<Teacher> findTeacherByLesson(Lesson lesson) {
        return this.teacherRepository.teacherByLesson(lesson);
    }
}

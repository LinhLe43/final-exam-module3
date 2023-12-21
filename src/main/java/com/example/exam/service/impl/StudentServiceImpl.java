package com.example.exam.service.impl;

import com.example.exam.model.ClassRoom;
import com.example.exam.model.Student;
import com.example.exam.service.StudentService;
import com.example.exam.service.connection.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {
    Connection connection = ConnectionToMySQL.getConnection();

    @Override
    public void add(Student student) {
        String sql = "insert into student(name, dob, address, phoneNumber, email, idClassRoom) values (?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDob());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassRoom().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Student student) {
        String sql = "update student\n" +
                "set name        = ?,\n" +
                "    dob         = ?,\n" +
                "    address     = ?,\n" +
                "    phoneNumber = ?,\n" +
                "    email       = ?,\n" +
                "    idClassRoom = ?\n" +
                "where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getDob());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhoneNumber());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getClassRoom().getId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from student s where  s.id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        String sql = "select s.*, c.name as className from student s join classroom c on c.id = s.idClassRoom order by s.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");
                String className = resultSet.getString("className");
                ClassRoom classRoom = new ClassRoom(idClassRoom, className);
                Student student = new Student(id, name, dob, address, phoneNumber, email, classRoom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student getById(int id) {
        Student student = null;
        String sql = "select s.*, c.name as className from student s join classroom c on c.id = s.idClassRoom where s.id =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");
                String className = resultSet.getString("className");
                ClassRoom classRoom = new ClassRoom(idClassRoom, className);
                student = new Student(id, name, dob, address, phoneNumber, email, classRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return student;
    }

    public List<Student> getByName(String nameClassRoom) {
        List<Student> students = new ArrayList<>();
        String sql = "select s.*, c.name as className\n" +
                "from student s\n" +
                "         join classroom c on c.id = s.idClassRoom\n" +
                "where c.name like ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameClassRoom);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");
                ClassRoom classRoom = new ClassRoom(idClassRoom, nameClassRoom);
                Student student = new Student(id, name, dob, address, phoneNumber, email, classRoom);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}

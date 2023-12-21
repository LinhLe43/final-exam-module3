package com.example.exam.service.impl;

import com.example.exam.model.ClassRoom;
import com.example.exam.service.ClassRoomService;
import com.example.exam.service.connection.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRoomServiceImpl implements ClassRoomService<ClassRoom> {
    Connection connection = ConnectionToMySQL.getConnection();

    @Override
    public List<ClassRoom> findAll() {
        List<ClassRoom> classRooms = new ArrayList<>();
        String sql = "select * from classroom";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                ClassRoom classRoom = new ClassRoom(id, name);
                classRooms.add(classRoom);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classRooms;
    }
}

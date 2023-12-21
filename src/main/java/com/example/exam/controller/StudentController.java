package com.example.exam.controller;

import com.example.exam.model.ClassRoom;
import com.example.exam.model.Student;
import com.example.exam.service.ClassRoomService;
import com.example.exam.service.StudentService;
import com.example.exam.service.impl.ClassRoomServiceImpl;
import com.example.exam.service.impl.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentController", value = "/students")
public class StudentController extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private ClassRoomService classRoomService = new ClassRoomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
                showHome(req, resp);
                break;
            case "create":
                showCreate(req, resp);
                break;
            case "update":
                showUpdate(req, resp);
                break;
            case "view":
                RequestDispatcher dispatcher = req.getRequestDispatcher("student/view.jsp");
                int id = Integer.parseInt(req.getParameter("id"));
                Student student = (Student) studentService.getById(id);
                req.setAttribute("student", student);
                dispatcher.forward(req, resp);
        }
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/home.jsp");
        List<Student> students = studentService.findAll();
        req.setAttribute("students", students);
        dispatcher.forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        List<ClassRoom> classRooms = classRoomService.findAll();
        req.setAttribute("classRooms", classRooms);
        dispatcher.forward(req, resp);
    }

    //
    private void showUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/update.jsp");
        int updateId = Integer.parseInt(req.getParameter("id"));
        Student student = (Student) studentService.getById(updateId);
        req.setAttribute("student", student);
        List<ClassRoom> classRooms = classRoomService.findAll();
        req.setAttribute("classRooms", classRooms);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        int idClassRoom = Integer.parseInt(req.getParameter("idClassRoom"));
        ClassRoom classRoom = new ClassRoom(idClassRoom);
        Student student = new Student(name, dob, address, phoneNumber, email, classRoom);
        studentService.add(student);
        resp.sendRedirect("/students?action=home");
    }

    //
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idDelete = Integer.parseInt(req.getParameter("id"));
        studentService.delete(idDelete);
        resp.sendRedirect("/students?action=home");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int idUpdate = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        String email = req.getParameter("email");
        int idClassRoom = Integer.parseInt(req.getParameter("idClassRoom"));
        ClassRoom classRoom = new ClassRoom(idClassRoom);
        Student student = new Student(name, dob, address, phoneNumber, email, classRoom);
        studentService.edit(idUpdate, student);
        resp.sendRedirect("/students?action=home");
    }

    //
    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/searchResult.jsp");
        String name = req.getParameter("name");
        List<Student> students = studentService.getByName(name);
        req.setAttribute("students", students);
        dispatcher.forward(req, resp);
    }
}

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2023
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home</title>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
            integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"
    ></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
            crossorigin="anonymous"
    ></script>
    <link rel="stylesheet" href="../css/style.css"/>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg nav-bg">
                <a href="http://localhost:8080/students?action=home" class="navbar-brand color-white">Logo</a>
                <button
                        class="navbar-toggler"
                        type="button"
                        data-toggle="collapse"
                        data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent"
                        aria-expanded="false"
                        aria-label="Toggle navigation"
                >
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a
                                    class="nav-link color-white"
                                    href="http://localhost:8080/students?action=create"
                            >Create Students <span class="sr-only">(current)</span></a
                            >
                        </li>
                    </ul>
                    <div class="form-inline my-2 my-lg-0">
                        <form action="students" method="post">
                            <input type="hidden" name="action" value="search">
                            <input
                                    class="form-control mr-sm-2"
                                    type="text"
                                    placeholder="Search"
                                    name="name"
                            />
                            <button
                                    class="btn btn-outline-success my-2 my-sm-0"
                            >
                                Search
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <table class="table">
                <thead>
                <tr class="nav-bg color-white">
                    <th scope="col">STT</th>
                    <th scope="col">Name</th>
                    <th scope="col">Dob</th>
                    <th scope="col">Address</th>
                    <th scope="col">PhoneNumber</th>
                    <th scope="col">Email</th>
                    <th scope="col">ClassRoom</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">${student.id}</th>
                    <td>${student.name}</td>
                    <td>${student.dob}</td>
                    <td>${student.address}</td>
                    <td>${student.phoneNumber}</td>
                    <td>${student.email}</td>
                    <td>${student.classRoom.name}</td>
                    <td>
                        <a href="http://localhost:8080/students?action=home">
                            <button type="button" class="btn btn-outline-dark">Quay lại</button>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>


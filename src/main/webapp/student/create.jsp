<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2023
  Time: 11:04 AM
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
    <title>Create</title>
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
                <a
                        class="navbar-brand color-white"
                        href="http://localhost:8080/students?action=home"
                >Logo</a
                >
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
                            >Create Student <span class="sr-only">(current)</span></a
                            >
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0">
                        <input
                                class="form-control mr-sm-2"
                                type="search"
                                placeholder="Search"
                                aria-label="Search"
                        />
                        <button
                                class="btn btn-outline-success my-2 my-sm-0"
                                type="submit"
                        >
                            Search
                        </button>
                    </form>
                </div>
            </nav>
        </div>
        <div class="col-12 mt-5">
            <form
                    action="http://localhost:8080/students?action=create"
                    method="post"
            >
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputName">Name</label>
                        <input
                                type="text"
                                class="form-control"
                                id="inputName"
                                name="name"
                                required
                        />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputDob">Date Of Birth</label>
                        <input
                                type="date"
                                class="form-control"
                                id="inputDob"
                                name="dob"
                                required
                        />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputAddress">Address</label>
                        <input
                                type="text"
                                class="form-control"
                                id="inputAddress"
                                name="address"
                                required
                        />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPhoneNumber">Phone Number</label>
                        <input
                                type="tel"
                                class="form-control"
                                id="inputPhoneNumber"
                                name="phoneNumber"
                                pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required
                                placeholder="xxx-xxx-xxxx"
                        />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail">Email</label>
                        <input
                                type="email"
                                class="form-control"
                                id="inputEmail"
                                name="email"
                                required
                        />
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputState">ClassRoom</label>
                        <select id="inputState" class="form-control" name="idClassRoom">
                            <c:forEach items="${classRooms}" var="classRoom">
                                <option value="${classRoom.id}">${classRoom.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">
                    Create Student
                </button>
            </form>
        </div>
    </div>
</div>
</body>
</html>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<div class="container mt-5">
    <div class="row justify-content-center">

        <div class="col-md-6">

            <div class="card shadow">

                <div class="card-header bg-primary text-white text-center">
                    <h3>User Registration</h3>
                </div>

                <div class="card-body">

                    <form action="/UserCtl" method="post">

                        <div class="mb-3">
                            <label class="form-label">First Name</label>
                            <input type="text" name="firstName"
                                class="form-control"
                                placeholder="Enter First Name">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Last Name</label>
                            <input type="text" name="lastName"
                                class="form-control"
                                placeholder="Enter Last Name">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Login</label>
                            <input type="email" name="login"
                                class="form-control"
                                placeholder="Enter Email">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="password"
                                class="form-control"
                                placeholder="Enter Password">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input type="date" name="dob"
                                class="form-control">
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <textarea name="address"
                                class="form-control"
                                rows="3"
                                placeholder="Enter Address"></textarea>
                        </div>

                        <div class="mb-3">
                            <label class="form-label d-block">Gender</label>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input"
                                    type="radio"
                                    name="gender"
                                    value="Male">

                                <label class="form-check-label">
                                    Male
                                </label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input"
                                    type="radio"
                                    name="gender"
                                    value="Female">

                                <label class="form-check-label">
                                    Female
                                </label>
                            </div>

                        </div>

                        <div class="text-center">

                            <button type="submit"
                                class="btn btn-primary">
                                Save
                            </button>

                            <button type="reset"
                                class="btn btn-secondary">
                                Reset
                            </button>

                        </div>

                    </form>

                </div>

            </div>

        </div>

    </div>

</div>
<%@ include file="Footer.jsp" %>
</body>
</html>
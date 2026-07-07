<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<div class="container d-flex justify-content-center align-items-center"
     style="height: 100vh;">

    <div class="border p-4 rounded shadow">

        <h2 class="text-center mb-4">Login Here</h2>

        <form action="/LoginCtl" method="post">

            <table class="table-borderless">

                <tr>
                    <th>User Name</th>
                    <td>
                        <input type="text" class="form-control"
                               name="login"
                               placeholder="Enter Your UserName">
                    </td>
                </tr>

                <tr>
                    <th>Password</th>
                    <td>
                        <input type="password" class="form-control"
                               name="password"
                               placeholder="Enter Your Password">
                    </td>
                </tr>

                <tr>
                    <th></th>
                    <td>
                        <input type="submit"
                               class="btn btn-primary w-100"
                               value="Login">
                    </td>
                </tr>

            </table>

        </form>

    </div>

</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>
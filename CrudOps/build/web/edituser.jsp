<%-- 
    Document   : edituser
    Created on : Nov 15, 2024, 4:16:45 PM
    Author     : computop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Insertion Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    
   <style>
        /* Fade-in animation */
        .fade-in {
            opacity: 0;
            transform: translateY(20px);
            animation: fadeIn 1s forwards;
        }
        
        @keyframes fadeIn {
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        /* Form styling */
        .form-container {
            max-width: 300px;
          
            margin: 2rem auto;
            padding: 2rem;
            background-color: #f8f9fa;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        
        /* Button hover effect */
        .btn-custom:hover {
            background-color: #0056b3;
            transform: scale(1.05);
            transition: transform 0.3s;
        }
    </style>
    
    
</head>
<body>

    
    
    
<div class="container">
    <div class="form-container fade-in">
        <h2 class="text-center">Edit User</h2>
        <form action="updatecontroller" method="post">
            <div class="form-group">
                <label for="userID">ID</label>
                <input type="text" name="id" value="${param.id}" class="form-control" id="userID" placeholder="Enter ID" required>
            </div>
            <div class="form-group">
                <label for="userName">Name</label>
                <input type="text" name="name" class="form-control" id="userName" placeholder="Enter Name" required>
            </div>
            <div class="form-group">
                <label for="userEmail">Email</label>
                <input type="email" name="email" class="form-control" id="userEmail" placeholder="Enter Email" required>
            </div>
            <div class="form-group">
                <label for="userCountry">Country</label>
                <input type="text" name="country" class="form-control" id="userCountry" placeholder="Enter Country" required>
            </div>
            <button type="submit" class="btn btn-primary btn-block btn-custom">Submit</button>
        </form>
    </div> 
    
</div>
    
    
    
    
    
    

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
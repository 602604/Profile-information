<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Information</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
	<h1>Profile Information</h1>
    <form action="updateProfile" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="profilePicture">Profile Picture</label>
            <input type="file" id="profilePicture" name="profilePicture" accept="image/jpeg, image/gif, image/png">
            <small>JPG, GIF or PNG, 1MB Max.</small>
        </div>

        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="${user.name}" required>
            <small>Will appear on receipts, invoices, and other communication.</small>
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
            <small>Used to sign in, for email receipts and product updates.</small>
        </div>

        <div class="form-group">
            <label for="currentPassword">Current Password</label>
            <input type="password" id="currentPassword" name="currentPassword" required>
            <small>Confirm your current password before setting a new one.</small>
        </div>

        <div class="form-group">
            <label for="newPassword">New Password</label>
            <input type="password" id="newPassword" name="newPassword" required>
            <small>Must contain 1 uppercase letter, 1 number, min. 8 characters.</small>
        </div>

        <div class="form-group">
            <button type="submit">Save Changes</button>
        </div>
    </form>
</body>
</html>
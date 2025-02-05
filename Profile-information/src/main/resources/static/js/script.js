document.addEventListener("DOMContentLoaded", () => {
    const saveButton = document.querySelector(".save-btn");
    const profilePictureButtons = document.querySelectorAll(".profile-picture button");

    // Event listener for the Save Changes button
    saveButton.addEventListener("click", (event) => {
        event.preventDefault();
        alert("Your changes have been saved successfully!");
    });

    // Event listeners for the Upload and Remove buttons
    profilePictureButtons.forEach((button) => {
        button.addEventListener("click", () => {
            const action = button.textContent;
            alert(`Profile picture action: ${action}`);
        });
    });
});

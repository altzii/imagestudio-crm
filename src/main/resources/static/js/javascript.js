function checkGeneratePassword() {
    var generatePassword = document.getElementById("generate-password");
    var passwords = document.getElementById("passwords");

    var password = document.getElementsByName("password")[0];
    var confirmPassword = document.getElementsByName("confirmPassword")[0];

    if (generatePassword.checked == true) {
        passwords.style.display = "none";
        password.value = "empty";
        confirmPassword.value = "empty";
    } else {
        passwords.style.display = "block";
        password.value = "";
        confirmPassword.value = "";
    }
}


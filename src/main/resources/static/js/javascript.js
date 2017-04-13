function checkGeneratePassword() {
    var generatePassword = document.getElementById("generate-password");
    var passwords = document.getElementById("passwords");

    if (generatePassword.checked == true) {
        passwords.style.display = "none";
    } else {
        passwords.style.display = "block";
    }
}


function valid(event) {
    var pas = document.getElementById('password_reg').value
    var cpas = document.getElementById('password_confirm').value
    for (i = 0; i < cpas.length; i++) {
        if (pas[i] != cpas[i]) {
            alert("Passwords do not match!")
            break;
        }
    }
}
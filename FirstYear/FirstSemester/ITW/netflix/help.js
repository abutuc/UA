function validate() {
    var retVal = true;
    /* TODO */
    //Validate name
    var nome = document.getElementById("Name");
    var nameError = document.getElementById("NameError");
    var email = document.getElementById("Email").value;
    var emailError = document.getElementById("EmailError");
    var problem = document.getElementById("Problem");
    var problemError = document.getElementById("ProblemError");

    if (nome.value.trim().length < 3) {
        retVal = false;
        nameError.classList.add("d-block");
        nameError.classList.remove("d_none");

    } else {
        nameError.classList.remove("d-block");
        nameError.classList.add("d_none");
    }

    var palavrasArray = problem.value.split(' ');
    if (palavrasArray.length < 5) {
        retVal = false;
        problemError.classList.add("d-block");
        problemError.classList.remove("d_none");
    } else {
        problemError.classList.remove("d-block");
        problemError.classList.add("d_none");
    }
  
    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!(email.length > 10 && email.length < 100 && regex.test(email))) {
        retVal = false;
        emailError.classList.add("d-block");
        emailError.classList.remove("d_none");
       
    }
    else {
        emailError.classList.remove("d-block");
        emailError.classList.add("d_none");
    }

    var _priority = document.querySelectorAll('input[name="Priority"]:checked').length; 
    var _priorityError = document.getElementById("PriorityError");
    if (_priority == 0) {
        retVal = false;
        _priorityError.classList.add("d-block");
        _priorityError.classList.remove("d_none");
    }
    else {
        _priorityError.classList.remove("d-block");
        _priorityError.classList.add("d_none");
    }

    return retVal;
}
function validaEmail(email) {
    const emailRegex = /^([a-zA-Z][^<>\"!@[\]#$%¨&*()~^:;ç,\-´`=+{}º\|/\\?]{1,})@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return emailRegex.test(String(email).toLowerCase());
}
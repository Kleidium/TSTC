// Declarations //
var contactForm = document.getElementById("contact_form");
var nameField = document.getElementById("name");
var phoneField = document.getElementById("tel");
var emailField = document.getElementById("email");
var bathService = document.getElementById("bath");
var haircutService = document.getElementById("haircut");
var nailService = document.getElementById("nail_trim");
var petType = document.getElementById("selectlist");
var comments = document.getElementById("comments");

// Check Required Fields "Function 2"//
function validate() {
	var validity = false;

	if (nameField.value === "" && phoneField.value === "") {
		//Name and phone number missing
		alert("Please enter your name and phone number in their respective fields.");
		nameField.focus();
	} else if (nameField.value === "") {
		//Name missing
		alert("Please enter your name.");
		nameField.focus();
	} else if (phoneField.value === "") {
		//Phone number missing
		alert("Please enter your phone number.");
		phoneField.focus();
	} else {
		//Required fields present
		validity = true;
	}

	return validity;
}

// Calculate Service Total "Function 3"//
function getTotal() {
	//Convert string values to integers, initialize total and tax rate
	var bathCharge = parseInt(bathService.value);
	var haircutCharge = parseInt(haircutService.value);
	var nailCharge = parseInt(nailService.value);
	var total = 0;
	var taxRate = .0825;

	//If service is checked, add to total
	if (bathService.checked === true) {
		total = total + bathCharge;
	}

	if (haircutService.checked === true) {
		total = total + haircutCharge;
	}

	if (nailService.checked === true) {
		total = total + nailCharge;
	}

	//Add tax
	total = total + (total * taxRate);


	return total;
}

// Form Submission "Function 1"//
function submit(e) {
	//Prevent page reload
	e.preventDefault();

	//Check for required fields
	if (validate() === false) {
		//Validation failed.
		return;
	} else {
		//Validation successful. Display results.
		var contactMethod = document.querySelector("input[name=contact_method]:checked");
		
		console.log("Name: " + nameField.value);
		console.log("Phone Number: " + phoneField.value);
		console.log("Email: " + emailField.value);
		console.log("Contact Method: " + contactMethod.value);
		console.log("Services: Bath: " + bathService.checked + ", Haircut: " + haircutService.checked + ", Nail Trim: " + nailService.checked);
		console.log("Pet Type: " + petType.value);
		console.log("Comments: " + comments.value);
		console.log("Service Total: $" + getTotal().toFixed(2));
		console.log("");
	}
}

// Events //
contactForm.addEventListener("submit", submit);
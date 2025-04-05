// Declarations //
const ORDER_HEADING = document.querySelector(".center h2");	// Requirement #1: Constant
const ORDER_FORM = document.getElementById("order_form");
const FIRST_NAME = document.getElementById("first_name");
const LAST_NAME = document.getElementById("last_name");
const PHONE = document.getElementById("tel");
const EMAIL = document.getElementById("email");
const GIFT_WRAPPED = document.getElementById("gift_wrapped");
const NAME_EMBROIDERY = document.getElementById("name_embroidery");
const V_NECK = document.getElementById("v_neck");
const SIZE = document.getElementById("sizelist");
const COLOR = document.getElementById("colorlist");
const QUANTITY = document.getElementById("quantity");
const RESULTS_SECTION = document.querySelector(".results");
const RESULTS = document.querySelectorAll(".results div");
const TAX_RATE = .0825;


// Check Required Fields //
function validate() {
	var validity = false;	// Requirement #2 and #3: Variable and Boolean

	if (FIRST_NAME.value === "" && LAST_NAME.value === "" && PHONE.value === "") {	// Requirement #4: If/Else
		//Name and phone number missing
		alert("Please enter your first name, last name, and phone number in their respective fields.");
		FIRST_NAME.focus();
	} else if (FIRST_NAME.value === "") {
		//First Name missing
		alert("Please enter your first name.");
		FIRST_NAME.focus();
	} else if (LAST_NAME.value === "") {
		//Last Name missing
		alert("Please enter your last name.");
		LAST_NAME.focus();
	} else if (PHONE.value === "" || PHONE.value.length < 10) {
		//Phone number missing/too short
		alert("Please enter a valid 10+ digit phone number.");
		PHONE.focus();
	} else {
		//Validate Phone Number
		validity = true;
		var array = PHONE.value.split("");	// Requirement #5 and #6: String Method and Array

		for (var i = 0; i < array.length; i++) {	// Requirement #7: For Loop
			var match = false;

			for (var n = 0; n < 10; n++) {
				if (array[i] === n.toString()) {
					//Character is a number 0-9
					match = true;
					break;
				}
			}

			if (match === false) {
				//Character is not a number 0-9, invalid input
				validity = false;
				alert("Phone number can only contain digits.");
				PHONE.focus();
				break;
			}
		}
	}

	return validity;
}

// Calculate Subtotal //
function getSubtotal(material) {
	//Convert string values to integers, initialize subtotal
	var giftCharge = parseInt(GIFT_WRAPPED.value);
	var nameCharge = parseInt(NAME_EMBROIDERY.value);
	var vNeckCharge = parseInt(V_NECK.value);
	var materialCost = parseInt(material);
	var numericQuantity = parseInt(QUANTITY.value);
	var subtotal = 0;

	//If option is checked, add to subtotal
	if (GIFT_WRAPPED.checked === true) {
		subtotal = subtotal + giftCharge;		// Requirement #8: Arithmetic Operator
	}

	if (NAME_EMBROIDERY.checked === true) {
		subtotal = subtotal + nameCharge;
	}

	if (V_NECK.checked === true) {
		subtotal = subtotal + vNeckCharge;
	}

	// Add material value
	subtotal = subtotal + materialCost;

	// Multiply by quantity
	subtotal = subtotal * numericQuantity;


	return subtotal;
}

// Form Submission //
function submit(e) {
	//Prevent page reload
	e.preventDefault();

	//Check for required fields
	let validated = validate();		// Requirement #9: Let

	if (validated === false) {
		// Validation Failure
		return;
	} else {
		// Validation Success //
		var material = document.querySelector("input[name=material]:checked"); //check this on button press
		var giftWrapped = "";
		var nameEmbroidery = "";
		var vNeck = "";
		var subtotal = getSubtotal(material.value);
		var taxTotal = (subtotal * TAX_RATE).toFixed(2);
		var total = (subtotal + parseFloat(taxTotal)).toFixed(2);


		// Prepare Results //

		// Name Result
		RESULTS[0].innerHTML = FIRST_NAME.value + " " + LAST_NAME.value;

		// Phone Result
		RESULTS[1].innerHTML = PHONE.value;

		// Email Result
		if (EMAIL.value === "") {
			// Empty
			RESULTS[2].innerHTML = "N/A";
		} else {
			// Not Empty
			RESULTS[2].innerHTML = EMAIL.value;
		}


		// Shirt Option Results //

		// Gift Wrapped Option
		if (GIFT_WRAPPED.checked) {
			giftWrapped = document.querySelector("label[for=gift_wrapped]").innerHTML;
		} else {
			if (NAME_EMBROIDERY.checked === false && V_NECK.checked == false) {
				// No Options Selected
				giftWrapped = "None";
			}
		}
		RESULTS[3].innerHTML = giftWrapped;

		// Name Embroidery Option
		if (NAME_EMBROIDERY.checked) {
			nameEmbroidery = document.querySelector("label[for=name_embroidery]").innerHTML;
		}
		RESULTS[4].innerHTML = nameEmbroidery;

		// V-Neck Style Option
		if (V_NECK.checked) {
			vNeck = document.querySelector("label[for=v_neck]").innerHTML;
		}
		RESULTS[5].innerHTML = vNeck;

		// Material Option
		RESULTS[6].innerHTML = document.querySelector("label[for=" + material.id + "]").innerHTML;

		// Size Option
		RESULTS[7].innerHTML = SIZE.value;

		// Color Option
		RESULTS[8].innerHTML = COLOR.value;

		// Quantity Option
		RESULTS[9].innerHTML = QUANTITY.value;

		// Order Totals //

		// Subtotal
		RESULTS[10].innerHTML = "Subtotal: $" + subtotal.toFixed(2);

		// Tax Total
		RESULTS[11].innerHTML = "Tax: $" + taxTotal;

		// Total
		RESULTS[12].innerHTML = "Total: $" + total;


		// Hide Form, Display Results //
		ORDER_HEADING.innerHTML = "Thank you for ordering with us!"
		ORDER_FORM.style.display = "none";
		RESULTS_SECTION.style.display = "block";
	}
}


// Events //
ORDER_FORM.addEventListener("submit", submit);	// Requirement #10: Event Listener
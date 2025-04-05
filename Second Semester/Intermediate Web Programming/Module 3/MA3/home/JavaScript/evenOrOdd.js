//// Declarations ////
var firstNum = 0;
var secondNum = 0;
var product;


//// Capture First Number Input ////
while (firstNum < 1 || firstNum > 10) {
	firstNum = parseFloat(window.prompt("Please enter a whole number from 1-10 (inclusive). Then click OK."));

	//Invalid Input: Cannot be outside of range, a non-whole number, or NaN.
	if (firstNum < 1 || firstNum > 10 || firstNum % 1 !== 0) {
		window.alert("Invalid input. Please enter a whole number from 1-10 (inclusive).");
		firstNum = 0;
	}
}


//// Capture Second Number Input ////
while (secondNum < 1 || secondNum > 10) {
	secondNum = parseFloat(window.prompt("Please enter another whole number from 1-10 (inclusive). Then click OK."));

	//Invalid Input: Cannot be outside of range, a non-whole number, or NaN.
	if (secondNum < 1 || secondNum > 10 || secondNum % 1 !== 0) {
		window.alert("Invalid input. Please enter a whole number from 1-10 (inclusive).");
		secondNum = 0;
	}
}


//// Multiply Number Inputs ////
product = (firstNum * secondNum);


//// Determine Even or Odd ////
if (product % 2 == 0) {
	//Even Product
	console.log("The product of " + firstNum + " and " + secondNum + " is " + product + ", which is an even number.");
} else {
	//Odd Product
	console.log("The product of " + firstNum + " and " + secondNum + " is " + product + ", which is an odd number.");
}
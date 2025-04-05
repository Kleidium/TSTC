// Sentences //
var kidSentence = "Oscar has 5 kids and a beautiful wife named Stella. 4 of the children are identical twins and the other child is the oldest by 1 year.";
var relativeSentence = "The family has 6 relatives living in the San Antonio area, and 2 more relatives who live within 100 miles of the area.";
var summerSentence = "This summer they plan on traveling to El Paso to visit as many family members as possible.";

// San Antonio Extracted
var sanAntonio = relativeSentence.slice([41], [52]);

// Replace "El Paso" with "San Antonio"
var newSummerSentence = summerSentence.replace("El Paso", sanAntonio);


// First Sentence Numbers //
var five = kidSentence.slice([10], [11]);
var four = kidSentence.slice([52], [53]);
var one = kidSentence.slice([127], [128]);


// Second Sentence Numbers //
var six = relativeSentence.slice([15], [16]);
var two = relativeSentence.slice([63], [64]);
var oneHundred = relativeSentence.slice([96], [99]);

// Split 100 into 10 and 0
var ten = oneHundred.slice([0], [2]);
var zero = oneHundred.slice([2]);


// Parse Integers //
five = parseInt(five);
four = parseInt(four);
one = parseInt(one);
six = parseInt(six);
two = parseInt(two);
ten = parseInt(ten);

// Determine Total
var sumTotal = (five + four + one + six + two + ten);


// Console Logs //

// Total Sentence
console.log("The variable sumTotal is storing " + sumTotal);

// Altered Summer Sentence
console.log(newSummerSentence);

// Loop message
while(one <= ten) {
	console.log("I saw " + one + " car(s) on my trip.");
	one = one + 1;
}
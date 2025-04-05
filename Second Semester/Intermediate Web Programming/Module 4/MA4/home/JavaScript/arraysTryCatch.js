/// Declarations ///

//String Arrays
var siteTopics = ["small dog", "large dog", "small cat", "large cat", "hamster"];
var dayNames = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"];

//Strings
var firstName = "Kc";

//Integers
var birthYear = 1994;
var index = 0;


/// Array Properties and Methods ///

//Add Value to siteTopics Array
siteTopics.push("exotic animal");

//Print Length of siteTopics Array
console.log("The length of the siteTopics array is " + siteTopics.length);

//Print siteTopics Values
while (index < siteTopics.length) {
	console.log(siteTopics[index]);
	index++;
}

//Reverse dayNames index order
dayNames.reverse();

//Print dayNames to console
for ( i = 0; i < dayNames.length; i++) {
	console.log(dayNames[i]);
}

//Remove first item from dayNames
dayNames.shift();


/// Try Block ///

//Test if first index value in dayNames is "Sunday", print birthYear message
try {
	if (dayNames[0] == "Sunday") {
		throw "Error: Sunday should be missing!";
	}
} catch(msgThrown) {
	//Sunday is not missing:
	console.log(msgThrown);
} finally {
	//Final Message
	console.log(firstName + " was born in the year " + birthYear + ". I think the day was either a " + dayNames[1] + " or " + dayNames[3] + ".");
}
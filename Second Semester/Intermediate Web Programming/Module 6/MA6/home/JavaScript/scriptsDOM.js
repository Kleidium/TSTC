// Declarations //
const INTRO_TEXT = document.querySelector(".intro p");
const IMAGES = document.querySelectorAll(".reason img");
const IMAGE_HEADINGS = document.querySelectorAll(".content-title");
const IMAGE_DESCRIPTIONS = document.querySelectorAll("figcaption p");
const IMAGE_BUTTONS = document.querySelectorAll("figcaption button");
const HEADING = document.querySelector(".headings");


// Change Intro Paragraph //
INTRO_TEXT.innerHTML = "The past need not dictate the future. Despite all that has happened, achieving happiness is still possible as long as one is still living. One must make mistakes in order to learn. Hardship is the greatest teacher.";


// Change Images //
IMAGES[0].setAttribute("src", "Images/travel.jpg");
IMAGES[1].setAttribute("src", "Images/music.jpg");
IMAGES[2].setAttribute("src", "Images/games.jpg");


// Change Image Headings //
IMAGE_HEADINGS[0].innerHTML = "See the World";
IMAGE_HEADINGS[1].innerHTML = "Hear the Music";
IMAGE_HEADINGS[2].innerHTML = "Play the Game of Life";


// Change Image Descriptions //
IMAGE_DESCRIPTIONS[0].innerHTML = "To stay within a single environment is to limit one's understanding of the world at large. Do not see the world through the eyes of others. See the world for what it is.";
IMAGE_DESCRIPTIONS[1].innerHTML = "Hear the songs of the people. Understand the messages within. Then, create your own songs with your own messages.";
IMAGE_DESCRIPTIONS[2].innerHTML = "Life is as much a game as those which are played upon the screen. The stakes are simply higher. Learn the rules of the game and devise your strategy.";


// Image Buttons //

//Functions
function changeColor(e, element){
	e.preventDefault();

	if (element === IMAGE_BUTTONS[0]){
		HEADING.style.backgroundColor = "olive";
	} else if (element === IMAGE_BUTTONS[1]) {
		HEADING.style.backgroundColor = "orangered";
	} else {
		HEADING.style.backgroundColor = "black";
	}
}

//Events
for (var i = 0; i < IMAGE_BUTTONS.length; i++){
	IMAGE_BUTTONS[i].addEventListener("click", function(e) {changeColor(e, this)}, false);
}
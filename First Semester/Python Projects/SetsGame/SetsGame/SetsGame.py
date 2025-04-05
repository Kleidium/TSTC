# Program: SetsGame
# Course: ITSE 1302 7P3
# Author: Kc Poland
# Description: This program simulates a dice game by rolling 5 dice for the computer and for the player. Each player's results are stored in their own lists. Whoever has the largest number of matching dice wins.
# Each result list is displayed along with the winner. If both players have the same score, a tie is declared.


import random

# Initialize dice lists and number of matches
comDice = []
playDice = []
cMatches = 0
pMatches = 0

# Roll 5 dice each for computer and player, add them to lists
for x in range(1, 6):
    comDice.append(random.randint(1, 6))
    playDice.append(random.randint(1, 6))

# For numbers 1-6, check how many times they occur in the lists and record highest number of matches
for x in range(1, 7):
    cCount = comDice.count(x)
    pCount = playDice.count(x)
    if pCount > pMatches:
        pMatches = pCount
    if cCount > cMatches:
        cMatches = cCount

# Display dice results
print("Computer rolled: " + str(comDice))
print("Player rolled: " + str(playDice))
print("")
print("Computer has " + str(cMatches) + " of a kind.")
print("Player has " + str(pMatches) + " of a kind.")
print("")

# Display the winner or if its a tie
if cMatches != pMatches:
    if cMatches > pMatches:
        print("Computer wins.")
        print("")
    else:
        print("Player wins!")
        print("")
else:
    print("It is a tie game.")
    print("")
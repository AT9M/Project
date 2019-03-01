#!/usr/bin/python3
import pyttsx3
engine = pyttsx3.init()
import os,random
import webbrowser
import datetime
#import turtle
import math
import random
min = 1
max = 6
i=1
roll_again = "yes"
voices = engine.getProperty('voices')

engine.setProperty('voice','english+f1')
start=["Hi !","Hello, How are you ?","Greetings"]
engine.say(random.choice(start))
engine.runAndWait()
now = datetime.datetime.now()



def say():
    engine.say("what did i must say ?")
    engine.runAndWait()
    phrase= input("what did i must say ?\n")
    gg=str(phrase)
    engine.say(gg)
    return 
 
def web():
    engine.say("enter the address")
    engine.runAndWait()
    w = input("address ?\n")
    return webbrowser.open('http://'+w+'.ie')
 
def today():
    return str(now)
 
def home():
    return
 
def background():
    return "May"
 
def game():
    while roll_again == "yes" or roll_again == "y":
        engine.say("Rolling the dices")
        engine.runAndWait()
        print ("Rolling the dices...")
        engine.say("The values are....")
        engine.runAndWait()
        print ("The values are....")
        a=(random.randint(min, max))
        print(a)
        engine.say("The values are....",a)
        engine.runAndWait()
        b=(random.randint(min, max))
        print(b)
        engine.say("The values are....",b)
        engine.runAndWait()
        roll_again = raw_input("Roll the dices again?")
        engine.say("Roll the dices again?")
        engine.runAndWait()
    return ""

switcher = {
        1: say,
        2: web,
        3: today,
        4: home,
        5: background,
        6: game
    }
 
def commande(n):
    
    # Get the function from switcher dictionary
    func = switcher.get(n, "nothing")
    # Execute the function
    return func()
    

u=0
o=1
while u!=o:
	okt=int(input())
	
	commande(okt)




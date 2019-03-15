#!/usr/bin/python3
#import pyttsx3
#engine = pyttsx3.init()
import os,random
import webbrowser
import datetime
#import turtle
import math

from playsound import playsound


Liam_fulla=r"hihowareyou.mp3"
Liam_hi=r"hi.mp3"
Liam_how=r"how.mp3"
Liam_are=r"are.mp3"
Liam_you=r"you.mp3"
jajoya=r"jajoy2.mp3"
johnnya=r"johndepp.mp3"
hpa=r"hp.mp3"
anakina=r"anakin.mp3"
jaune=r"jaune.mp3"
nani=r"nani.mp3"
deus=r"deus.mp3"
vult=r"vult.mp3"
slav=r"slav.mp3"
sax=r"sax.mp3"
gandalf=r"gandalf.mp3"
pirate=r"pirate.mp3"
nine=r"nine.mp3"
niness=r"90s.mp3"




min = 1
max = 6
i=1
roll_again = "yes"
#voices = engine.getProperty('voices')
#
#engine.setProperty('voice','english+f1')
#start=["Hi !","Hello, How are you ?","Greetings"]
#engine.say(random.choice(start))
#engine.runAndWait()
now = datetime.datetime.now()



def say():
#    engine.say("what did i must say ?")
#    engine.runAndWait()
    phrase= input("what did i must say ?\n")
    gg=str(phrase)
#    engine.say(gg)
#    engine.runAndWait()
    return 
 
def web():
#    engine.say("enter the address")
#    engine.runAndWait()
    w = input("address ?\n")
    return webbrowser.open('http://'+w+'.ie')
 
def today():
    return str(now)
 
def home():
    return
 
def background():
    return "May"
 
def game():
    
#        engine.say("Rolling the dices")
#        engine.runAndWait()
        print ("Rolling the dices...")
        
        print ("The values are....")
        a=(random.randint(min, max))
        print(a)
        
        b=(random.randint(min, max))
        print(b)
        
        
        return
def music():
    def nineties():
        playsound(niness)
        return

    def nnie():
        playsound(nine)
        return

    def nanni():
        playsound(nani)
        return
    def vultt():
        playsound(vult)
        return 
    def deus_vult():
        playsound(deus)
        return 

    def Liam_full():
        playsound(Liam_fulla)
        return
    def jaunea():
        playsound(jaune)
        return 
    def jajoy():
        playsound(jajoya)
        return 
    def johnny():
        playsound(johnnya)
        return 

    def hp():
        playsound(hpa)
        return 
    def anakin():
        playsound(anakina)
        return 
    def slave():
        playsound(slav)
        return
    def saxx():
        playsound(sax)
        return
    def gandalff():
        playsound(gandalf)
        return
    def piratte():
        playsound(pirate)
        return
    def liste():
        print('''switcher = {
            0: liste,
            1: Liam_full,
            2: jajoy,
            3: johnny,
            4: hp,maximum recursion depth exceed
            5: anakin,
            6: jaunea,
            7: nanni,
            8: deus_vult,
            9: vultt,
            10: slave,
           11: saxx,
            12: gandalff,
            13: piratte,
            14: nnie,
            15: nineties
        }''')
        return
    switcher = {
            0: liste,
            1: Liam_full,
            2: jajoy,
            3: johnny,
            4: hp,
            5: anakin,
            6: jaunea,
            7: nanni,
            8: deus_vult,
            9: vultt,
            10: slave,
            11: saxx,
            12: gandalff,
            13: piratte,
            14: nnie,
            15: nineties
        }
     
    def commande(n):
        
        # Get the function from switcher dictionary
        func = switcher.get(n)
        # Execute the function
        return func()
        

    print('''switcher = {
        0: liste,
        1: Liam_full,
        2: jajoy,
        3: johnny,
        4: hp,
        5: anakin,
        6: jaunea,
        7: nanni,
        8: deus_vult,
        9: vultt,
        10: slave,
        11: saxx,
        12: gandalff,
        13: piratte,
        14: nnie,
        15: nineties
     }''')
    okt=int(input("enter number music "))
    
    commande(okt)
    return      




switcher = {
        1: say,
        2: web,
        3: today,
        4: home,
        5: background,
        6: game,
        7: music
    }
 
def commande(n):
    
    # Get the function from switcher dictionary
    func = switcher.get(n)
    # Execute the function
    return func()
    


print('''1: say,
        2: web,
        3: today,
        4: home,
        5: background,
        6: game,
        7: music''')
u=1
o=0
while u!=o:
    
    oktt=int(input("enter number function"))
    
    commande(oktt)




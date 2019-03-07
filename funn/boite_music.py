from playsound import playsound



Liam_fulla=r"C:\Users\melia\Desktop\Nouveau dossier\hihowareyou.mp3"
Liam_hi=r"C:\Users\melia\Desktop\Nouveau dossier\hi.mp3"
Liam_how=r"C:\Users\melia\Desktop\Nouveau dossier\how.mp3"
Liam_are=r"C:\Users\melia\Desktop\Nouveau dossier\are.mp3"
Liam_you=r"C:\Users\melia\Desktop\Nouveau dossier\you.mp3"
jajoya=r"C:\Users\melia\Desktop\Nouveau dossier\jajoy2.mp3"
johnnya=r"C:\Users\melia\Desktop\Nouveau dossier\johndepp.mp3"
hpa=r"C:\Users\melia\Desktop\Nouveau dossier\hp.mp3"
anakina=r"C:\Users\melia\Desktop\Nouveau dossier\anakin.mp3"
jaune=r"C:\Users\melia\Desktop\Nouveau dossier\jaune.mp3"
nani=r"C:\Users\melia\Desktop\Nouveau dossier\nani.mp3"
deus=r"C:\Users\melia\Desktop\Nouveau dossier\deus.mp3"
vult=r"C:\Users\melia\Desktop\Nouveau dossier\vult.mp3"
slav=r"C:\Users\melia\Desktop\Nouveau dossier\slav.mp3"
sax=r"C:\Users\melia\Desktop\Nouveau dossier\sax.mp3"
gandalf=r"C:\Users\melia\Desktop\Nouveau dossier\gandalf.mp3"
pirate=r"C:\Users\melia\Desktop\Nouveau dossier\pirate.mp3"
nine=r"C:\Users\melia\Desktop\Nouveau dossier\nine.mp3"
niness=r"C:\Users\melia\Desktop\Nouveau dossier\90s.mp3"


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
switcher = {
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
    func = switcher.get(n, "nothing")
    # Execute the function
    return func()
    

u=0
o=1
while u!=o:
    okt=int(input("enter "))
   
    commande(okt)
    


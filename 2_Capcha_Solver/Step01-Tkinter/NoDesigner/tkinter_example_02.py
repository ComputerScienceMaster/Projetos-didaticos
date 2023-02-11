# Import required libraries
from tkinter import *

def action():
    print("executei a ação")

# Create an instance of tkinter window
win = Tk()

# Define the geometry of the window
win.geometry("800x600")

frame = Frame(win, width=800, height=600)
frame.pack()
frame.place(anchor='center', relx=0.5, rely=0.5)

label = Label(frame, text="eu sou um label")
label.pack()

button = Button(frame, text="Enviar comando", command=action)
button.pack()

win.mainloop()
# Import required libraries
from tkinter import *

# Create an instance of tkinter window
win = Tk()

# Define the geometry of the window
win.geometry("800x600")

frame = Frame(win, width=800, height=600)
frame.pack()
frame.place(anchor='center', relx=0.5, rely=0.5)

win.mainloop()
# Import required libraries
from tkinter import *
# import filedialog module
from tkinter import filedialog

def action():
    filename = filedialog.askopenfilename(initialdir = "/",
                                          title = "Select a File",
                                          filetypes = (("Text files",
                                                        "*.jpg*"),
                                                       ("all files",
                                                        "*.*")))
    filepath.set(filename)

def loadimage():
    pass

# Create an instance of tkinter window
win = Tk()

# Define the geometry of the window
win.geometry("800x600")

frame = Frame(win, width=800, height=600)
frame.pack()
frame.place(anchor='center', relx=0.5, rely=0.5)

label = Label(frame, text="Clique no botão para procurar um arquivo")
label.pack()

filepath =  StringVar(frame, value='aguardando...')
entry = Entry(frame, textvariable=filepath, width=100)
entry.pack()

button = Button(frame, text="browse files", command=action)
button.pack()

win.mainloop()
# Import required libraries
from tkinter import *
# import filedialog module
from tkinter import filedialog
# library for images
from PIL import ImageTk, Image

def action():
    filename = filedialog.askopenfilename(initialdir = "/",
                                          title = "Select a File",
                                          filetypes = (("Text files",
                                                        "*.jpg*"),
                                                       ("all files",
                                                        "*.*")))
    filepath.set(filename)
    loadimage()

def loadimage():
    if len(entry.get()) == 0 or entry.get() == "aguardando...":
        label = Label(frame, text="Você não escolheu um caminho para sua imagem")
        label.pack()
    
    img = Image.open(entry.get().replace("/","\\\\"))
    img = img.resize((400,300))
    photoloaded = ImageTk.PhotoImage(img)
    
    imageplace = Label(frame, image = photoloaded)
    imageplace.configure(image=photoloaded)
    imageplace.image = photoloaded
    imageplace.grid(column=1, row=2, columnspan=3)

    btnSolve = Button(frame, text="classify", command=solve)
    btnSolve.grid(column=1, row=3, columnspan=3)

def solve():
    pass
        
    
# Create an instance of tkinter window
win = Tk()

# Define the geometry of the window
win.geometry("800x600")

frame = Frame(win, width=800, height=600)
frame.place(anchor='center', relx=0.5, rely=0.5)

label = Label(frame, text="Caminho para o arquivo:")
label.grid(column=1, row=1)

filepath =  StringVar(frame, value='aguardando...')
entry = Entry(frame, textvariable=filepath, width=50)
entry.grid(column=2, row=1)

button = Button(frame, text="Browse files", command=action)
button.grid(column=3, row=1)



win.mainloop()
from PyQt5 import QtWidgets, uic
import sys

class Ui(QtWidgets.QDialog):
    def __init__(self):
        super(Ui, self).__init__()
        uic.loadUi(r'C:\Users\santos.vinicius\OneDrive - DB1 Group\Documentos\5_Github\Projetos-didaticos\2_Capcha_Solver\Step01-Tkinter\QtDesigner\loginForm.ui', self)
        
        ## pega o botão pelo nome
        self.button = self.findChild(QtWidgets.QPushButton, 'btnLogin') 
        # conecta o botão com o método
        self.button.clicked.connect(self.logar)

        self.show()
    def logar(self):
        print("login")


app = QtWidgets.QApplication(sys.argv)
window = Ui()
app.exec_()
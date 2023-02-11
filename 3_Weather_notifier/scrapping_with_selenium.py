from selenium import webdriver
from selenium.webdriver.common.by import By

navegador = webdriver.Firefox()
navegador.get('https://www.computersciencemaster.com.br/como-ler-pdf-com-python/')

cards = navegador.find_element(By.CLASS_NAME, 'entry-title')
print(cards.get_attribute('innerHTML'))
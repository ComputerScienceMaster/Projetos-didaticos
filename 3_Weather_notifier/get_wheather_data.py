import requests

API_KEY = "9d2fe477da5745c2ea2776e40853f905"
cidade = "são carlos"
link = f"https://api.openweathermap.org/data/2.5/weather?q={cidade}&appid={API_KEY}&lang=pt_br"

requisicao = requests.get(link)
requisicao_dic = requisicao.json()
print(requisicao_dic)




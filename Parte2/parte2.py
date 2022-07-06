import requests

archivo=open("C:/Users/felipe.morales/Documents/EjerciciosFinales/Parte2/Clientes.txt","r")
datos=[]
for i in archivo:
    datos.append(i.rstrip("\n"))

archivo.close()
datos_dict=[]
keys=["surname","firstname","c_name","l_name","a_name"]
for i in range(len(datos)):
    datos[i]=tuple(datos[i].replace(" ","").split(","))
    dato_dict=[]
    for j in range(len(datos[i])):
        key_value=keys[j],datos[i][j]
        dato_dict.append(key_value)
    datos_dict.append(dict(dato_dict))

api_url = "http://localhost:8080/apiv1/clientes/add"
response = requests.post(api_url, json=datos_dict)
response.json()
print(response.json())
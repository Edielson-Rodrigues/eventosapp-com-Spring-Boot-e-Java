'''tupla = (1, 2, 2, 2, 2, 3, 4, 4, 4, 4)
tupla = list(tupla)
nova = []

for i in tupla:
    if i not in nova:
        nova.append(i)
    
print(nova)
'''
#Questão 01
'''valor = float(input('Digite o preço do pão: '))
quantidadeValores = []

for i in range(1, 51):
    quantidadeValores.append(valor*i)
for i in range(len(quantidadeValores)):
    print(f'{i+1} - R$ {quantidadeValores[i]:.2f}')
    '''

#Questão 02
'''
frase = input('Digite a sua frase: ').lower()
print(f'Total de espaços em branco: {frase.count(" ")}\nTotal de a: {frase.count("a")}\nTotal de e: {frase.count("e")}\nTotal de i: {frase.count("i")}\nTotal de o: {frase.count("o")}\nTotal de u: {frase.count("u")}')
'''

#Questão 03
'''
cpf = input('Digite seu cpf: ').replace(' ', '').replace('.', '').replace('-', '')
verificar = list(cpf)
verificar.pop(-1)
verificar.pop(-1)

if len(cpf) != 11: print('CPF inválido.') 
else:
    primeiroDigito = []; segundoDigito = []
    cont = 10

    for i in range(len(verificar)):
        primeiroDigito.append(cont*int(verificar[i])) 
        cont -= 1

    verificadorUm = sum(primeiroDigito) % 11; verificadorUm = 11 - verificadorUm
    verificar.append(verificadorUm)
    cont = 11

    for i in range (len(verificar)):
        segundoDigito.append(cont*int(verificar[i]))
        cont -= 1

    verificadorDois = sum(segundoDigito) % 11; verificadorDois = 11 - verificadorDois
    verificar.append(verificadorDois)

    if verificar[-1] >= 10: verificar[-1] = 0
    if verificar[-2] >= 10: verificar[-2] = 0

    if verificar[-1] == int(cpf[-1]) and verificar[-2] == int(cpf[-2]): print('Digito verificador correto.')
    else: print('Digito verificador errado.')
'''

#Questão 04
'''
palavras = ['osso', 'hospital', 'CaRro', 'latipsoh', 'hospital', 'orrAc', 'dsaoi' ,'uyfdssd', 'ac','ca']

palavras = set(palavras)
palavras = list(palavras)
paresInversos = []


for i in palavras:
    for x in palavras:
        if i.lower() == x[::-1].lower() and (i not in paresInversos and i.lower() not in paresInversos) and (x not in paresInversos and x.lower() not in paresInversos):
            paresInversos.append(i)
            paresInversos.append(x)

print('Pares inversos:')

cont = len(paresInversos)-1
while True:
    if cont <= 0: break
    print(f'{paresInversos[cont]} - {paresInversos[cont-1]}')
    cont -= 2
'''

#Questão 05
'''
import random

lancamentos = []

for i in range(1, 51):
    lancamentos.append(random.randrange(1, 7))

print(f'Percentual de ocorrência do número 1 (apareceu {lancamentos.count(1)} vezes): {(100*lancamentos.count(1))/len(lancamentos)}\nPercentual de ocorrência do número 2 (apareceu {lancamentos.count(2)} vezes): {(100*lancamentos.count(2))/len(lancamentos)}\nPercentual de ocorrência do número 3 (apareceu {lancamentos.count(3)} vezes): {(100*lancamentos.count(3))/len(lancamentos)}\nPercentual de ocorrência do número 4 (apareceu {lancamentos.count(4)} vezes): {(100*lancamentos.count(4))/len(lancamentos)}',
f'\nPercentual de ocorrência do número 5 (apareceu {lancamentos.count(5)} vezes): {(100*lancamentos.count(5))/len(lancamentos)}\nPercentual de ocorrência do número 6 (apareceu {lancamentos.count(6)} vezes): {(100*lancamentos.count(6))/len(lancamentos)}')
'''

#Questão 06
'''
lista = []; pos = []

for i in range(20):
    valor = int(input('Digite um valor inteiro: '))
    lista.append(valor)

for i in range(len(lista)):
    if lista[i] > 0:
        pos.append(lista[i])

semdup = set(pos)
semdup = list(semdup)

print('Positivos sem números repetidos: ')
for i in range(len(semdup)):
    print(semdup[i])
'''

#Questão 07
'''
tupla1 = (1, 2, 3)
tupla2 = (4, 5, 6)

novaTupla = tuple(list(tupla1) + list(tupla2))
print(novaTupla)
'''
# -*- encoding: utf8 -*-
import string

def codificar(frase, chave, abc_maiusculo, abc_minusculo):
    frase_codificada = ""

    for letra in frase:
        posicao = 0
        if letra in abc_minusculo:
            while letra != abc_minusculo[posicao]:
                posicao+=1
            frase_codificada += chave[posicao]
        elif letra in abc_maiusculo:
            while letra != abc_maiusculo[posicao]:
                posicao+=1
            frase_codificada += string.upper(chave[posicao])
        else:
            frase_codificada += letra

    return frase_codificada

def descodificar(frase, chave):
    return codificar(frase, string.lowercase, string.upper(chave), string.lower(chave))

def menu(chave):
    print "(c)odificar"
    print "(d)escodificar"
    print "(s)air"

    opcao = raw_input(">")

    if opcao == "c" or opcao == "codificar":
        frase = raw_input("(frase): ")
        print "Codificado = " + codificar(frase, chave, string.uppercase, string.lowercase)
    elif opcao == "d" or opcao == "descodificar":
        frase = raw_input("(frase): ")
        print "Descoficado = " + descodificar(frase, chave)
    else:
        return

    menu(chave)

chave = raw_input("(chave em minusculas):")
menu(chave)


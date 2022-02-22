PF = 20
PC = 24.95
IMP = 0.23
SPA = 0.20

Lucro = (((PC - SPA)/(1+IMP)) - PF) * 500
impostos = (PC*0.23)*500
taxas = SPA * 500
print("Lucro: {:.2f}€    Impostos: {:.2f}€   Taxas:{:.2f}€".format(Lucro, impostos, taxas))
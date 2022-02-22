
# This function reads a file and returns a list with every line stripped.
def load(fname):
    with open(fname) as f:
        lst = []
        for line in f:
            word = line.strip()
            lst.append(word)
    return lst


"""
Complete a função filterPattern(lst, pattern) para extrair duma lista de strings
as strings que têm o padrão dado.
Sugestão: invoque a função matchesPattern (ver abaixo) para testar cada palavra.
"""
def filterPattern(lst, pattern):
    # Complete ...


"""
Complete a função matchesPattern(s, pattern) para devolver
True se s corresponder ao padrão fornecido e False, no caso contrário.
Uma string s corresponde ao padrão se e só se tiver os mesmos carateres
que o padrão nas mesmas posições, exceto onde o padrão tem ?.
Nas posições dos ?, não importa que carateres estão na string s.
A correspondência não deve fazer distinção entre maiúsculas e minúsculas.

Complete matchesPattern(s, pattern) to return
True if s matches the given pattern and return False, otherwise.
A string s matches the pattern if and only if it has the same characters
as the pattern in the same positions, except where the pattern has ?.
Wherever the pattern has ?, it doesn't matter which characters are in s.
Matching should be case-insensitive.
"""
def matchesPattern(s, pattern):
    # Complete ...


def main():
    # Uncomment these lines to test the matchesPattern function:
    #assert matchesPattern("secret", "s?c??t") == True
    #assert matchesPattern("secreta", "s?c??t") == False
    #assert matchesPattern("socket", "s?c??t") == True
    #assert matchesPattern("soccer", "s?c??t") == False
    #assert matchesPattern("SEcrEt", "?ecr?t") == True, "should be case-insensitive"
    #assert matchesPattern("SEcrET", "?ecr?t") == True, "should be case-insensitive"
    #assert matchesPattern("SecrEt", "?ECR?T") == True, "should be case-insensitive"

    words = load("wordlist.txt")

    lst = filterPattern(words, "s?c??t")
    print(lst)

    assert isinstance(lst, list),  "result lst should be a list"
    assert "secret" in lst,  "result should contain 'secret'"

    # Solution to "?YS???Y"
    lst = filterPattern(words, "?ys???y")
    print(lst)


# Call main function:
if __name__ == "__main__":
    main()













# CODE CHECK RESOLUTION

# NMEC: 
# NOME: 

"""
Imagine que está a fazer palavras cruzadas (em Inglês) e falta-lhe uma
palavra com o padrão "?YS???Y", onde os "?" representam letras por preencher.
Complete este programa para o ajudar a descobrir a palavra.
O programa já inclui instruções para ler uma lista de palavras inglesas a
partir do ficheiro wordlist.txt.
"""

# This function reads a file and returns a list with every line stripped.
def load(fname):
   with open(fname) as f:
      lst = []
      for line in f:
         word = line.strip()
         lst.append(word)
   return lst


"""
Complete a função filterPattern(lst, pattern) para extrair duma lista de strings
as strings que têm o padrão dado.
Sugestão: invoque a função matchesPattern (ver abaixo) para testar cada palavra.
"""
def filterPattern(lst, pattern):
   char_length = len(pattern)
   
   pattern = pattern.lower()
   
   word_correct_len = []
   
   for i in lst:
      if len(i) == char_length:
         word_correct_len.append(i)
      else:
         continue
   
   word_correct_pattern = []
   pattern_criteria = False
   for word in word_correct_len:
      for j,f in enumerate(pattern):
         if f == '?':
            continue
         else:
            if word[j].lower() == f:
               pattern_criteria = True
            else:
               pattern_criteria = False
               break
      
      if pattern_criteria:
         word_correct_pattern.append(word)
      else:
         continue
      
   return word_correct_pattern
   
"""
Complete a função matchesPattern(s, pattern) para devolver
True se s corresponder ao padrão fornecido e False, no caso contrário.
Uma string s corresponde ao padrão se e só se tiver os mesmos carateres
que o padrão nas mesmas posições, exceto onde o padrão tem ?.
Nas posições dos ?, não importa que carateres estão na string s.
A correspondência não deve fazer distinção entre maiúsculas e minúsculas.

Complete matchesPattern(s, pattern) to return
True if s matches the given pattern and return False, otherwise.
A string s matches the pattern if and only if it has the same characters
as the pattern in the same positions, except where the pattern has ?.
Wherever the pattern has ?, it doesn't matter which characters are in s.
Matching should be case-insensitive.
"""

def matchesPattern(s, pattern):
   lst = [s]
   word = filterPattern(lst, pattern)
   if word == []:
      return False
   else:
      return True


def main():
   # Uncomment these lines to test the matchesPattern function:
   assert matchesPattern("secret", "s?c??t") == True
   assert matchesPattern("secreta", "s?c??t") == False
   assert matchesPattern("socket", "s?c??t") == True
   assert matchesPattern("soccer", "s?c??t") == False
   assert matchesPattern("SEcrEt", "?ecr?t") == True, "should be case-insensitive"
   assert matchesPattern("SEcrET", "?ecr?t") == True, "should be case-insensitive"
   assert matchesPattern("SecrEt", "?ECR?T") == True, "should be case-insensitive"

   words = load("wordlist.txt")

   lst = filterPattern(words, "s?c??t")
   print(lst)

   assert isinstance(lst, list),  "result lst should be a list"
   assert "secret" in lst,  "result should contain 'secret'"

   # Solution to "?YS???Y"
   lst = filterPattern(words, "?ys???y")
   print(lst)


# Call main function:
if __name__ == "__main__":
   main()

#HIDE
"""
Public URL (for your students): http://codecheck.it/files/20112321127cfl600ycgp5enyc64n3ht0ll
Edit URL (for you only): http://codecheck.it/edit/20112321127cfl600ycgp5enyc64n3ht0ll/2011232112c7pnpquu6pnc6svuay9nt6sfm
"""
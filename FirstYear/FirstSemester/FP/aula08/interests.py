
def main():
    A = "reading"
    B = "eating"
    C = "traveling"
    D = "writing"
    E = "running"
    F = "music"
    G = "movies"
    H = "programming"

    interests = {
        "Marco": {A, D, E, F},
        "Anna": {E, A, G},
        "Maria": {G, D, E},
        "Paolo": {B, D, F},
        "Frank": {D, B, E, F, A},
        "Teresa": {F, H, C, D}
        }


    print("a) Table of common interests:")
    commoninterests = {(nome1, nome2) : interests[nome1] & interests[nome2] for nome1 in interests for nome2 in interests if nome1 < nome2}
    print(commoninterests)
    
    print("b) Maximum number of common interests:")
    maxCI = max(len(v) for v in commoninterests.values())
    print(maxCI)

    print("c) Pairs with maximum number of matching interests:")
    maxmatches = [pair for pair in commoninterests if len(commoninterests[pair]) == maxCI]
    print(maxmatches)

    print("d) Pairs with low similarity:")
    lowJaccard = [(name1, name2) for name1 in interests for name2 in interests if ((len(interests[name1] & interests[name2]))/(len(interests[name1] | interests[name2])))<0.25 if name1 < name2]
    print(lowJaccard)
    

# Start program:
main()


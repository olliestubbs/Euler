def gen_perms(tup):
    perm_set = set()
    for i in range(3):
        for j in range(3):
            for k in range(3):
                if (i!=j) and (j!=k) and (i!=k):
                    test_tup = (tup[i],tup[j],tup[k])
                    perm_set.add(test_tup)
    return perm_set
def nim_check(nim,nim_set):
    for i in range(3):
        for j in range(nim[i]):
            test_nim=list(nim)
            test_nim[i]=test_nim[i]-1-j
            test_nim=tuple(test_nim)
            if test_nim in nim_set:
                #print(f"{nim} is a winning position")
                return 1
    return 0
def nim_exhaust(nim_set,n):
    new_nim=nim_set
    for i in range((n//3)+1):
        for j in range(i,((n-i)//2)+1):
            if not nim_check((i,j,n-i-j),nim_set):
                new_nim.update(gen_perms((i,j,n-i-j)))
    return new_nim
nim_set = set()
nim_set.add((0,0,0))
for i in range(1,50):
    nim_set=nim_exhaust(nim_set,i)
print(nim_set)

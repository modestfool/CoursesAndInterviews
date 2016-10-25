def subs(n):
    res = [[]]
    for i in range(1,n+1):
        dummy = []
        print "res = ",res
        for s in res:
            print "s: i", s,i
            s = s + [i]
            dummy.append(s)
        print dummy
        res.extend(dummy)
        #break
    print res

subs(3)
def solve():
    R = [float(x) for x in input().split(' ')]
    print("Highest Distance excluding Finishers:")   
            
    R.sort(reverse=True)
    
    print(R.pop())       
    
    
def inc():  
 print("Highest Distance excluding Finishers:")  
 
 #solution with without pop
 R=[]   
 flag=0
 while True:
    value = input() 
    if value=="q":
        break;
    elif float(value)<=0:
        print("Invalid Input")
        flag=1;
        break;
    elif float(value)<42.195 :
        R.append(float(value))
        
 if flag==0:
  R.sort(reverse=True)    
  print(R[:3])
 
 #alternative solution with pop
 R.sort() 
 ans=[]
   
 while True:
    value = R.pop()
    if value<0:
        print("Invalid Input")
        break;
    if value!=42.195:
        if len(ans)!=3:
            ans.append(value)
        else:
            break;
        
 print(ans)         
         
  
if __name__ =="__main__":
    inc()
   #solve()
    

import java.util.*;

//APLHA-BETA PRUNONG
class Node{

 int value,n=0;
 int alpha=Integer.MIN_VALUE,beta=Integer.MAX_VALUE;
 ArrayList<Node> list ;
 ArrayList<Node> queue = new ArrayList<Node>();

 Node()
  {
    
  }

  
  Node(int b)
  {
   list = new ArrayList<Node>(b); 
  }

 // MINIMAX ALPHA BETA

 Node createTree(ArrayList<Block> board , int d , int alpha , int beta , int maxPlayer)
  {
    TicTacToe t = new TicTacToe();
    Node temp = new Node(t.branch(board));  
   

    if(d==2)
      { 
        temp.value=t.staticEvalFunction(0,board);
        System.out.println("NULL NULL"+" Depth :"+d+" "+"Number :"+temp.value);
        return(temp);
      } 
    else
      {
       if(maxPlayer==1)
        { 
        int maxEval=Integer.MIN_VALUE;  

         for(int k=1;k<=t.branch(board);k++)
          {
           Node n = createTree(board , d+1 , alpha , beta , 0);
           int eval =n.value;
          
           maxEval = (maxEval>eval)?maxEval:eval;
           n.alpha=(n.alpha>eval)?n.alpha:eval;
          
           if(n.beta<=n.alpha)
             break;       
          
           System.out.println("Depth: "+d+" " +"Number: "+n.value);
          
           n.value=maxEval;
           temp.list.add(n);               
          }
        }
        else{
        
         int minEval=Integer.MAX_VALUE;  

         for(int k=1;k<=t.branch(board);k++)
          {
           Node n = createTree(board , d+1 , alpha , beta , 1);
           int eval =n.value;
          
           minEval = (minEval<eval)?minEval:eval;
           n.beta=(n.beta<eval)?n.beta:eval;
          
           System.out.println("Depth: "+d+" " +"Number: "+n.value);
          
           n.value=minEval;
           temp.list.add(n);               
          }

        }  
    }
 
   return(temp);

  }

 void printTree(Node temp)
  {
    enQueue(temp);
    
    while(availNode())
    {
     Node t = deQueue();
     System.out.println("Value : "+t.value +" "+"ALPHA :"+t.alpha+" "+"BETA :"+t.beta);

     for(Node g:t.list)
      {
       enQueue(g);
      }
    }        
  }
 
 void enQueue(Node tem)
  {
    queue.add(tem); 
  }

 Node deQueue()
  {
    Node tem = queue.get(0);
    queue.remove(0);
    return(tem);
  }

 boolean availNode()
  {
   Node g = queue.get(0);
   
   try 
   {
    if(g.equals(null))
     {
      return(false); 
     }
    else{ 
      return(true);   
     }
   }catch(Exception e)
     {
       return(false);
     }  
  }


}


//BLOCK OF BOARD
class Block
 { 
   char ch;
   int boardMap;
 }

//TIC-TAC_TOE GAME PLAY

class TicTacToe{

 ArrayList<Block> board = new ArrayList<Block>(10);

 TicTacToe()
  { 
   for(int i=1;i<=10;i++) 
    {
      Block b = new Block();
      b.ch=' ';
      board.add(b);  
    }

  board.get(1).boardMap=8;
  board.get(2).boardMap=3;
  board.get(3).boardMap=4;
  board.get(4).boardMap=1;
  board.get(5).boardMap=5;
  board.get(6).boardMap=9;
  board.get(7).boardMap=6;
  board.get(8).boardMap=7;
  board.get(9).boardMap=2;

  board.get(7).ch='X';
  board.get(8).ch='X';
  board.get(1).ch='X';
  board.get(2).ch='X';
  board.get(3).ch='X';
  board.get(4).ch='X';
 }

 void printBoard()
  {
    System.out.println("|"+board.get(1).ch+"|"+board.get(2).ch+"|"+board.get(3).ch+"|");
    System.out.println("|"+board.get(4).ch+"|"+board.get(5).ch+"|"+board.get(6).ch+"|");
    System.out.println("|"+board.get(7).ch+"|"+board.get(8).ch+"|"+board.get(9).ch+"|");
  }

 int branch(ArrayList<Block> board)
  { 
     int count=0 ; 
     
     for(int i=1;i<=9;i++)
      {
        if(board.get(i).ch==' ')
         {
           count++;  
         }        
      }
     return(count);
  }


 int staticEvalFunction(int c , ArrayList<Block> board)
  { 
    int evalue=0,n=0;
    ArrayList<Integer> ar = new ArrayList<Integer>();     

    if(c==0)
     {
       for(int i=1;i<=9;i++)
        {
          if(board.get(i).ch=='X')
           {
             ar.add(board.get(i).boardMap);                                                    
           }
        }
     }
    else
     {
        for(int i=1;i<=9;i++)
        {
          if(board.get(i).ch=='O')
           {
             ar.add(board.get(i).boardMap);                                                    
           }
        }
     }
  
    int sum=0;

    for(int i=1;i<=ar.size();i++)
     {
       sum=sum+board.get(i).boardMap;
       if(i%2==0)
        {
         evalue=evalue+(15-sum);
         sum=0;
        }         
     }  
   
    return(evalue);    
  }
 
  boolean Win(ArrayList<Block> board)
  {
   if(board.get(1).ch==board.get(2).ch&&board.get(2).ch==board.get(3).ch)
    {return(true); }
   else if(board.get(4).ch==board.get(5).ch&&board.get(5).ch==board.get(6).ch)
    {return(true);}
   else if(board.get(7).ch==board.get(8).ch&&board.get(8).ch==board.get(9).ch)
    {return(true);}
   else if(board.get(1).ch==board.get(5).ch&&board.get(5).ch==board.get(9).ch)
    {return(true);}
   else if(board.get(3).ch==board.get(5).ch&&board.get(5).ch==board.get(7).ch)
    {return(true);}

   return(false);
  } 
 
 
}

//TIC-TAC-TOE AI

public class ttt_ai
{
  
 public static void main(String args[])
  {
   Scanner scan = new Scanner(System.in);
   System.out.println("Enter the number of leaf nodes");
   //int number = Integer.parseInt(scan.nextLine());
   TicTacToe t = new TicTacToe();
   t.printBoard();    
   Node d = new Node();
   Node f =d.createTree(t.board,0,Integer.MIN_VALUE,Integer.MAX_VALUE,1);

   System.out.println(f.list);

   d.printTree(f);

   t.printBoard();    
   System.out.println(t.branch(t.board)+" "+t.staticEvalFunction('X',t.board)+" "+ t.Win(t.board) );
   
  }

}
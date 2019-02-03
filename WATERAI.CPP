#include <stdio.h>
#include <conio.h>
#include <stdlib.h>

struct CHILD
{
 int x,y ;
 struct CHILD *next;
 struct CHILD *parent;

 void insertCHILD(int n,int m,struct CHILD *PARENT)
 {
  printf(" %d,%d ",n,m);
  if(next==NULL)
   {
    CHILD *newnode = (CHILD*)malloc(sizeof(CHILD));
    newnode->next=NULL;
    newnode->x=n;
    newnode->y=m;
    newnode->parent=NULL;
    next=newnode;
    PARENT=newnode;
   }
   else
   {
    struct CHILD *node=next;

    while(node->next!=NULL)
    {
     node=node->next;
    }

    CHILD *newnode = (CHILD*)malloc(sizeof(CHILD));
    newnode->next=NULL;
    newnode->x=n;
    newnode->y=m;
    newnode->parent=PARENT;
    node->next=newnode;
   }
 }

 void traverseCHILD()
  {
  printf("TRAVERSE \n\n");
   struct CHILD *node=next;
   struct CHILD *node2;

   while(node!=NULL)
    {
     //printf(" (%d,%d) ",node->x,node->y);
     node2=node;

     if(node->x==2)
     {
      j++;
      //printf("GOT IT");
      backtrack(node2);
      //break;
     }
     node=node->next;
    }

  }

  void backtrack(struct CHILD *node)
  {

   struct CHILD *node2=node;
   printf("\n");
   while(node2!=NULL)
     {
      printf("(%d,%d)",node2->x,node2->y);
      node2=node2->parent;
     }

  }
};

int j=0;

void main()
{
 clrscr();
 struct CHILD *c= (CHILD*)malloc(sizeof(CHILD));

 struct CHILD *ptr=c;

 c->insertCHILD(0,0,c);

 struct CHILD *node=c;
 long double i=9800;

 while(i!=0)
 {
  i--;
  int x,y;

  struct CHILD *ptr=node->next ;
  x=ptr->x;
  y=ptr->y;

if(x!=2)
 {

  int z=x+y;
  printf(" ! %d,%d ! ",x,y);

  if(x==2)
  {
   printf("GOT IT");
   break;
  }

  if(x<4)
   { c->insertCHILD(4,y,ptr); }

  if(y<3)
   {c->insertCHILD(x,3,ptr);  }

  if(x>=4)
   {c->insertCHILD(0,y,ptr);}

  if(y>=4)
  {c->insertCHILD(x,0,ptr);}

  if(z>=4&&y>=0)
   {c->insertCHILD(4,y-(4-x),ptr);}

  if(z>=3&&x>=0)
   {c->insertCHILD(x-(3-y),3,ptr);}

  if(z<=4&&x>=0)
   {c->insertCHILD(x+y,0,ptr);}

  if(z<=3&&y>=0)
   {c->insertCHILD(0,x+y,ptr);}

  node=node->next;
 }
}
 c->traverseCHILD();

 printf("%d",j);

 free(c);
 getch();
}
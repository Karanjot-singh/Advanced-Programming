package Refresher;
// linked list java sort
class linkedlist
{
    node head;
    static class node{
        int data;
        node next;

        node(){
            this.data=1;
            this.next=null;
        }
        node(int data, node next){
            this.data=data;
            this.next=next;
        }

        node(node n2){
            n2 = new node();
        }
    }
    linkedlist(node head){
        this.head=head;
    }
    void add(node n){
        node temp = head;
        while(temp.next!=null){
            temp= temp.next;
        }
        temp.next = n;
    }
    void sort(){

    }
    void display(){

    }
}
public class Day2Q2 {

    public static void main( String args[]){

        for(int i=0; i<5;i++)
        {
            linkedlist.node obj = new linkedlist.node();
        }
        for(int i=0; i<5;i++)
        {
            linkedlist.node as = new linkedlist.node();
            linkedlist.node obj = new linkedlist.node(as);

        }


    }
}

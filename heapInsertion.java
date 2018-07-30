import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        int heap[]= new int[100];
        for(int i=0;i<99;i++){
            heap[i]=-1;
        }
        int input=1;
        int leftIndex=0;
        int rightIndex=0;
        int parentIndex=0;
        while(input==1)
        {
            System.out.println("Enter a value");
            leftIndex = heapInsert(heap,sc.nextInt(),leftIndex,rightIndex,parentIndex);
            System.out.println("Press 0 to exit 1 to continue adding");
            input=sc.nextInt();
        }
        if(input==0){
            arrayPrint(heap);
        }
    }
    private static int heapInsert(int[] heap,int value,int leftIndex,int rightIndex,int parentIndex){
        if(heap[leftIndex]!=-1){
            if(heap[leftIndex+1]!=-1){
                if(heap[rightIndex]!=-1){
                    if(heap[rightIndex+1]!=-1){
                        parentIndex=rightIndex;
                        rightIndex=2*rightIndex;
                    heapInsert(heap,value,leftIndex,rightIndex,parentIndex);
                    }
                    else{
                        heap[rightIndex+1]=value;
                    }
                }
                else{
                    heap[rightIndex]=value;
                }
            parentIndex=leftIndex;
            leftIndex=2*leftIndex;
            heapInsert(heap,value,leftIndex,rightIndex,parentIndex);        
            }
            else{
                heap[leftIndex+1]=value;
            }
        }
        else {
            heap[leftIndex]=value;
        }
        return leftIndex;
    }
    private static void arrayPrint(int[] heap){
        for(int i=0;i<99;i++){
            System.out.print(heap[i]+" ");
        }
    }
} 

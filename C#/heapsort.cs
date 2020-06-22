using System;
using System.Collections.Generic;
using System.Collections;
 
public class Test
{
	public static void Main()
	{
		Console.WriteLine("Hello");
    Console.WriteLine("Max Heap");
    Heap heap = new Heap("max");
    heap.Insert(4);
    heap.Insert(10);
    heap.Insert(7);
    heap.Insert(9);
    heap.Print();
    Console.WriteLine();
    Console.WriteLine("After Remove 9");
    heap.Remove(9);
    heap.Print();
    Console.WriteLine();
    Console.WriteLine("Min Heap");
    Heap heap1 = new Heap("min");
    heap1.Insert(4);
    heap1.Insert(10);
    heap1.Insert(7);
    heap1.Insert(9);
    heap1.Print();
    Console.WriteLine();
    Console.WriteLine("After Remove 9");
    heap1.Remove(9);
    heap1.Print();
    
	}
}

class Heap {
   List<int> heap;
   String type;
   
   public Heap(String type){
     this.type = type;
     heap = new List<int>();
   }
   
   public void Insert(int value){
     heap.Add(value);// [4,10] // MaxHeap
     BubbleUp(heap.Count - 1);
   }
  
   public void Print(){
     
     foreach(int dinosaur in heap)
      {
        Console.Write(dinosaur+" ");
      }
   }
   
   /*
     (0) 4
      /
   (1) 10 
   heap.Size() => 2
   parent = n
   left = (2*parent)+1 => [(left - 1) = 2*parent] => parent =(left-1)/2 
   right = (2*parent)+2 => right - 2 = 2*parent => parent = (right-2)/2 
   
   parentIndex = (leftIndex - 1)/2 => 
   parentIndex = (rightIndex - 2)/2 
   
   */
   
   public void BubbleUp(int index){ //HeapifyUp
     if(index < 0 || index > heap.Count){
       return;
     }
     
     int parentIndex = GetParentIndex(0, index);
      int childIndex = index;
     while(childIndex > 0 && !Compare(parentIndex, childIndex)){
       Swap(parentIndex, childIndex);
       GetParentIndex(parentIndex, childIndex);
     }
   }
  
   public void BubbleDown(int index){ //HeapifyDown
     if(index < 0 || index > heap.Count){
       return;
     }
     
     int parentIndex = GetParentIndex(0, index);
     int leftChild = (2 * parentIndex) + 1;
     int rightChild = (2* parentIndex) + 2;
     int bubbleDownChild = 0;
     if(leftChild > heap.Count -1 ){
       return;
     }
     bubbleDownChild = GetChildIndex(parentIndex, leftChild, rightChild);
   
      
     while((bubbleDownChild > 0) && !Compare(parentIndex, bubbleDownChild) ){
       Swap(parentIndex, bubbleDownChild);
       leftChild = (2 * parentIndex) + 1;
       rightChild = (2* parentIndex) + 2;
       if(leftChild > heap.Count -1 ){
            return;
      }
       bubbleDownChild = GetChildIndex(parentIndex, leftChild, rightChild);
     }
   }
   
   public int GetChildIndex(int parentIndex, int leftChild, int rightChild){
    int bubbleDownChild = 0;
    if (rightChild > heap.Count - 1) {
       bubbleDownChild = leftChild;
     } else if(Compare(leftChild, rightChild)){ //check to see which type of heap we have
        bubbleDownChild = leftChild; 
     } else {
       bubbleDownChild = rightChild;
     }
     return bubbleDownChild;
    }
    
   public int GetParentIndex(int parentIndex, int childIndex){
     if(childIndex % 2 == 0){
         parentIndex = (childIndex -2) / 2;
      }else{
         parentIndex = (childIndex - 1) / 2;
      }
      return parentIndex;
   }
   
   public void Swap(int parentIndex, int childIndex){
     int temp = heap[childIndex];
     heap[childIndex] = heap[parentIndex];
     heap[parentIndex] = temp; 
   }
   
   public bool Compare(int parentIndex, int childIndex){
     if(type.Equals("max")){ // type -> max or min
       return heap[parentIndex] > heap[childIndex];
     } else {
       return heap[parentIndex] < heap[childIndex];
     }
   }

   public int GetPeak(){
     return heap[heap.Count - 1];
   }
   
   public bool Remove(int value){
     for(int i = 0; i < heap.Count; i++){
       if(heap[i] == value){
         Swap(i, heap.Count - 1);
         heap.RemoveAt(heap.Count - 1);
         BubbleUp(i);
         BubbleDown(i);
         return true;
       }
     }
     return false;
   }
   
}
/*
 *  Prompt: Create a Heap class/constructor
  *
  *  The Heap will take in the following input:

  *                type: argument should be either 'min' or 'max'. This will
  *                      dictate whether the heap will be a minheap or maxheap.
  *                      The comparator method will be affected by this
  *                      argument. See method description below
  *
  *  The Heap will have the following property:
  *
  *             storage: array/list
  *
  *                type: property that will be either 'min' or 'max'. This will
  *                      be dictated by
  *
  *  The Heap will have the following methods:
  *
  *             compare: takes in two arguments (a and b). Depending on the heap
  *                      type (minheap or maxheap), the comparator will behave
  *                      differently. If the heap is a minheap, then the compare
  *                      function will return true if a is less than b, false
  *                      otherwise. If the heap is a maxheap, then the compare
  *                      function will return true if a is greater than b, false
  *                      otherwise.
  *
  *                swap: takes in two indexes and swaps the elements at the two
  *                      indexes in the storage array
  *
  *                peak: returns the peak element of the storage array. This
  *                      will be the most minimum and maximum element for a
  *                      minheap and maxheap respectively
  *
  *                size: returns the number of elements in the heap
  *
  *              insert: inserts a value into the heap. Should begin by pushing
  *                      the value onto the end of the array, and then calling
  *                      the bubbleUp method from the last index of the array
  *
  *            bubbleUp: takes in an index, and considers the element at that
  *                      index to be a child. Continues to swap that child with
  *                      its parent value if the heap comparator condition is
  *                      not fulfilled
  *
  *          removePeak: removes the peak element from the heap and returns it.
  *                      Should begin by swapping the 0th-index element with the
  *                      last element in the storage array. Uses bubbleDown
  *                      method from the 0th index
  *
  *          bubbleDown: takes in an index, and considers the element at this
  *                      index to be the parent. Continues to swap this parent
  *                      element with its children if the heap comparator
  *                      condition is not fulfilled
  *
  *              remove: takes in a value and (if it exists in the heap),
  *                      removes that value from the heap data structure and
  *                      returns it. Should rearrange the rest of the heap to
  *                      ensure the heap comparator conditions are fulfilled
  *                      for all of its elements
  *
  *
  *
  *  Input:  N/A
  *  Output: A Heap instance


*/

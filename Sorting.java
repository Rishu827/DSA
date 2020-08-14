import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;
import java.util.*;

class Sorting
{
    public static void main(String[] args) throws IOException 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

        System.out.println("Enter the size of array");
        int size = Integer.parseInt(reader.readLine()); //size of an array

        int[] array;
        array = new int[size];
        for (int i=0; i<size; i++)
        {
            //System.out.println("Enter the " + i + " element of array");
            array[i] = Integer.parseInt(reader.readLine());
        }


        //array = BubbleSort(size, array);
        System.out.println("Bubble Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        //array = SelectionSort(size, array);
        System.out.println("Selection Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        //array = InsertionSort(size, array);
        System.out.println("Insertion Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        array = MergeSort(0, size-1, array);
        System.out.println("Merge Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

    }

    public static int[] BubbleSort(int size, int[] array)
    {
        int temp;
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size-1-i; j++)
            {
                if(array[j]>array[j+1])
                {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] SelectionSort(int size, int[] array)
    {
        int min_index_element, temp;
        for(int i=0; i<size; i++)
        {
            min_index_element = i;
            for(int j=i+1; j<size; j++)
            {
                if(array[min_index_element] > array[j])
                {
                    min_index_element = j;
                }
            }
            temp = array[min_index_element];
            array[min_index_element] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] InsertionSort(int size, int[] array) 
    {
        int previous_index, value;
        for(int i=0; i<size; i++)
        {
           previous_index = i-1;
           value = array[i];
           while((previous_index>-1) && (value < array[previous_index]))
           {
               array[previous_index+1] = array[previous_index];
               previous_index--; 
           } 
           array[previous_index+1] = value;
        }   
        return array;
    }

    public static int[] MergeSort(int left, int right, int[] array)
    {   
        int mid = left + (right-left)/2;
        if(left<right)
        {
            array = MergeSort(left,mid,array);
            array = MergeSort(mid+1,right,array);
            //merge array[left....mid], array[mid+1...right]
            array = Merge(left,mid,right,array);
        }
        return array;
    }

    public static int[] Merge(int left, int mid, int right, int[] array) 
    {
        //merge array[left....mid], array[mid+1...right] to a single Array temp_arr[left.right]
        int[] temp_arr = array;
        int[] left_array = Arrays.copyOfRange(array,left,mid+1);
        int[] right_array = Arrays.copyOfRange(array,mid+1,right+1);
        int i=0,j=0,k=left;
        int size_left = mid-left+1; //size of left array
        int size_right = right-mid; //size of right aaray
        while(i<size_left && j<size_right)
        {
            if(left_array[i]>right_array[j])
            {	
                temp_arr[k] = right_array[j];
                j++;
            }
            else
            {
                temp_arr[k] = left_array[i];
                i++;
            }
            k++;
        }
        if(i<size_left)
        {
            for(;i<size_left;i++)
            {
                temp_arr[k] = left_array[i];
                k++;
            }
        }
        else
        {
            for(;j<size_right;j++)
            {
                temp_arr[k] = right_array[j];
                k++;
            }
        } 
        return temp_arr; 
    }

}
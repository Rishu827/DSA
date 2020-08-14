import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.*;

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


        array = BubbleSort(size, array);
        System.out.println("Bubble Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        array = SelectionSort(size, array);
        System.out.println("Selection Sort Output ");
        for(int i=0; i<size; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        array = InsertionSort(size, array);
        System.out.println("Insertion Sort Output ");
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
           while((previous_index>0) && (value < array[previous_index]))
           {
               array[previous_index+1] = array[previous_index];
               previous_index--; 
           } 
           array[previous_index+1] = value;
        }   
        return array;
    }

}
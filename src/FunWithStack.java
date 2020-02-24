import java.util.*;

/**
 * A class that implements math operations utilizing a stack.
 *
 * @author Travis Chamness
 * @version 06/12/2019
 */
public class FunWithStack
{
    public void decimalToBinary()
    {
        // TODO PROJECT #1 - Done
        Scanner keyboard = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        try
        {
            do
            {
                System.out.println("\nPlease enter a positive integer, or type \"stop\"");
                int decimalNumber = keyboard.nextInt();

                System.out.print(decimalNumber + " in binary is --> ");

                // YOUR CODE GOES HERE

                while(decimalNumber != 0){

                    stack.push(decimalNumber%2);
                    decimalNumber = decimalNumber/2;

                }
                while(!stack.empty())
                {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println();

            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done with conversion.\n");
        }
    }

    public void ancientMultiplier()
    {
        // TODO PROJECT #1 - Done, look at efficiency of algorithm and not using peek methods
        // http://en.wikipedia.org/wiki/Ancient_Egyptian_multiplication
        Stack<Integer> stack1 = new Stack<>(); //stack to hold multiplier
        Stack<Integer> stack2 = new Stack<>(); //stack to hold value
        Scanner keyboard = new Scanner(System.in);
        int smaller; //this multiplied by
        int larger; //that
        int holdLarger, swap;
        int total = 0;

        try
        {
            do
            {
                System.out.println("\nPlease enter smaller, or type \"stop\"");
                smaller = keyboard.nextInt(); //h
                System.out.println("Please enter larger");
                larger = keyboard.nextInt();
                holdLarger = larger;
                // YOUR CODE GOES HERE

                int multiple = 1;
                if(smaller == 0 || larger == 0){

                    smaller = 0;
                    larger = 0;

                }else if(larger < smaller){ //handles if values are backwards

                    swap = smaller;
                    smaller = larger;
                    larger = swap;
                }

                System.out.printf("The smaller operand is: %d; and the larger operand is: %d \n", smaller, larger);
                System.out.printf("--> Creating the mapping table: \n");

                while(smaller >= (multiple)){ //larger

                    System.out.printf("%d --> %d\n",multiple ,larger);
                    stack1.push(multiple); //adds state of multiple to stack1
                    multiple = multiple+multiple; //multiple * 2
                    stack2.push(larger); //adds larger value to value stack
                    larger = larger + larger; //larger *2

                }

                System.out.print("---> Calculating the result\n");
                System.out.printf("%d * %d is: ", smaller, holdLarger);

                while(smaller > 0){ //while inital larger value >= top of stack 1

                    if(smaller > stack1.peek()){ //if stack1 value is less than smaller or equal to

                        System.out.printf("%d +", stack2.peek()); //print the value at top of stack 2
                        total = total + stack2.pop(); // total = the whole amount of any
                        smaller = smaller - stack1.pop();

                    } else if(smaller == stack1.peek()){

                        System.out.printf(" %d ", stack2.peek());
                        total = total + stack2.pop();
                        smaller = smaller - stack1.pop();

                    }else{
                        stack1.pop();
                        stack2.pop();
                    }


                }
                System.out.printf("= %d", total);
            //printf while loop executing repeatedly displaying multiplier --->

            } while (true);
        }
        catch (InputMismatchException ime)
        {
            System.out.println("Done multiplying\n");
        }
    }


    public static void main(String[] args)
    {
        FunWithStack funWithStack = new FunWithStack();
        System.out.println("\u001B[35m\u001B[1m*** DECIMAL TO BINARY CONVERTER ***\u001B[0m");
        funWithStack.decimalToBinary();
        System.out.println("\u001B[35m\u001B[1m*** ANCIENT MULTIPLIER ***\u001B[0m");
        funWithStack.ancientMultiplier();

        System.out.println("Done!");
    }
}
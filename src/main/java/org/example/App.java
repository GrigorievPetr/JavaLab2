package org.example;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        PriorityStack<String> priorityStack = new PriorityStack<>();

        // Добавление элементов
        priorityStack.add("A", 1);
        priorityStack.add("B", 3);
        priorityStack.add("C", 2);
        priorityStack.add("E", 4);
        priorityStack.add("D", 5);


        System.out.println("Peek: " + priorityStack.peek());


        System.out.println("Pop: " + priorityStack.pop());
        System.out.println("Pop: " + priorityStack.pop());

        System.out.println("Contains A: " + priorityStack.contains("A"));
        System.out.println("Size: " + priorityStack.size());


        for (String item : priorityStack) {
            System.out.println("Item: " + item);
        }

    }
}

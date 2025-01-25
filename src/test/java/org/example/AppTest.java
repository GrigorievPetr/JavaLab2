package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.NoSuchElementException;
import java.util.Iterator;

class PriorityStackTest {

    @Test
    void testAddAndPop() {
        PriorityStack<String> stack = new PriorityStack<>();
        stack.add("A", 1);
        stack.add("B", 5);
        stack.add("C", 3);

        // Сначала уходит "B" (приоритет 5)
        Assertions.assertEquals("B", stack.pop());
        // Затем "C" (приоритет 3)
        Assertions.assertEquals("C", stack.pop());
        // Наконец "A" (приоритет 1)
        Assertions.assertEquals("A", stack.pop());
    }

    @Test
    void testPopFromEmpty() {
        PriorityStack<Integer> stack = new PriorityStack<>();
        // Попытка pop() из пустого стека должна бросить NoSuchElementException
        Assertions.assertThrows(NoSuchElementException.class, stack::pop);
    }

    @Test
    void testPeek() {
        PriorityStack<String> stack = new PriorityStack<>();
        stack.add("X", 10);
        stack.add("Y", 5);

        // Приоритет 10 у "X" выше
        Assertions.assertEquals("X", stack.peek());
        // Убедимся, что peek() не удалил элемент:
        Assertions.assertEquals(2, stack.size());
        // Второй вызов всё так же вернёт "X"
        Assertions.assertEquals("X", stack.peek());
    }

    @Test
    void testContains() {
        PriorityStack<Integer> stack = new PriorityStack<>();
        stack.add(5, 5);
        stack.add(10, 10);

        Assertions.assertTrue(stack.contains(5));
        Assertions.assertTrue(stack.contains(10));
        Assertions.assertFalse(stack.contains(7));
    }

    @Test
    void testRemove() {
        PriorityStack<Integer> stack = new PriorityStack<>();
        stack.add(1, 1);
        stack.add(2, 2);
        stack.add(3, 3);

        // Удаляем элемент 2
        Assertions.assertTrue(stack.remove(2));
        // Теперь в стеке только 1 и 3
        Assertions.assertFalse(stack.contains(2));
        // Попробуем удалить несуществующий элемент
        Assertions.assertFalse(stack.remove(10));
    }

    @Test
    void testSizeAndClear() {
        PriorityStack<String> stack = new PriorityStack<>();
        Assertions.assertTrue(stack.isEmpty());

        stack.add("A", 1);
        stack.add("B", 2);
        Assertions.assertEquals(2, stack.size());
        Assertions.assertFalse(stack.isEmpty());

        // Очищаем стек
        stack.clear();
        Assertions.assertEquals(0, stack.size());
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void testIteration() {
        PriorityStack<String> stack = new PriorityStack<>();
        stack.add("A", 1);
        stack.add("B", 3);
        stack.add("C", 2);

        // По условию итератор идёт по элементам в порядке убывания приоритета:
        // ожидаем B -> C -> A
        Iterator<String> it = stack.iterator();
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("B", it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("C", it.next());
        Assertions.assertTrue(it.hasNext());
        Assertions.assertEquals("A", it.next());
        Assertions.assertFalse(it.hasNext());
    }

}

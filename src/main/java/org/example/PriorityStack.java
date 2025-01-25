package org.example;

import java.util.*;

public class PriorityStack<T> implements Iterable<T> {
    // Внутренний класс для хранения элементов и их приоритета
    private static class PriorityNode<T> {
        private final T element;
        private final int priority;

        public PriorityNode(T element, int priority) {
            this.element = element;
            this.priority = priority;
        }

        public T getElement() {
            return element;
        }

        public int getPriority() {
            return priority;
        }
    }

    // Хранилище для элементов с приоритетом
    private final PriorityQueue<PriorityNode<T>> priorityQueue;

    // Конструктор
    public PriorityStack() {
        this.priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b.priority, a.priority));
    }

    // Добавление элемента с приоритетом
    public void add(T element, int priority) {
        priorityQueue.add(new PriorityNode<>(element, priority));
    }

    // Извлечение элемента с наивысшим приоритетом
    public T pop() {
        if (priorityQueue.isEmpty()) {
            throw new NoSuchElementException("PriorityStack is empty");
        }
        return priorityQueue.poll().getElement();
    }

    // Просмотр верхнего элемента (с наивысшим приоритетом)
    public T peek() {
        if (priorityQueue.isEmpty()) {
            throw new NoSuchElementException("PriorityStack is empty");
        }
        return priorityQueue.peek().getElement();
    }

    // Проверка на наличие элемента
    public boolean contains(T element) {
        return priorityQueue.stream().anyMatch(node -> node.getElement().equals(element));
    }

    // Удаление элемента
    public boolean remove(T element) {
        return priorityQueue.removeIf(node -> node.getElement().equals(element));
    }

    // Размер коллекции
    public int size() {
        return priorityQueue.size();
    }

    // Очистка стека
    public void clear() {
        priorityQueue.clear();
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    // Итератор для обхода (по приоритету)
    @Override
    public Iterator<T> iterator() {
        List<PriorityNode<T>> sortedList = new ArrayList<>(priorityQueue);
        sortedList.sort((a, b) -> Integer.compare(b.priority, a.priority));
        return sortedList.stream().map(PriorityNode::getElement).iterator();
    }

}


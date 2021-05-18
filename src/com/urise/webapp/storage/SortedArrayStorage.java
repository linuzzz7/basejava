package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void removeElementArray(int index) {
        int elementsMoved = size - index - 1;
        if (elementsMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, elementsMoved);
        }
    }

    @Override
    protected void addElementArray(Resume newResume, int index) {
        int indexAdd = - index - 1;
        System.arraycopy(storage, indexAdd, storage, indexAdd + 1, size - indexAdd);
        storage[indexAdd] = newResume;
    }

    @Override
    protected int getIndex(String uuid) {
        // создаем резюме, записываем туда нужный uuid и уже его ищем
        Resume searchKey = new Resume(uuid);
        /*
         * Метод Arrays.binarySearch() возвращает позицию заданного значения.
         * Если искомый элемент не найден, то возвращается - (position + 1), и минус впереди,
         * где position - позиция элемента где он МОГ БЫ БЫТЬ.
         */
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}

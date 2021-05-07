package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * ArrayStorage класс для работы с Резюме
 *
 * @author Zukov Alexander
 * @version 0.2
 */
public class ArrayStorage extends AbstractArrayStorage {
    /**
     * Создание массива резюме storage с размером 10.000
     * Установка счетчика резюме size в 0
     */
    private static final int STORAGE_LIMIT = 10_000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    /**
     * Метод для отчистки массива
     * Заполняет только занятые ячейки null
     */
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    /**
     * Метод для обновления резюме
     * Находит резюме, и заменяет его новым
     */
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме " + resume.getUuid() + " не найдено, обновление не произведено");
        }
    }

    /**
     * Метод для создания нового резюме
     * Делается проверка, есть ли резюме с таким же uuid
     * Далее проверяется, что база не переполнена
     * И происходит создание нового резюме и увеличение size на 1
     */
    public void save(Resume newResume) {
        if (getIndex(newResume.getUuid()) != -1) {
            System.out.println("Резюме " + newResume.getUuid() + " уже существует");
        } else if (size == STORAGE_LIMIT) {
            System.out.println("База данных резюме заполнена, добавление не возможно");
        } else {
            storage[size] = newResume;
            size++;
        }
    }



    /**
     * Метод для удаления резюме
     * Если резюме найдено, заменяет его позицию, последним в массиве, последний делает null
     * и уменьшает счетчик size
     */
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме " + uuid + " не найдено, удаление не произведено");
        }
    }

    /**
     * Метод для получения списка всех резюме
     *
     * @return - возвращает новый массив всех не null элементов
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    /**
     * Метод для поиска резюме, по uuid
     *
     * @return - возвращает найденный index в массиве резюме,
     * если не найдено возвращает -1
     */
    protected int getIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * AbstractArrayStorage класс для работы с Резюме
 *
 * @author Zukov Alexander
 * @version 0.2
 */
public abstract class AbstractArrayStorage implements Storage {
    /**
     * Создание массива резюме storage с размером 10.000
     * Установка счетчика резюме size в 0
     */
    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    /**
     * Method для подсчета всех резюме
     *
     * @return - возвращает размер масива
     */
    public int size() {
        return size;
    }

    /**
     * Метод для поиска резюме, вызывает проверку по uuid
     * Создаем переменную index, чтобы не бегать кучу раз по массиву резюме
     *
     * @return - возвращает найденное резюме
     */
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резюме " + uuid + " не найдено");
        return null;
    }

    protected abstract int getIndex(String uuid);
}
package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

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
}
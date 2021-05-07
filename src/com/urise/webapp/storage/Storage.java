package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Storage интерфейс для работы с Резюме и методы работы с ним
 *
 * @author Zukov Alexander
 * @version 0.2
 */
public interface Storage {

    void clear();

    void update(Resume resume);

    void save(Resume newResume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}
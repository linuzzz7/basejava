package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public interface IStorage {

    void clear();

    void update(Resume resume);

    void save(Resume Resume);

    Resume get(String uuid);

    void delete(String uuid);

    Resume[] getAll();

    int size();
}
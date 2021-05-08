package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void addElementArray(Resume newResume, int index) {
        storage[size] = newResume;
    }

    @Override
    protected void removeElementArray(int index) {
        storage[index] = storage[size - 1];
    }

    // поиск перебором
    protected int getIndex(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }
}
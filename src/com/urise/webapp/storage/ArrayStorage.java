package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private int checkResume(String uuid) {
        for (int index = 0; index < size; index++) {
            if (storage[index].getUuid().equals(uuid)) {
                return index;
            }
        }
        return -1;
    }

    public void save(Resume newResume) {
        if (size == storage.length) {
            System.out.println("База данных резюме заполнена, добавление не возможно");
        } else {
            if (checkResume(newResume.getUuid()) == -1) {
                storage[size] = newResume;
                size++;
            } else {
                System.out.println("Резюме " + newResume.getUuid() + " уже существует");
            }
        }
    }

    public Resume get(String uuid) {
        int index = checkResume(uuid);
        if (index != -1) {
            return storage[index];
        }
        System.out.println("Резюме " + uuid + " не найдено");
        return null;
    }

    public void delete(String uuid) {
        int index = checkResume(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме " + uuid + " не найдено, удаление не произведено");
        }
    }

    public void update(Resume resume) {
        int index = checkResume(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме " + resume.getUuid() + " не найдено, обновление не произведено");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
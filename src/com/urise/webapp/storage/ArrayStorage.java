package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private int checkResumeId;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public boolean checkResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                checkResumeId = i;
                return true;
            }
        }
        return false;
    }

    public void save(Resume newResume) {
        if (size == 10000) {
            System.out.println("База данных резюме заполнена, добавление не возможно");
        } else {
            if (!checkResume(newResume.getUuid())) {
                size++;
                storage[size - 1] = newResume;
            } else {
                System.out.println("Резюме уже существует");
            }
        }
    }

    public Resume get(String uuid) {
        if (checkResume(uuid)) {
            return storage[checkResumeId];
        } else {
            System.out.println("Резюме не найдено");
            return null;
        }
    }

    public void delete(String uuid) {
        if (checkResume(uuid)) {
            storage[checkResumeId] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме не найдено, удаление не произведено");
        }
    }

    public void update(Resume resume) {
        if (checkResume(resume.getUuid())) {
            storage[checkResumeId] = resume;
        } else {
            System.out.println("Резюме не найдено, обновление не произведено");
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
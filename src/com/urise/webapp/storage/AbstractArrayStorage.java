package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements IStorage {

    protected static final int STORAGE_LIMIT = 10_000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            throw new NotExistStorageException("Резюме " + resume.getUuid() + " не найдено, обновление не произведено");
        } else {
            storage[index] = resume;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void save(Resume Resume) {
        int index = getIndex(Resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException("Резюме " + Resume.getUuid() + " уже существует");
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("База данных резюме заполнена, добавление не возможно", Resume.getUuid());
        } else {
            addElementArray(Resume, index);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException("Резюме " + uuid + " не найдено");
        } else {
            removeElementArray(index);
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * Метод для поиска резюме, проверка по uuid
     * дергает getIndex в классах наследниках ArrayStorage или SortedArrayStorage
     * @return - возвращает найденное резюме
     */
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException("Резюме " + uuid + " не найдено");
        }
        return storage[index];
    }

    protected abstract void addElementArray(Resume newResume, int index);

    protected abstract void removeElementArray(int index);

    protected abstract int getIndex(String uuid);
}
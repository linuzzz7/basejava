import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;
    int checkResumeId;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    boolean checkResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                checkResumeId = i;
                return true;
            }
        }
        return false;
    }

    void save(Resume newResume) {
        if (size == 10000) {
            System.out.println("the base is full");
        } else {
            if (!checkResume(newResume.uuid)) {
                size++;
                storage[size - 1] = newResume;
            } else {
                System.out.println("Resume exists");
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Resume not found");
        return null;
    }

    void delete(String uuid) {
        if (checkResume(uuid)) {
            storage[checkResumeId] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Resume not found");
        }
    }

    void update(Resume resume) {
        if (checkResume(resume.uuid)) {
            storage[checkResumeId] = resume;
        } else {
            System.out.println("Resume not found");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
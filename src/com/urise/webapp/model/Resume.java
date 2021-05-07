package com.urise.webapp.model;

import java.util.Objects;

/**
 * Инициализация Резюме
 *
 * @author Zukov Alexander
 * @version 0.2
 */

public class Resume implements Comparable<Resume> {

    // уникальный идентификатор резюме
    private String uuid;

    /**
     * Метод возвращает номер Resume
     *
     * @return uuid
     */
    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    /**
     * Метод присваивает номер Resume
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }

    /**
     * Метод для сравнения
     */
    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }
}

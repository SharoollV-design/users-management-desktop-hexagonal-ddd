package com.jcaa.usersmanagement.domain.specification;

public interface  Specification<T> {
    boolean isSatisfiedBy(T item);
}

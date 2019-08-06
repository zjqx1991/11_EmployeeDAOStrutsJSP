package com.revanwang.employee.util.result;

import java.sql.ResultSet;

public interface IResultHandle<T> {
    T handler(ResultSet rs);
}

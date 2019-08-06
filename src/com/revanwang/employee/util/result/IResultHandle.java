package com.revanwang.employee.util.result;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultHandle<T> {
    T handler(ResultSet rs) throws SQLException;
}

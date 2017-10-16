package jdbc_application_coffeeProject.dao;

import java.sql.SQLException;
import java.util.List;

import jdbc_application_coffeeProject.dto.CoffeeReportRank;

public interface SqlDao<T> {
	void insertItem(T item) throws SQLException;
	void updateItem(T item) throws SQLException;
	void deleteItem(T item) throws SQLException;
	T selectItemByNo(T item) throws SQLException;
	List<T> selectItemByAll() throws SQLException;
}

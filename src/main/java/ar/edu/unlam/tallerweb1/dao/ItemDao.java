package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Message;

import java.util.List;

public interface ItemDao {
   List<Object[]> obtainItemsByCategoryAndLocation(Message message);
}

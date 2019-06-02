package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Item;
import ar.edu.unlam.tallerweb1.modelo.Message;

import java.util.List;

public interface ItemDao {
   List<Item> obtainItemsByCategory(Message message);
   List<Object[]> obtainItemsByCategoryAndLocation(Message message);
}

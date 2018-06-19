package services;

import cache.ItemsCache;
import com.googlecode.objectify.ObjectifyService;
import domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

	private static final String OFY_SERVICE_NAME = "objectifyService";
	private final ItemsCache itemsCache;

	@Autowired
	public ItemsServiceImpl(ItemsCache itemsCache) {
		this.itemsCache = itemsCache;
	}

	@Override
	public List getItems() {
		if (itemsCache.getItems().isEmpty()) {
			ObjectifyService.ofy().load().type(Item.class);
		}

		return itemsCache.getItems();
	}

	@Override
	public Item setItem(Item item) {
		itemsCache.setItems(item);
		ObjectifyService.ofy().save().entity(item).now();
		return item;
	}
}

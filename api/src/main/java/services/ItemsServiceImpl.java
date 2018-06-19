package services;

import cache.ItemsCache;
import com.googlecode.objectify.ObjectifyService;
import domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
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
			itemsCache.setItems(ObjectifyService.ofy().load().type(Item.class).list());
		}

		return itemsCache.getItems();
	}

	@Override
	public Item setItem(Item item) {
		ObjectifyService.ofy().save().entity(item).now();
		itemsCache.setItem(item);
		return item;
	}
}

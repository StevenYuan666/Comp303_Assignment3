
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a sequence of watchables to watch in FIFO order.
 */
public class WatchList implements Bingeable<Watchable> {
	
	private final List<Watchable> aList = new LinkedList<>();
	private String aName;
	private int aNext;
	
	/**
	 * Creates a new empty watchlist.
	 * 
	 * @param pName
	 *            the name of the list
	 * @pre pName!=null;
	 */
	public WatchList(String pName) {
		assert pName != null;
		aName = pName;
		aNext = 0;
	}
	
	public String getName() {
		return aName;
	}
	
	/**
	 * Changes the name of this watchlist.
	 * 
	 * @param pName
	 *            the new name
	 * @pre pName!=null;
	 */
	public void setName(String pName) {
		assert pName != null;
		aName = pName;
	}
	
	/**
	 * Adds a watchable at the end of this watchlist.
	 * 
	 * @param pWatchable
	 *            the watchable to add
	 * @pre pWatchable!=null;
	 */
	public void addWatchable(Watchable pWatchable) {
		assert pWatchable != null;
		aList.add(pWatchable);
	}
	
	/**
	 * Retrieves and removes the next watchable to watch from this watchlist. Watchables are retrieved in FIFO order.
	 */
	public Watchable removeNext() {
		return aList.remove(0);
	}
	
	/**
	 * @return the total number of valid watchable elements
	 */
	public int getValidCount() {
		int count = 0;
		for (Watchable item : aList) {
			if (item.isValid()) {
				count++;
			}
		}
		return count;
	}
	
	@Override
	public int getTotalCount() {
		return aList.size();
	}
	
	@Override
	public int getRemainingCount() {
		return aList.size() - aNext;
	}
	
	@Override
	public Watchable next() {
		assert getRemainingCount() > 0;
		Watchable next = aList.get(aNext);
		aNext++;
		if (aNext >= aList.size()) {
			aNext = 0;
		}
		return next;
	}
	
	@Override
	public void reset() {
		aNext = 0;
	}
	
	@Override
	public Iterator<Watchable> iterator() {
		return Collections.unmodifiableList(aList).iterator();
	}
	
	@Override
	//Two watch list have same hash code 
	//if the watchable objects inside are same no matter the order
	//That is equal watch list must have same hashcode, but same hashcode don't mean equal
	public int hashCode() {
		int code = 0;
		for(Watchable w : this.aList) {
			code += w.hashCode();
		}
		return code;
	}
	
	@Override
	//Two watch list are considered as equal if the content and order are exactly same
	public boolean equals(Object o) {
		if(o instanceof WatchList) {
			WatchList l = (WatchList) o;
			if(this.aList.size() == l.aList.size()) {
				for(int i = 0; i < this.aList.size(); i ++) {
					//Can only add TVShows and Movies, which are implemented flyweight pattern
					//So comparing the reference directly is safe
					if(this.aList.get(i) != l.aList.get(i)) {
						return false;
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}

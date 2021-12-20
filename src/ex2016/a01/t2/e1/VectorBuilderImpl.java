package ex2016.a01.t2.e1;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VectorBuilderImpl<X> implements VectorBuilder<X> {

	private boolean alreadyBuilt = false;
	private List<X> internalList = new LinkedList<>();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addElement(X x) {
		this.internalList.add(x);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeElement(int position) {
		this.internalList.remove(position);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void reverse() {
		this.internalList = reversedList();
	}

	private List<X> reversedList() {
		List<X> reversedList = new LinkedList<>();
		
		for (int i = 0, j = internalList.size()-1; i < internalList.size(); i++, j--) {
			reversedList.add(this.internalList.get(j));
		}
		
		return reversedList;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		this.internalList.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Vector<X>> build() {
		if(this.isAlreadyBuilt()) {
			return Optional.empty();
		}
		this.alreadyBuilt = true;
		return Optional.of(new VectorImpl<>(this.internalList));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Vector<X>> buildWithFilter(Filter<X> filter) {
		if(this.isAlreadyBuilt()) {
			return Optional.empty();
		}
		
		for (var elem : this.internalList) {
			if (!filter.check(elem)) {
				return Optional.empty();
			}
		}
		
		this.alreadyBuilt = true;
		return Optional.of(new VectorImpl<>(this.internalList));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <Y> VectorBuilder<Y> mapToNewBuilder(Mapper<X, Y> mapper) {
		VectorBuilder<Y> newBuilder = new VectorBuilderImpl<>();
		
		for (var elem : this.internalList) {
			newBuilder.addElement(mapper.transform(elem));
		}
		
		return newBuilder;
	}
	
	private boolean isAlreadyBuilt() {
		return this.alreadyBuilt;
	}

}

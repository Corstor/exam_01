package ex2016.a01.t2.e1;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VectorImpl<X> implements Vector<X> {
	
	private final List<X> vector;
	
	public VectorImpl(List<X> vector) {
		this.vector = vector;
	}

	@Override
	public Optional<X> getAtPosition(int position) {
		if(position >= this.vector.size()) {
			return Optional.empty();
		}
		
		return Optional.of(this.vector.get(position));
	}

	@Override
	public int size() {
		return this.vector.size();
	}

	@Override
	public List<X> asList() {
		return new LinkedList<>(vector);
	}

	@Override
	public void executeOnAllElements(Executor<X> executor) {
		this.vector.forEach(executor::execute);
	}

}

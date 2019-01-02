package app.common;

import java.util.Collection;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public interface Converter<A, B> extends Function<A, B> {

	default Collection<B> convertToList(final Collection<A> input) {
		return input.stream().map(this).collect(toList());
	}

}

package thk.fae.ua.core.domain.common;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class EqualsBuilderExtension extends EqualsBuilder {

	public <T> EqualsBuilder append(final List<T> lhs, final List<T> rhs) {

		if (lhs != rhs && lhs != null && rhs != null) {
			for (int i = 0; i < lhs.size(); i++) {
				this.append(lhs.get(i), rhs.get(i));
			}
		}

		return this;
	}
}

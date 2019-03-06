package net.dark_roleplay.medieval.one_twelve.objects.block_properties;

import java.util.Collection;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableSet;

import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertyBool implements IUnlistedProperty<Boolean> {


    private final String name;

	private final ImmutableSet<Boolean> allowedValues = ImmutableSet.<Boolean>of(Boolean.valueOf(true), Boolean.valueOf(false));

	protected UnlistedPropertyBool(String name){
        this.name = name;
    }

	public static UnlistedPropertyBool create(String name){
        return new UnlistedPropertyBool(name);
    }

	public Collection<Boolean> getAllowedValues() {
		return this.allowedValues;
	}

	public Optional<Boolean> parseValue(String value) {
		return !"true".equals(value) && !"false".equals(value) ? Optional.absent() : Optional.of(Boolean.valueOf(value));
	}

	/**
	 * Get the name for the given value.
	 */
	public String getName(Boolean value) {
		return value.toString();
	}

	@Override
	public boolean equals(Object p_equals_1_) {
		if (this == p_equals_1_) {
			return true;
		} else if (p_equals_1_ instanceof UnlistedPropertyBool && super.equals(p_equals_1_)) {
			UnlistedPropertyBool propertybool = (UnlistedPropertyBool) p_equals_1_;
			return this.allowedValues.equals(propertybool.allowedValues);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return 31 * super.hashCode() + this.allowedValues.hashCode();
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean isValid(Boolean value) {
		return this.allowedValues.contains(value);
	}

	@Override
	public Class<Boolean> getType() {
		return Boolean.class;
	}

	@Override
	public String valueToString(Boolean value) {
		return String.valueOf(value);
	}
}
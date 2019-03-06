package net.dark_roleplay.medieval.one_twelve.objects.block_properties;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import net.minecraftforge.common.property.IUnlistedProperty;

public class UnlistedPropertyInteger implements IUnlistedProperty<Integer>{

	private final String name;
	
    private final ImmutableSet<Integer> allowedValues;

	
	protected UnlistedPropertyInteger(String name, int min, int max){
		this.name = name;
		
		if (min < 0){
            throw new IllegalArgumentException("Min value of " + name + " must be 0 or greater");
        }else if (max <= min){
            throw new IllegalArgumentException("Max value of " + name + " must be greater than min (" + min + ")");
        }else{
            Set<Integer> set = Sets.<Integer>newHashSet();

            for (int i = min; i <= max; ++i)
            {
                set.add(Integer.valueOf(i));
            }

            this.allowedValues = ImmutableSet.copyOf(set);
        }
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isValid(Integer value) {
		return allowedValues.contains(value);
	}

	@Override
	public Class<Integer> getType() {
		return Integer.class;
	}

	@Override
	public String valueToString(Integer value) {
		return String.valueOf(value);
	}

	public static UnlistedPropertyInteger create(String name, int min, int max){
        return new UnlistedPropertyInteger(name, min, max);
    }
}

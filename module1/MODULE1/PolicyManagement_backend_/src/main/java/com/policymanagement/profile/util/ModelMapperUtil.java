package com.policymanagement.profile.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ModelMapperUtil {

	private static ModelMapper modelMapper;

	static {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	public static <S, D> D map(S source, Class<D> destinationType) {
		return modelMapper.map(source, destinationType);
	}
}

package com.cg.moviesforyou.MovieBookSpringBoot.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {
	
	public Optional<String> getCurrentAuditor(){
		
		return Optional.of("Mr. Auditor");
	}

}

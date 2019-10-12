package com.cg.moviesforyou.MovieBookSpringBoot.repository;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.moviesforyou.MovieBookSpringBoot.dto.Booking;

public interface BookingRepository extends JpaRepository<Booking, BigInteger>{

	
}
